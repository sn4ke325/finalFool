// $ANTLR 3.5.2 C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g 2016-09-19 11:19:02

import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class SVMParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADD", "BRANCH", "BRANCHEQ", "BRANCHLESS", 
		"COL", "COPYFP", "DIV", "ERR", "HALT", "JS", "LABEL", "LOADFP", "LOADHP", 
		"LOADRA", "LOADRV", "LOADW", "MULT", "NUMBER", "POP", "PRINT", "PUSH", 
		"STOREFP", "STOREHP", "STORERA", "STORERV", "STOREW", "SUB", "WHITESP"
	};
	public static final int EOF=-1;
	public static final int ADD=4;
	public static final int BRANCH=5;
	public static final int BRANCHEQ=6;
	public static final int BRANCHLESS=7;
	public static final int COL=8;
	public static final int COPYFP=9;
	public static final int DIV=10;
	public static final int ERR=11;
	public static final int HALT=12;
	public static final int JS=13;
	public static final int LABEL=14;
	public static final int LOADFP=15;
	public static final int LOADHP=16;
	public static final int LOADRA=17;
	public static final int LOADRV=18;
	public static final int LOADW=19;
	public static final int MULT=20;
	public static final int NUMBER=21;
	public static final int POP=22;
	public static final int PRINT=23;
	public static final int PUSH=24;
	public static final int STOREFP=25;
	public static final int STOREHP=26;
	public static final int STORERA=27;
	public static final int STORERV=28;
	public static final int STOREW=29;
	public static final int SUB=30;
	public static final int WHITESP=31;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public SVMParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public SVMParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return SVMParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g"; }


	      
	    int[] code = new int[ExecuteVM.CODESIZE];    
	    private int i = 0;
	    private HashMap<String,Integer> labelAdd = new HashMap<String,Integer>();
	    private HashMap<Integer,String> labelRef = new HashMap<Integer,String>();
	        



	// $ANTLR start "assembly"
	// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:20:1: assembly : ( PUSH e= NUMBER | PUSH e= LABEL | POP | ADD | SUB | MULT | DIV | STOREW | LOADW |e= LABEL COL | BRANCH e= LABEL | BRANCHEQ e= LABEL | BRANCHLESS e= LABEL | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT )* ;
	public final void assembly() throws RecognitionException {
		Token e=null;

		try {
			// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:20:9: ( ( PUSH e= NUMBER | PUSH e= LABEL | POP | ADD | SUB | MULT | DIV | STOREW | LOADW |e= LABEL COL | BRANCH e= LABEL | BRANCHEQ e= LABEL | BRANCHLESS e= LABEL | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT )* )
			// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:21:5: ( PUSH e= NUMBER | PUSH e= LABEL | POP | ADD | SUB | MULT | DIV | STOREW | LOADW |e= LABEL COL | BRANCH e= LABEL | BRANCHEQ e= LABEL | BRANCHLESS e= LABEL | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT )*
			{
			// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:21:5: ( PUSH e= NUMBER | PUSH e= LABEL | POP | ADD | SUB | MULT | DIV | STOREW | LOADW |e= LABEL COL | BRANCH e= LABEL | BRANCHEQ e= LABEL | BRANCHLESS e= LABEL | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT )*
			loop1:
			while (true) {
				int alt1=26;
				switch ( input.LA(1) ) {
				case PUSH:
					{
					int LA1_2 = input.LA(2);
					if ( (LA1_2==NUMBER) ) {
						alt1=1;
					}
					else if ( (LA1_2==LABEL) ) {
						alt1=2;
					}

					}
					break;
				case POP:
					{
					alt1=3;
					}
					break;
				case ADD:
					{
					alt1=4;
					}
					break;
				case SUB:
					{
					alt1=5;
					}
					break;
				case MULT:
					{
					alt1=6;
					}
					break;
				case DIV:
					{
					alt1=7;
					}
					break;
				case STOREW:
					{
					alt1=8;
					}
					break;
				case LOADW:
					{
					alt1=9;
					}
					break;
				case LABEL:
					{
					alt1=10;
					}
					break;
				case BRANCH:
					{
					alt1=11;
					}
					break;
				case BRANCHEQ:
					{
					alt1=12;
					}
					break;
				case BRANCHLESS:
					{
					alt1=13;
					}
					break;
				case JS:
					{
					alt1=14;
					}
					break;
				case LOADRA:
					{
					alt1=15;
					}
					break;
				case STORERA:
					{
					alt1=16;
					}
					break;
				case LOADRV:
					{
					alt1=17;
					}
					break;
				case STORERV:
					{
					alt1=18;
					}
					break;
				case LOADFP:
					{
					alt1=19;
					}
					break;
				case STOREFP:
					{
					alt1=20;
					}
					break;
				case COPYFP:
					{
					alt1=21;
					}
					break;
				case LOADHP:
					{
					alt1=22;
					}
					break;
				case STOREHP:
					{
					alt1=23;
					}
					break;
				case PRINT:
					{
					alt1=24;
					}
					break;
				case HALT:
					{
					alt1=25;
					}
					break;
				}
				switch (alt1) {
				case 1 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:21:7: PUSH e= NUMBER
					{
					match(input,PUSH,FOLLOW_PUSH_in_assembly32); 
					e=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_assembly36); 
					code[i++] = PUSH; 
								                 code[i++] = Integer.parseInt((e!=null?e.getText():null));
					}
					break;
				case 2 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:23:6: PUSH e= LABEL
					{
					match(input,PUSH,FOLLOW_PUSH_in_assembly47); 
					e=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly51); 
					code[i++] = PUSH; //
						    		             labelRef.put(i++,(e!=null?e.getText():null));
					}
					break;
				case 3 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:25:6: POP
					{
					match(input,POP,FOLLOW_POP_in_assembly71); 
					code[i++] = POP;
					}
					break;
				case 4 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:26:6: ADD
					{
					match(input,ADD,FOLLOW_ADD_in_assembly86); 
					code[i++] = ADD;
					}
					break;
				case 5 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:27:6: SUB
					{
					match(input,SUB,FOLLOW_SUB_in_assembly100); 
					code[i++] = SUB;
					}
					break;
				case 6 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:28:6: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_assembly114); 
					code[i++] = MULT;
					}
					break;
				case 7 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:29:6: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_assembly127); 
					code[i++] = DIV;
					}
					break;
				case 8 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:30:6: STOREW
					{
					match(input,STOREW,FOLLOW_STOREW_in_assembly141); 
					code[i++] = STOREW;
					}
					break;
				case 9 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:31:6: LOADW
					{
					match(input,LOADW,FOLLOW_LOADW_in_assembly153); 
					code[i++] = LOADW;
					}
					break;
				case 10 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:32:6: e= LABEL COL
					{
					e=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly175); 
					match(input,COL,FOLLOW_COL_in_assembly177); 
					labelAdd.put((e!=null?e.getText():null),i);
					}
					break;
				case 11 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:33:6: BRANCH e= LABEL
					{
					match(input,BRANCH,FOLLOW_BRANCH_in_assembly190); 
					e=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly194); 
					code[i++] = BRANCH;
					                       labelRef.put(i++,(e!=null?e.getText():null));
					}
					break;
				case 12 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:35:6: BRANCHEQ e= LABEL
					{
					match(input,BRANCHEQ,FOLLOW_BRANCHEQ_in_assembly204); 
					e=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly208); 
					code[i++] = BRANCHEQ; //
					                        labelRef.put(i++,(e!=null?e.getText():null));
					}
					break;
				case 13 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:37:6: BRANCHLESS e= LABEL
					{
					match(input,BRANCHLESS,FOLLOW_BRANCHLESS_in_assembly217); 
					e=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly221); 
					code[i++] = BRANCHLESS;
					                          labelRef.put(i++,(e!=null?e.getText():null));
					}
					break;
				case 14 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:39:6: JS
					{
					match(input,JS,FOLLOW_JS_in_assembly230); 
					code[i++] = JS;
					}
					break;
				case 15 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:40:6: LOADRA
					{
					match(input,LOADRA,FOLLOW_LOADRA_in_assembly259); 
					code[i++] = LOADRA;
					}
					break;
				case 16 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:41:6: STORERA
					{
					match(input,STORERA,FOLLOW_STORERA_in_assembly281); 
					code[i++] = STORERA;
					}
					break;
				case 17 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:42:6: LOADRV
					{
					match(input,LOADRV,FOLLOW_LOADRV_in_assembly301); 
					code[i++] = LOADRV;
					}
					break;
				case 18 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:43:6: STORERV
					{
					match(input,STORERV,FOLLOW_STORERV_in_assembly322); 
					code[i++] = STORERV;
					}
					break;
				case 19 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:44:6: LOADFP
					{
					match(input,LOADFP,FOLLOW_LOADFP_in_assembly343); 
					code[i++] = LOADFP;
					}
					break;
				case 20 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:45:6: STOREFP
					{
					match(input,STOREFP,FOLLOW_STOREFP_in_assembly364); 
					code[i++] = STOREFP;
					}
					break;
				case 21 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:46:6: COPYFP
					{
					match(input,COPYFP,FOLLOW_COPYFP_in_assembly384); 
					code[i++] = COPYFP;
					}
					break;
				case 22 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:47:6: LOADHP
					{
					match(input,LOADHP,FOLLOW_LOADHP_in_assembly405); 
					code[i++] = LOADHP;
					}
					break;
				case 23 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:48:6: STOREHP
					{
					match(input,STOREHP,FOLLOW_STOREHP_in_assembly426); 
					code[i++] = STOREHP;
					}
					break;
				case 24 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:49:6: PRINT
					{
					match(input,PRINT,FOLLOW_PRINT_in_assembly446); 
					code[i++] = PRINT;
					}
					break;
				case 25 :
					// C:\\Users\\Lisa Sajeva\\Documents\\GitLinguaggi\\finalFool\\SVM.g:50:6: HALT
					{
					match(input,HALT,FOLLOW_HALT_in_assembly465); 
					code[i++] = HALT;
					}
					break;

				default :
					break loop1;
				}
			}

			 for (Integer refAdd: labelRef.keySet()) {
				              code[refAdd]=labelAdd.get(labelRef.get(refAdd));
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
	}
	// $ANTLR end "assembly"

	// Delegated rules



	public static final BitSet FOLLOW_PUSH_in_assembly32 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_NUMBER_in_assembly36 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_PUSH_in_assembly47 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_LABEL_in_assembly51 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_POP_in_assembly71 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_ADD_in_assembly86 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_SUB_in_assembly100 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_MULT_in_assembly114 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_DIV_in_assembly127 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_STOREW_in_assembly141 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_LOADW_in_assembly153 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_LABEL_in_assembly175 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_COL_in_assembly177 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_BRANCH_in_assembly190 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_LABEL_in_assembly194 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_BRANCHEQ_in_assembly204 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_LABEL_in_assembly208 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_BRANCHLESS_in_assembly217 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_LABEL_in_assembly221 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_JS_in_assembly230 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_LOADRA_in_assembly259 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_STORERA_in_assembly281 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_LOADRV_in_assembly301 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_STORERV_in_assembly322 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_LOADFP_in_assembly343 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_STOREFP_in_assembly364 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_COPYFP_in_assembly384 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_LOADHP_in_assembly405 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_STOREHP_in_assembly426 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_PRINT_in_assembly446 = new BitSet(new long[]{0x000000007FDFF6F2L});
	public static final BitSet FOLLOW_HALT_in_assembly465 = new BitSet(new long[]{0x000000007FDFF6F2L});
}
