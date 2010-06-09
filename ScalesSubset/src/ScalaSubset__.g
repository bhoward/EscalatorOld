lexer grammar ScalaSubset;

T33 : 'package' ;
T34 : '.' ;
T35 : 'object' ;
T36 : '{' ;
T37 : '}' ;
T38 : 'def' ;
T39 : ':' ;
T40 : '=' ;
T41 : '(' ;
T42 : ')' ;
T43 : ',' ;
T44 : 'case' ;
T45 : '=>' ;
T46 : 'true' ;
T47 : 'false' ;
T48 : '[' ;
T49 : ']' ;
T50 : ';' ;

// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 190
Newline	:	'\n' | '\r' '\n'?
	;
	
// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 193
WS	:	(' ' | '\t' | '\f')+ { $channel=HIDDEN; }
	;
	
// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 196
UpperID	:	Upper IdRest
	;

// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 199
VarID	:	Lower IdRest
	;
	
// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 202
fragment	
IdRest	:	(Letter | Digit)* ('_' Op)?
	;

// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 206
fragment
Letter	:	Upper | Lower
	;

/* These character ranges are only approximate above unicode 0100.
 * Partly taken from the ANTLR Java 1.5 grammar,
 * and also based on tables from http://www.fileformat.info/info/unicode/category/
 */
// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 214
fragment	
Upper	:	'A'..'Z'
	|	'$'
	|	'_'
	|	'\u00c0'..'\u00d6'
	|	'\u00d8'..'\u00de'
	|	'\u0100'..'\u1fff' // there are lots of lowercase letters (and others) in here, but they're intermixed
	|	'\u3040'..'\u31ff'
	|	'\u3400'..'\u3d2d'
	|	'\u4e00'..'\u9fff'
	|	'\uf900'..'\ufaff'
    ;

// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 227
fragment
Lower	:	'a'..'z'
	|	'\u00aa'
	|	'\u00b5'
	|	'\u00ba'
	|	'\u00df'..'\u00f6'
	|	'\u00f8'..'\u00ff'
	;
	
// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 236
Op	:	OpChar+
	;
	
// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 239
fragment
OpChar	:	'!' | '%' | '&' | '*' | '+' | '-' | '/' | '<' | '=' | '>' | '?' | '\\' | '^' | '|' | '~'
	|	'\u00a6'
	|	'\u00a7'
	|	'\u00a9'
	|	'\u00ac'
	|	'\u00ae'
	|	'\u00b0'
	|	'\u00b1'
	|	'\u00b6'
	|	'\u00d7'
	|	'\u00f7'
	|	'\u2000'..'\u303f' // there are lots of other character in here as well...
	|	'\u3300'..'\u337f'
	|	'\u4dc0'..'\u4dff'
	|	'\ufb00'..'\ufffd'
	;
	
// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 257
IntegerLiteral
	:	(DecimalNumeral | HexNumeral | OctalNumeral) ('L' | 'l')?
	;
	
// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 261
FloatingPointLiteral
	:	Digit+ '.' Digit* ExponentPart? FloatType?
	|	'.' Digit+ ExponentPart? FloatType?
	|	Digit+ ExponentPart FloatType?
	|	Digit+ FloatType
	;
	
// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 268
fragment
ExponentPart
	:	('E' | 'e') ('+' | '-')? Digit+
	;
	
// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 273
fragment
FloatType
	:	'F' | 'f' | 'D' | 'd'
	;
	
// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 278
CharacterLiteral
	:	'\'' PrintableChar '\''
	|	'\'' CharEscapeSeq '\''
	;
	
// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 283
StringLiteral
	:	'"' StringElement* '"'
	;
	
// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 287
fragment
PrintableChar
	:	PrintableCharNoDoubleQuote
	|	'"'
	;
	
// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 293
fragment
CharEscapeSeq
	:	'\\' ('b' | 't' | 'n' | 'f' | 'r' | '"' | '\'' | '\\' | OctalDigits)
	;
	
// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 298
fragment
OctalDigits
	:	OctalDigit (OctalDigit OctalDigit?)?
	;
	
// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 303
fragment
StringElement
	:	PrintableCharNoDoubleQuote
	|	CharEscapeSeq
	;
	
// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 309
fragment
PrintableCharNoDoubleQuote
	:	' ' | '!' | '#'..'\ufffe'
	;
	
// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 314
fragment
DecimalNumeral
	:	'0'
	|	'1'..'9' Digit*
	;

// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 320
fragment
Digit	:	'0'..'9'
	;

	
// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 325
fragment
HexNumeral
	:	'0' 'x' HexDigit+
	;

// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 330
fragment
OctalNumeral
	:	'0' OctalDigit+
	;

// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 335
fragment
OctalDigit
	:	'0'..'7'
	;

// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 340
fragment
HexDigit:	'0'..'9'
	|	'A'..'F'
	|	'a'..'f'
	;

// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 346
Comment
    :   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

// $ANTLR src "/Users/bhoward/workspace/ScalesSubset/ScalaSubset.g" 350
Line_Comment
    : '//' ~('\n'|'\r')* ('\n' | '\r' '\n'?) {$channel=HIDDEN;}
    ;

