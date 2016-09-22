grammar FOOL;

@header {
import java.util.ArrayList;
import java.util.HashMap;
}

@lexer::members {
int lexicalErrors = 0;
}

@members {
private ArrayList<HashMap<String, STentry>> symTable = new ArrayList<HashMap<String, STentry>>();
private ArrayList<HashMap<String, STentry>> virTable = new ArrayList<HashMap<String, STentry>>();
private HashMap<String, CTentry> clTable = new HashMap<String, CTentry>();
private HashMap<String, String> superType = new HashMap<String, String>();//associo classi con loro estensione
private int nestingLevel = -1;
private int offset = -2;

//livello ambiente con dichiarazioni piu' esterno � 0 (prima posizione ArrayList) invece che 1 (slides)
//il "fronte" della lista di tabelle � symTable.get(nestingLevel)
}
/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/


prog returns [Node ast]
  :
  e=expr SEMIC 
               {
                $ast = new ProgNode($e.ast);
               }
  | LET 
        {
         FOOLlib.putSuperType(superType);
         nestingLevel++;
         HashMap<String, STentry> hm = new HashMap<String, STentry>();
         symTable.add(hm);
        }
  c=cllist IN e=expr SEMIC 
                           {
                            symTable.remove(nestingLevel--);
                            $ast = new LetInNode($c.astlist, $e.ast);
                           }
  ;

cllist returns [ArrayList < Node > astlist]
  :
  
   {
    $astlist = new ArrayList<Node>();
   }
  (
    CLASS cid=ID 
                 {// non usare la symbol table dentro la classe, uso solo virtual table. Riutilizzo Symbol dentro i metodi
                  int classOffset = -2; //offset per la symbol table per la dichiarazione di var e fun dentro la classe
                  int fieldOffset = -2; //va decrementato
                  int methodOffset = 0; //va incrementato
                  HashMap<String, STentry> hm = symTable.get(nestingLevel);
                  STentry classEntry = new STentry(nestingLevel, null, offset--);//STentry per nome della classe
                  if (hm.put($cid.text, classEntry) != null) {
                  	System.out.println("Class" + $cid.text + " at line " + $cid.line + " already declared");
                  	System.exit(0);
                  }
                  nestingLevel++;
                  HashMap<String, STentry> hmn = new HashMap<String, STentry>();
                  symTable.add(hmn);
                  //creo entry per class table
                  CTentry c = new CTentry();
                  if (clTable.put($cid.text, c) != null) {
                  	System.out.println("Class" + $cid.text + " at line " + $cid.line + " already declared");
                  	System.exit(0);
                  }
                  //creo il class node per l'albero sintattico e lo aggiungo
                  ClassNode cn = new ClassNode($cid.text);
                  $astlist.add(cn);
                 }
    (EXTENDS eid=ID 
                    {
                     //cerco se esiste la classe da cui estendo
                     CTentry cle = clTable.get($eid.text);
                     if (cle == null) {
                     	System.out.println(
                     			"Class " + $cid.text + " cannot extend class " + $eid.text + ". Class " + $eid.text + " does not exist");
                     	System.exit(0);
                     }
                     //estendo la classe copiando le informazioni contenunte in super class
                     c.extendsClass(cle);
                     //aggiungo una entry nella superType che associa la classe con la superclasse
                     superType.put($cid.text, $eid.text);
                    })? LPAR (pid=ID COLON ptype=basic 
                                                       {//aggiungo il nodo del field alla lista dentro ClassNode
                                                        cn.addField(new FieldNode($pid.text, $ptype.ast, fieldOffset));
                                                        //aggiungo il field nella symbol table per lo scope interno alla classe (nesting level)
                                                        if (hmn.put($pid.text, new STentry(nestingLevel, $ptype.ast, fieldOffset)) != null) {
                                                        	System.out.println("Parameter id " + $pid.text + " at line " + $pid.line + " already declared");
                                                        	System.exit(0);
                                                        }
                                                        fieldOffset--;
                                                        //aggiungo il parametro (field) alla class table
                                                        FieldNode par = new FieldNode();
                                                       }
      (COMMA pid2=ID COLON ptype2=basic 
                                        {
                                         cn.addPar(new ParNode($pid2.text, $ptype2.ast));
                                         if (hmn.put($pid2.text, new STentry(nestingLevel, $ptype2.ast, parOffset++)) != null) {
                                         	System.out.println("Parameter id " + $pid2.text + " at line " + $pid2.line + " already declared");
                                         	System.exit(0);
                                         }
                                        })*)? RPAR CLPAR
    (
      FUN fid=ID COLON fty=basic 
                                 {
                                  int fparOffset = 1;
                                  //aggiungo a symbol table //devo considerare overloading
                                  /* if (hmn.put($fid.text, new STentry(nestingLevel, classOffset--, true)) != null) {
                                           System.out.println("Method id " + $pid2.text + " at line " + $pid2.line + " already declared");
                                           System.exit(0);
                                          }*/
                                  nestingLevel++;
                                  HashMap<String, STentry> hmf = new HashMap<String, STentry>();
                                  symTable.add(hmf);
                                  
                                  //aggiungo a class table //devo considerare overriding  
                                  //FunNode m = new FunNode($fid.text.$fty.ast);
                                  MethodNode m = new MethodNode($fid.text.$fty.ast, methodOffset++);
                                  cn.addMethod(m);//aggiungo a ClassNode
                                  c.addMethod(m); //aggiungo a CTentry
                                 }
      LPAR 
           {
            ArrayList<Node> parTypes = new ArrayList<Node>();//creo lista tipi di parametro per arrow e controllo overloading
           }
      (pidf=ID COLON ptyf=type 
                               {
                                //aggiungo alla symbol table
                                if (hmf.put($pidf.text, new STentry(nestingLevel, $ptyf.ast, fparOffset++)) != null) {
                                	System.out.println("Parameter id " + $pidf.text + " at line " + $pidf.line + " already declared");
                                	System.exit(0);
                                }
                                //aggiungo al MethodNode
                                m.addPar(new ParNode($pidf.text, $ptyf.ast));
                                //aggiungo i tipi di parametro nella lista dei tipi di parametro
                                parTypes.add($ptyf.ast);
                               }
        (COMMA pidf2=ID COLON ptyf2=type 
                                         {
                                          m.addPar(new ParNode($pidf2.text, $ptyf2.ast));
                                          parTypes.add($ptyf2.ast);
                                         })*)? RPAR 
                                                    {
                                                     
                                                    }
      (LET (VAR vid=ID COLON vty=basic ASS ve=expr SEMIC 
                                                         {
                                                          cn.addField(new VarNode($vid.text, $vty.ast, $ve.ast));
                                                         })* IN)? le=expr SEMIC 
                                                                                {
                                                                                 cn.addBody($le.ast);
                                                                                }
    )*
    CRPAR
  )*
  d=declist 
            {
             $astlist.addAll($d.astlist);
            }
  ;

declist returns [ArrayList < Node > astlist]
  :
  
   {
    $astlist = new ArrayList<Node>();
    int offset = -2;
   }
  (
    (
      VAR i=ID COLON t=type ASS e=expr 
                                       {
                                        VarNode v = new VarNode($i.text, $t.ast, $e.ast);
                                        $astlist.add(v);
                                        HashMap<String, STentry> hm = symTable.get(nestingLevel);
                                        if (hm.put($i.text, new STentry(nestingLevel, $t.ast, offset--)) != null) {
                                        	System.out.println("Var id " + $i.text + " at line " + $i.line + " already declared");
                                        	System.exit(0);
                                        }
                                       }
      | FUN i=ID COLON t=type 
                              {
                               //inserimento di ID nella symtable
                               FunNode f = new FunNode($i.text, $t.ast);
                               $astlist.add(f);
                               HashMap<String, STentry> hm = symTable.get(nestingLevel);
                               STentry entry = new STentry(nestingLevel, offset--);
                               if (hm.put($i.text, entry) != null) {
                               	System.out.println("Fun id " + $i.text + " at line " + $i.line + " already declared");
                               	System.exit(0);
                               }
                               //creare una nuova hashmap per la symTable
                               nestingLevel++;
                               HashMap<String, STentry> hmn = new HashMap<String, STentry>();
                               symTable.add(hmn);
                              }
      LPAR 
           {
            ArrayList<Node> parTypes = new ArrayList<Node>();
            int paroffset = 1;
           }
      (fid=ID COLON fty=type 
                             {
                              parTypes.add($fty.ast);
                              ParNode fpar = new ParNode($fid.text, $fty.ast);
                              f.addPar(fpar);
                              if (hmn.put($fid.text, new STentry(nestingLevel, $fty.ast, paroffset++)) != null) {
                              	System.out.println("Parameter id " + $fid.text + " at line " + $fid.line + " already declared");
                              	System.exit(0);
                              }
                             }
        (COMMA id=ID COLON ty=type 
                                   {
                                    parTypes.add($ty.ast);
                                    ParNode par = new ParNode($id.text, $ty.ast);
                                    f.addPar(par);
                                    if (hmn.put($id.text, new STentry(nestingLevel, $ty.ast, paroffset++)) != null) {
                                    	System.out.println("Parameter id " + $id.text + " at line " + $id.line + " already declared");
                                    	System.exit(0);
                                    }
                                   })*)? RPAR 
                                              {
                                               entry.addType(new ArrowTypeNode(parTypes, $t.ast));
                                              }
      (LET d=declist IN 
                        {
                         f.addDec($d.astlist);
                        })? e=expr 
                                   {
                                    //chiudere scope
                                    symTable.remove(nestingLevel--);
                                    f.addBody($e.ast);
                                   }
    )
    SEMIC
  )+
  ;

type returns [Node ast]
  :
  b=basic 
          {
           $ast = $b.ast;
          }
  | a=arrow 
            {
             $ast = $a.ast;
            }
  ;

basic returns [Node ast]
  :
  INT 
      {
       $ast = new IntTypeNode();
      }
  | BOOL 
         {
          $ast = new BoolTypeNode();
         }
  | i=ID 
         {
          int j = nestingLevel;
          STentry entry = null;
          while (j >= 0 && entry == null)
          	entry = (symTable.get(j--)).get($i.text);
          if (entry == null) {
          	System.out.println("Id " + $i.text + " at line " + $i.line + " not declared");
          	System.exit(0);
          }
          $ast = new IdNode($i.text, entry, nestingLevel - j - 1);
         }
  ;

arrow returns [Node ast] //capire a cosa serve typeOffset simile a parOffset
  :
  LPAR 
       {
        ArrayList<Node> parTypes = new ArrayList<Node>();
       }
  (t1=type 
           {
            parTypes.add($t1.ast);
           }
    (COMMA t2=type 
                   {
                    parTypes.add($t2.ast);
                   }
      
       {
        
       })*)? RPAR ARROW r=basic 
                                {
                                 return new ArrowTypeNode(parTypes, $r.ast);
                                }
  ;

expr returns [Node ast]
  :
  f=term 
         {
          $ast = $f.ast;
         }
  (
    PLUS l=term 
                {
                 $ast = new PlusNode($ast, $l.ast);
                }
    | MINUS l=term 
                   {
                    $ast = new MinusNode($ast, $l.ast);
                   }
    | OR t2=term 
                 {
                  $ast = new OrNode($ast, $t2.ast);
                 }
  )*
  ;

term returns [Node ast]
  :
  f=factor 
           {
            $ast = $f.ast;
           }
  (
    MULT l=factor 
                  {
                   $ast = new MultNode($ast, $l.ast);
                  }
    | DIV l=factor 
                   {
                    $ast = new DivNode($ast, $l.ast);
                   }
    | AND l=factor 
                   {
                    $ast = new AndNode($ast, $l.ast);
                   }
  )*
  ;

factor returns [Node ast]
  :
  f=value 
          {
           $ast = $f.ast;
          }
  (
    EQ l=value 
               {
                $ast = new EqualNode($ast, $l.ast);
               }
    | GR l=value 
                 {
                  $ast = new GRNode($ast, $l.ast);
                 }
    | LE l=value 
                 {
                  $ast = new LENode($ast, $l.ast);
                 }
  )*
  ;

value returns [Node ast]
  :
  n=INTEGER 
            {
             $ast = new NatNode(Integer.parseInt($n.text));
            }
  | TRUE 
         {
          $ast = new BoolNode(true);
         }
  | FALSE 
          {
           $ast = new BoolNode(false);
          }
  | NULL 
         {
          $ast = new EmptyNode();
         }
  | NEW ID LPAR (expr (COMMA expr)*)? RPAR
  | LPAR e=expr RPAR 
                     {
                      $ast = $e.ast;
                     }
  | IF x=expr THEN CLPAR y=expr CRPAR ELSE CLPAR z=expr CRPAR 
                                                              {
                                                               $ast = new IfNode($x.ast, $y.ast, $z.ast);
                                                              }
  | NOT LPAR e=expr RPAR 
                         {
                          $ast = new NotNode($e.ast);
                         }
  | PRINT LPAR e=expr RPAR 
                           {
                            $ast = new PrintNode($e.ast);
                           }
/*| i=ID {//cercare la dichiarazione
    int j=nestingLevel;
    STentry entry=null; 
    while (j>=0 && entry==null)
      entry=(symTable.get(j--)).get($i.text);
    if (entry==null)
      {System.out.println("Id "+$i.text+" at line "+$i.line+" not declared");
       System.exit(0);}               
	  $ast= new IdNode($i.text,entry,nestingLevel-j-1);}  
	  ( LPAR {ArrayList<Node> argList = new ArrayList<Node>();} 
	    (fa=expr {argList.add($fa.ast);}
	      (COMMA a=expr {argList.add($a.ast);})* 
	    )? {$ast=new CallNode($i.text,entry,argList,nestingLevel-j-1);}	     
	    RPAR 
	   )?*/

  | ID
  (
    LPAR (expr (COMMA expr)*)? RPAR
    | DOT ID LPAR (expr (COMMA expr)*)? RPAR
  )
  ;
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/


PLUS
  :
  '+'
  ;

MINUS
  :
  '-'
  ;

MULT
  :
  '*'
  ;

DIV
  :
  '/'
  ;

LPAR
  :
  '('
  ;

RPAR
  :
  ')'
  ;

CLPAR
  :
  '{'
  ;

CRPAR
  :
  '}'
  ;

SEMIC
  :
  ';'
  ;

COLON
  :
  ':'
  ;

COMMA
  :
  ','
  ;

DOT
  :
  '.'
  ;

OR
  :
  '||'
  ;

AND
  :
  '&&'
  ;

NOT
  :
  'not'
  ;

GR
  :
  '>='
  ;

LE
  :
  '<='
  ;

EQ
  :
  '=='
  ;

ASS
  :
  '='
  ;

TRUE
  :
  'true'
  ;

FALSE
  :
  'false'
  ;

IF
  :
  'if'
  ;

THEN
  :
  'then'
  ;

ELSE
  :
  'else'
  ;

PRINT
  :
  'print'
  ;

LET
  :
  'let'
  ;

IN
  :
  'in'
  ;

VAR
  :
  'var'
  ;

FUN
  :
  'fun'
  ;

CLASS
  :
  'class'
  ;

EXTENDS
  :
  'extends'
  ;

NEW
  :
  'new'
  ;

NULL
  :
  'null'
  ;

INT
  :
  'int'
  ;

BOOL
  :
  'bool'
  ;

ARROW
  :
  '->'
  ;

INTEGER
  :
  (
    ('1'..'9') ('0'..'9')*
  )
  | '0'
  ;

ID
  :
  (
    'a'..'z'
    | 'A'..'Z'
  )
  (
    'a'..'z'
    | 'A'..'Z'
    | '0'..'9'
  )*
  ;

WHITESP
  :
  (
    '\t'
    | ' '
    | '\r'
    | '\n'
  )+
  
   {
    $channel = HIDDEN;
   }
  ;

COMMENT
  :
  '/*' .* '*/' 
               {
                $channel = HIDDEN;
               }
  ;

ERR
  :
  . 
    {
     System.out.println("Invalid char: " + $text);
     lexicalErrors++;
     $channel = HIDDEN;
    }
  ;
