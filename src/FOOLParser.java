// $ANTLR 3.5.2 D:\\git\\finalFool\\FOOL.g 2016-09-16 16:45:37

import java.util.ArrayList;
import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class FOOLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASS", "BOOL", "CLPAR", "COLON", 
		"COMMA", "COMMENT", "CRPAR", "ELSE", "EQ", "ERR", "FALSE", "FUN", "ID", 
		"IF", "IN", "INT", "LET", "LPAR", "NAT", "PLUS", "PRINT", "RPAR", "SEMIC", 
		"THEN", "TIMES", "TRUE", "VAR", "WHITESP"
	};
	public static final int EOF=-1;
	public static final int ASS=4;
	public static final int BOOL=5;
	public static final int CLPAR=6;
	public static final int COLON=7;
	public static final int COMMA=8;
	public static final int COMMENT=9;
	public static final int CRPAR=10;
	public static final int ELSE=11;
	public static final int EQ=12;
	public static final int ERR=13;
	public static final int FALSE=14;
	public static final int FUN=15;
	public static final int ID=16;
	public static final int IF=17;
	public static final int IN=18;
	public static final int INT=19;
	public static final int LET=20;
	public static final int LPAR=21;
	public static final int NAT=22;
	public static final int PLUS=23;
	public static final int PRINT=24;
	public static final int RPAR=25;
	public static final int SEMIC=26;
	public static final int THEN=27;
	public static final int TIMES=28;
	public static final int TRUE=29;
	public static final int VAR=30;
	public static final int WHITESP=31;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public FOOLParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public FOOLParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return FOOLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "D:\\git\\finalFool\\FOOL.g"; }


	private ArrayList<HashMap<String,STentry>>  symTable = new ArrayList<HashMap<String,STentry>>();
	private int nestingLevel = -1;
	//livello ambiente con dichiarazioni piu' esterno � 0 (prima posizione ArrayList) invece che 1 (slides)
	//il "fronte" della lista di tabelle � symTable.get(nestingLevel)



	// $ANTLR start "prog"
	// D:\\git\\finalFool\\FOOL.g:23:1: prog returns [Node ast] : (e= exp SEMIC | LET d= dec IN e= exp SEMIC );
	public final Node prog() throws RecognitionException {
		Node ast = null;


		Node e =null;
		ArrayList<Node> d =null;

		try {
			// D:\\git\\finalFool\\FOOL.g:24:2: (e= exp SEMIC | LET d= dec IN e= exp SEMIC )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==FALSE||(LA1_0 >= ID && LA1_0 <= IF)||(LA1_0 >= LPAR && LA1_0 <= NAT)||LA1_0==PRINT||LA1_0==TRUE) ) {
				alt1=1;
			}
			else if ( (LA1_0==LET) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// D:\\git\\finalFool\\FOOL.g:24:10: e= exp SEMIC
					{
					pushFollow(FOLLOW_exp_in_prog47);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_prog49); 
					ast = new ProgNode(e);
					}
					break;
				case 2 :
					// D:\\git\\finalFool\\FOOL.g:26:11: LET d= dec IN e= exp SEMIC
					{
					match(input,LET,FOLLOW_LET_in_prog76); 
					nestingLevel++;
					             HashMap<String,STentry> hm = new HashMap<String,STentry> ();
					             symTable.add(hm);
					            
					pushFollow(FOLLOW_dec_in_prog105);
					d=dec();
					state._fsp--;

					match(input,IN,FOLLOW_IN_in_prog107); 
					pushFollow(FOLLOW_exp_in_prog111);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_prog113); 
					symTable.remove(nestingLevel--);
					             ast = new LetInNode(d,e) ;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "prog"



	// $ANTLR start "dec"
	// D:\\git\\finalFool\\FOOL.g:36:1: dec returns [ArrayList<Node> astlist] : ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= dec IN )? e= exp ) SEMIC )+ ;
	public final ArrayList<Node> dec() throws RecognitionException {
		ArrayList<Node> astlist = null;


		Token i=null;
		Token fid=null;
		Token id=null;
		Node t =null;
		Node e =null;
		Node fty =null;
		Node ty =null;
		ArrayList<Node> d =null;

		try {
			// D:\\git\\finalFool\\FOOL.g:37:2: ( ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= dec IN )? e= exp ) SEMIC )+ )
			// D:\\git\\finalFool\\FOOL.g:37:4: ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= dec IN )? e= exp ) SEMIC )+
			{
			astlist = new ArrayList<Node>() ;
				   int offset=-2;
			// D:\\git\\finalFool\\FOOL.g:39:8: ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= dec IN )? e= exp ) SEMIC )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==FUN||LA6_0==VAR) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// D:\\git\\finalFool\\FOOL.g:39:10: ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= dec IN )? e= exp ) SEMIC
					{
					// D:\\git\\finalFool\\FOOL.g:39:10: ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= dec IN )? e= exp )
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==VAR) ) {
						alt5=1;
					}
					else if ( (LA5_0==FUN) ) {
						alt5=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 5, 0, input);
						throw nvae;
					}

					switch (alt5) {
						case 1 :
							// D:\\git\\finalFool\\FOOL.g:40:13: VAR i= ID COLON t= type ASS e= exp
							{
							match(input,VAR,FOLLOW_VAR_in_dec169); 
							i=(Token)match(input,ID,FOLLOW_ID_in_dec173); 
							match(input,COLON,FOLLOW_COLON_in_dec175); 
							pushFollow(FOLLOW_type_in_dec179);
							t=type();
							state._fsp--;

							match(input,ASS,FOLLOW_ASS_in_dec181); 
							pushFollow(FOLLOW_exp_in_dec185);
							e=exp();
							state._fsp--;

							VarNode v = new VarNode((i!=null?i.getText():null),t,e);
							               astlist.add(v);
							               HashMap<String,STentry> hm = symTable.get(nestingLevel);
							               if ( hm.put((i!=null?i.getText():null),new STentry(nestingLevel,t,offset--)) != null  )
							                 {System.out.println("Var id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" already declared");
							                  System.exit(0);}  
							              
							}
							break;
						case 2 :
							// D:\\git\\finalFool\\FOOL.g:49:13: FUN i= ID COLON t= type LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= dec IN )? e= exp
							{
							match(input,FUN,FOLLOW_FUN_in_dec230); 
							i=(Token)match(input,ID,FOLLOW_ID_in_dec234); 
							match(input,COLON,FOLLOW_COLON_in_dec236); 
							pushFollow(FOLLOW_type_in_dec240);
							t=type();
							state._fsp--;

							//inserimento di ID nella symtable
							               FunNode f = new FunNode((i!=null?i.getText():null),t);
							               astlist.add(f);
							               HashMap<String,STentry> hm = symTable.get(nestingLevel);
							               STentry entry = new STentry(nestingLevel,offset--);
							               if ( hm.put((i!=null?i.getText():null),entry) != null )
							                 {System.out.println("Fun id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" already declared");
							                  System.exit(0);}
							                  //creare una nuova hashmap per la symTable
							               nestingLevel++;
							               HashMap<String,STentry> hmn = new HashMap<String,STentry> ();
							               symTable.add(hmn);
							              
							match(input,LPAR,FOLLOW_LPAR_in_dec272); 
							ArrayList<Node> parTypes = new ArrayList<Node>();
							                    int paroffset=1;
							// D:\\git\\finalFool\\FOOL.g:65:17: (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )?
							int alt3=2;
							int LA3_0 = input.LA(1);
							if ( (LA3_0==ID) ) {
								alt3=1;
							}
							switch (alt3) {
								case 1 :
									// D:\\git\\finalFool\\FOOL.g:65:18: fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )*
									{
									fid=(Token)match(input,ID,FOLLOW_ID_in_dec296); 
									match(input,COLON,FOLLOW_COLON_in_dec298); 
									pushFollow(FOLLOW_type_in_dec302);
									fty=type();
									state._fsp--;


									                  parTypes.add(fty); 
									                  ParNode fpar = new ParNode((fid!=null?fid.getText():null),fty);
									                  f.addPar(fpar);
									                  if ( hmn.put((fid!=null?fid.getText():null),new STentry(nestingLevel,fty,paroffset++)) != null  )
									                    {System.out.println("Parameter id "+(fid!=null?fid.getText():null)+" at line "+(fid!=null?fid.getLine():0)+" already declared");
									                     System.exit(0);}
									                  
									// D:\\git\\finalFool\\FOOL.g:74:19: ( COMMA id= ID COLON ty= type )*
									loop2:
									while (true) {
										int alt2=2;
										int LA2_0 = input.LA(1);
										if ( (LA2_0==COMMA) ) {
											alt2=1;
										}

										switch (alt2) {
										case 1 :
											// D:\\git\\finalFool\\FOOL.g:74:20: COMMA id= ID COLON ty= type
											{
											match(input,COMMA,FOLLOW_COMMA_in_dec343); 
											id=(Token)match(input,ID,FOLLOW_ID_in_dec347); 
											match(input,COLON,FOLLOW_COLON_in_dec349); 
											pushFollow(FOLLOW_type_in_dec353);
											ty=type();
											state._fsp--;


											                    parTypes.add(ty); 
											                    ParNode par = new ParNode((id!=null?id.getText():null),ty);
											                    f.addPar(par);
											                    if ( hmn.put((id!=null?id.getText():null),new STentry(nestingLevel,ty,paroffset++)) != null  )
											                      {System.out.println("Parameter id "+(id!=null?id.getText():null)+" at line "+(id!=null?id.getLine():0)+" already declared");
											                       System.exit(0);}
											                    
											}
											break;

										default :
											break loop2;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_dec432); 
							entry.addType( new ArrowTypeNode(parTypes, t) );
							// D:\\git\\finalFool\\FOOL.g:86:15: ( LET d= dec IN )?
							int alt4=2;
							int LA4_0 = input.LA(1);
							if ( (LA4_0==LET) ) {
								alt4=1;
							}
							switch (alt4) {
								case 1 :
									// D:\\git\\finalFool\\FOOL.g:86:16: LET d= dec IN
									{
									match(input,LET,FOLLOW_LET_in_dec452); 
									pushFollow(FOLLOW_dec_in_dec456);
									d=dec();
									state._fsp--;

									match(input,IN,FOLLOW_IN_in_dec458); 
									f.addDec(d);
									}
									break;

							}

							pushFollow(FOLLOW_exp_in_dec466);
							e=exp();
							state._fsp--;

							//chiudere scope
							              symTable.remove(nestingLevel--);
							              f.addBody(e);
							              
							}
							break;

					}

					match(input,SEMIC,FOLLOW_SEMIC_in_dec497); 
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return astlist;
	}
	// $ANTLR end "dec"



	// $ANTLR start "type"
	// D:\\git\\finalFool\\FOOL.g:95:1: type returns [Node ast] : ( INT | BOOL );
	public final Node type() throws RecognitionException {
		Node ast = null;


		try {
			// D:\\git\\finalFool\\FOOL.g:96:3: ( INT | BOOL )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==INT) ) {
				alt7=1;
			}
			else if ( (LA7_0==BOOL) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// D:\\git\\finalFool\\FOOL.g:96:11: INT
					{
					match(input,INT,FOLLOW_INT_in_type541); 
					ast =new IntTypeNode();
					}
					break;
				case 2 :
					// D:\\git\\finalFool\\FOOL.g:97:11: BOOL
					{
					match(input,BOOL,FOLLOW_BOOL_in_type556); 
					ast =new BoolTypeNode();
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "type"



	// $ANTLR start "exp"
	// D:\\git\\finalFool\\FOOL.g:100:1: exp returns [Node ast] : f= term ( PLUS l= term )* ;
	public final Node exp() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// D:\\git\\finalFool\\FOOL.g:101:3: (f= term ( PLUS l= term )* )
			// D:\\git\\finalFool\\FOOL.g:101:5: f= term ( PLUS l= term )*
			{
			pushFollow(FOLLOW_term_in_exp580);
			f=term();
			state._fsp--;

			ast = f;
			// D:\\git\\finalFool\\FOOL.g:102:7: ( PLUS l= term )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==PLUS) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// D:\\git\\finalFool\\FOOL.g:102:8: PLUS l= term
					{
					match(input,PLUS,FOLLOW_PLUS_in_exp591); 
					pushFollow(FOLLOW_term_in_exp595);
					l=term();
					state._fsp--;

					ast = new PlusNode (ast,l);
					}
					break;

				default :
					break loop8;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "exp"



	// $ANTLR start "term"
	// D:\\git\\finalFool\\FOOL.g:107:1: term returns [Node ast] : f= factor ( TIMES l= factor )* ;
	public final Node term() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// D:\\git\\finalFool\\FOOL.g:108:2: (f= factor ( TIMES l= factor )* )
			// D:\\git\\finalFool\\FOOL.g:108:4: f= factor ( TIMES l= factor )*
			{
			pushFollow(FOLLOW_factor_in_term634);
			f=factor();
			state._fsp--;

			ast = f;
			// D:\\git\\finalFool\\FOOL.g:109:6: ( TIMES l= factor )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==TIMES) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// D:\\git\\finalFool\\FOOL.g:109:7: TIMES l= factor
					{
					match(input,TIMES,FOLLOW_TIMES_in_term644); 
					pushFollow(FOLLOW_factor_in_term648);
					l=factor();
					state._fsp--;

					ast = new MultNode (ast,l);
					}
					break;

				default :
					break loop9;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "term"



	// $ANTLR start "factor"
	// D:\\git\\finalFool\\FOOL.g:114:1: factor returns [Node ast] : f= value ( EQ l= value )* ;
	public final Node factor() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// D:\\git\\finalFool\\FOOL.g:115:2: (f= value ( EQ l= value )* )
			// D:\\git\\finalFool\\FOOL.g:115:4: f= value ( EQ l= value )*
			{
			pushFollow(FOLLOW_value_in_factor683);
			f=value();
			state._fsp--;

			ast = f;
			// D:\\git\\finalFool\\FOOL.g:116:6: ( EQ l= value )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==EQ) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// D:\\git\\finalFool\\FOOL.g:116:7: EQ l= value
					{
					match(input,EQ,FOLLOW_EQ_in_factor693); 
					pushFollow(FOLLOW_value_in_factor697);
					l=value();
					state._fsp--;

					ast = new EqualNode (ast,l);
					}
					break;

				default :
					break loop10;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "factor"



	// $ANTLR start "value"
	// D:\\git\\finalFool\\FOOL.g:121:1: value returns [Node ast] : (n= NAT | TRUE | FALSE | LPAR e= exp RPAR | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | PRINT LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR )? );
	public final Node value() throws RecognitionException {
		Node ast = null;


		Token n=null;
		Token i=null;
		Node e =null;
		Node x =null;
		Node y =null;
		Node z =null;
		Node fa =null;
		Node a =null;

		try {
			// D:\\git\\finalFool\\FOOL.g:122:2: (n= NAT | TRUE | FALSE | LPAR e= exp RPAR | IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | PRINT LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR )? )
			int alt14=7;
			switch ( input.LA(1) ) {
			case NAT:
				{
				alt14=1;
				}
				break;
			case TRUE:
				{
				alt14=2;
				}
				break;
			case FALSE:
				{
				alt14=3;
				}
				break;
			case LPAR:
				{
				alt14=4;
				}
				break;
			case IF:
				{
				alt14=5;
				}
				break;
			case PRINT:
				{
				alt14=6;
				}
				break;
			case ID:
				{
				alt14=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}
			switch (alt14) {
				case 1 :
					// D:\\git\\finalFool\\FOOL.g:122:4: n= NAT
					{
					n=(Token)match(input,NAT,FOLLOW_NAT_in_value737); 
					ast = new NatNode(Integer.parseInt((n!=null?n.getText():null)));
					}
					break;
				case 2 :
					// D:\\git\\finalFool\\FOOL.g:124:4: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_value752); 
					ast = new BoolNode(true);
					}
					break;
				case 3 :
					// D:\\git\\finalFool\\FOOL.g:126:4: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_value765); 
					ast = new BoolNode(false);
					}
					break;
				case 4 :
					// D:\\git\\finalFool\\FOOL.g:128:4: LPAR e= exp RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_value777); 
					pushFollow(FOLLOW_exp_in_value781);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value783); 
					ast = e;
					}
					break;
				case 5 :
					// D:\\git\\finalFool\\FOOL.g:130:4: IF x= exp THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR
					{
					match(input,IF,FOLLOW_IF_in_value795); 
					pushFollow(FOLLOW_exp_in_value799);
					x=exp();
					state._fsp--;

					match(input,THEN,FOLLOW_THEN_in_value801); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value803); 
					pushFollow(FOLLOW_exp_in_value807);
					y=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value809); 
					match(input,ELSE,FOLLOW_ELSE_in_value817); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value819); 
					pushFollow(FOLLOW_exp_in_value823);
					z=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value825); 
					ast = new IfNode(x,y,z);
					}
					break;
				case 6 :
					// D:\\git\\finalFool\\FOOL.g:133:4: PRINT LPAR e= exp RPAR
					{
					match(input,PRINT,FOLLOW_PRINT_in_value838); 
					match(input,LPAR,FOLLOW_LPAR_in_value840); 
					pushFollow(FOLLOW_exp_in_value844);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value846); 
					ast = new PrintNode(e);
					}
					break;
				case 7 :
					// D:\\git\\finalFool\\FOOL.g:135:4: i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR )?
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_value859); 
					//cercare la dichiarazione
					    int j=nestingLevel;
					    STentry entry=null; 
					    while (j>=0 && entry==null)
					      entry=(symTable.get(j--)).get((i!=null?i.getText():null));
					    if (entry==null)
					      {System.out.println("Id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" not declared");
					       System.exit(0);}               
						  ast = new IdNode((i!=null?i.getText():null),entry,nestingLevel);
					// D:\\git\\finalFool\\FOOL.g:145:4: ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR )?
					int alt13=2;
					int LA13_0 = input.LA(1);
					if ( (LA13_0==LPAR) ) {
						alt13=1;
					}
					switch (alt13) {
						case 1 :
							// D:\\git\\finalFool\\FOOL.g:145:6: LPAR (fa= exp ( COMMA a= exp )* )? RPAR
							{
							match(input,LPAR,FOLLOW_LPAR_in_value874); 
							ArrayList<Node> argList = new ArrayList<Node>();
							// D:\\git\\finalFool\\FOOL.g:146:6: (fa= exp ( COMMA a= exp )* )?
							int alt12=2;
							int LA12_0 = input.LA(1);
							if ( (LA12_0==FALSE||(LA12_0 >= ID && LA12_0 <= IF)||(LA12_0 >= LPAR && LA12_0 <= NAT)||LA12_0==PRINT||LA12_0==TRUE) ) {
								alt12=1;
							}
							switch (alt12) {
								case 1 :
									// D:\\git\\finalFool\\FOOL.g:146:7: fa= exp ( COMMA a= exp )*
									{
									pushFollow(FOLLOW_exp_in_value887);
									fa=exp();
									state._fsp--;

									argList.add(fa);
									// D:\\git\\finalFool\\FOOL.g:147:8: ( COMMA a= exp )*
									loop11:
									while (true) {
										int alt11=2;
										int LA11_0 = input.LA(1);
										if ( (LA11_0==COMMA) ) {
											alt11=1;
										}

										switch (alt11) {
										case 1 :
											// D:\\git\\finalFool\\FOOL.g:147:9: COMMA a= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_value899); 
											pushFollow(FOLLOW_exp_in_value903);
											a=exp();
											state._fsp--;

											argList.add(a);
											}
											break;

										default :
											break loop11;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_value929); 
							ast =new CallNode((i!=null?i.getText():null),entry,argList,nestingLevel);
							}
							break;

					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "value"

	// Delegated rules



	public static final BitSet FOLLOW_exp_in_prog47 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog49 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LET_in_prog76 = new BitSet(new long[]{0x0000000040008000L});
	public static final BitSet FOLLOW_dec_in_prog105 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_IN_in_prog107 = new BitSet(new long[]{0x0000000021634000L});
	public static final BitSet FOLLOW_exp_in_prog111 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog113 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_dec169 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ID_in_dec173 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_COLON_in_dec175 = new BitSet(new long[]{0x0000000000080020L});
	public static final BitSet FOLLOW_type_in_dec179 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASS_in_dec181 = new BitSet(new long[]{0x0000000021634000L});
	public static final BitSet FOLLOW_exp_in_dec185 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_FUN_in_dec230 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ID_in_dec234 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_COLON_in_dec236 = new BitSet(new long[]{0x0000000000080020L});
	public static final BitSet FOLLOW_type_in_dec240 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_LPAR_in_dec272 = new BitSet(new long[]{0x0000000002010000L});
	public static final BitSet FOLLOW_ID_in_dec296 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_COLON_in_dec298 = new BitSet(new long[]{0x0000000000080020L});
	public static final BitSet FOLLOW_type_in_dec302 = new BitSet(new long[]{0x0000000002000100L});
	public static final BitSet FOLLOW_COMMA_in_dec343 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ID_in_dec347 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_COLON_in_dec349 = new BitSet(new long[]{0x0000000000080020L});
	public static final BitSet FOLLOW_type_in_dec353 = new BitSet(new long[]{0x0000000002000100L});
	public static final BitSet FOLLOW_RPAR_in_dec432 = new BitSet(new long[]{0x0000000021734000L});
	public static final BitSet FOLLOW_LET_in_dec452 = new BitSet(new long[]{0x0000000040008000L});
	public static final BitSet FOLLOW_dec_in_dec456 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_IN_in_dec458 = new BitSet(new long[]{0x0000000021634000L});
	public static final BitSet FOLLOW_exp_in_dec466 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_SEMIC_in_dec497 = new BitSet(new long[]{0x0000000040008002L});
	public static final BitSet FOLLOW_INT_in_type541 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_type556 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_exp580 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_PLUS_in_exp591 = new BitSet(new long[]{0x0000000021634000L});
	public static final BitSet FOLLOW_term_in_exp595 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_factor_in_term634 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_TIMES_in_term644 = new BitSet(new long[]{0x0000000021634000L});
	public static final BitSet FOLLOW_factor_in_term648 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_value_in_factor683 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_EQ_in_factor693 = new BitSet(new long[]{0x0000000021634000L});
	public static final BitSet FOLLOW_value_in_factor697 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_NAT_in_value737 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_value752 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_value765 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_value777 = new BitSet(new long[]{0x0000000021634000L});
	public static final BitSet FOLLOW_exp_in_value781 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_RPAR_in_value783 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_value795 = new BitSet(new long[]{0x0000000021634000L});
	public static final BitSet FOLLOW_exp_in_value799 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_THEN_in_value801 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLPAR_in_value803 = new BitSet(new long[]{0x0000000021634000L});
	public static final BitSet FOLLOW_exp_in_value807 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CRPAR_in_value809 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ELSE_in_value817 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLPAR_in_value819 = new BitSet(new long[]{0x0000000021634000L});
	public static final BitSet FOLLOW_exp_in_value823 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CRPAR_in_value825 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_value838 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_LPAR_in_value840 = new BitSet(new long[]{0x0000000021634000L});
	public static final BitSet FOLLOW_exp_in_value844 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_RPAR_in_value846 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value859 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_LPAR_in_value874 = new BitSet(new long[]{0x0000000023634000L});
	public static final BitSet FOLLOW_exp_in_value887 = new BitSet(new long[]{0x0000000002000100L});
	public static final BitSet FOLLOW_COMMA_in_value899 = new BitSet(new long[]{0x0000000021634000L});
	public static final BitSet FOLLOW_exp_in_value903 = new BitSet(new long[]{0x0000000002000100L});
	public static final BitSet FOLLOW_RPAR_in_value929 = new BitSet(new long[]{0x0000000000000002L});
}
