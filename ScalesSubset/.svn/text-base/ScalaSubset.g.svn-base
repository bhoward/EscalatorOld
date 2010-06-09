grammar ScalaSubset;

compilationUnit
	:	'package' qualId semi topStatSeq
	;
	
qualId	:	id ('.' id)*
	;
	
topStatSeq
	:	topStat (semi topStat)*
	;
	
topStat	:	tmplDef
	|
	;
	
tmplDef	:	'object' objectDef
	;
	
objectDef
	:	id classTemplateOpt
	;
	
classTemplateOpt
	:	templateBody
	;

templateBody
	:	Newline? '{' templateStat (semi templateStat)* '}'
	;
	
templateStat
	:	def
	|
	;
	
def	:	'def' funDef
	;
	
funDef	:	funSig Newline? funDefRest
	;
	
funDefRest
	:	':' Newline? type '=' Newline? expr
	|	'{' block '}'
	;

funSig	:	id paramClauses
	;
	
paramClauses
	:	paramClause*
	;
	
paramClause
	:	Newline? '(' params? ')'
	;
	
params	:	param (',' param)*
	;
	
param	:	Newline? id ':' paramType
	;
	
paramType
	:	type
	;

block	:	expr1? (semi block)?
	;
			
expr	:	expr1
	;
	
expr1	:	postfixExpr
	;
	
postfixExpr
	:	infixExpr
	;

infixExpr
	:	prefixExpr (Op Newline? infixExpr)?
	;
	
prefixExpr
	:	simpleExpr
	;
	
simpleExpr
	:	blockExpr
	|	simpleExpr1
	;
	
blockExpr
	:	'{' Newline? caseClauses '}'
	;
	
caseClauses
	:	caseClause+
	;
	
caseClause
	:	'case' pattern Newline? '=>' block
	;

pattern	:	pattern1
	;
	
pattern1:	pattern2
	;
	
pattern2:	pattern3
	;
	
pattern3:	simplePattern
	;

simplePattern
	:	literal
	|	stableID
	|	stableID '(' Newline? (patterns Newline? )? ')'
	;
	
patterns:	pattern (',' Newline? patterns)?
	;
	
simpleExpr1
	:	literal argumentExprs*
	|	path argumentExprs*
	;
	
argumentExprs
	:	'(' Newline? (exprs Newline? )? ')'
	;
	
exprs	:	expr (',' Newline? expr)*
	;
	
path	:	stableID
	;

stableID:	id ('.' id)*
	;
	
literal	:	IntegerLiteral
	|	FloatingPointLiteral
	|	'true' | 'false'
	|	CharacterLiteral
	|	StringLiteral
	;
	
type	:	infixType ('=>' Newline? type)?
	;
	
infixType
	:	compoundType
	;
	
compoundType
	:	annotType
	;
	
annotType
	:	simpleType
	;
	
simpleType
	: 	stableID typeArgs*
	|	'(' Newline? types Newline? ')'
	;
	
typeArgs:	'[' Newline? types Newline? ']'
	;
	
types	:	type (',' Newline? type)*
	;
	
id	:	UpperID
	|	VarID
	|	Op
	;

semi	:	';'
	|	Newline
	;
 
//LEXER
	
Newline	:	'\n' | '\r' '\n'?
	;
	
WS	:	(' ' | '\t' | '\f')+ { $channel=HIDDEN; }
	;
	
UpperID	:	Upper IdRest
	;

VarID	:	Lower IdRest
	;
	
fragment	
IdRest	:	(Letter | Digit)* ('_' Op)?
	;

fragment
Letter	:	Upper | Lower
	;

/* These character ranges are only approximate above unicode 0100.
 * Partly taken from the ANTLR Java 1.5 grammar,
 * and also based on tables from http://www.fileformat.info/info/unicode/category/
 */
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

fragment
Lower	:	'a'..'z'
	|	'\u00aa'
	|	'\u00b5'
	|	'\u00ba'
	|	'\u00df'..'\u00f6'
	|	'\u00f8'..'\u00ff'
	;
	
Op	:	OpChar+
	;
	
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
	
IntegerLiteral
	:	(DecimalNumeral | HexNumeral | OctalNumeral) ('L' | 'l')?
	;
	
FloatingPointLiteral
	:	Digit+ '.' Digit* ExponentPart? FloatType?
	|	'.' Digit+ ExponentPart? FloatType?
	|	Digit+ ExponentPart FloatType?
	|	Digit+ FloatType
	;
	
fragment
ExponentPart
	:	('E' | 'e') ('+' | '-')? Digit+
	;
	
fragment
FloatType
	:	'F' | 'f' | 'D' | 'd'
	;
	
CharacterLiteral
	:	'\'' PrintableChar '\''
	|	'\'' CharEscapeSeq '\''
	;
	
StringLiteral
	:	'"' StringElement* '"'
	;
	
fragment
PrintableChar
	:	PrintableCharNoDoubleQuote
	|	'"'
	;
	
fragment
CharEscapeSeq
	:	'\\' ('b' | 't' | 'n' | 'f' | 'r' | '"' | '\'' | '\\' | OctalDigits)
	;
	
fragment
OctalDigits
	:	OctalDigit (OctalDigit OctalDigit?)?
	;
	
fragment
StringElement
	:	PrintableCharNoDoubleQuote
	|	CharEscapeSeq
	;
	
fragment
PrintableCharNoDoubleQuote
	:	' ' | '!' | '#'..'\ufffe'
	;
	
fragment
DecimalNumeral
	:	'0'
	|	'1'..'9' Digit*
	;

fragment
Digit	:	'0'..'9'
	;

	
fragment
HexNumeral
	:	'0' 'x' HexDigit+
	;

fragment
OctalNumeral
	:	'0' OctalDigit+
	;

fragment
OctalDigit
	:	'0'..'7'
	;

fragment
HexDigit:	'0'..'9'
	|	'A'..'F'
	|	'a'..'f'
	;

Comment
    :   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

Line_Comment
    : '//' ~('\n'|'\r')* ('\n' | '\r' '\n'?) {$channel=HIDDEN;}
    ;

