// $ANTLR 3.5.2 D:\\git\\finalFool\\FOOL.g 2016-09-19 13:05:39

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class FOOLLexer extends Lexer {
	public static final int EOF=-1;
	public static final int ASS=4;
	public static final int BOOL=5;
	public static final int CLASS=6;
	public static final int CLPAR=7;
	public static final int COLON=8;
	public static final int COMMA=9;
	public static final int COMMENT=10;
	public static final int CRPAR=11;
	public static final int ELSE=12;
	public static final int EQ=13;
	public static final int ERR=14;
	public static final int EXTENDS=15;
	public static final int FALSE=16;
	public static final int FUN=17;
	public static final int ID=18;
	public static final int IF=19;
	public static final int IN=20;
	public static final int INT=21;
	public static final int LET=22;
	public static final int LPAR=23;
	public static final int NAT=24;
	public static final int PLUS=25;
	public static final int PRINT=26;
	public static final int RPAR=27;
	public static final int SEMIC=28;
	public static final int THEN=29;
	public static final int TIMES=30;
	public static final int TRUE=31;
	public static final int VAR=32;
	public static final int WHITESP=33;

	int lexicalErrors=0;


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public FOOLLexer() {} 
	public FOOLLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public FOOLLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "D:\\git\\finalFool\\FOOL.g"; }

	// $ANTLR start "SEMIC"
	public final void mSEMIC() throws RecognitionException {
		try {
			int _type = SEMIC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:167:7: ( ';' )
			// D:\\git\\finalFool\\FOOL.g:167:9: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMIC"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:168:7: ( ':' )
			// D:\\git\\finalFool\\FOOL.g:168:9: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:169:7: ( ',' )
			// D:\\git\\finalFool\\FOOL.g:169:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "EQ"
	public final void mEQ() throws RecognitionException {
		try {
			int _type = EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:170:4: ( '==' )
			// D:\\git\\finalFool\\FOOL.g:170:6: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ"

	// $ANTLR start "ASS"
	public final void mASS() throws RecognitionException {
		try {
			int _type = ASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:171:5: ( '=' )
			// D:\\git\\finalFool\\FOOL.g:171:7: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASS"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:172:6: ( '+' )
			// D:\\git\\finalFool\\FOOL.g:172:8: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "TIMES"
	public final void mTIMES() throws RecognitionException {
		try {
			int _type = TIMES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:173:7: ( '*' )
			// D:\\git\\finalFool\\FOOL.g:173:9: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TIMES"

	// $ANTLR start "NAT"
	public final void mNAT() throws RecognitionException {
		try {
			int _type = NAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:174:5: ( ( ( '1' .. '9' ) ( '0' .. '9' )* ) | '0' )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( ((LA2_0 >= '1' && LA2_0 <= '9')) ) {
				alt2=1;
			}
			else if ( (LA2_0=='0') ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// D:\\git\\finalFool\\FOOL.g:174:7: ( ( '1' .. '9' ) ( '0' .. '9' )* )
					{
					// D:\\git\\finalFool\\FOOL.g:174:7: ( ( '1' .. '9' ) ( '0' .. '9' )* )
					// D:\\git\\finalFool\\FOOL.g:174:8: ( '1' .. '9' ) ( '0' .. '9' )*
					{
					if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// D:\\git\\finalFool\\FOOL.g:174:18: ( '0' .. '9' )*
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
							alt1=1;
						}

						switch (alt1) {
						case 1 :
							// D:\\git\\finalFool\\FOOL.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop1;
						}
					}

					}

					}
					break;
				case 2 :
					// D:\\git\\finalFool\\FOOL.g:174:33: '0'
					{
					match('0'); 
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NAT"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:175:6: ( 'true' )
			// D:\\git\\finalFool\\FOOL.g:175:8: 'true'
			{
			match("true"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "FALSE"
	public final void mFALSE() throws RecognitionException {
		try {
			int _type = FALSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:176:7: ( 'false' )
			// D:\\git\\finalFool\\FOOL.g:176:9: 'false'
			{
			match("false"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FALSE"

	// $ANTLR start "LPAR"
	public final void mLPAR() throws RecognitionException {
		try {
			int _type = LPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:177:7: ( '(' )
			// D:\\git\\finalFool\\FOOL.g:177:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAR"

	// $ANTLR start "RPAR"
	public final void mRPAR() throws RecognitionException {
		try {
			int _type = RPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:178:6: ( ')' )
			// D:\\git\\finalFool\\FOOL.g:178:8: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAR"

	// $ANTLR start "CLPAR"
	public final void mCLPAR() throws RecognitionException {
		try {
			int _type = CLPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:179:8: ( '{' )
			// D:\\git\\finalFool\\FOOL.g:179:10: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLPAR"

	// $ANTLR start "CRPAR"
	public final void mCRPAR() throws RecognitionException {
		try {
			int _type = CRPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:180:7: ( '}' )
			// D:\\git\\finalFool\\FOOL.g:180:9: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CRPAR"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:181:5: ( 'if' )
			// D:\\git\\finalFool\\FOOL.g:181:7: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "THEN"
	public final void mTHEN() throws RecognitionException {
		try {
			int _type = THEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:182:7: ( 'then' )
			// D:\\git\\finalFool\\FOOL.g:182:9: 'then'
			{
			match("then"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "THEN"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:183:7: ( 'else' )
			// D:\\git\\finalFool\\FOOL.g:183:9: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "PRINT"
	public final void mPRINT() throws RecognitionException {
		try {
			int _type = PRINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:184:7: ( 'print' )
			// D:\\git\\finalFool\\FOOL.g:184:9: 'print'
			{
			match("print"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRINT"

	// $ANTLR start "LET"
	public final void mLET() throws RecognitionException {
		try {
			int _type = LET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:185:5: ( 'let' )
			// D:\\git\\finalFool\\FOOL.g:185:7: 'let'
			{
			match("let"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LET"

	// $ANTLR start "IN"
	public final void mIN() throws RecognitionException {
		try {
			int _type = IN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:186:4: ( 'in' )
			// D:\\git\\finalFool\\FOOL.g:186:6: 'in'
			{
			match("in"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IN"

	// $ANTLR start "VAR"
	public final void mVAR() throws RecognitionException {
		try {
			int _type = VAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:187:5: ( 'var' )
			// D:\\git\\finalFool\\FOOL.g:187:7: 'var'
			{
			match("var"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VAR"

	// $ANTLR start "FUN"
	public final void mFUN() throws RecognitionException {
		try {
			int _type = FUN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:188:5: ( 'fun' )
			// D:\\git\\finalFool\\FOOL.g:188:7: 'fun'
			{
			match("fun"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FUN"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:189:5: ( 'int' )
			// D:\\git\\finalFool\\FOOL.g:189:7: 'int'
			{
			match("int"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "BOOL"
	public final void mBOOL() throws RecognitionException {
		try {
			int _type = BOOL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:190:6: ( 'bool' )
			// D:\\git\\finalFool\\FOOL.g:190:8: 'bool'
			{
			match("bool"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BOOL"

	// $ANTLR start "CLASS"
	public final void mCLASS() throws RecognitionException {
		try {
			int _type = CLASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:191:7: ( 'class' )
			// D:\\git\\finalFool\\FOOL.g:191:8: 'class'
			{
			match("class"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLASS"

	// $ANTLR start "EXTENDS"
	public final void mEXTENDS() throws RecognitionException {
		try {
			int _type = EXTENDS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:192:9: ( 'extends' )
			// D:\\git\\finalFool\\FOOL.g:192:11: 'extends'
			{
			match("extends"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXTENDS"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:194:5: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
			// D:\\git\\finalFool\\FOOL.g:194:7: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// D:\\git\\finalFool\\FOOL.g:195:5: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// D:\\git\\finalFool\\FOOL.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop3;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "WHITESP"
	public final void mWHITESP() throws RecognitionException {
		try {
			int _type = WHITESP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:197:10: ( ( '\\t' | ' ' | '\\r' | '\\n' )+ )
			// D:\\git\\finalFool\\FOOL.g:197:12: ( '\\t' | ' ' | '\\r' | '\\n' )+
			{
			// D:\\git\\finalFool\\FOOL.g:197:12: ( '\\t' | ' ' | '\\r' | '\\n' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '\t' && LA4_0 <= '\n')||LA4_0=='\r'||LA4_0==' ') ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// D:\\git\\finalFool\\FOOL.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			 _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHITESP"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:199:9: ( '/*' ( . )* '*/' )
			// D:\\git\\finalFool\\FOOL.g:199:11: '/*' ( . )* '*/'
			{
			match("/*"); 

			// D:\\git\\finalFool\\FOOL.g:199:16: ( . )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0=='*') ) {
					int LA5_1 = input.LA(2);
					if ( (LA5_1=='/') ) {
						alt5=2;
					}
					else if ( ((LA5_1 >= '\u0000' && LA5_1 <= '.')||(LA5_1 >= '0' && LA5_1 <= '\uFFFF')) ) {
						alt5=1;
					}

				}
				else if ( ((LA5_0 >= '\u0000' && LA5_0 <= ')')||(LA5_0 >= '+' && LA5_0 <= '\uFFFF')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// D:\\git\\finalFool\\FOOL.g:199:16: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop5;
				}
			}

			match("*/"); 

			 _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "ERR"
	public final void mERR() throws RecognitionException {
		try {
			int _type = ERR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\git\\finalFool\\FOOL.g:201:9: ( . )
			// D:\\git\\finalFool\\FOOL.g:201:11: .
			{
			matchAny(); 
			 System.out.println("Invalid char: "+getText()); lexicalErrors++; _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ERR"

	@Override
	public void mTokens() throws RecognitionException {
		// D:\\git\\finalFool\\FOOL.g:1:8: ( SEMIC | COLON | COMMA | EQ | ASS | PLUS | TIMES | NAT | TRUE | FALSE | LPAR | RPAR | CLPAR | CRPAR | IF | THEN | ELSE | PRINT | LET | IN | VAR | FUN | INT | BOOL | CLASS | EXTENDS | ID | WHITESP | COMMENT | ERR )
		int alt6=30;
		alt6 = dfa6.predict(input);
		switch (alt6) {
			case 1 :
				// D:\\git\\finalFool\\FOOL.g:1:10: SEMIC
				{
				mSEMIC(); 

				}
				break;
			case 2 :
				// D:\\git\\finalFool\\FOOL.g:1:16: COLON
				{
				mCOLON(); 

				}
				break;
			case 3 :
				// D:\\git\\finalFool\\FOOL.g:1:22: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 4 :
				// D:\\git\\finalFool\\FOOL.g:1:28: EQ
				{
				mEQ(); 

				}
				break;
			case 5 :
				// D:\\git\\finalFool\\FOOL.g:1:31: ASS
				{
				mASS(); 

				}
				break;
			case 6 :
				// D:\\git\\finalFool\\FOOL.g:1:35: PLUS
				{
				mPLUS(); 

				}
				break;
			case 7 :
				// D:\\git\\finalFool\\FOOL.g:1:40: TIMES
				{
				mTIMES(); 

				}
				break;
			case 8 :
				// D:\\git\\finalFool\\FOOL.g:1:46: NAT
				{
				mNAT(); 

				}
				break;
			case 9 :
				// D:\\git\\finalFool\\FOOL.g:1:50: TRUE
				{
				mTRUE(); 

				}
				break;
			case 10 :
				// D:\\git\\finalFool\\FOOL.g:1:55: FALSE
				{
				mFALSE(); 

				}
				break;
			case 11 :
				// D:\\git\\finalFool\\FOOL.g:1:61: LPAR
				{
				mLPAR(); 

				}
				break;
			case 12 :
				// D:\\git\\finalFool\\FOOL.g:1:66: RPAR
				{
				mRPAR(); 

				}
				break;
			case 13 :
				// D:\\git\\finalFool\\FOOL.g:1:71: CLPAR
				{
				mCLPAR(); 

				}
				break;
			case 14 :
				// D:\\git\\finalFool\\FOOL.g:1:77: CRPAR
				{
				mCRPAR(); 

				}
				break;
			case 15 :
				// D:\\git\\finalFool\\FOOL.g:1:83: IF
				{
				mIF(); 

				}
				break;
			case 16 :
				// D:\\git\\finalFool\\FOOL.g:1:86: THEN
				{
				mTHEN(); 

				}
				break;
			case 17 :
				// D:\\git\\finalFool\\FOOL.g:1:91: ELSE
				{
				mELSE(); 

				}
				break;
			case 18 :
				// D:\\git\\finalFool\\FOOL.g:1:96: PRINT
				{
				mPRINT(); 

				}
				break;
			case 19 :
				// D:\\git\\finalFool\\FOOL.g:1:102: LET
				{
				mLET(); 

				}
				break;
			case 20 :
				// D:\\git\\finalFool\\FOOL.g:1:106: IN
				{
				mIN(); 

				}
				break;
			case 21 :
				// D:\\git\\finalFool\\FOOL.g:1:109: VAR
				{
				mVAR(); 

				}
				break;
			case 22 :
				// D:\\git\\finalFool\\FOOL.g:1:113: FUN
				{
				mFUN(); 

				}
				break;
			case 23 :
				// D:\\git\\finalFool\\FOOL.g:1:117: INT
				{
				mINT(); 

				}
				break;
			case 24 :
				// D:\\git\\finalFool\\FOOL.g:1:121: BOOL
				{
				mBOOL(); 

				}
				break;
			case 25 :
				// D:\\git\\finalFool\\FOOL.g:1:126: CLASS
				{
				mCLASS(); 

				}
				break;
			case 26 :
				// D:\\git\\finalFool\\FOOL.g:1:132: EXTENDS
				{
				mEXTENDS(); 

				}
				break;
			case 27 :
				// D:\\git\\finalFool\\FOOL.g:1:140: ID
				{
				mID(); 

				}
				break;
			case 28 :
				// D:\\git\\finalFool\\FOOL.g:1:143: WHITESP
				{
				mWHITESP(); 

				}
				break;
			case 29 :
				// D:\\git\\finalFool\\FOOL.g:1:151: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 30 :
				// D:\\git\\finalFool\\FOOL.g:1:159: ERR
				{
				mERR(); 

				}
				break;

		}
	}


	protected DFA6 dfa6 = new DFA6(this);
	static final String DFA6_eotS =
		"\4\uffff\1\36\4\uffff\2\44\4\uffff\7\44\2\uffff\1\31\11\uffff\2\44\1\uffff"+
		"\2\44\4\uffff\1\72\1\74\7\44\2\uffff\3\44\1\107\1\uffff\1\110\1\uffff"+
		"\3\44\1\114\1\115\2\44\1\120\1\121\1\44\2\uffff\1\123\2\44\2\uffff\1\126"+
		"\1\44\2\uffff\1\130\1\uffff\1\44\1\132\1\uffff\1\133\1\uffff\1\44\2\uffff"+
		"\1\135\1\uffff";
	static final String DFA6_eofS =
		"\136\uffff";
	static final String DFA6_minS =
		"\1\0\3\uffff\1\75\4\uffff\1\150\1\141\4\uffff\1\146\1\154\1\162\1\145"+
		"\1\141\1\157\1\154\2\uffff\1\52\11\uffff\1\165\1\145\1\uffff\1\154\1\156"+
		"\4\uffff\2\60\1\163\1\164\1\151\1\164\1\162\1\157\1\141\2\uffff\1\145"+
		"\1\156\1\163\1\60\1\uffff\1\60\1\uffff\2\145\1\156\2\60\1\154\1\163\2"+
		"\60\1\145\2\uffff\1\60\1\156\1\164\2\uffff\1\60\1\163\2\uffff\1\60\1\uffff"+
		"\1\144\1\60\1\uffff\1\60\1\uffff\1\163\2\uffff\1\60\1\uffff";
	static final String DFA6_maxS =
		"\1\uffff\3\uffff\1\75\4\uffff\1\162\1\165\4\uffff\1\156\1\170\1\162\1"+
		"\145\1\141\1\157\1\154\2\uffff\1\52\11\uffff\1\165\1\145\1\uffff\1\154"+
		"\1\156\4\uffff\2\172\1\163\1\164\1\151\1\164\1\162\1\157\1\141\2\uffff"+
		"\1\145\1\156\1\163\1\172\1\uffff\1\172\1\uffff\2\145\1\156\2\172\1\154"+
		"\1\163\2\172\1\145\2\uffff\1\172\1\156\1\164\2\uffff\1\172\1\163\2\uffff"+
		"\1\172\1\uffff\1\144\1\172\1\uffff\1\172\1\uffff\1\163\2\uffff\1\172\1"+
		"\uffff";
	static final String DFA6_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\uffff\1\6\1\7\2\10\2\uffff\1\13\1\14\1\15\1\16"+
		"\7\uffff\1\33\1\34\1\uffff\1\36\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff"+
		"\1\33\2\uffff\1\13\1\14\1\15\1\16\11\uffff\1\34\1\35\4\uffff\1\17\1\uffff"+
		"\1\24\12\uffff\1\26\1\27\3\uffff\1\23\1\25\2\uffff\1\11\1\20\1\uffff\1"+
		"\21\2\uffff\1\30\1\uffff\1\12\1\uffff\1\22\1\31\1\uffff\1\32";
	static final String DFA6_specialS =
		"\1\0\135\uffff}>";
	static final String[] DFA6_transitionS = {
			"\11\31\2\27\2\31\1\27\22\31\1\27\7\31\1\13\1\14\1\6\1\5\1\3\2\31\1\30"+
			"\1\10\11\7\1\2\1\1\1\31\1\4\3\31\32\26\6\31\1\26\1\24\1\25\1\26\1\20"+
			"\1\12\2\26\1\17\2\26\1\22\3\26\1\21\3\26\1\11\1\26\1\23\4\26\1\15\1\31"+
			"\1\16\uff82\31",
			"",
			"",
			"",
			"\1\35",
			"",
			"",
			"",
			"",
			"\1\43\11\uffff\1\42",
			"\1\45\23\uffff\1\46",
			"",
			"",
			"",
			"",
			"\1\53\7\uffff\1\54",
			"\1\55\13\uffff\1\56",
			"\1\57",
			"\1\60",
			"\1\61",
			"\1\62",
			"\1\63",
			"",
			"",
			"\1\65",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\66",
			"\1\67",
			"",
			"\1\70",
			"\1\71",
			"",
			"",
			"",
			"",
			"\12\44\7\uffff\32\44\6\uffff\32\44",
			"\12\44\7\uffff\32\44\6\uffff\23\44\1\73\6\44",
			"\1\75",
			"\1\76",
			"\1\77",
			"\1\100",
			"\1\101",
			"\1\102",
			"\1\103",
			"",
			"",
			"\1\104",
			"\1\105",
			"\1\106",
			"\12\44\7\uffff\32\44\6\uffff\32\44",
			"",
			"\12\44\7\uffff\32\44\6\uffff\32\44",
			"",
			"\1\111",
			"\1\112",
			"\1\113",
			"\12\44\7\uffff\32\44\6\uffff\32\44",
			"\12\44\7\uffff\32\44\6\uffff\32\44",
			"\1\116",
			"\1\117",
			"\12\44\7\uffff\32\44\6\uffff\32\44",
			"\12\44\7\uffff\32\44\6\uffff\32\44",
			"\1\122",
			"",
			"",
			"\12\44\7\uffff\32\44\6\uffff\32\44",
			"\1\124",
			"\1\125",
			"",
			"",
			"\12\44\7\uffff\32\44\6\uffff\32\44",
			"\1\127",
			"",
			"",
			"\12\44\7\uffff\32\44\6\uffff\32\44",
			"",
			"\1\131",
			"\12\44\7\uffff\32\44\6\uffff\32\44",
			"",
			"\12\44\7\uffff\32\44\6\uffff\32\44",
			"",
			"\1\134",
			"",
			"",
			"\12\44\7\uffff\32\44\6\uffff\32\44",
			""
	};

	static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
	static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
	static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
	static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
	static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
	static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
	static final short[][] DFA6_transition;

	static {
		int numStates = DFA6_transitionS.length;
		DFA6_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
		}
	}

	protected class DFA6 extends DFA {

		public DFA6(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 6;
			this.eot = DFA6_eot;
			this.eof = DFA6_eof;
			this.min = DFA6_min;
			this.max = DFA6_max;
			this.accept = DFA6_accept;
			this.special = DFA6_special;
			this.transition = DFA6_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( SEMIC | COLON | COMMA | EQ | ASS | PLUS | TIMES | NAT | TRUE | FALSE | LPAR | RPAR | CLPAR | CRPAR | IF | THEN | ELSE | PRINT | LET | IN | VAR | FUN | INT | BOOL | CLASS | EXTENDS | ID | WHITESP | COMMENT | ERR );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA6_0 = input.LA(1);
						s = -1;
						if ( (LA6_0==';') ) {s = 1;}
						else if ( (LA6_0==':') ) {s = 2;}
						else if ( (LA6_0==',') ) {s = 3;}
						else if ( (LA6_0=='=') ) {s = 4;}
						else if ( (LA6_0=='+') ) {s = 5;}
						else if ( (LA6_0=='*') ) {s = 6;}
						else if ( ((LA6_0 >= '1' && LA6_0 <= '9')) ) {s = 7;}
						else if ( (LA6_0=='0') ) {s = 8;}
						else if ( (LA6_0=='t') ) {s = 9;}
						else if ( (LA6_0=='f') ) {s = 10;}
						else if ( (LA6_0=='(') ) {s = 11;}
						else if ( (LA6_0==')') ) {s = 12;}
						else if ( (LA6_0=='{') ) {s = 13;}
						else if ( (LA6_0=='}') ) {s = 14;}
						else if ( (LA6_0=='i') ) {s = 15;}
						else if ( (LA6_0=='e') ) {s = 16;}
						else if ( (LA6_0=='p') ) {s = 17;}
						else if ( (LA6_0=='l') ) {s = 18;}
						else if ( (LA6_0=='v') ) {s = 19;}
						else if ( (LA6_0=='b') ) {s = 20;}
						else if ( (LA6_0=='c') ) {s = 21;}
						else if ( ((LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='a'||LA6_0=='d'||(LA6_0 >= 'g' && LA6_0 <= 'h')||(LA6_0 >= 'j' && LA6_0 <= 'k')||(LA6_0 >= 'm' && LA6_0 <= 'o')||(LA6_0 >= 'q' && LA6_0 <= 's')||LA6_0=='u'||(LA6_0 >= 'w' && LA6_0 <= 'z')) ) {s = 22;}
						else if ( ((LA6_0 >= '\t' && LA6_0 <= '\n')||LA6_0=='\r'||LA6_0==' ') ) {s = 23;}
						else if ( (LA6_0=='/') ) {s = 24;}
						else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\b')||(LA6_0 >= '\u000B' && LA6_0 <= '\f')||(LA6_0 >= '\u000E' && LA6_0 <= '\u001F')||(LA6_0 >= '!' && LA6_0 <= '\'')||(LA6_0 >= '-' && LA6_0 <= '.')||LA6_0=='<'||(LA6_0 >= '>' && LA6_0 <= '@')||(LA6_0 >= '[' && LA6_0 <= '`')||LA6_0=='|'||(LA6_0 >= '~' && LA6_0 <= '\uFFFF')) ) {s = 25;}
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 6, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
