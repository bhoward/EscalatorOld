// $ANTLR 3.0 /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g 2007-07-31 11:22:30

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ScalaSubsetLexer extends Lexer {
    public static final int Comment=31;
    public static final int CharEscapeSeq=25;
    public static final int Digit=17;
    public static final int HexDigit=30;
    public static final int T36=36;
    public static final int Op=5;
    public static final int Line_Comment=32;
    public static final int T35=35;
    public static final int OctalDigits=28;
    public static final int T45=45;
    public static final int T34=34;
    public static final int StringElement=26;
    public static final int Letter=16;
    public static final int T37=37;
    public static final int OpChar=18;
    public static final int T46=46;
    public static final int UpperID=10;
    public static final int T38=38;
    public static final int HexNumeral=20;
    public static final int FloatingPointLiteral=7;
    public static final int T41=41;
    public static final int IdRest=14;
    public static final int T39=39;
    public static final int T44=44;
    public static final int DecimalNumeral=19;
    public static final int VarID=11;
    public static final int T33=33;
    public static final int OctalNumeral=21;
    public static final int T50=50;
    public static final int WS=12;
    public static final int CharacterLiteral=8;
    public static final int IntegerLiteral=6;
    public static final int T43=43;
    public static final int OctalDigit=29;
    public static final int T42=42;
    public static final int T40=40;
    public static final int StringLiteral=9;
    public static final int Upper=13;
    public static final int FloatType=23;
    public static final int ExponentPart=22;
    public static final int T48=48;
    public static final int PrintableCharNoDoubleQuote=27;
    public static final int Newline=4;
    public static final int EOF=-1;
    public static final int T47=47;
    public static final int Tokens=51;
    public static final int T49=49;
    public static final int PrintableChar=24;
    public static final int Lower=15;
    public ScalaSubsetLexer() {;} 
    public ScalaSubsetLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g"; }

    // $ANTLR start T33
    public final void mT33() throws RecognitionException {
        try {
            int _type = T33;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:3:5: ( 'package' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:3:7: 'package'
            {
            match("package"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T33

    // $ANTLR start T34
    public final void mT34() throws RecognitionException {
        try {
            int _type = T34;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:4:5: ( '.' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:4:7: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T34

    // $ANTLR start T35
    public final void mT35() throws RecognitionException {
        try {
            int _type = T35;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:5:5: ( 'object' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:5:7: 'object'
            {
            match("object"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T35

    // $ANTLR start T36
    public final void mT36() throws RecognitionException {
        try {
            int _type = T36;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:6:5: ( '{' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:6:7: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T36

    // $ANTLR start T37
    public final void mT37() throws RecognitionException {
        try {
            int _type = T37;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:7:5: ( '}' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:7:7: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T37

    // $ANTLR start T38
    public final void mT38() throws RecognitionException {
        try {
            int _type = T38;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:8:5: ( 'def' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:8:7: 'def'
            {
            match("def"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T38

    // $ANTLR start T39
    public final void mT39() throws RecognitionException {
        try {
            int _type = T39;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:9:5: ( ':' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:9:7: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T39

    // $ANTLR start T40
    public final void mT40() throws RecognitionException {
        try {
            int _type = T40;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:10:5: ( '=' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:10:7: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T40

    // $ANTLR start T41
    public final void mT41() throws RecognitionException {
        try {
            int _type = T41;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:11:5: ( '(' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:11:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T41

    // $ANTLR start T42
    public final void mT42() throws RecognitionException {
        try {
            int _type = T42;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:12:5: ( ')' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:12:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T42

    // $ANTLR start T43
    public final void mT43() throws RecognitionException {
        try {
            int _type = T43;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:13:5: ( ',' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:13:7: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T43

    // $ANTLR start T44
    public final void mT44() throws RecognitionException {
        try {
            int _type = T44;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:14:5: ( 'case' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:14:7: 'case'
            {
            match("case"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T44

    // $ANTLR start T45
    public final void mT45() throws RecognitionException {
        try {
            int _type = T45;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:15:5: ( '=>' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:15:7: '=>'
            {
            match("=>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T45

    // $ANTLR start T46
    public final void mT46() throws RecognitionException {
        try {
            int _type = T46;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:16:5: ( 'true' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:16:7: 'true'
            {
            match("true"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T46

    // $ANTLR start T47
    public final void mT47() throws RecognitionException {
        try {
            int _type = T47;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:17:5: ( 'false' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:17:7: 'false'
            {
            match("false"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T47

    // $ANTLR start T48
    public final void mT48() throws RecognitionException {
        try {
            int _type = T48;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:18:5: ( '[' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:18:7: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T48

    // $ANTLR start T49
    public final void mT49() throws RecognitionException {
        try {
            int _type = T49;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:19:5: ( ']' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:19:7: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T49

    // $ANTLR start T50
    public final void mT50() throws RecognitionException {
        try {
            int _type = T50;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:20:5: ( ';' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:20:7: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T50

    // $ANTLR start Newline
    public final void mNewline() throws RecognitionException {
        try {
            int _type = Newline;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:190:9: ( '\\n' | '\\r' ( '\\n' )? )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\n') ) {
                alt2=1;
            }
            else if ( (LA2_0=='\r') ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("190:1: Newline : ( '\\n' | '\\r' ( '\\n' )? );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:190:11: '\\n'
                    {
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:190:18: '\\r' ( '\\n' )?
                    {
                    match('\r'); 
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:190:23: ( '\\n' )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0=='\n') ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:190:23: '\\n'
                            {
                            match('\n'); 

                            }
                            break;

                    }


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Newline

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:193:4: ( ( ' ' | '\\t' | '\\f' )+ )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:193:6: ( ' ' | '\\t' | '\\f' )+
            {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:193:6: ( ' ' | '\\t' | '\\f' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\t'||LA3_0=='\f'||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

             channel=HIDDEN; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    // $ANTLR start UpperID
    public final void mUpperID() throws RecognitionException {
        try {
            int _type = UpperID;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:196:9: ( Upper IdRest )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:196:11: Upper IdRest
            {
            mUpper(); 
            mIdRest(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end UpperID

    // $ANTLR start VarID
    public final void mVarID() throws RecognitionException {
        try {
            int _type = VarID;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:199:7: ( Lower IdRest )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:199:9: Lower IdRest
            {
            mLower(); 
            mIdRest(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end VarID

    // $ANTLR start IdRest
    public final void mIdRest() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:203:8: ( ( Letter | Digit )* ( '_' Op )? )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:203:10: ( Letter | Digit )* ( '_' Op )?
            {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:203:10: ( Letter | Digit )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='_') ) {
                    int LA4_1 = input.LA(2);



                    alt4=1; 
                }
                else if ( (LA4_0=='$'||(LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||(LA4_0>='a' && LA4_0<='z')||LA4_0=='\u00AA'||LA4_0=='\u00B5'||LA4_0=='\u00BA'||(LA4_0>='\u00C0' && LA4_0<='\u00D6')||(LA4_0>='\u00D8' && LA4_0<='\u00F6')||(LA4_0>='\u00F8' && LA4_0<='\u1FFF')||(LA4_0>='\u3040' && LA4_0<='\u31FF')||(LA4_0>='\u3400' && LA4_0<='\u3D2D')||(LA4_0>='\u4E00' && LA4_0<='\u9FFF')||(LA4_0>='\uF900' && LA4_0<='\uFAFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:
            	    {
            	    if ( input.LA(1)=='$'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||input.LA(1)=='\u00AA'||input.LA(1)=='\u00B5'||input.LA(1)=='\u00BA'||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u1FFF')||(input.LA(1)>='\u3040' && input.LA(1)<='\u31FF')||(input.LA(1)>='\u3400' && input.LA(1)<='\u3D2D')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FFF')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFAFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:203:28: ( '_' Op )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='_') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:203:29: '_' Op
                    {
                    match('_'); 
                    mOp(); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end IdRest

    // $ANTLR start Letter
    public final void mLetter() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:207:8: ( Upper | Lower )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:
            {
            if ( input.LA(1)=='$'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||input.LA(1)=='\u00AA'||input.LA(1)=='\u00B5'||input.LA(1)=='\u00BA'||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u1FFF')||(input.LA(1)>='\u3040' && input.LA(1)<='\u31FF')||(input.LA(1)>='\u3400' && input.LA(1)<='\u3D2D')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FFF')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFAFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end Letter

    // $ANTLR start Upper
    public final void mUpper() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:215:7: ( 'A' .. 'Z' | '$' | '_' | '\\u00c0' .. '\\u00d6' | '\\u00d8' .. '\\u00de' | '\\u0100' .. '\\u1fff' | '\\u3040' .. '\\u31ff' | '\\u3400' .. '\\u3d2d' | '\\u4e00' .. '\\u9fff' | '\\uf900' .. '\\ufaff' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:
            {
            if ( input.LA(1)=='$'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00DE')||(input.LA(1)>='\u0100' && input.LA(1)<='\u1FFF')||(input.LA(1)>='\u3040' && input.LA(1)<='\u31FF')||(input.LA(1)>='\u3400' && input.LA(1)<='\u3D2D')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FFF')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFAFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end Upper

    // $ANTLR start Lower
    public final void mLower() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:228:7: ( 'a' .. 'z' | '\\u00aa' | '\\u00b5' | '\\u00ba' | '\\u00df' .. '\\u00f6' | '\\u00f8' .. '\\u00ff' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:
            {
            if ( (input.LA(1)>='a' && input.LA(1)<='z')||input.LA(1)=='\u00AA'||input.LA(1)=='\u00B5'||input.LA(1)=='\u00BA'||(input.LA(1)>='\u00DF' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u00FF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end Lower

    // $ANTLR start Op
    public final void mOp() throws RecognitionException {
        try {
            int _type = Op;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:236:4: ( ( OpChar )+ )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:236:6: ( OpChar )+
            {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:236:6: ( OpChar )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='!'||(LA6_0>='%' && LA6_0<='&')||(LA6_0>='*' && LA6_0<='+')||LA6_0=='-'||LA6_0=='/'||(LA6_0>='<' && LA6_0<='?')||LA6_0=='\\'||LA6_0=='^'||LA6_0=='|'||LA6_0=='~'||(LA6_0>='\u00A6' && LA6_0<='\u00A7')||LA6_0=='\u00A9'||LA6_0=='\u00AC'||LA6_0=='\u00AE'||(LA6_0>='\u00B0' && LA6_0<='\u00B1')||LA6_0=='\u00B6'||LA6_0=='\u00D7'||LA6_0=='\u00F7'||(LA6_0>='\u2000' && LA6_0<='\u303F')||(LA6_0>='\u3300' && LA6_0<='\u337F')||(LA6_0>='\u4DC0' && LA6_0<='\u4DFF')||(LA6_0>='\uFB00' && LA6_0<='\uFFFD')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:236:6: OpChar
            	    {
            	    mOpChar(); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Op

    // $ANTLR start OpChar
    public final void mOpChar() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:240:8: ( '!' | '%' | '&' | '*' | '+' | '-' | '/' | '<' | '=' | '>' | '?' | '\\\\' | '^' | '|' | '~' | '\\u00a6' | '\\u00a7' | '\\u00a9' | '\\u00ac' | '\\u00ae' | '\\u00b0' | '\\u00b1' | '\\u00b6' | '\\u00d7' | '\\u00f7' | '\\u2000' .. '\\u303f' | '\\u3300' .. '\\u337f' | '\\u4dc0' .. '\\u4dff' | '\\ufb00' .. '\\ufffd' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:
            {
            if ( input.LA(1)=='!'||(input.LA(1)>='%' && input.LA(1)<='&')||(input.LA(1)>='*' && input.LA(1)<='+')||input.LA(1)=='-'||input.LA(1)=='/'||(input.LA(1)>='<' && input.LA(1)<='?')||input.LA(1)=='\\'||input.LA(1)=='^'||input.LA(1)=='|'||input.LA(1)=='~'||(input.LA(1)>='\u00A6' && input.LA(1)<='\u00A7')||input.LA(1)=='\u00A9'||input.LA(1)=='\u00AC'||input.LA(1)=='\u00AE'||(input.LA(1)>='\u00B0' && input.LA(1)<='\u00B1')||input.LA(1)=='\u00B6'||input.LA(1)=='\u00D7'||input.LA(1)=='\u00F7'||(input.LA(1)>='\u2000' && input.LA(1)<='\u303F')||(input.LA(1)>='\u3300' && input.LA(1)<='\u337F')||(input.LA(1)>='\u4DC0' && input.LA(1)<='\u4DFF')||(input.LA(1)>='\uFB00' && input.LA(1)<='\uFFFD') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end OpChar

    // $ANTLR start IntegerLiteral
    public final void mIntegerLiteral() throws RecognitionException {
        try {
            int _type = IntegerLiteral;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:258:2: ( ( DecimalNumeral | HexNumeral | OctalNumeral ) ( 'L' | 'l' )? )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:258:4: ( DecimalNumeral | HexNumeral | OctalNumeral ) ( 'L' | 'l' )?
            {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:258:4: ( DecimalNumeral | HexNumeral | OctalNumeral )
            int alt7=3;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='0') ) {
                switch ( input.LA(2) ) {
                case 'x':
                    {
                    alt7=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt7=3;
                    }
                    break;
                default:
                    alt7=1;}

            }
            else if ( ((LA7_0>='1' && LA7_0<='9')) ) {
                alt7=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("258:4: ( DecimalNumeral | HexNumeral | OctalNumeral )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:258:5: DecimalNumeral
                    {
                    mDecimalNumeral(); 

                    }
                    break;
                case 2 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:258:22: HexNumeral
                    {
                    mHexNumeral(); 

                    }
                    break;
                case 3 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:258:35: OctalNumeral
                    {
                    mOctalNumeral(); 

                    }
                    break;

            }

            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:258:49: ( 'L' | 'l' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='L'||LA8_0=='l') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:
                    {
                    if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end IntegerLiteral

    // $ANTLR start FloatingPointLiteral
    public final void mFloatingPointLiteral() throws RecognitionException {
        try {
            int _type = FloatingPointLiteral;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:262:2: ( ( Digit )+ '.' ( Digit )* ( ExponentPart )? ( FloatType )? | '.' ( Digit )+ ( ExponentPart )? ( FloatType )? | ( Digit )+ ExponentPart ( FloatType )? | ( Digit )+ FloatType )
            int alt19=4;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:262:4: ( Digit )+ '.' ( Digit )* ( ExponentPart )? ( FloatType )?
                    {
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:262:4: ( Digit )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:262:4: Digit
                    	    {
                    	    mDigit(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);

                    match('.'); 
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:262:15: ( Digit )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:262:15: Digit
                    	    {
                    	    mDigit(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:262:22: ( ExponentPart )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='E'||LA11_0=='e') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:262:22: ExponentPart
                            {
                            mExponentPart(); 

                            }
                            break;

                    }

                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:262:36: ( FloatType )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='D'||LA12_0=='F'||LA12_0=='d'||LA12_0=='f') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:262:36: FloatType
                            {
                            mFloatType(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:263:4: '.' ( Digit )+ ( ExponentPart )? ( FloatType )?
                    {
                    match('.'); 
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:263:8: ( Digit )+
                    int cnt13=0;
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:263:8: Digit
                    	    {
                    	    mDigit(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt13 >= 1 ) break loop13;
                                EarlyExitException eee =
                                    new EarlyExitException(13, input);
                                throw eee;
                        }
                        cnt13++;
                    } while (true);

                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:263:15: ( ExponentPart )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='E'||LA14_0=='e') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:263:15: ExponentPart
                            {
                            mExponentPart(); 

                            }
                            break;

                    }

                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:263:29: ( FloatType )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='D'||LA15_0=='F'||LA15_0=='d'||LA15_0=='f') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:263:29: FloatType
                            {
                            mFloatType(); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:264:4: ( Digit )+ ExponentPart ( FloatType )?
                    {
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:264:4: ( Digit )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>='0' && LA16_0<='9')) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:264:4: Digit
                    	    {
                    	    mDigit(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);

                    mExponentPart(); 
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:264:24: ( FloatType )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0=='D'||LA17_0=='F'||LA17_0=='d'||LA17_0=='f') ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:264:24: FloatType
                            {
                            mFloatType(); 

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:265:4: ( Digit )+ FloatType
                    {
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:265:4: ( Digit )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>='0' && LA18_0<='9')) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:265:4: Digit
                    	    {
                    	    mDigit(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);

                    mFloatType(); 

                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FloatingPointLiteral

    // $ANTLR start ExponentPart
    public final void mExponentPart() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:270:2: ( ( 'E' | 'e' ) ( '+' | '-' )? ( Digit )+ )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:270:4: ( 'E' | 'e' ) ( '+' | '-' )? ( Digit )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:270:16: ( '+' | '-' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='+'||LA20_0=='-') ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }

            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:270:29: ( Digit )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>='0' && LA21_0<='9')) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:270:29: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end ExponentPart

    // $ANTLR start FloatType
    public final void mFloatType() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:275:2: ( 'F' | 'f' | 'D' | 'd' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:
            {
            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end FloatType

    // $ANTLR start CharacterLiteral
    public final void mCharacterLiteral() throws RecognitionException {
        try {
            int _type = CharacterLiteral;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:279:2: ( '\\'' PrintableChar '\\'' | '\\'' CharEscapeSeq '\\'' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0=='\'') ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1=='\\') ) {
                    int LA22_2 = input.LA(3);

                    if ( (LA22_2=='\'') ) {
                        int LA22_4 = input.LA(4);

                        if ( (LA22_4=='\'') ) {
                            alt22=2;
                        }
                        else {
                            alt22=1;}
                    }
                    else if ( (LA22_2=='\"'||(LA22_2>='0' && LA22_2<='7')||LA22_2=='\\'||LA22_2=='b'||LA22_2=='f'||LA22_2=='n'||LA22_2=='r'||LA22_2=='t') ) {
                        alt22=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("278:1: CharacterLiteral : ( '\\'' PrintableChar '\\'' | '\\'' CharEscapeSeq '\\'' );", 22, 2, input);

                        throw nvae;
                    }
                }
                else if ( ((LA22_1>=' ' && LA22_1<='[')||(LA22_1>=']' && LA22_1<='\uFFFE')) ) {
                    alt22=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("278:1: CharacterLiteral : ( '\\'' PrintableChar '\\'' | '\\'' CharEscapeSeq '\\'' );", 22, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("278:1: CharacterLiteral : ( '\\'' PrintableChar '\\'' | '\\'' CharEscapeSeq '\\'' );", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:279:4: '\\'' PrintableChar '\\''
                    {
                    match('\''); 
                    mPrintableChar(); 
                    match('\''); 

                    }
                    break;
                case 2 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:280:4: '\\'' CharEscapeSeq '\\''
                    {
                    match('\''); 
                    mCharEscapeSeq(); 
                    match('\''); 

                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CharacterLiteral

    // $ANTLR start StringLiteral
    public final void mStringLiteral() throws RecognitionException {
        try {
            int _type = StringLiteral;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:284:2: ( '\"' ( StringElement )* '\"' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:284:4: '\"' ( StringElement )* '\"'
            {
            match('\"'); 
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:284:8: ( StringElement )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=' ' && LA23_0<='!')||(LA23_0>='#' && LA23_0<='\uFFFE')) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:284:8: StringElement
            	    {
            	    mStringElement(); 

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            match('\"'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end StringLiteral

    // $ANTLR start PrintableChar
    public final void mPrintableChar() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:289:2: ( PrintableCharNoDoubleQuote | '\"' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:
            {
            if ( (input.LA(1)>=' ' && input.LA(1)<='\uFFFE') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end PrintableChar

    // $ANTLR start CharEscapeSeq
    public final void mCharEscapeSeq() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:295:2: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' | OctalDigits ) )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:295:4: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' | OctalDigits )
            {
            match('\\'); 
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:295:9: ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' | OctalDigits )
            int alt24=9;
            switch ( input.LA(1) ) {
            case 'b':
                {
                alt24=1;
                }
                break;
            case 't':
                {
                alt24=2;
                }
                break;
            case 'n':
                {
                alt24=3;
                }
                break;
            case 'f':
                {
                alt24=4;
                }
                break;
            case 'r':
                {
                alt24=5;
                }
                break;
            case '\"':
                {
                alt24=6;
                }
                break;
            case '\'':
                {
                alt24=7;
                }
                break;
            case '\\':
                {
                alt24=8;
                }
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
                {
                alt24=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("295:9: ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' | OctalDigits )", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:295:10: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 2 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:295:16: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 3 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:295:22: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 4 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:295:28: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 5 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:295:34: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 6 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:295:40: '\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 7 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:295:46: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 8 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:295:53: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 9 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:295:60: OctalDigits
                    {
                    mOctalDigits(); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end CharEscapeSeq

    // $ANTLR start OctalDigits
    public final void mOctalDigits() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:300:2: ( OctalDigit ( OctalDigit ( OctalDigit )? )? )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:300:4: OctalDigit ( OctalDigit ( OctalDigit )? )?
            {
            mOctalDigit(); 
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:300:15: ( OctalDigit ( OctalDigit )? )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>='0' && LA26_0<='7')) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:300:16: OctalDigit ( OctalDigit )?
                    {
                    mOctalDigit(); 
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:300:27: ( OctalDigit )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( ((LA25_0>='0' && LA25_0<='7')) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:300:27: OctalDigit
                            {
                            mOctalDigit(); 

                            }
                            break;

                    }


                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end OctalDigits

    // $ANTLR start StringElement
    public final void mStringElement() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:305:2: ( PrintableCharNoDoubleQuote | CharEscapeSeq )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0=='\\') ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1=='\"'||LA27_1=='\''||(LA27_1>='0' && LA27_1<='7')||LA27_1=='\\'||LA27_1=='b'||LA27_1=='f'||LA27_1=='n'||LA27_1=='r'||LA27_1=='t') ) {
                    alt27=2;
                }
                else {
                    alt27=1;}
            }
            else if ( ((LA27_0>=' ' && LA27_0<='!')||(LA27_0>='#' && LA27_0<='[')||(LA27_0>=']' && LA27_0<='\uFFFE')) ) {
                alt27=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("303:1: fragment StringElement : ( PrintableCharNoDoubleQuote | CharEscapeSeq );", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:305:4: PrintableCharNoDoubleQuote
                    {
                    mPrintableCharNoDoubleQuote(); 

                    }
                    break;
                case 2 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:306:4: CharEscapeSeq
                    {
                    mCharEscapeSeq(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end StringElement

    // $ANTLR start PrintableCharNoDoubleQuote
    public final void mPrintableCharNoDoubleQuote() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:311:2: ( ' ' | '!' | '#' .. '\\ufffe' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:
            {
            if ( (input.LA(1)>=' ' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFE') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end PrintableCharNoDoubleQuote

    // $ANTLR start DecimalNumeral
    public final void mDecimalNumeral() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:316:2: ( '0' | '1' .. '9' ( Digit )* )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0=='0') ) {
                alt29=1;
            }
            else if ( ((LA29_0>='1' && LA29_0<='9')) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("314:1: fragment DecimalNumeral : ( '0' | '1' .. '9' ( Digit )* );", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:316:4: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:317:4: '1' .. '9' ( Digit )*
                    {
                    matchRange('1','9'); 
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:317:13: ( Digit )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( ((LA28_0>='0' && LA28_0<='9')) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:317:13: Digit
                    	    {
                    	    mDigit(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end DecimalNumeral

    // $ANTLR start Digit
    public final void mDigit() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:321:7: ( '0' .. '9' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:321:9: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end Digit

    // $ANTLR start HexNumeral
    public final void mHexNumeral() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:327:2: ( '0' 'x' ( HexDigit )+ )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:327:4: '0' 'x' ( HexDigit )+
            {
            match('0'); 
            match('x'); 
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:327:12: ( HexDigit )+
            int cnt30=0;
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>='0' && LA30_0<='9')||(LA30_0>='A' && LA30_0<='F')||(LA30_0>='a' && LA30_0<='f')) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:327:12: HexDigit
            	    {
            	    mHexDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt30 >= 1 ) break loop30;
                        EarlyExitException eee =
                            new EarlyExitException(30, input);
                        throw eee;
                }
                cnt30++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end HexNumeral

    // $ANTLR start OctalNumeral
    public final void mOctalNumeral() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:332:2: ( '0' ( OctalDigit )+ )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:332:4: '0' ( OctalDigit )+
            {
            match('0'); 
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:332:8: ( OctalDigit )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>='0' && LA31_0<='7')) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:332:8: OctalDigit
            	    {
            	    mOctalDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end OctalNumeral

    // $ANTLR start OctalDigit
    public final void mOctalDigit() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:337:2: ( '0' .. '7' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:337:4: '0' .. '7'
            {
            matchRange('0','7'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end OctalDigit

    // $ANTLR start HexDigit
    public final void mHexDigit() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:341:9: ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end HexDigit

    // $ANTLR start Comment
    public final void mComment() throws RecognitionException {
        try {
            int _type = Comment;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:347:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:347:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:347:14: ( options {greedy=false; } : . )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0=='*') ) {
                    int LA32_1 = input.LA(2);

                    if ( (LA32_1=='/') ) {
                        alt32=2;
                    }
                    else if ( ((LA32_1>='\u0000' && LA32_1<='.')||(LA32_1>='0' && LA32_1<='\uFFFE')) ) {
                        alt32=1;
                    }


                }
                else if ( ((LA32_0>='\u0000' && LA32_0<=')')||(LA32_0>='+' && LA32_0<='\uFFFE')) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:347:42: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            match("*/"); 

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Comment

    // $ANTLR start Line_Comment
    public final void mLine_Comment() throws RecognitionException {
        try {
            int _type = Line_Comment;
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:351:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\n' | '\\r' ( '\\n' )? ) )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:351:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\n' | '\\r' ( '\\n' )? )
            {
            match("//"); 

            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:351:12: (~ ( '\\n' | '\\r' ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>='\u0000' && LA33_0<='\t')||(LA33_0>='\u000B' && LA33_0<='\f')||(LA33_0>='\u000E' && LA33_0<='\uFFFE')) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:351:12: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:351:26: ( '\\n' | '\\r' ( '\\n' )? )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0=='\n') ) {
                alt35=1;
            }
            else if ( (LA35_0=='\r') ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("351:26: ( '\\n' | '\\r' ( '\\n' )? )", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:351:27: '\\n'
                    {
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:351:34: '\\r' ( '\\n' )?
                    {
                    match('\r'); 
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:351:39: ( '\\n' )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0=='\n') ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:351:39: '\\n'
                            {
                            match('\n'); 

                            }
                            break;

                    }


                    }
                    break;

            }

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Line_Comment

    public void mTokens() throws RecognitionException {
        // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:8: ( T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | Newline | WS | UpperID | VarID | Op | IntegerLiteral | FloatingPointLiteral | CharacterLiteral | StringLiteral | Comment | Line_Comment )
        int alt36=29;
        alt36 = dfa36.predict(input);
        switch (alt36) {
            case 1 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:10: T33
                {
                mT33(); 

                }
                break;
            case 2 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:14: T34
                {
                mT34(); 

                }
                break;
            case 3 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:18: T35
                {
                mT35(); 

                }
                break;
            case 4 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:22: T36
                {
                mT36(); 

                }
                break;
            case 5 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:26: T37
                {
                mT37(); 

                }
                break;
            case 6 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:30: T38
                {
                mT38(); 

                }
                break;
            case 7 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:34: T39
                {
                mT39(); 

                }
                break;
            case 8 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:38: T40
                {
                mT40(); 

                }
                break;
            case 9 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:42: T41
                {
                mT41(); 

                }
                break;
            case 10 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:46: T42
                {
                mT42(); 

                }
                break;
            case 11 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:50: T43
                {
                mT43(); 

                }
                break;
            case 12 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:54: T44
                {
                mT44(); 

                }
                break;
            case 13 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:58: T45
                {
                mT45(); 

                }
                break;
            case 14 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:62: T46
                {
                mT46(); 

                }
                break;
            case 15 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:66: T47
                {
                mT47(); 

                }
                break;
            case 16 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:70: T48
                {
                mT48(); 

                }
                break;
            case 17 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:74: T49
                {
                mT49(); 

                }
                break;
            case 18 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:78: T50
                {
                mT50(); 

                }
                break;
            case 19 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:82: Newline
                {
                mNewline(); 

                }
                break;
            case 20 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:90: WS
                {
                mWS(); 

                }
                break;
            case 21 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:93: UpperID
                {
                mUpperID(); 

                }
                break;
            case 22 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:101: VarID
                {
                mVarID(); 

                }
                break;
            case 23 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:107: Op
                {
                mOp(); 

                }
                break;
            case 24 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:110: IntegerLiteral
                {
                mIntegerLiteral(); 

                }
                break;
            case 25 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:125: FloatingPointLiteral
                {
                mFloatingPointLiteral(); 

                }
                break;
            case 26 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:146: CharacterLiteral
                {
                mCharacterLiteral(); 

                }
                break;
            case 27 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:163: StringLiteral
                {
                mStringLiteral(); 

                }
                break;
            case 28 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:177: Comment
                {
                mComment(); 

                }
                break;
            case 29 :
                // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:1:185: Line_Comment
                {
                mLine_Comment(); 

                }
                break;

        }

    }


    protected DFA19 dfa19 = new DFA19(this);
    protected DFA36 dfa36 = new DFA36(this);
    static final String DFA19_eotS =
        "\6\uffff";
    static final String DFA19_eofS =
        "\6\uffff";
    static final String DFA19_minS =
        "\2\56\4\uffff";
    static final String DFA19_maxS =
        "\1\71\1\146\4\uffff";
    static final String DFA19_acceptS =
        "\2\uffff\1\2\1\4\1\3\1\1";
    static final String DFA19_specialS =
        "\6\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\5\1\uffff\12\1\12\uffff\1\3\1\4\1\3\35\uffff\1\3\1\4\1\3",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "261:1: FloatingPointLiteral : ( ( Digit )+ '.' ( Digit )* ( ExponentPart )? ( FloatType )? | '.' ( Digit )+ ( ExponentPart )? ( FloatType )? | ( Digit )+ ExponentPart ( FloatType )? | ( Digit )+ FloatType );";
        }
    }
    static final String DFA36_eotS =
        "\1\uffff\1\25\1\36\1\25\2\uffff\1\25\1\uffff\1\42\3\uffff\3\25\7"+
        "\uffff\1\33\2\50\3\uffff\1\25\2\uffff\2\25\1\56\1\uffff\3\25\2\33"+
        "\1\uffff\2\50\2\25\1\71\1\uffff\3\25\1\33\1\uffff\1\33\1\uffff\1"+
        "\33\2\25\1\uffff\1\100\1\101\1\25\1\33\2\25\2\uffff\1\105\1\25\1"+
        "\107\1\uffff\1\110\2\uffff";
    static final String DFA36_eofS =
        "\111\uffff";
    static final String DFA36_minS =
        "\1\11\1\141\1\60\1\142\2\uffff\1\145\1\uffff\1\41\3\uffff\1\141"+
        "\1\162\1\141\7\uffff\1\52\2\56\3\uffff\1\143\2\uffff\1\152\1\146"+
        "\1\41\1\uffff\1\163\1\165\1\154\2\0\1\uffff\2\56\1\153\1\145\1\44"+
        "\1\uffff\2\145\1\163\1\0\1\uffff\1\0\1\uffff\1\0\1\141\1\143\1\uffff"+
        "\2\44\1\145\1\0\1\147\1\164\2\uffff\1\44\1\145\1\44\1\uffff\1\44"+
        "\2\uffff";
    static final String DFA36_maxS =
        "\1\ufffd\1\141\1\71\1\142\2\uffff\1\145\1\uffff\1\ufffd\3\uffff"+
        "\1\141\1\162\1\141\7\uffff\1\57\2\146\3\uffff\1\143\2\uffff\1\152"+
        "\1\146\1\ufffd\1\uffff\1\163\1\165\1\154\2\ufffe\1\uffff\2\146\1"+
        "\153\1\145\1\ufaff\1\uffff\2\145\1\163\1\ufffe\1\uffff\1\ufffe\1"+
        "\uffff\1\ufffe\1\141\1\143\1\uffff\2\ufaff\1\145\1\ufffe\1\147\1"+
        "\164\2\uffff\1\ufaff\1\145\1\ufaff\1\uffff\1\ufaff\2\uffff";
    static final String DFA36_acceptS =
        "\4\uffff\1\4\1\5\1\uffff\1\7\1\uffff\1\11\1\12\1\13\3\uffff\1\20"+
        "\1\21\1\22\1\23\1\24\1\25\1\26\3\uffff\1\32\1\33\1\27\1\uffff\1"+
        "\31\1\2\3\uffff\1\10\5\uffff\1\30\5\uffff\1\15\4\uffff\1\35\1\uffff"+
        "\1\34\3\uffff\1\6\6\uffff\1\14\1\16\3\uffff\1\17\1\uffff\1\3\1\1";
    static final String DFA36_specialS =
        "\111\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\23\1\22\1\uffff\1\23\1\22\22\uffff\1\23\1\33\1\32\1\uffff"+
            "\1\24\2\33\1\31\1\11\1\12\2\33\1\13\1\33\1\2\1\26\1\27\11\30"+
            "\1\7\1\21\1\33\1\10\2\33\1\uffff\32\24\1\17\1\33\1\20\1\33\1"+
            "\24\1\uffff\2\25\1\14\1\6\1\25\1\16\10\25\1\3\1\1\3\25\1\15"+
            "\6\25\1\4\1\33\1\5\1\33\47\uffff\2\33\1\uffff\1\33\1\25\1\uffff"+
            "\1\33\1\uffff\1\33\1\uffff\2\33\3\uffff\1\25\1\33\3\uffff\1"+
            "\25\5\uffff\27\24\1\33\7\24\30\25\1\33\10\25\u1f00\24\u1040"+
            "\33\u01c0\24\u0100\uffff\u0080\33\u0080\uffff\u092e\24\u1092"+
            "\uffff\100\33\u5200\24\u5900\uffff\u0200\24\u04fe\33",
            "\1\34",
            "\12\35",
            "\1\37",
            "",
            "",
            "\1\40",
            "",
            "\1\33\3\uffff\2\33\3\uffff\2\33\1\uffff\1\33\1\uffff\1\33\14"+
            "\uffff\2\33\1\41\1\33\34\uffff\1\33\1\uffff\1\33\35\uffff\1"+
            "\33\1\uffff\1\33\47\uffff\2\33\1\uffff\1\33\2\uffff\1\33\1\uffff"+
            "\1\33\1\uffff\2\33\4\uffff\1\33\40\uffff\1\33\37\uffff\1\33"+
            "\u1f08\uffff\u1040\33\u02c0\uffff\u0080\33\u1a40\uffff\100\33"+
            "\uad00\uffff\u04fe\33",
            "",
            "",
            "",
            "\1\43",
            "\1\44",
            "\1\45",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\47\4\uffff\1\46",
            "\1\35\1\uffff\10\51\2\35\12\uffff\3\35\35\uffff\3\35",
            "\1\35\1\uffff\12\52\12\uffff\3\35\35\uffff\3\35",
            "",
            "",
            "",
            "\1\53",
            "",
            "",
            "\1\54",
            "\1\55",
            "\1\33\3\uffff\2\33\3\uffff\2\33\1\uffff\1\33\1\uffff\1\33\14"+
            "\uffff\4\33\34\uffff\1\33\1\uffff\1\33\35\uffff\1\33\1\uffff"+
            "\1\33\47\uffff\2\33\1\uffff\1\33\2\uffff\1\33\1\uffff\1\33\1"+
            "\uffff\2\33\4\uffff\1\33\40\uffff\1\33\37\uffff\1\33\u1f08\uffff"+
            "\u1040\33\u02c0\uffff\u0080\33\u1a40\uffff\100\33\uad00\uffff"+
            "\u04fe\33",
            "",
            "\1\57",
            "\1\60",
            "\1\61",
            "\41\63\1\62\3\63\2\62\3\63\2\62\1\63\1\62\1\63\1\62\14\63\4"+
            "\62\34\63\1\62\1\63\1\62\35\63\1\62\1\63\1\62\47\63\2\62\1\63"+
            "\1\62\2\63\1\62\1\63\1\62\1\63\2\62\4\63\1\62\40\63\1\62\37"+
            "\63\1\62\u1f08\63\u1040\62\u02c0\63\u0080\62\u1a40\63\100\62"+
            "\uad00\63\u04fe\62\1\63",
            "\41\65\1\66\3\65\2\66\3\65\1\64\1\66\1\65\1\66\1\65\1\66\14"+
            "\65\4\66\34\65\1\66\1\65\1\66\35\65\1\66\1\65\1\66\47\65\2\66"+
            "\1\65\1\66\2\65\1\66\1\65\1\66\1\65\2\66\4\65\1\66\40\65\1\66"+
            "\37\65\1\66\u1f08\65\u1040\66\u02c0\65\u0080\66\u1a40\65\100"+
            "\66\uad00\65\u04fe\66\1\65",
            "",
            "\1\35\1\uffff\10\51\2\35\12\uffff\3\35\35\uffff\3\35",
            "\1\35\1\uffff\12\52\12\uffff\3\35\35\uffff\3\35",
            "\1\67",
            "\1\70",
            "\1\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25"+
            "\57\uffff\1\25\12\uffff\1\25\4\uffff\1\25\5\uffff\27\25\1\uffff"+
            "\37\25\1\uffff\u1f08\25\u1040\uffff\u01c0\25\u0200\uffff\u092e"+
            "\25\u10d2\uffff\u5200\25\u5900\uffff\u0200\25",
            "",
            "\1\72",
            "\1\73",
            "\1\74",
            "\41\63\1\62\3\63\2\62\3\63\2\62\1\63\1\62\1\63\1\62\14\63\4"+
            "\62\34\63\1\62\1\63\1\62\35\63\1\62\1\63\1\62\47\63\2\62\1\63"+
            "\1\62\2\63\1\62\1\63\1\62\1\63\2\62\4\63\1\62\40\63\1\62\37"+
            "\63\1\62\u1f08\63\u1040\62\u02c0\63\u0080\62\u1a40\63\100\62"+
            "\uad00\63\u04fe\62\1\63",
            "",
            "\41\65\1\66\3\65\2\66\3\65\1\64\1\66\1\65\1\66\1\65\1\75\14"+
            "\65\4\66\34\65\1\66\1\65\1\66\35\65\1\66\1\65\1\66\47\65\2\66"+
            "\1\65\1\66\2\65\1\66\1\65\1\66\1\65\2\66\4\65\1\66\40\65\1\66"+
            "\37\65\1\66\u1f08\65\u1040\66\u02c0\65\u0080\66\u1a40\65\100"+
            "\66\uad00\65\u04fe\66\1\65",
            "",
            "\41\65\1\66\3\65\2\66\3\65\1\64\1\66\1\65\1\66\1\65\1\66\14"+
            "\65\4\66\34\65\1\66\1\65\1\66\35\65\1\66\1\65\1\66\47\65\2\66"+
            "\1\65\1\66\2\65\1\66\1\65\1\66\1\65\2\66\4\65\1\66\40\65\1\66"+
            "\37\65\1\66\u1f08\65\u1040\66\u02c0\65\u0080\66\u1a40\65\100"+
            "\66\uad00\65\u04fe\66\1\65",
            "\1\76",
            "\1\77",
            "",
            "\1\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25"+
            "\57\uffff\1\25\12\uffff\1\25\4\uffff\1\25\5\uffff\27\25\1\uffff"+
            "\37\25\1\uffff\u1f08\25\u1040\uffff\u01c0\25\u0200\uffff\u092e"+
            "\25\u10d2\uffff\u5200\25\u5900\uffff\u0200\25",
            "\1\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25"+
            "\57\uffff\1\25\12\uffff\1\25\4\uffff\1\25\5\uffff\27\25\1\uffff"+
            "\37\25\1\uffff\u1f08\25\u1040\uffff\u01c0\25\u0200\uffff\u092e"+
            "\25\u10d2\uffff\u5200\25\u5900\uffff\u0200\25",
            "\1\102",
            "\41\65\1\66\3\65\2\66\3\65\1\64\1\66\1\65\1\66\1\65\1\66\14"+
            "\65\4\66\34\65\1\66\1\65\1\66\35\65\1\66\1\65\1\66\47\65\2\66"+
            "\1\65\1\66\2\65\1\66\1\65\1\66\1\65\2\66\4\65\1\66\40\65\1\66"+
            "\37\65\1\66\u1f08\65\u1040\66\u02c0\65\u0080\66\u1a40\65\100"+
            "\66\uad00\65\u04fe\66\1\65",
            "\1\103",
            "\1\104",
            "",
            "",
            "\1\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25"+
            "\57\uffff\1\25\12\uffff\1\25\4\uffff\1\25\5\uffff\27\25\1\uffff"+
            "\37\25\1\uffff\u1f08\25\u1040\uffff\u01c0\25\u0200\uffff\u092e"+
            "\25\u10d2\uffff\u5200\25\u5900\uffff\u0200\25",
            "\1\106",
            "\1\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25"+
            "\57\uffff\1\25\12\uffff\1\25\4\uffff\1\25\5\uffff\27\25\1\uffff"+
            "\37\25\1\uffff\u1f08\25\u1040\uffff\u01c0\25\u0200\uffff\u092e"+
            "\25\u10d2\uffff\u5200\25\u5900\uffff\u0200\25",
            "",
            "\1\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25"+
            "\57\uffff\1\25\12\uffff\1\25\4\uffff\1\25\5\uffff\27\25\1\uffff"+
            "\37\25\1\uffff\u1f08\25\u1040\uffff\u01c0\25\u0200\uffff\u092e"+
            "\25\u10d2\uffff\u5200\25\u5900\uffff\u0200\25",
            "",
            ""
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | Newline | WS | UpperID | VarID | Op | IntegerLiteral | FloatingPointLiteral | CharacterLiteral | StringLiteral | Comment | Line_Comment );";
        }
    }
 

}