// $ANTLR 3.0 /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g 2007-07-31 11:22:29

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ScalaSubsetParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Newline", "Op", "IntegerLiteral", "FloatingPointLiteral", "CharacterLiteral", "StringLiteral", "UpperID", "VarID", "WS", "Upper", "IdRest", "Lower", "Letter", "Digit", "OpChar", "DecimalNumeral", "HexNumeral", "OctalNumeral", "ExponentPart", "FloatType", "PrintableChar", "CharEscapeSeq", "StringElement", "PrintableCharNoDoubleQuote", "OctalDigits", "OctalDigit", "HexDigit", "Comment", "Line_Comment", "'package'", "'.'", "'object'", "'{'", "'}'", "'def'", "':'", "'='", "'('", "')'", "','", "'case'", "'=>'", "'true'", "'false'", "'['", "']'", "';'"
    };
    public static final int DecimalNumeral=19;
    public static final int Comment=31;
    public static final int CharEscapeSeq=25;
    public static final int VarID=11;
    public static final int Digit=17;
    public static final int OctalNumeral=21;
    public static final int HexDigit=30;
    public static final int WS=12;
    public static final int IntegerLiteral=6;
    public static final int CharacterLiteral=8;
    public static final int OctalDigit=29;
    public static final int Op=5;
    public static final int Line_Comment=32;
    public static final int StringLiteral=9;
    public static final int Upper=13;
    public static final int OctalDigits=28;
    public static final int StringElement=26;
    public static final int FloatType=23;
    public static final int Letter=16;
    public static final int ExponentPart=22;
    public static final int PrintableCharNoDoubleQuote=27;
    public static final int OpChar=18;
    public static final int Newline=4;
    public static final int EOF=-1;
    public static final int UpperID=10;
    public static final int HexNumeral=20;
    public static final int PrintableChar=24;
    public static final int FloatingPointLiteral=7;
    public static final int Lower=15;
    public static final int IdRest=14;

        public ScalaSubsetParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g"; }



    // $ANTLR start compilationUnit
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:3:1: compilationUnit : 'package' qualId semi topStatSeq ;
    public final void compilationUnit() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:4:2: ( 'package' qualId semi topStatSeq )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:4:4: 'package' qualId semi topStatSeq
            {
            match(input,33,FOLLOW_33_in_compilationUnit11); 
            pushFollow(FOLLOW_qualId_in_compilationUnit13);
            qualId();
            _fsp--;

            pushFollow(FOLLOW_semi_in_compilationUnit15);
            semi();
            _fsp--;

            pushFollow(FOLLOW_topStatSeq_in_compilationUnit17);
            topStatSeq();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end compilationUnit


    // $ANTLR start qualId
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:7:1: qualId : id ( '.' id )* ;
    public final void qualId() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:7:8: ( id ( '.' id )* )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:7:10: id ( '.' id )*
            {
            pushFollow(FOLLOW_id_in_qualId28);
            id();
            _fsp--;

            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:7:13: ( '.' id )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==34) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:7:14: '.' id
            	    {
            	    match(input,34,FOLLOW_34_in_qualId31); 
            	    pushFollow(FOLLOW_id_in_qualId33);
            	    id();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end qualId


    // $ANTLR start topStatSeq
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:10:1: topStatSeq : topStat ( semi topStat )* ;
    public final void topStatSeq() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:11:2: ( topStat ( semi topStat )* )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:11:4: topStat ( semi topStat )*
            {
            pushFollow(FOLLOW_topStat_in_topStatSeq47);
            topStat();
            _fsp--;

            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:11:12: ( semi topStat )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Newline||LA2_0==50) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:11:13: semi topStat
            	    {
            	    pushFollow(FOLLOW_semi_in_topStatSeq50);
            	    semi();
            	    _fsp--;

            	    pushFollow(FOLLOW_topStat_in_topStatSeq52);
            	    topStat();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end topStatSeq


    // $ANTLR start topStat
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:14:1: topStat : ( tmplDef | );
    public final void topStat() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:14:9: ( tmplDef | )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==35) ) {
                alt3=1;
            }
            else if ( (LA3_0==EOF||LA3_0==Newline||LA3_0==50) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("14:1: topStat : ( tmplDef | );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:14:11: tmplDef
                    {
                    pushFollow(FOLLOW_tmplDef_in_topStat65);
                    tmplDef();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:16:2: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end topStat


    // $ANTLR start tmplDef
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:18:1: tmplDef : 'object' objectDef ;
    public final void tmplDef() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:18:9: ( 'object' objectDef )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:18:11: 'object' objectDef
            {
            match(input,35,FOLLOW_35_in_tmplDef79); 
            pushFollow(FOLLOW_objectDef_in_tmplDef81);
            objectDef();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end tmplDef


    // $ANTLR start objectDef
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:21:1: objectDef : id classTemplateOpt ;
    public final void objectDef() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:22:2: ( id classTemplateOpt )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:22:4: id classTemplateOpt
            {
            pushFollow(FOLLOW_id_in_objectDef93);
            id();
            _fsp--;

            pushFollow(FOLLOW_classTemplateOpt_in_objectDef95);
            classTemplateOpt();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end objectDef


    // $ANTLR start classTemplateOpt
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:25:1: classTemplateOpt : templateBody ;
    public final void classTemplateOpt() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:26:2: ( templateBody )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:26:4: templateBody
            {
            pushFollow(FOLLOW_templateBody_in_classTemplateOpt107);
            templateBody();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end classTemplateOpt


    // $ANTLR start templateBody
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:29:1: templateBody : ( Newline )? '{' templateStat ( semi templateStat )* '}' ;
    public final void templateBody() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:30:2: ( ( Newline )? '{' templateStat ( semi templateStat )* '}' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:30:4: ( Newline )? '{' templateStat ( semi templateStat )* '}'
            {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:30:4: ( Newline )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==Newline) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:30:4: Newline
                    {
                    match(input,Newline,FOLLOW_Newline_in_templateBody118); 

                    }
                    break;

            }

            match(input,36,FOLLOW_36_in_templateBody121); 
            pushFollow(FOLLOW_templateStat_in_templateBody123);
            templateStat();
            _fsp--;

            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:30:30: ( semi templateStat )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==Newline||LA5_0==50) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:30:31: semi templateStat
            	    {
            	    pushFollow(FOLLOW_semi_in_templateBody126);
            	    semi();
            	    _fsp--;

            	    pushFollow(FOLLOW_templateStat_in_templateBody128);
            	    templateStat();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match(input,37,FOLLOW_37_in_templateBody132); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end templateBody


    // $ANTLR start templateStat
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:33:1: templateStat : ( def | );
    public final void templateStat() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:34:2: ( def | )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==38) ) {
                alt6=1;
            }
            else if ( (LA6_0==Newline||LA6_0==37||LA6_0==50) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("33:1: templateStat : ( def | );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:34:4: def
                    {
                    pushFollow(FOLLOW_def_in_templateStat144);
                    def();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:36:2: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end templateStat


    // $ANTLR start def
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:38:1: def : 'def' funDef ;
    public final void def() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:38:5: ( 'def' funDef )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:38:7: 'def' funDef
            {
            match(input,38,FOLLOW_38_in_def158); 
            pushFollow(FOLLOW_funDef_in_def160);
            funDef();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end def


    // $ANTLR start funDef
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:41:1: funDef : funSig ( Newline )? funDefRest ;
    public final void funDef() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:41:8: ( funSig ( Newline )? funDefRest )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:41:10: funSig ( Newline )? funDefRest
            {
            pushFollow(FOLLOW_funSig_in_funDef171);
            funSig();
            _fsp--;

            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:41:17: ( Newline )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==Newline) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:41:17: Newline
                    {
                    match(input,Newline,FOLLOW_Newline_in_funDef173); 

                    }
                    break;

            }

            pushFollow(FOLLOW_funDefRest_in_funDef176);
            funDefRest();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end funDef


    // $ANTLR start funDefRest
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:44:1: funDefRest : ( ':' ( Newline )? type '=' ( Newline )? expr | '{' block '}' );
    public final void funDefRest() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:45:2: ( ':' ( Newline )? type '=' ( Newline )? expr | '{' block '}' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==39) ) {
                alt10=1;
            }
            else if ( (LA10_0==36) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("44:1: funDefRest : ( ':' ( Newline )? type '=' ( Newline )? expr | '{' block '}' );", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:45:4: ':' ( Newline )? type '=' ( Newline )? expr
                    {
                    match(input,39,FOLLOW_39_in_funDefRest188); 
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:45:8: ( Newline )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==Newline) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:45:8: Newline
                            {
                            match(input,Newline,FOLLOW_Newline_in_funDefRest190); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_type_in_funDefRest193);
                    type();
                    _fsp--;

                    match(input,40,FOLLOW_40_in_funDefRest195); 
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:45:26: ( Newline )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==Newline) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:45:26: Newline
                            {
                            match(input,Newline,FOLLOW_Newline_in_funDefRest197); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_expr_in_funDefRest200);
                    expr();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:46:4: '{' block '}'
                    {
                    match(input,36,FOLLOW_36_in_funDefRest205); 
                    pushFollow(FOLLOW_block_in_funDefRest207);
                    block();
                    _fsp--;

                    match(input,37,FOLLOW_37_in_funDefRest209); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end funDefRest


    // $ANTLR start funSig
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:49:1: funSig : id paramClauses ;
    public final void funSig() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:49:8: ( id paramClauses )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:49:10: id paramClauses
            {
            pushFollow(FOLLOW_id_in_funSig219);
            id();
            _fsp--;

            pushFollow(FOLLOW_paramClauses_in_funSig221);
            paramClauses();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end funSig


    // $ANTLR start paramClauses
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:52:1: paramClauses : ( paramClause )* ;
    public final void paramClauses() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:53:2: ( ( paramClause )* )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:53:4: ( paramClause )*
            {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:53:4: ( paramClause )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==Newline) ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1==41) ) {
                        alt11=1;
                    }


                }
                else if ( (LA11_0==41) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:53:4: paramClause
            	    {
            	    pushFollow(FOLLOW_paramClause_in_paramClauses233);
            	    paramClause();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end paramClauses


    // $ANTLR start paramClause
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:56:1: paramClause : ( Newline )? '(' ( params )? ')' ;
    public final void paramClause() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:57:2: ( ( Newline )? '(' ( params )? ')' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:57:4: ( Newline )? '(' ( params )? ')'
            {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:57:4: ( Newline )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==Newline) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:57:4: Newline
                    {
                    match(input,Newline,FOLLOW_Newline_in_paramClause246); 

                    }
                    break;

            }

            match(input,41,FOLLOW_41_in_paramClause249); 
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:57:17: ( params )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=Newline && LA13_0<=Op)||(LA13_0>=UpperID && LA13_0<=VarID)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:57:17: params
                    {
                    pushFollow(FOLLOW_params_in_paramClause251);
                    params();
                    _fsp--;


                    }
                    break;

            }

            match(input,42,FOLLOW_42_in_paramClause254); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end paramClause


    // $ANTLR start params
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:60:1: params : param ( ',' param )* ;
    public final void params() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:60:8: ( param ( ',' param )* )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:60:10: param ( ',' param )*
            {
            pushFollow(FOLLOW_param_in_params265);
            param();
            _fsp--;

            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:60:16: ( ',' param )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==43) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:60:17: ',' param
            	    {
            	    match(input,43,FOLLOW_43_in_params268); 
            	    pushFollow(FOLLOW_param_in_params270);
            	    param();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end params


    // $ANTLR start param
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:63:1: param : ( Newline )? id ':' paramType ;
    public final void param() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:63:7: ( ( Newline )? id ':' paramType )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:63:9: ( Newline )? id ':' paramType
            {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:63:9: ( Newline )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==Newline) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:63:9: Newline
                    {
                    match(input,Newline,FOLLOW_Newline_in_param283); 

                    }
                    break;

            }

            pushFollow(FOLLOW_id_in_param286);
            id();
            _fsp--;

            match(input,39,FOLLOW_39_in_param288); 
            pushFollow(FOLLOW_paramType_in_param290);
            paramType();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end param


    // $ANTLR start paramType
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:66:1: paramType : type ;
    public final void paramType() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:67:2: ( type )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:67:4: type
            {
            pushFollow(FOLLOW_type_in_paramType302);
            type();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end paramType


    // $ANTLR start block
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:70:1: block : ( expr1 )? ( semi block )? ;
    public final void block() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:70:7: ( ( expr1 )? ( semi block )? )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:70:9: ( expr1 )? ( semi block )?
            {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:70:9: ( expr1 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=Op && LA16_0<=VarID)||LA16_0==36||(LA16_0>=46 && LA16_0<=47)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:70:9: expr1
                    {
                    pushFollow(FOLLOW_expr1_in_block312);
                    expr1();
                    _fsp--;


                    }
                    break;

            }

            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:70:16: ( semi block )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==Newline||LA17_0==50) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:70:17: semi block
                    {
                    pushFollow(FOLLOW_semi_in_block316);
                    semi();
                    _fsp--;

                    pushFollow(FOLLOW_block_in_block318);
                    block();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end block


    // $ANTLR start expr
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:73:1: expr : expr1 ;
    public final void expr() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:73:6: ( expr1 )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:73:8: expr1
            {
            pushFollow(FOLLOW_expr1_in_expr333);
            expr1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end expr


    // $ANTLR start expr1
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:76:1: expr1 : postfixExpr ;
    public final void expr1() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:76:7: ( postfixExpr )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:76:9: postfixExpr
            {
            pushFollow(FOLLOW_postfixExpr_in_expr1344);
            postfixExpr();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end expr1


    // $ANTLR start postfixExpr
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:79:1: postfixExpr : infixExpr ;
    public final void postfixExpr() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:80:2: ( infixExpr )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:80:4: infixExpr
            {
            pushFollow(FOLLOW_infixExpr_in_postfixExpr356);
            infixExpr();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end postfixExpr


    // $ANTLR start infixExpr
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:83:1: infixExpr : prefixExpr ( Op ( Newline )? infixExpr )? ;
    public final void infixExpr() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:84:2: ( prefixExpr ( Op ( Newline )? infixExpr )? )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:84:4: prefixExpr ( Op ( Newline )? infixExpr )?
            {
            pushFollow(FOLLOW_prefixExpr_in_infixExpr367);
            prefixExpr();
            _fsp--;

            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:84:15: ( Op ( Newline )? infixExpr )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==Op) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:84:16: Op ( Newline )? infixExpr
                    {
                    match(input,Op,FOLLOW_Op_in_infixExpr370); 
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:84:19: ( Newline )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==Newline) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:84:19: Newline
                            {
                            match(input,Newline,FOLLOW_Newline_in_infixExpr372); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_infixExpr_in_infixExpr375);
                    infixExpr();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end infixExpr


    // $ANTLR start prefixExpr
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:87:1: prefixExpr : simpleExpr ;
    public final void prefixExpr() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:88:2: ( simpleExpr )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:88:4: simpleExpr
            {
            pushFollow(FOLLOW_simpleExpr_in_prefixExpr389);
            simpleExpr();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end prefixExpr


    // $ANTLR start simpleExpr
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:91:1: simpleExpr : ( blockExpr | simpleExpr1 );
    public final void simpleExpr() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:92:2: ( blockExpr | simpleExpr1 )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==36) ) {
                alt20=1;
            }
            else if ( ((LA20_0>=Op && LA20_0<=VarID)||(LA20_0>=46 && LA20_0<=47)) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("91:1: simpleExpr : ( blockExpr | simpleExpr1 );", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:92:4: blockExpr
                    {
                    pushFollow(FOLLOW_blockExpr_in_simpleExpr401);
                    blockExpr();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:93:4: simpleExpr1
                    {
                    pushFollow(FOLLOW_simpleExpr1_in_simpleExpr406);
                    simpleExpr1();
                    _fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end simpleExpr


    // $ANTLR start blockExpr
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:96:1: blockExpr : '{' ( Newline )? caseClauses '}' ;
    public final void blockExpr() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:97:2: ( '{' ( Newline )? caseClauses '}' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:97:4: '{' ( Newline )? caseClauses '}'
            {
            match(input,36,FOLLOW_36_in_blockExpr418); 
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:97:8: ( Newline )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==Newline) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:97:8: Newline
                    {
                    match(input,Newline,FOLLOW_Newline_in_blockExpr420); 

                    }
                    break;

            }

            pushFollow(FOLLOW_caseClauses_in_blockExpr423);
            caseClauses();
            _fsp--;

            match(input,37,FOLLOW_37_in_blockExpr425); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end blockExpr


    // $ANTLR start caseClauses
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:100:1: caseClauses : ( caseClause )+ ;
    public final void caseClauses() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:101:2: ( ( caseClause )+ )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:101:4: ( caseClause )+
            {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:101:4: ( caseClause )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==44) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:101:4: caseClause
            	    {
            	    pushFollow(FOLLOW_caseClause_in_caseClauses437);
            	    caseClause();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end caseClauses


    // $ANTLR start caseClause
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:104:1: caseClause : 'case' pattern ( Newline )? '=>' block ;
    public final void caseClause() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:105:2: ( 'case' pattern ( Newline )? '=>' block )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:105:4: 'case' pattern ( Newline )? '=>' block
            {
            match(input,44,FOLLOW_44_in_caseClause450); 
            pushFollow(FOLLOW_pattern_in_caseClause452);
            pattern();
            _fsp--;

            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:105:19: ( Newline )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==Newline) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:105:19: Newline
                    {
                    match(input,Newline,FOLLOW_Newline_in_caseClause454); 

                    }
                    break;

            }

            match(input,45,FOLLOW_45_in_caseClause457); 
            pushFollow(FOLLOW_block_in_caseClause459);
            block();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end caseClause


    // $ANTLR start pattern
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:108:1: pattern : pattern1 ;
    public final void pattern() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:108:9: ( pattern1 )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:108:11: pattern1
            {
            pushFollow(FOLLOW_pattern1_in_pattern469);
            pattern1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end pattern


    // $ANTLR start pattern1
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:111:1: pattern1 : pattern2 ;
    public final void pattern1() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:111:9: ( pattern2 )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:111:11: pattern2
            {
            pushFollow(FOLLOW_pattern2_in_pattern1479);
            pattern2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end pattern1


    // $ANTLR start pattern2
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:114:1: pattern2 : pattern3 ;
    public final void pattern2() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:114:9: ( pattern3 )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:114:11: pattern3
            {
            pushFollow(FOLLOW_pattern3_in_pattern2489);
            pattern3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end pattern2


    // $ANTLR start pattern3
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:117:1: pattern3 : simplePattern ;
    public final void pattern3() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:117:9: ( simplePattern )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:117:11: simplePattern
            {
            pushFollow(FOLLOW_simplePattern_in_pattern3499);
            simplePattern();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end pattern3


    // $ANTLR start simplePattern
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:120:1: simplePattern : ( literal | stableID | stableID '(' ( Newline )? ( patterns ( Newline )? )? ')' );
    public final void simplePattern() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:121:2: ( literal | stableID | stableID '(' ( Newline )? ( patterns ( Newline )? )? ')' )
            int alt27=3;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:121:4: literal
                    {
                    pushFollow(FOLLOW_literal_in_simplePattern510);
                    literal();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:122:4: stableID
                    {
                    pushFollow(FOLLOW_stableID_in_simplePattern515);
                    stableID();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:123:4: stableID '(' ( Newline )? ( patterns ( Newline )? )? ')'
                    {
                    pushFollow(FOLLOW_stableID_in_simplePattern520);
                    stableID();
                    _fsp--;

                    match(input,41,FOLLOW_41_in_simplePattern522); 
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:123:17: ( Newline )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==Newline) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:123:17: Newline
                            {
                            match(input,Newline,FOLLOW_Newline_in_simplePattern524); 

                            }
                            break;

                    }

                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:123:26: ( patterns ( Newline )? )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( ((LA26_0>=Op && LA26_0<=VarID)||(LA26_0>=46 && LA26_0<=47)) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:123:27: patterns ( Newline )?
                            {
                            pushFollow(FOLLOW_patterns_in_simplePattern528);
                            patterns();
                            _fsp--;

                            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:123:36: ( Newline )?
                            int alt25=2;
                            int LA25_0 = input.LA(1);

                            if ( (LA25_0==Newline) ) {
                                alt25=1;
                            }
                            switch (alt25) {
                                case 1 :
                                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:123:36: Newline
                                    {
                                    match(input,Newline,FOLLOW_Newline_in_simplePattern530); 

                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    match(input,42,FOLLOW_42_in_simplePattern536); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end simplePattern


    // $ANTLR start patterns
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:126:1: patterns : pattern ( ',' ( Newline )? patterns )? ;
    public final void patterns() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:126:9: ( pattern ( ',' ( Newline )? patterns )? )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:126:11: pattern ( ',' ( Newline )? patterns )?
            {
            pushFollow(FOLLOW_pattern_in_patterns546);
            pattern();
            _fsp--;

            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:126:19: ( ',' ( Newline )? patterns )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==43) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:126:20: ',' ( Newline )? patterns
                    {
                    match(input,43,FOLLOW_43_in_patterns549); 
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:126:24: ( Newline )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==Newline) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:126:24: Newline
                            {
                            match(input,Newline,FOLLOW_Newline_in_patterns551); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_patterns_in_patterns554);
                    patterns();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end patterns


    // $ANTLR start simpleExpr1
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:129:1: simpleExpr1 : ( literal ( argumentExprs )* | path ( argumentExprs )* );
    public final void simpleExpr1() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:130:2: ( literal ( argumentExprs )* | path ( argumentExprs )* )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=IntegerLiteral && LA32_0<=StringLiteral)||(LA32_0>=46 && LA32_0<=47)) ) {
                alt32=1;
            }
            else if ( (LA32_0==Op||(LA32_0>=UpperID && LA32_0<=VarID)) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("129:1: simpleExpr1 : ( literal ( argumentExprs )* | path ( argumentExprs )* );", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:130:4: literal ( argumentExprs )*
                    {
                    pushFollow(FOLLOW_literal_in_simpleExpr1568);
                    literal();
                    _fsp--;

                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:130:12: ( argumentExprs )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==41) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:130:12: argumentExprs
                    	    {
                    	    pushFollow(FOLLOW_argumentExprs_in_simpleExpr1570);
                    	    argumentExprs();
                    	    _fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:131:4: path ( argumentExprs )*
                    {
                    pushFollow(FOLLOW_path_in_simpleExpr1576);
                    path();
                    _fsp--;

                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:131:9: ( argumentExprs )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==41) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:131:9: argumentExprs
                    	    {
                    	    pushFollow(FOLLOW_argumentExprs_in_simpleExpr1578);
                    	    argumentExprs();
                    	    _fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end simpleExpr1


    // $ANTLR start argumentExprs
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:134:1: argumentExprs : '(' ( Newline )? ( exprs ( Newline )? )? ')' ;
    public final void argumentExprs() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:135:2: ( '(' ( Newline )? ( exprs ( Newline )? )? ')' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:135:4: '(' ( Newline )? ( exprs ( Newline )? )? ')'
            {
            match(input,41,FOLLOW_41_in_argumentExprs591); 
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:135:8: ( Newline )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==Newline) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:135:8: Newline
                    {
                    match(input,Newline,FOLLOW_Newline_in_argumentExprs593); 

                    }
                    break;

            }

            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:135:17: ( exprs ( Newline )? )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=Op && LA35_0<=VarID)||LA35_0==36||(LA35_0>=46 && LA35_0<=47)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:135:18: exprs ( Newline )?
                    {
                    pushFollow(FOLLOW_exprs_in_argumentExprs597);
                    exprs();
                    _fsp--;

                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:135:24: ( Newline )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==Newline) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:135:24: Newline
                            {
                            match(input,Newline,FOLLOW_Newline_in_argumentExprs599); 

                            }
                            break;

                    }


                    }
                    break;

            }

            match(input,42,FOLLOW_42_in_argumentExprs605); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end argumentExprs


    // $ANTLR start exprs
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:138:1: exprs : expr ( ',' ( Newline )? expr )* ;
    public final void exprs() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:138:7: ( expr ( ',' ( Newline )? expr )* )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:138:9: expr ( ',' ( Newline )? expr )*
            {
            pushFollow(FOLLOW_expr_in_exprs616);
            expr();
            _fsp--;

            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:138:14: ( ',' ( Newline )? expr )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==43) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:138:15: ',' ( Newline )? expr
            	    {
            	    match(input,43,FOLLOW_43_in_exprs619); 
            	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:138:19: ( Newline )?
            	    int alt36=2;
            	    int LA36_0 = input.LA(1);

            	    if ( (LA36_0==Newline) ) {
            	        alt36=1;
            	    }
            	    switch (alt36) {
            	        case 1 :
            	            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:138:19: Newline
            	            {
            	            match(input,Newline,FOLLOW_Newline_in_exprs621); 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_expr_in_exprs624);
            	    expr();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end exprs


    // $ANTLR start path
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:141:1: path : stableID ;
    public final void path() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:141:6: ( stableID )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:141:8: stableID
            {
            pushFollow(FOLLOW_stableID_in_path637);
            stableID();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end path


    // $ANTLR start stableID
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:144:1: stableID : id ( '.' id )* ;
    public final void stableID() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:144:9: ( id ( '.' id )* )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:144:11: id ( '.' id )*
            {
            pushFollow(FOLLOW_id_in_stableID646);
            id();
            _fsp--;

            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:144:14: ( '.' id )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==34) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:144:15: '.' id
            	    {
            	    match(input,34,FOLLOW_34_in_stableID649); 
            	    pushFollow(FOLLOW_id_in_stableID651);
            	    id();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end stableID


    // $ANTLR start literal
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:147:1: literal : ( IntegerLiteral | FloatingPointLiteral | 'true' | 'false' | CharacterLiteral | StringLiteral );
    public final void literal() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:147:9: ( IntegerLiteral | FloatingPointLiteral | 'true' | 'false' | CharacterLiteral | StringLiteral )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:
            {
            if ( (input.LA(1)>=IntegerLiteral && input.LA(1)<=StringLiteral)||(input.LA(1)>=46 && input.LA(1)<=47) ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_literal0);    throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end literal


    // $ANTLR start type
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:154:1: type : infixType ( '=>' ( Newline )? type )? ;
    public final void type() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:154:6: ( infixType ( '=>' ( Newline )? type )? )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:154:8: infixType ( '=>' ( Newline )? type )?
            {
            pushFollow(FOLLOW_infixType_in_type699);
            infixType();
            _fsp--;

            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:154:18: ( '=>' ( Newline )? type )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==45) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:154:19: '=>' ( Newline )? type
                    {
                    match(input,45,FOLLOW_45_in_type702); 
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:154:24: ( Newline )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==Newline) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:154:24: Newline
                            {
                            match(input,Newline,FOLLOW_Newline_in_type704); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_type_in_type707);
                    type();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end type


    // $ANTLR start infixType
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:157:1: infixType : compoundType ;
    public final void infixType() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:158:2: ( compoundType )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:158:4: compoundType
            {
            pushFollow(FOLLOW_compoundType_in_infixType721);
            compoundType();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end infixType


    // $ANTLR start compoundType
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:161:1: compoundType : annotType ;
    public final void compoundType() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:162:2: ( annotType )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:162:4: annotType
            {
            pushFollow(FOLLOW_annotType_in_compoundType733);
            annotType();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end compoundType


    // $ANTLR start annotType
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:165:1: annotType : simpleType ;
    public final void annotType() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:166:2: ( simpleType )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:166:4: simpleType
            {
            pushFollow(FOLLOW_simpleType_in_annotType745);
            simpleType();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end annotType


    // $ANTLR start simpleType
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:169:1: simpleType : stableID ( typeArgs )* ;
    public final void simpleType() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:170:2: ( stableID ( typeArgs )* )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:170:5: stableID ( typeArgs )*
            {
            pushFollow(FOLLOW_stableID_in_simpleType758);
            stableID();
            _fsp--;

            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:170:14: ( typeArgs )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==48) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:170:14: typeArgs
            	    {
            	    pushFollow(FOLLOW_typeArgs_in_simpleType760);
            	    typeArgs();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end simpleType


    // $ANTLR start typeArgs
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:173:1: typeArgs : '[' ( Newline )? types ( Newline )? ']' ;
    public final void typeArgs() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:173:9: ( '[' ( Newline )? types ( Newline )? ']' )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:173:11: '[' ( Newline )? types ( Newline )? ']'
            {
            match(input,48,FOLLOW_48_in_typeArgs771); 
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:173:15: ( Newline )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==Newline) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:173:15: Newline
                    {
                    match(input,Newline,FOLLOW_Newline_in_typeArgs773); 

                    }
                    break;

            }

            pushFollow(FOLLOW_types_in_typeArgs776);
            types();
            _fsp--;

            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:173:30: ( Newline )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==Newline) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:173:30: Newline
                    {
                    match(input,Newline,FOLLOW_Newline_in_typeArgs778); 

                    }
                    break;

            }

            match(input,49,FOLLOW_49_in_typeArgs781); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end typeArgs


    // $ANTLR start types
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:176:1: types : type ( ',' ( Newline )? type )* ;
    public final void types() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:176:7: ( type ( ',' ( Newline )? type )* )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:176:9: type ( ',' ( Newline )? type )*
            {
            pushFollow(FOLLOW_type_in_types792);
            type();
            _fsp--;

            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:176:14: ( ',' ( Newline )? type )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==43) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:176:15: ',' ( Newline )? type
            	    {
            	    match(input,43,FOLLOW_43_in_types795); 
            	    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:176:19: ( Newline )?
            	    int alt44=2;
            	    int LA44_0 = input.LA(1);

            	    if ( (LA44_0==Newline) ) {
            	        alt44=1;
            	    }
            	    switch (alt44) {
            	        case 1 :
            	            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:176:19: Newline
            	            {
            	            match(input,Newline,FOLLOW_Newline_in_types797); 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_type_in_types800);
            	    type();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end types


    // $ANTLR start id
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:179:1: id : ( UpperID | VarID | Op );
    public final void id() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:179:4: ( UpperID | VarID | Op )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:
            {
            if ( input.LA(1)==Op||(input.LA(1)>=UpperID && input.LA(1)<=VarID) ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_id0);    throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end id


    // $ANTLR start semi
    // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:184:1: semi : ( ';' | Newline );
    public final void semi() throws RecognitionException {
        try {
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:184:6: ( ';' | Newline )
            // /Users/bhoward/workspace/ScalesSubset/ScalaSubset.g:
            {
            if ( input.LA(1)==Newline||input.LA(1)==50 ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_semi0);    throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end semi


    protected DFA27 dfa27 = new DFA27(this);
    static final String DFA27_eotS =
        "\7\uffff";
    static final String DFA27_eofS =
        "\7\uffff";
    static final String DFA27_minS =
        "\1\5\1\uffff\1\4\1\5\2\uffff\1\4";
    static final String DFA27_maxS =
        "\1\57\1\uffff\1\55\1\13\2\uffff\1\55";
    static final String DFA27_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\1\3\1\uffff";
    static final String DFA27_specialS =
        "\7\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\2\4\1\2\2\42\uffff\2\1",
            "",
            "\1\4\35\uffff\1\3\6\uffff\1\5\2\4\1\uffff\1\4",
            "\1\6\4\uffff\2\6",
            "",
            "",
            "\1\4\35\uffff\1\3\6\uffff\1\5\2\4\1\uffff\1\4"
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "120:1: simplePattern : ( literal | stableID | stableID '(' ( Newline )? ( patterns ( Newline )? )? ')' );";
        }
    }
 

    public static final BitSet FOLLOW_33_in_compilationUnit11 = new BitSet(new long[]{0x0000000000000C20L});
    public static final BitSet FOLLOW_qualId_in_compilationUnit13 = new BitSet(new long[]{0x0004000000000010L});
    public static final BitSet FOLLOW_semi_in_compilationUnit15 = new BitSet(new long[]{0x0004000800000012L});
    public static final BitSet FOLLOW_topStatSeq_in_compilationUnit17 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_qualId28 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_qualId31 = new BitSet(new long[]{0x0000000000000C20L});
    public static final BitSet FOLLOW_id_in_qualId33 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_topStat_in_topStatSeq47 = new BitSet(new long[]{0x0004000000000012L});
    public static final BitSet FOLLOW_semi_in_topStatSeq50 = new BitSet(new long[]{0x0004000800000012L});
    public static final BitSet FOLLOW_topStat_in_topStatSeq52 = new BitSet(new long[]{0x0004000000000012L});
    public static final BitSet FOLLOW_tmplDef_in_topStat65 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_tmplDef79 = new BitSet(new long[]{0x0000000000000C20L});
    public static final BitSet FOLLOW_objectDef_in_tmplDef81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_objectDef93 = new BitSet(new long[]{0x0000001000000010L});
    public static final BitSet FOLLOW_classTemplateOpt_in_objectDef95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_templateBody_in_classTemplateOpt107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Newline_in_templateBody118 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_templateBody121 = new BitSet(new long[]{0x0004006000000010L});
    public static final BitSet FOLLOW_templateStat_in_templateBody123 = new BitSet(new long[]{0x0004002000000010L});
    public static final BitSet FOLLOW_semi_in_templateBody126 = new BitSet(new long[]{0x0004006000000010L});
    public static final BitSet FOLLOW_templateStat_in_templateBody128 = new BitSet(new long[]{0x0004002000000010L});
    public static final BitSet FOLLOW_37_in_templateBody132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_def_in_templateStat144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_def158 = new BitSet(new long[]{0x0000000000000C20L});
    public static final BitSet FOLLOW_funDef_in_def160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funSig_in_funDef171 = new BitSet(new long[]{0x0000009000000010L});
    public static final BitSet FOLLOW_Newline_in_funDef173 = new BitSet(new long[]{0x0000009000000000L});
    public static final BitSet FOLLOW_funDefRest_in_funDef176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_funDefRest188 = new BitSet(new long[]{0x0000000000000C30L});
    public static final BitSet FOLLOW_Newline_in_funDefRest190 = new BitSet(new long[]{0x0000000000000C20L});
    public static final BitSet FOLLOW_type_in_funDefRest193 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_funDefRest195 = new BitSet(new long[]{0x0000C01000000FF0L});
    public static final BitSet FOLLOW_Newline_in_funDefRest197 = new BitSet(new long[]{0x0000C01000000FE0L});
    public static final BitSet FOLLOW_expr_in_funDefRest200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_funDefRest205 = new BitSet(new long[]{0x0004C03000000FF0L});
    public static final BitSet FOLLOW_block_in_funDefRest207 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_funDefRest209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_funSig219 = new BitSet(new long[]{0x0000020000000012L});
    public static final BitSet FOLLOW_paramClauses_in_funSig221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_paramClause_in_paramClauses233 = new BitSet(new long[]{0x0000020000000012L});
    public static final BitSet FOLLOW_Newline_in_paramClause246 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_paramClause249 = new BitSet(new long[]{0x0000040000000C30L});
    public static final BitSet FOLLOW_params_in_paramClause251 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_paramClause254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_param_in_params265 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_params268 = new BitSet(new long[]{0x0000000000000C30L});
    public static final BitSet FOLLOW_param_in_params270 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_Newline_in_param283 = new BitSet(new long[]{0x0000000000000C20L});
    public static final BitSet FOLLOW_id_in_param286 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_param288 = new BitSet(new long[]{0x0000000000000C20L});
    public static final BitSet FOLLOW_paramType_in_param290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_paramType302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr1_in_block312 = new BitSet(new long[]{0x0004000000000012L});
    public static final BitSet FOLLOW_semi_in_block316 = new BitSet(new long[]{0x0004C01000000FF0L});
    public static final BitSet FOLLOW_block_in_block318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr1_in_expr333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpr_in_expr1344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_infixExpr_in_postfixExpr356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prefixExpr_in_infixExpr367 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_Op_in_infixExpr370 = new BitSet(new long[]{0x0000C01000000FF0L});
    public static final BitSet FOLLOW_Newline_in_infixExpr372 = new BitSet(new long[]{0x0000C01000000FE0L});
    public static final BitSet FOLLOW_infixExpr_in_infixExpr375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleExpr_in_prefixExpr389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blockExpr_in_simpleExpr401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleExpr1_in_simpleExpr406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_blockExpr418 = new BitSet(new long[]{0x0000100000000010L});
    public static final BitSet FOLLOW_Newline_in_blockExpr420 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_caseClauses_in_blockExpr423 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_blockExpr425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_caseClause_in_caseClauses437 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_caseClause450 = new BitSet(new long[]{0x0000C00000000FE0L});
    public static final BitSet FOLLOW_pattern_in_caseClause452 = new BitSet(new long[]{0x0000200000000010L});
    public static final BitSet FOLLOW_Newline_in_caseClause454 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_caseClause457 = new BitSet(new long[]{0x0004C01000000FF2L});
    public static final BitSet FOLLOW_block_in_caseClause459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pattern1_in_pattern469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pattern2_in_pattern1479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pattern3_in_pattern2489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simplePattern_in_pattern3499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_simplePattern510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stableID_in_simplePattern515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stableID_in_simplePattern520 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_simplePattern522 = new BitSet(new long[]{0x0000C40000000FF0L});
    public static final BitSet FOLLOW_Newline_in_simplePattern524 = new BitSet(new long[]{0x0000C40000000FE0L});
    public static final BitSet FOLLOW_patterns_in_simplePattern528 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_Newline_in_simplePattern530 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_simplePattern536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pattern_in_patterns546 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_patterns549 = new BitSet(new long[]{0x0000C00000000FF0L});
    public static final BitSet FOLLOW_Newline_in_patterns551 = new BitSet(new long[]{0x0000C00000000FE0L});
    public static final BitSet FOLLOW_patterns_in_patterns554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_simpleExpr1568 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_argumentExprs_in_simpleExpr1570 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_path_in_simpleExpr1576 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_argumentExprs_in_simpleExpr1578 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_argumentExprs591 = new BitSet(new long[]{0x0000C41000000FF0L});
    public static final BitSet FOLLOW_Newline_in_argumentExprs593 = new BitSet(new long[]{0x0000C41000000FE0L});
    public static final BitSet FOLLOW_exprs_in_argumentExprs597 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_Newline_in_argumentExprs599 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_argumentExprs605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_exprs616 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_exprs619 = new BitSet(new long[]{0x0000C01000000FF0L});
    public static final BitSet FOLLOW_Newline_in_exprs621 = new BitSet(new long[]{0x0000C01000000FE0L});
    public static final BitSet FOLLOW_expr_in_exprs624 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_stableID_in_path637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_stableID646 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_stableID649 = new BitSet(new long[]{0x0000000000000C20L});
    public static final BitSet FOLLOW_id_in_stableID651 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_set_in_literal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_infixType_in_type699 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_type702 = new BitSet(new long[]{0x0000000000000C30L});
    public static final BitSet FOLLOW_Newline_in_type704 = new BitSet(new long[]{0x0000000000000C20L});
    public static final BitSet FOLLOW_type_in_type707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compoundType_in_infixType721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotType_in_compoundType733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleType_in_annotType745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stableID_in_simpleType758 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_typeArgs_in_simpleType760 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_typeArgs771 = new BitSet(new long[]{0x0000000000000C30L});
    public static final BitSet FOLLOW_Newline_in_typeArgs773 = new BitSet(new long[]{0x0000000000000C20L});
    public static final BitSet FOLLOW_types_in_typeArgs776 = new BitSet(new long[]{0x0002000000000010L});
    public static final BitSet FOLLOW_Newline_in_typeArgs778 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_typeArgs781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_types792 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_types795 = new BitSet(new long[]{0x0000000000000C30L});
    public static final BitSet FOLLOW_Newline_in_types797 = new BitSet(new long[]{0x0000000000000C20L});
    public static final BitSet FOLLOW_type_in_types800 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_set_in_id0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_semi0 = new BitSet(new long[]{0x0000000000000002L});

}