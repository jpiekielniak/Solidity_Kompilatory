lexer grammar SolidityLexer;

ReservedKeywords:
	'after' | 'alias' | 'apply' | 'auto' | 'byte' | 'case' | 'copyof' | 'default' | 'define' | 'final'
	| 'implements' | 'in' | 'inline' | 'let' | 'macro' | 'match' | 'mutable' | 'null' | 'of'
	| 'partial' | 'promise' | 'reference' | 'relocatable' | 'sealed' | 'sizeof' | 'static'
	| 'supports' | 'switch' | 'typedef' | 'typeof' | 'var';

Abstract: 'abstract';
Address: 'address';
Anonymous: 'anonymous';
As: 'as';
Assembly: 'assembly' -> pushMode(AssemblyBlockMode);
Bool: 'bool';
Break: 'break';
Bytes: 'bytes';
Calldata: 'calldata';
Catch: 'catch';
Constant: 'constant';
Constructor: 'constructor';
Continue: 'continue';
Contract: 'contract';
Delete: 'delete';
Do: 'do';
Else: 'else';
Emit: 'emit';
Enum: 'enum';
Error: 'error'; // not a real keyword
Event: 'event';
External: 'external';
Fallback: 'fallback';
False: 'false';
Fixed: 'fixed' | ('fixed' [1-9][0-9]* 'x' [1-9][0-9]*);
FixedBytes:
	'bytes1' | 'bytes2' | 'bytes3' | 'bytes4' | 'bytes5' | 'bytes6' | 'bytes7' | 'bytes8' |
	'bytes9' | 'bytes10' | 'bytes11' | 'bytes12' | 'bytes13' | 'bytes14' | 'bytes15' | 'bytes16' |
	'bytes17' | 'bytes18' | 'bytes19' | 'bytes20' | 'bytes21' | 'bytes22' | 'bytes23' | 'bytes24' |
	'bytes25' | 'bytes26' | 'bytes27' | 'bytes28' | 'bytes29' | 'bytes30' | 'bytes31' | 'bytes32';
For: 'for';
From: 'from'; // not a real keyword
Function: 'function';
Global: 'global'; // not a real keyword
Hex: 'hex';
If: 'if';
Immutable: 'immutable';
Import: 'import';
Indexed: 'indexed';
Interface: 'interface';
Internal: 'internal';
Is: 'is';
Library: 'library';
Mapping: 'mapping';
Memory: 'memory';
Modifier: 'modifier';
New: 'new';
SubDenomination: 'wei' | 'gwei' | 'ether' | 'seconds' | 'minutes' | 'hours' | 'days' | 'weeks' | 'years';
Override: 'override';
Payable: 'payable';
Pragma: 'pragma' -> pushMode(PragmaMode);
Private: 'private';
Public: 'public';
Pure: 'pure';
Receive: 'receive';
Return: 'return';
Returns: 'returns';
Revert: 'revert'; // not a real keyword
SignedIntegerType:
	'int' | 'int8' | 'int16' | 'int24' | 'int32' | 'int40' | 'int48' | 'int56' | 'int64' |
	'int72' | 'int80' | 'int88' | 'int96' | 'int104' | 'int112' | 'int120' | 'int128' |
	'int136' | 'int144' | 'int152' | 'int160' | 'int168' | 'int176' | 'int184' | 'int192' |
	'int200' | 'int208' | 'int216' | 'int224' | 'int232' | 'int240' | 'int248' | 'int256';
Storage: 'storage';
String: 'string';
Struct: 'struct';
True: 'true';
Try: 'try';
Type: 'type';
Ufixed: 'ufixed' | ('ufixed' [1-9][0-9]+ 'x' [1-9][0-9]+);
Unchecked: 'unchecked';
Unicode: 'unicode';
UnsignedIntegerType:
	'uint' | 'uint8' | 'uint16' | 'uint24' | 'uint32' | 'uint40' | 'uint48' | 'uint56' | 'uint64' |
	'uint72' | 'uint80' | 'uint88' | 'uint96' | 'uint104' | 'uint112' | 'uint120' | 'uint128' |
	'uint136' | 'uint144' | 'uint152' | 'uint160' | 'uint168' | 'uint176' | 'uint184' | 'uint192' |
	'uint200' | 'uint208' | 'uint216' | 'uint224' | 'uint232' | 'uint240' | 'uint248' | 'uint256';
Using: 'using';
View: 'view';
Virtual: 'virtual';
While: 'while';

LParen: '(';
RParen: ')';
LBrack: '[';
RBrack: ']';
LBrace: '{';
RBrace: '}';
Colon: ':';
Semicolon: ';';
Period: '.';
Conditional: '?';
DoubleArrow: '=>';
RightArrow: '->';

Assign: '=';
AssignBitOr: '|=';
AssignBitXor: '^=';
AssignBitAnd: '&=';
AssignShl: '<<=';
AssignSar: '>>=';
AssignShr: '>>>=';
AssignAdd: '+=';
AssignSub: '-=';
AssignMul: '*=';
AssignDiv: '/=';
AssignMod: '%=';

Comma: ',';
Or: '||';
And: '&&';
BitOr: '|';
BitXor: '^';
BitAnd: '&';
Shl: '<<';
Sar: '>>';
Shr: '>>>';
Add: '+';
Sub: '-';
Mul: '*';
Div: '/';
Mod: '%';
Exp: '**';

Equal: '==';
NotEqual: '!=';
LessThan: '<';
GreaterThan: '>';
LessThanOrEqual: '<=';
GreaterThanOrEqual: '>=';
Not: '!';
BitNot: '~';
Inc: '++';
Dec: '--';
DoubleQuote: '"';
SingleQuote: '\'';

NonEmptyStringLiteral: '"' DoubleQuotedStringCharacter+ '"' | '\'' SingleQuotedStringCharacter+ '\'';
EmptyStringLiteral: '"' '"' | '\'' '\'';

fragment DoubleQuotedStringCharacter: DoubleQuotedPrintable | EscapeSequence;
fragment SingleQuotedStringCharacter: SingleQuotedPrintable | EscapeSequence;
fragment SingleQuotedPrintable: [\u0020-\u0026\u0028-\u005B\u005D-\u007E];
fragment DoubleQuotedPrintable: [\u0020-\u0021\u0023-\u005B\u005D-\u007E];

fragment EscapeSequence:
	'\\' (
		['"\\nrt\n\r]
		| 'u' HexCharacter HexCharacter HexCharacter HexCharacter
		| 'x' HexCharacter HexCharacter
	);

UnicodeStringLiteral: 'unicode' (('"' DoubleQuotedUnicodeStringCharacter* '"') | ('\'' SingleQuotedUnicodeStringCharacter* '\''));
fragment DoubleQuotedUnicodeStringCharacter: ~["\r\n\\] | EscapeSequence;
fragment SingleQuotedUnicodeStringCharacter: ~['\r\n\\] | EscapeSequence;

HexString: 'hex' (('"' EvenHexDigits? '"') | ('\'' EvenHexDigits? '\''));
HexNumber: '0' 'x' HexDigits;
fragment HexDigits: HexCharacter ('_'? HexCharacter)*;
fragment EvenHexDigits: HexCharacter HexCharacter ('_'? HexCharacter HexCharacter)*;
fragment HexCharacter: [0-9A-Fa-f];

OctalNumber: '0' DecimalDigits ('.' DecimalDigits)?;

DecimalNumber: (DecimalDigits | (DecimalDigits? '.' DecimalDigits)) ([eE] '-'? DecimalDigits)?;
fragment DecimalDigits: [0-9] ('_'? [0-9])* ;

DecimalNumberFollowedByIdentifier: DecimalNumber Identifier;

Identifier: IdentifierStart IdentifierPart*;
fragment IdentifierStart: [a-zA-Z$_];
fragment IdentifierPart: [a-zA-Z0-9$_];

WS: [ \t\r\n\u000C]+ -> skip ;
COMMENT: '/*' .*? '*/' -> channel(HIDDEN) ;
LINE_COMMENT: '//' ~[\r\n]* -> channel(HIDDEN);

mode AssemblyBlockMode;

AssemblyDialect: '"evmasm"';

AssemblyFlagString: '"' DoubleQuotedStringCharacter+ '"';

AssemblyBlockLParen: '(';
AssemblyBlockRParen: ')';
AssemblyBlockComma: ',';

AssemblyBlockWS: [ \t\r\n\u000C]+ -> skip ;
AssemblyBlockCOMMENT: '/*' .*? '*/' -> channel(HIDDEN) ;
AssemblyBlockLINE_COMMENT: '//' ~[\r\n]* -> channel(HIDDEN) ;

mode PragmaMode;

PragmaToken: ~[;]+;
PragmaSemicolon: ';' -> popMode;

PragmaWS: [ \t\r\n\u000C]+ -> skip ;
PragmaCOMMENT: '/*' .*? '*/' -> channel(HIDDEN) ;
PragmaLINE_COMMENT: '//' ~[\r\n]* -> channel(HIDDEN) ;
