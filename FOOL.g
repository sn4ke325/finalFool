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
private HashMap<String, CTentry> clTable = new HashMap<String, CTentry>();
private HashMap<String, String> superType = new HashMap<String, String>();//associo classi con loro estensione
private int nestingLevel = -1;
private int offset = -2;

//livello ambiente con dichiarazioni piu' esterno ï¿½ 0 (prima posizione ArrayList) invece che 1 (slides)
//il "fronte" della lista di tabelle ï¿½ symTable.get(nestingLevel)
}
/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/
//modificare ClassNode perchè riceva ST entry e nesting level nel costruttore


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
                 {
                  HashMap<String, STentry> hm = symTable.get(nestingLevel);
                  STentry classEntry = new STentry(nestingLevel, null, offset--);//STentry per nome della classe
                  if (hm.put($cid.text, classEntry) != null) {
                  	System.out.println("Class" + $cid.text + " at line " + $cid.line + " already declared");
                  	System.exit(0);
                  }
                  
                  //creo entry per class table
                  CTentry c = new CTentry();
                  if (clTable.put($cid.text, c) != null) {
                  	System.out.println("Class" + $cid.text + " at line " + $cid.line + " already declared");
                  	System.exit(0);
                  }
                  //creo il class node per l'albero sintattico e lo aggiungo
                  ClassNode cn = new ClassNode($cid.text, c);
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
                     //siccome ho esteso creo un nuovo oggetto class node che include anche al ct entry della classe da cui estendo
                     cn = new ClassNode($cid.text, c, cle);
                     //aggiungo una entry nella superType che associa la classe con la superclasse
                     superType.put($cid.text, $eid.text);
                    })? 
                        {//aggiungo class node al Syntax tree
                         $astlist.add(cn);
                         //entro nello scope della classe e uso la virtual table come scope per la classe nella symbol table (anche se alla fine chiudo lo scope
                         //la virtual table sarà conservata intatta all'interno della CTentry)
                         nestingLevel++;
                         HashMap<String, STentry> vTable = c.getVTable();
                         symTable.add(vTable);
                        }
    LPAR (pid=ID COLON ptype=basic 
                                   {
                                    FieldNode field = new FieldNode($pid.text, $ptype.ast);
                                    //aggiungo il nodo del field alla lista dentro ClassNode
                                    cn.addField(field);
                                    //aggiungo il campo nella virtual table
                                    c.addField(field, nestingLevel);
                                   }
      (COMMA pid2=ID COLON ptype2=basic 
                                        {
                                         //controllo che non sia già stato inserito (escludendo ereditarietà)
                                         field = new FieldNode($pid2.text, $ptype2.ast);
                                         if (cn.getFields().contains(field)) {//se è già stato inserito un campo uguale->errore
                                         	System.out.println("Field " + $pid2.text + " at line " + $pid2.line + " declared multiple times in this scope");
                                         	System.exit(0);
                                         }
                                         cn.addField(field);
                                         c.addField(field, nestingLevel);
                                        })*)? RPAR CLPAR
    (
      FUN fid=ID COLON fty=basic 
                                 {
                                  MethodNode method = new MethodNode($fid.text, $fty.ast);
                                  //entro nello scope del method
                                  nestingLevel++;
                                  HashMap<String, STentry> hmn = new HashMap<String, STentry>();
                                  symTable.add(hmn);
                                  int fparOffset = 1;
                                  int varOffset = -2;
                                 }
      LPAR 
           {
            ArrayList<Node> parTypes = new ArrayList<Node>();//creo lista tipi di parametro per arrow se dovesse servire
           }
      (pidf=ID COLON ptyf=type 
                               {
                                //aggiungo parametro alla symbol table
                                if (hmn.put($pidf.text, new STentry(nestingLevel, $ptyf.ast, fparOffset++)) != null) {
                                	System.out.println("Parameter id " + $pidf.text + " at line " + $pidf.line + " already declared");
                                	System.exit(0);
                                }
                                ParNode param = new ParNode($pidf.text, $ptyf.ast);
                                //aggiungo al method
                                method.addPar(param);
                                //aggiungo i tipi di parametro nella lista dei tipi di parametro
                                parTypes.add($ptyf.ast);
                               }
        (COMMA pidf2=ID COLON ptyf2=type 
                                         {
                                          //aggiungo a symbol table
                                          if (hmn.put($pidf2.text, new STentry(nestingLevel, $ptyf2.ast, fparOffset++)) != null) {
                                          	System.out.println("Parameter id " + $pidf2.text + " at line " + $pidf2.line + " already declared");
                                          	System.exit(0);
                                          }
                                          param = new ParNode($pidf2.text, $ptyf2.ast);
                                          //aggiungo al method
                                          method.addPar(param);
                                          //aggiungo i tipi di parametro nella lista dei tipi di parametro
                                          parTypes.add($ptyf2.ast);
                                         })*)? RPAR 
                                                    {
                                                     //aggiungo il tipo Arrow al metodo
                                                     method.setArrowType(new ArrowTypeNode(parTypes, $fty.ast));
                                                     
                                                     //una volta scritti tutti i parametri controllo se il metodo è già stato inserito
                                                     for (Node n : cn.getMethods()) {
                                                     	if (((MethodNode) n).getId().equals($fid.text)) {
                                                     		System.out.println("Method " + $fid.text + " at line " + $fid.line + " is declared multiple times");
                                                     		System.exit(0);
                                                     	}
                                                     }
                                                     
                                                     //aggiungo il methodNode al class Node                                  
                                                     cn.addMethod(method);
                                                     //aggiungo il metodo alla CTentry (si aggiunge automaticamente anche alla symbol table visto che condividono la stessa virtual table)
                                                     c.addMethod(method, nestingLevel - 1);//siccome sono già entrato nel nuovo scope e a me serve lo scope della classe devo usare il livello precedente
                                                    }
      (LET 
           {
            ArrayList<Node> varlist = new ArrayList<Node>();
           }
        (VAR vid=ID COLON vty=basic ASS ve=expr SEMIC 
                                                      {
                                                       //aggiungo a symbol table
                                                       if (hmn.put($vid.text, new STentry(nestingLevel, $vty.ast, varOffset--)) != null) {
                                                       	System.out.println("Var " + $vid.text + "already declared");
                                                       	System.exit(0);
                                                       }
                                                       //VarNode node = new VarNode($vid.text, $vty.ast, $ve.ast);
                                                       varlist.add(new VarNode($vid.text, $vty.ast, $ve.ast));
                                                      })* IN 
                                                             {
                                                              //aggiungo a Method 
                                                              method.addDec(varlist);
                                                             })? le=expr SEMIC 
                                                                               {
                                                                                //aggiungo body a metodo
                                                                                method.addBody($le.ast);
                                                                                //esco dallo scope del metodo
                                                                                symTable.remove(nestingLevel--);
                                                                               }
    )*
    CRPAR 
          {
           //esco dallo scope della classe
           symTable.remove(nestingLevel--);
          }
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
  | i=ID //è il tipo della classe
  {
          if (!clTable.containsKey($i.text)) {
          	System.out.println("Class type " + $i.text + " at line " + $i.line + " not declared");
          	System.exit(0);
          }
          
          $ast = new ClassTypeNode($i.text);
         }
  ;

arrow returns [Node ast]
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
  | NEW i=ID LPAR 
                  {
                   //controllo che la classe sia stata dichiarata
                   if (!clTable.containsKey($i.text)) {
                   	System.out.println("Class type " + $i.text + " at line " + $i.line + " not declared");
                   	System.exit(0);
                   }
                   $ast = new NewNode($i.text, clTable.get($i.text));
                   ArrayList<Node> par = new ArrayList<Node>();
                  }
  (e1=expr 
           {
            par.add($e1.ast);
           }
    (COMMA e2=expr 
                   {
                    par.add($e2.ast);
                   })* 
                       {
                        $ast = new NewNode($i.text, par, clTable.get($i.text));
                       })? RPAR 
                                {
                                 //controllo che i tipi corrispondano con quelli dichiarati
                                 ArrayList<Node> classFieldTypes = clTable.get($i.text).fieldTypeList();
                                 if (classFieldTypes.size() != par.size()) {
                                 	System.out.println("Params of " + $i.text + " at line " + $i.line + " do not correspond to declared");
                                 	System.exit(0);
                                 } else {
                                 	int k = 0;
                                 	for (Node node : par) {
                                 		if (!node.typeCheck().equals(classFieldTypes.get(k++))) {
                                 			System.out.println("Params of " + $i.text + "at line " + $i.line + " do not correspond to declared");
                                 			System.exit(0);
                                 		}
                                 	}
                                 }
                                }
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
  | i=ID 
         {
          // boolean isClassType = false;//flag che mi dice se la variabile punta ad un oggetto(classe) o altro (Int, bool)
          boolean isCall = false; //flag che mi dice se ho scritto le parentesi della call 
          boolean isClassCall = false;//flag che mi dice se ho scritto la sintassi della class call
          //caso 1
          //ID si riferisce ad una variabile richiamata nel corpo del programma
          //devo verificare se la variabile è stato dichiarata e quindi inserita nella symbol table
          boolean declared = false;
          STentry entry = null;
          for (HashMap<String, STentry> hm : symTable) {
          	if (hm.containsKey($i.text)) {
          		entry = hm.get($i.text);
          		declared = true;
          		break;
          	}
          }
          if (!declared) {
          	System.out.println("Var " + $i.text + " at line " + $i.line + " is not declared");
          	System.exit(0);
          }
          
          //devo controllare se la variabile è di tipo oggetto o di tipo "normale" per verificare in qualche modo se il valore assegnato è corretto (es a var int si assegnano solo interi) 
          // isClassType = (entry.getType() instanceof ClassTypeNode);//<-----------------continuare qui
          
          //devo inserire il nesting level di dove sto chiamando ID, la symbol table mi assicura che la variabile sia stata dichiarata(o meno) nello stesso scope o in uno più ampio
          $ast = new IdNode($i.text, entry, nestingLevel);
          //devo controllare che non venga chiamata una classe senza parentesi
         }
  (
    LPAR 
         {
          //caso 2
          //Call
          //dobbiamo verificare se ID è un metodo di una classe e arrowtype corrisponde
          ArrayList<Node> par = new ArrayList<Node>();
         }
    (e1=expr 
             {
              par.add($e1.ast);
             }
      (COMMA e2=expr 
                     {
                      par.add($e2.ast);
                     })*)? RPAR 
                                {
                                 if (!entry.isMethod()) {
                                 	System.out.println("Id " + $i.text + " at line " + $i.line + " is not a declared method");
                                 	System.exit(0);
                                 }
                                 isCall = true;
                                 //controllo che la lista di parametri della chiamata corrisponda con la lista di parametri dichiarati nella classe
                                 ArrayList<Node> dectypes = ((ArrowTypeNode) entry.getType()).getParList();
                                 if (dectypes.size() != par.size()) {
                                 	System.out.println("Params of " + $i.text + " at line " + $i.line + " do not correspond to declared");
                                 	System.exit(0);
                                 } else {
                                 	int k = 0;
                                 	for (Node node : par) {
                                 		if (!node.typeCheck().equals(dectypes.get(k++))) {
                                 			System.out.println("Params of " + $i.text + "at line " + $i.line + " do not correspond to declared");
                                 			System.exit(0);
                                 		}
                                 	}
                                 }
                                 
                                 $ast = new CallNode($i.text, entry, par, nestingLevel);
                                }
    | DOT i2=ID LPAR 
                     {
                      //Caso 3: Class call ID1 è la variabile che punta ad un un oggetto di tipo classe. ID2 è un metodo per quella classe
                      ArrayList<Node> arg = new ArrayList<Node>();
                     }
    (e1=expr 
             {
              arg.add($e1.ast);
             }
      (COMMA e2=expr 
                     {
                      arg.add($e2.ast);
                     })*)? RPAR 
                                {
                                 //controllo se la variabile è di tipo classe quindi può puntare ad un oggetto classe
                                 if (!(entry.getType() instanceof ClassTypeNode)) {
                                 	System.out.println("Var" + $i.text + "at line " + $i.line + " is not a class type variable");
                                 	System.exit(0);
                                 }
                                 //controllo se il metodo è stato dichiarato all'interno della classe richiamata prima del punto e mi salvo la sua STentry
                                 // String classTypeName=((ClassTypeNode) entry.getType()).getId();//recupero il nome del tipo della classe 
                                 HashMap<String, STentry> vtable = clTable.get(((ClassTypeNode) entry.getType()).getId()).getVTable();
                                 STentry methodentry = null;
                                 if (vtable.containsKey($i2.text)) {
                                 	methodentry = vtable.get($i2.text);
                                 } else {
                                 	System.out.println("Method " + $i2.text + "at line " + $i2.line + " is not declared for class " + $i.text);
                                 	System.exit(0);
                                 }
                                 //controllo se i tipi di ingresso del metodo richiamato corrispondono con quelli del metodo dichiarato
                                 ArrayList<Node> dectypes = ((ArrowTypeNode) methodentry.getType()).getParList();
                                 if (dectypes.size() != arg.size()) {
                                 	System.out.println("Params of " + $i.text + " at line " + $i.line + " do not correspond to declared");
                                 	System.exit(0);
                                 } else {
                                 	int k = 0;
                                 	for (Node node : arg) {
                                 		if (!node.typeCheck().equals(dectypes.get(k++))) {
                                 			System.out.println("Params of " + $i.text + "at line " + $i.line + " do not correspond to declared");
                                 			System.exit(0);
                                 		}
                                 	}
                                 }
                                 
                                 isClassCall = true;
                                 
                                 $ast = new ClassCallNode($i.text, $i2.text, entry, methodentry, nestingLevel);
                                 //ID1 è una variabile che punta ad un oggetto di tipo classType
                                }
  )?
  
   {
    if (entry.isMethod() && !isCall) {
    	//errore! ho scritto id senza parentesi. id è un metodo, non una variabile ma ho voluto chiamarla come variabile
    	System.out.println("Id  " + $i.text + " at line " + $i.line + " is not a variable");
    	System.exit(0);
    }
   }
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
