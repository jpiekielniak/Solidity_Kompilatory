parser grammar SolidityParser;

options { tokenVocab=SolidityLexer; }


sourceUnit: (
	pragmaDirective
	| importDirective
	| usingDirective
	| contractDefinition
	| interfaceDefinition
	| libraryDefinition
	| functionDefinition
	| constantVariableDeclaration
	| structDefinition
	| enumDefinition
	| userDefinedValueTypeDefinition
	| errorDefinition
	| eventDefinition
)* EOF;

pragmaDirective: Pragma PragmaToken+ PragmaSemicolon;


importDirective:
	Import (
		(path (As unitAlias=identifier)?)
		| (symbolAliases From path)
		| (Mul As unitAlias=identifier From path)
	) Semicolon;
importAliases: symbol=identifier (As alias=identifier)?;

path: NonEmptyStringLiteral;

symbolAliases: LBrace aliases+=importAliases (Comma aliases+=importAliases)* RBrace;


contractDefinition:
	Abstract? Contract name=identifier
	inheritanceSpecifierList?
	LBrace contractBodyElement* RBrace;

interfaceDefinition:
	Interface name=identifier
	inheritanceSpecifierList?
	LBrace contractBodyElement* RBrace;

libraryDefinition: Library name=identifier LBrace contractBodyElement* RBrace;

inheritanceSpecifierList:
	Is inheritanceSpecifiers+=inheritanceSpecifier
	(Comma inheritanceSpecifiers+=inheritanceSpecifier)*?;

inheritanceSpecifier: name=identifierPath arguments=callArgumentList?;


contractBodyElement:
	constructorDefinition
	| functionDefinition
	| modifierDefinition
	| fallbackFunctionDefinition
	| receiveFunctionDefinition
	| structDefinition
	| enumDefinition
	| userDefinedValueTypeDefinition
	| stateVariableDeclaration
	| eventDefinition
	| errorDefinition
	| usingDirective;
namedArgument: name=identifier Colon value=expression;

callArgumentList: LParen ((expression (Comma expression)*)? | LBrace (namedArgument (Comma namedArgument)*)? RBrace) RParen;

identifierPath: identifier (Period identifier)*;


modifierInvocation: identifierPath callArgumentList?;

visibility: Internal | External | Private | Public;

parameterList: parameters+=parameterDeclaration (Comma parameters+=parameterDeclaration)*;
parameterDeclaration: type=typeName location=dataLocation? name=identifier?;

constructorDefinition
locals[boolean payableSet = false, boolean visibilitySet = false]
:
	Constructor LParen (arguments=parameterList)? RParen
	(
		modifierInvocation
		| {!$payableSet}? Payable {$payableSet = true;}
		| {!$visibilitySet}? Internal {$visibilitySet = true;}
		| {!$visibilitySet}? Public {$visibilitySet = true;}
	)*
	body=block;


stateMutability: Pure | View | Payable;

overrideSpecifier: Override (LParen overrides+=identifierPath (Comma overrides+=identifierPath)* RParen)?;

functionDefinition
locals[
	boolean visibilitySet = false,
	boolean mutabilitySet = false,
	boolean virtualSet = false,
	boolean overrideSpecifierSet = false,
]
:
	Function (identifier | Fallback | Receive)
	LParen (arguments=parameterList)? RParen
	(
		{!$visibilitySet}? visibility {$visibilitySet = true;}
		| {!$mutabilitySet}? stateMutability {$mutabilitySet = true;}
		| modifierInvocation
		| {!$virtualSet}? Virtual {$virtualSet = true;}
		| {!$overrideSpecifierSet}? overrideSpecifier {$overrideSpecifierSet = true;}
	 )*
	(Returns LParen returnParameters=parameterList RParen)?
	(Semicolon | body=block);


modifierDefinition
locals[
	boolean virtualSet = false,
	boolean overrideSpecifierSet = false
]
:
	Modifier name=identifier
	(LParen (arguments=parameterList)? RParen)?
	(
		{!$virtualSet}? Virtual {$virtualSet = true;}
		| {!$overrideSpecifierSet}? overrideSpecifier {$overrideSpecifierSet = true;}
	)*
	(Semicolon | body=block);


fallbackFunctionDefinition
locals[
	boolean visibilitySet = false,
	boolean mutabilitySet = false,
	boolean virtualSet = false,
	boolean overrideSpecifierSet = false,
	boolean hasParameters = false
]
:
	kind=Fallback LParen (parameterList { $hasParameters = true; } )? RParen
	(
		{!$visibilitySet}? External {$visibilitySet = true;}
		| {!$mutabilitySet}? stateMutability {$mutabilitySet = true;}
		| modifierInvocation
		| {!$virtualSet}? Virtual {$virtualSet = true;}
		| {!$overrideSpecifierSet}? overrideSpecifier {$overrideSpecifierSet = true;}
	)*
	( {$hasParameters}? Returns LParen returnParameters=parameterList RParen | {!$hasParameters}? )
	(Semicolon | body=block);


receiveFunctionDefinition
locals[
	boolean visibilitySet = false,
	boolean mutabilitySet = false,
	boolean virtualSet = false,
	boolean overrideSpecifierSet = false
]
:
	kind=Receive LParen RParen
	(
		{!$visibilitySet}? External {$visibilitySet = true;}
		| {!$mutabilitySet}? Payable {$mutabilitySet = true;}
		| modifierInvocation
		| {!$virtualSet}? Virtual {$virtualSet = true;}
		| {!$overrideSpecifierSet}? overrideSpecifier {$overrideSpecifierSet = true;}
	 )*
	(Semicolon | body=block);


structDefinition: Struct name=identifier LBrace members=structMember+ RBrace;

structMember: type=typeName name=identifier Semicolon;

enumDefinition: Enum name=identifier LBrace enumValues+=identifier (Comma enumValues+=identifier)* RBrace;

userDefinedValueTypeDefinition:
	Type name=identifier Is elementaryTypeName[true] Semicolon;


stateVariableDeclaration
locals [boolean constantnessSet = false, boolean visibilitySet = false, boolean overrideSpecifierSet = false]
:
	type=typeName
	(
		{!$visibilitySet}? Public {$visibilitySet = true;}
		| {!$visibilitySet}? Private {$visibilitySet = true;}
		| {!$visibilitySet}? Internal {$visibilitySet = true;}
		| {!$constantnessSet}? Constant {$constantnessSet = true;}
		| {!$overrideSpecifierSet}? overrideSpecifier {$overrideSpecifierSet = true;}
		| {!$constantnessSet}? Immutable {$constantnessSet = true;}
	)*
	name=identifier
	(Assign initialValue=expression)?
	Semicolon;


constantVariableDeclaration
:
	type=typeName
	Constant
	name=identifier
	Assign initialValue=expression
	Semicolon;


eventParameter: type=typeName Indexed? name=identifier?;

eventDefinition:
	Event name=identifier
	LParen (parameters+=eventParameter (Comma parameters+=eventParameter)*)? RParen
	Anonymous?
	Semicolon;


errorParameter: type=typeName name=identifier?;

errorDefinition:
	Error name=identifier
	LParen (parameters+=errorParameter (Comma parameters+=errorParameter)*)? RParen
	Semicolon;


userDefinableOperator:
	BitAnd
	| BitNot
	| BitOr
	| BitXor
	| Add
	| Div
	| Mod
	| Mul
	| Sub
	| Equal
	| GreaterThan
	| GreaterThanOrEqual
	| LessThan
	| LessThanOrEqual
	| NotEqual;


usingDirective:
  Using (
    identifierPath
    | (LBrace usingAliases (Comma usingAliases)* RBrace)
  ) For (Mul | typeName) Global? Semicolon;

usingAliases: identifierPath (As userDefinableOperator)?;


typeName: elementaryTypeName[true] | functionTypeName | mappingType | identifierPath | typeName LBrack expression? RBrack;
elementaryTypeName[boolean allowAddressPayable]: Address | {$allowAddressPayable}? Address Payable | Bool | String | Bytes | SignedIntegerType | UnsignedIntegerType | FixedBytes | Fixed | Ufixed;
functionTypeName
locals [boolean visibilitySet = false, boolean mutabilitySet = false]
:
	Function LParen (arguments=parameterList)? RParen
	(
		{!$visibilitySet}? visibility {$visibilitySet = true;}
		| {!$mutabilitySet}? stateMutability {$mutabilitySet = true;}
	)*
	(Returns LParen returnParameters=parameterList RParen)?;


variableDeclaration: type=typeName location=dataLocation? name=identifier;
dataLocation: Memory | Storage | Calldata;


expression:
	expression LBrack index=expression? RBrack # IndexAccess
	| expression LBrack startIndex=expression? Colon endIndex=expression? RBrack # IndexRangeAccess
	| expression Period (identifier | Address) # MemberAccess
	| expression LBrace (namedArgument (Comma namedArgument)*)? RBrace # FunctionCallOptions
	| expression callArgumentList # FunctionCall
	| Payable callArgumentList # PayableConversion
	| Type LParen typeName RParen # MetaType
	| (Inc | Dec | Not | BitNot | Delete | Sub) expression # UnaryPrefixOperation
	| expression (Inc | Dec) # UnarySuffixOperation
	|<assoc=right> expression Exp expression # ExpOperation
	| expression (Mul | Div | Mod) expression # MulDivModOperation
	| expression (Add | Sub) expression # AddSubOperation
	| expression (Shl | Sar | Shr) expression # ShiftOperation
	| expression BitAnd expression # BitAndOperation
	| expression BitXor expression # BitXorOperation
	| expression BitOr expression # BitOrOperation
	| expression (LessThan | GreaterThan | LessThanOrEqual | GreaterThanOrEqual) expression # OrderComparison
	| expression (Equal | NotEqual) expression # EqualityComparison
	| expression And expression # AndOperation
	| expression Or expression # OrOperation
	|<assoc=right> expression Conditional expression Colon expression # Conditional
	|<assoc=right> expression assignOp expression # Assignment
	| New typeName # NewExpr
	| tupleExpression # Tuple
	| inlineArrayExpression # InlineArray
	| (
		identifier
		| literal
		| literalWithSubDenomination
		| elementaryTypeName[false]
	  ) # PrimaryExpression
;

assignOp: Assign | AssignBitOr | AssignBitXor | AssignBitAnd | AssignShl | AssignSar | AssignShr | AssignAdd | AssignSub | AssignMul | AssignDiv | AssignMod;
tupleExpression: LParen (expression? ( Comma expression?)* ) RParen;

inlineArrayExpression: LBrack (expression ( Comma expression)* ) RBrack;


identifier: Identifier | From | Error | Revert | Global;

literal: stringLiteral | numberLiteral | booleanLiteral | hexStringLiteral | unicodeStringLiteral;

literalWithSubDenomination: numberLiteral SubDenomination;

booleanLiteral: True | False;

stringLiteral: (NonEmptyStringLiteral | EmptyStringLiteral)+;

hexStringLiteral: HexString+;

unicodeStringLiteral: UnicodeStringLiteral+;


numberLiteral: DecimalNumber | HexNumber;


block:
	LBrace ( statement | uncheckedBlock )* RBrace;

uncheckedBlock: Unchecked block;

statement:
	block
	| simpleStatement
	| ifStatement
	| forStatement
	| whileStatement
	| doWhileStatement
	| continueStatement
	| breakStatement
	| tryStatement
	| returnStatement
	| emitStatement
	| revertStatement
	| assemblyStatement
;

simpleStatement: variableDeclarationStatement | expressionStatement;

ifStatement: If LParen expression RParen statement (Else statement)?;

forStatement: For LParen (simpleStatement | Semicolon) (expressionStatement | Semicolon) expression? RParen statement;
whileStatement: While LParen expression RParen statement;
doWhileStatement: Do statement While LParen expression RParen Semicolon;

continueStatement: Continue Semicolon;

breakStatement: Break Semicolon;

tryStatement: Try expression (Returns LParen returnParameters=parameterList RParen)? block catchClause+;

catchClause: Catch (identifier? LParen (arguments=parameterList) RParen)? block;

returnStatement: Return expression? Semicolon;

emitStatement: Emit expression callArgumentList Semicolon;

revertStatement: Revert expression callArgumentList Semicolon;

assemblyStatement: Assembly AssemblyDialect? assemblyFlags?;


assemblyFlags: AssemblyBlockLParen AssemblyFlagString (AssemblyBlockComma AssemblyFlagString)* AssemblyBlockRParen;

variableDeclarationList: variableDeclarations+=variableDeclaration (Comma variableDeclarations+=variableDeclaration)*;

variableDeclarationTuple:
	LParen
		(Comma* variableDeclarations+=variableDeclaration)
		(Comma (variableDeclarations+=variableDeclaration)?)*
	RParen;

variableDeclarationStatement: ((variableDeclaration (Assign expression)?) | (variableDeclarationTuple Assign expression)) Semicolon;
expressionStatement: expression Semicolon;

mappingType: Mapping LParen key=mappingKeyType name=identifier? DoubleArrow value=typeName name=identifier? RParen;

mappingKeyType: elementaryTypeName[false] | identifierPath;