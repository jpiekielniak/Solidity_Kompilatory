package org.example.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;


public interface SolidityParserListener extends ParseTreeListener {
	
	void enterSourceUnit(SolidityParser.SourceUnitContext ctx);
	
	void exitSourceUnit(SolidityParser.SourceUnitContext ctx);
	
	void enterPragmaDirective(SolidityParser.PragmaDirectiveContext ctx);
	
	void exitPragmaDirective(SolidityParser.PragmaDirectiveContext ctx);
	
	void enterImportDirective(SolidityParser.ImportDirectiveContext ctx);
	
	void exitImportDirective(SolidityParser.ImportDirectiveContext ctx);
	
	void enterImportAliases(SolidityParser.ImportAliasesContext ctx);
	
	void exitImportAliases(SolidityParser.ImportAliasesContext ctx);
	
	void enterPath(SolidityParser.PathContext ctx);
	
	void exitPath(SolidityParser.PathContext ctx);
	
	void enterSymbolAliases(SolidityParser.SymbolAliasesContext ctx);
	
	void exitSymbolAliases(SolidityParser.SymbolAliasesContext ctx);
	
	void enterContractDefinition(SolidityParser.ContractDefinitionContext ctx);
	
	void exitContractDefinition(SolidityParser.ContractDefinitionContext ctx);
	
	void enterInterfaceDefinition(SolidityParser.InterfaceDefinitionContext ctx);
	
	void exitInterfaceDefinition(SolidityParser.InterfaceDefinitionContext ctx);
	
	void enterLibraryDefinition(SolidityParser.LibraryDefinitionContext ctx);
	
	void exitLibraryDefinition(SolidityParser.LibraryDefinitionContext ctx);
	
	void enterInheritanceSpecifierList(SolidityParser.InheritanceSpecifierListContext ctx);
	
	void exitInheritanceSpecifierList(SolidityParser.InheritanceSpecifierListContext ctx);
	
	void enterInheritanceSpecifier(SolidityParser.InheritanceSpecifierContext ctx);
	
	void exitInheritanceSpecifier(SolidityParser.InheritanceSpecifierContext ctx);
	
	void enterContractBodyElement(SolidityParser.ContractBodyElementContext ctx);
	
	void exitContractBodyElement(SolidityParser.ContractBodyElementContext ctx);
	
	void enterNamedArgument(SolidityParser.NamedArgumentContext ctx);
	
	void exitNamedArgument(SolidityParser.NamedArgumentContext ctx);
	
	void enterCallArgumentList(SolidityParser.CallArgumentListContext ctx);
	
	void exitCallArgumentList(SolidityParser.CallArgumentListContext ctx);
	
	void enterIdentifierPath(SolidityParser.IdentifierPathContext ctx);
	
	void exitIdentifierPath(SolidityParser.IdentifierPathContext ctx);
	
	void enterModifierInvocation(SolidityParser.ModifierInvocationContext ctx);
	
	void exitModifierInvocation(SolidityParser.ModifierInvocationContext ctx);
	
	void enterVisibility(SolidityParser.VisibilityContext ctx);
	
	void exitVisibility(SolidityParser.VisibilityContext ctx);
	
	void enterParameterList(SolidityParser.ParameterListContext ctx);
	
	void exitParameterList(SolidityParser.ParameterListContext ctx);
	
	void enterParameterDeclaration(SolidityParser.ParameterDeclarationContext ctx);
	
	void exitParameterDeclaration(SolidityParser.ParameterDeclarationContext ctx);
	
	void enterConstructorDefinition(SolidityParser.ConstructorDefinitionContext ctx);
	
	void exitConstructorDefinition(SolidityParser.ConstructorDefinitionContext ctx);
	
	void enterStateMutability(SolidityParser.StateMutabilityContext ctx);
	
	void exitStateMutability(SolidityParser.StateMutabilityContext ctx);
	
	void enterOverrideSpecifier(SolidityParser.OverrideSpecifierContext ctx);
	
	void exitOverrideSpecifier(SolidityParser.OverrideSpecifierContext ctx);
	
	void enterFunctionDefinition(SolidityParser.FunctionDefinitionContext ctx);
	
	void exitFunctionDefinition(SolidityParser.FunctionDefinitionContext ctx);
	
	void enterModifierDefinition(SolidityParser.ModifierDefinitionContext ctx);
	
	void exitModifierDefinition(SolidityParser.ModifierDefinitionContext ctx);
	
	void enterFallbackFunctionDefinition(SolidityParser.FallbackFunctionDefinitionContext ctx);
	
	void exitFallbackFunctionDefinition(SolidityParser.FallbackFunctionDefinitionContext ctx);
	
	void enterReceiveFunctionDefinition(SolidityParser.ReceiveFunctionDefinitionContext ctx);
	
	void exitReceiveFunctionDefinition(SolidityParser.ReceiveFunctionDefinitionContext ctx);
	
	void enterStructDefinition(SolidityParser.StructDefinitionContext ctx);
	
	void exitStructDefinition(SolidityParser.StructDefinitionContext ctx);
	
	void enterStructMember(SolidityParser.StructMemberContext ctx);
	
	void exitStructMember(SolidityParser.StructMemberContext ctx);
	
	void enterEnumDefinition(SolidityParser.EnumDefinitionContext ctx);
	
	void exitEnumDefinition(SolidityParser.EnumDefinitionContext ctx);
	
	void enterUserDefinedValueTypeDefinition(SolidityParser.UserDefinedValueTypeDefinitionContext ctx);
	
	void exitUserDefinedValueTypeDefinition(SolidityParser.UserDefinedValueTypeDefinitionContext ctx);
	
	void enterStateVariableDeclaration(SolidityParser.StateVariableDeclarationContext ctx);
	
	void exitStateVariableDeclaration(SolidityParser.StateVariableDeclarationContext ctx);
	
	void enterConstantVariableDeclaration(SolidityParser.ConstantVariableDeclarationContext ctx);
	
	void exitConstantVariableDeclaration(SolidityParser.ConstantVariableDeclarationContext ctx);
	
	void enterEventParameter(SolidityParser.EventParameterContext ctx);
	
	void exitEventParameter(SolidityParser.EventParameterContext ctx);
	
	void enterEventDefinition(SolidityParser.EventDefinitionContext ctx);
	
	void exitEventDefinition(SolidityParser.EventDefinitionContext ctx);
	
	void enterErrorParameter(SolidityParser.ErrorParameterContext ctx);
	
	void exitErrorParameter(SolidityParser.ErrorParameterContext ctx);
	
	void enterErrorDefinition(SolidityParser.ErrorDefinitionContext ctx);
	
	void exitErrorDefinition(SolidityParser.ErrorDefinitionContext ctx);
	
	void enterUserDefinableOperator(SolidityParser.UserDefinableOperatorContext ctx);
	
	void exitUserDefinableOperator(SolidityParser.UserDefinableOperatorContext ctx);
	
	void enterUsingDirective(SolidityParser.UsingDirectiveContext ctx);
	
	void exitUsingDirective(SolidityParser.UsingDirectiveContext ctx);
	
	void enterUsingAliases(SolidityParser.UsingAliasesContext ctx);
	
	void exitUsingAliases(SolidityParser.UsingAliasesContext ctx);
	
	void enterTypeName(SolidityParser.TypeNameContext ctx);
	
	void exitTypeName(SolidityParser.TypeNameContext ctx);
	
	void enterElementaryTypeName(SolidityParser.ElementaryTypeNameContext ctx);
	
	void exitElementaryTypeName(SolidityParser.ElementaryTypeNameContext ctx);
	
	void enterFunctionTypeName(SolidityParser.FunctionTypeNameContext ctx);
	
	void exitFunctionTypeName(SolidityParser.FunctionTypeNameContext ctx);
	
	void enterVariableDeclaration(SolidityParser.VariableDeclarationContext ctx);
	
	void exitVariableDeclaration(SolidityParser.VariableDeclarationContext ctx);
	
	void enterDataLocation(SolidityParser.DataLocationContext ctx);
	
	void exitDataLocation(SolidityParser.DataLocationContext ctx);
	
	void enterUnaryPrefixOperation(SolidityParser.UnaryPrefixOperationContext ctx);
	
	void exitUnaryPrefixOperation(SolidityParser.UnaryPrefixOperationContext ctx);
	
	void enterPrimaryExpression(SolidityParser.PrimaryExpressionContext ctx);
	
	void exitPrimaryExpression(SolidityParser.PrimaryExpressionContext ctx);
	
	void enterOrderComparison(SolidityParser.OrderComparisonContext ctx);
	
	void exitOrderComparison(SolidityParser.OrderComparisonContext ctx);
	
	void enterConditional(SolidityParser.ConditionalContext ctx);
	
	void exitConditional(SolidityParser.ConditionalContext ctx);
	
	void enterPayableConversion(SolidityParser.PayableConversionContext ctx);
	
	void exitPayableConversion(SolidityParser.PayableConversionContext ctx);
	
	void enterAssignment(SolidityParser.AssignmentContext ctx);
	
	void exitAssignment(SolidityParser.AssignmentContext ctx);
	
	void enterUnarySuffixOperation(SolidityParser.UnarySuffixOperationContext ctx);
	
	void exitUnarySuffixOperation(SolidityParser.UnarySuffixOperationContext ctx);
	
	void enterShiftOperation(SolidityParser.ShiftOperationContext ctx);
	
	void exitShiftOperation(SolidityParser.ShiftOperationContext ctx);
	
	void enterBitAndOperation(SolidityParser.BitAndOperationContext ctx);
	
	void exitBitAndOperation(SolidityParser.BitAndOperationContext ctx);
	
	void enterFunctionCall(SolidityParser.FunctionCallContext ctx);
	
	void exitFunctionCall(SolidityParser.FunctionCallContext ctx);
	
	void enterIndexRangeAccess(SolidityParser.IndexRangeAccessContext ctx);
	
	void exitIndexRangeAccess(SolidityParser.IndexRangeAccessContext ctx);
	
	void enterIndexAccess(SolidityParser.IndexAccessContext ctx);
	
	void exitIndexAccess(SolidityParser.IndexAccessContext ctx);
	
	void enterAddSubOperation(SolidityParser.AddSubOperationContext ctx);
	
	void exitAddSubOperation(SolidityParser.AddSubOperationContext ctx);
	
	void enterBitOrOperation(SolidityParser.BitOrOperationContext ctx);
	
	void exitBitOrOperation(SolidityParser.BitOrOperationContext ctx);
	
	void enterExpOperation(SolidityParser.ExpOperationContext ctx);
	
	void exitExpOperation(SolidityParser.ExpOperationContext ctx);
	
	void enterAndOperation(SolidityParser.AndOperationContext ctx);
	
	void exitAndOperation(SolidityParser.AndOperationContext ctx);
	
	void enterInlineArray(SolidityParser.InlineArrayContext ctx);
	
	void exitInlineArray(SolidityParser.InlineArrayContext ctx);
	
	void enterOrOperation(SolidityParser.OrOperationContext ctx);
	
	void exitOrOperation(SolidityParser.OrOperationContext ctx);
	
	void enterMemberAccess(SolidityParser.MemberAccessContext ctx);
	
	void exitMemberAccess(SolidityParser.MemberAccessContext ctx);
	
	void enterMulDivModOperation(SolidityParser.MulDivModOperationContext ctx);
	
	void exitMulDivModOperation(SolidityParser.MulDivModOperationContext ctx);
	
	void enterFunctionCallOptions(SolidityParser.FunctionCallOptionsContext ctx);
	
	void exitFunctionCallOptions(SolidityParser.FunctionCallOptionsContext ctx);
	
	void enterNewExpr(SolidityParser.NewExprContext ctx);
	
	void exitNewExpr(SolidityParser.NewExprContext ctx);
	
	void enterBitXorOperation(SolidityParser.BitXorOperationContext ctx);
	
	void exitBitXorOperation(SolidityParser.BitXorOperationContext ctx);
	
	void enterTuple(SolidityParser.TupleContext ctx);
	
	void exitTuple(SolidityParser.TupleContext ctx);
	
	void enterEqualityComparison(SolidityParser.EqualityComparisonContext ctx);
	
	void exitEqualityComparison(SolidityParser.EqualityComparisonContext ctx);
	
	void enterMetaType(SolidityParser.MetaTypeContext ctx);
	
	void exitMetaType(SolidityParser.MetaTypeContext ctx);
	
	void enterAssignOp(SolidityParser.AssignOpContext ctx);
	
	void exitAssignOp(SolidityParser.AssignOpContext ctx);
	
	void enterTupleExpression(SolidityParser.TupleExpressionContext ctx);
	
	void exitTupleExpression(SolidityParser.TupleExpressionContext ctx);
	
	void enterInlineArrayExpression(SolidityParser.InlineArrayExpressionContext ctx);
	
	void exitInlineArrayExpression(SolidityParser.InlineArrayExpressionContext ctx);
	
	void enterIdentifier(SolidityParser.IdentifierContext ctx);
	
	void exitIdentifier(SolidityParser.IdentifierContext ctx);
	
	void enterLiteral(SolidityParser.LiteralContext ctx);
	
	void exitLiteral(SolidityParser.LiteralContext ctx);
	
	void enterLiteralWithSubDenomination(SolidityParser.LiteralWithSubDenominationContext ctx);
	
	void exitLiteralWithSubDenomination(SolidityParser.LiteralWithSubDenominationContext ctx);
	
	void enterBooleanLiteral(SolidityParser.BooleanLiteralContext ctx);
	
	void exitBooleanLiteral(SolidityParser.BooleanLiteralContext ctx);
	
	void enterStringLiteral(SolidityParser.StringLiteralContext ctx);
	
	void exitStringLiteral(SolidityParser.StringLiteralContext ctx);
	
	void enterHexStringLiteral(SolidityParser.HexStringLiteralContext ctx);
	
	void exitHexStringLiteral(SolidityParser.HexStringLiteralContext ctx);
	
	void enterUnicodeStringLiteral(SolidityParser.UnicodeStringLiteralContext ctx);
	
	void exitUnicodeStringLiteral(SolidityParser.UnicodeStringLiteralContext ctx);
	
	void enterNumberLiteral(SolidityParser.NumberLiteralContext ctx);
	
	void exitNumberLiteral(SolidityParser.NumberLiteralContext ctx);
	
	void enterBlock(SolidityParser.BlockContext ctx);
	
	void exitBlock(SolidityParser.BlockContext ctx);
	
	void enterUncheckedBlock(SolidityParser.UncheckedBlockContext ctx);
	
	void exitUncheckedBlock(SolidityParser.UncheckedBlockContext ctx);
	
	void enterStatement(SolidityParser.StatementContext ctx);
	
	void exitStatement(SolidityParser.StatementContext ctx);
	
	void enterSimpleStatement(SolidityParser.SimpleStatementContext ctx);
	
	void exitSimpleStatement(SolidityParser.SimpleStatementContext ctx);
	
	void enterIfStatement(SolidityParser.IfStatementContext ctx);
	
	void exitIfStatement(SolidityParser.IfStatementContext ctx);
	
	void enterForStatement(SolidityParser.ForStatementContext ctx);
	
	void exitForStatement(SolidityParser.ForStatementContext ctx);
	
	void enterWhileStatement(SolidityParser.WhileStatementContext ctx);
	
	void exitWhileStatement(SolidityParser.WhileStatementContext ctx);
	
	void enterDoWhileStatement(SolidityParser.DoWhileStatementContext ctx);
	
	void exitDoWhileStatement(SolidityParser.DoWhileStatementContext ctx);
	
	void enterContinueStatement(SolidityParser.ContinueStatementContext ctx);
	
	void exitContinueStatement(SolidityParser.ContinueStatementContext ctx);
	
	void enterBreakStatement(SolidityParser.BreakStatementContext ctx);
	
	void exitBreakStatement(SolidityParser.BreakStatementContext ctx);
	
	void enterTryStatement(SolidityParser.TryStatementContext ctx);
	
	void exitTryStatement(SolidityParser.TryStatementContext ctx);
	
	void enterCatchClause(SolidityParser.CatchClauseContext ctx);
	
	void exitCatchClause(SolidityParser.CatchClauseContext ctx);
	
	void enterReturnStatement(SolidityParser.ReturnStatementContext ctx);
	
	void exitReturnStatement(SolidityParser.ReturnStatementContext ctx);
	
	void enterEmitStatement(SolidityParser.EmitStatementContext ctx);
	
	void exitEmitStatement(SolidityParser.EmitStatementContext ctx);
	
	void enterRevertStatement(SolidityParser.RevertStatementContext ctx);
	
	void exitRevertStatement(SolidityParser.RevertStatementContext ctx);
	
	void enterAssemblyStatement(SolidityParser.AssemblyStatementContext ctx);
	
	void exitAssemblyStatement(SolidityParser.AssemblyStatementContext ctx);
	
	void enterAssemblyFlags(SolidityParser.AssemblyFlagsContext ctx);
	
	void exitAssemblyFlags(SolidityParser.AssemblyFlagsContext ctx);
	
	void enterVariableDeclarationList(SolidityParser.VariableDeclarationListContext ctx);
	
	void exitVariableDeclarationList(SolidityParser.VariableDeclarationListContext ctx);
	
	void enterVariableDeclarationTuple(SolidityParser.VariableDeclarationTupleContext ctx);
	
	void exitVariableDeclarationTuple(SolidityParser.VariableDeclarationTupleContext ctx);
	
	void enterVariableDeclarationStatement(SolidityParser.VariableDeclarationStatementContext ctx);
	
	void exitVariableDeclarationStatement(SolidityParser.VariableDeclarationStatementContext ctx);
	
	void enterExpressionStatement(SolidityParser.ExpressionStatementContext ctx);
	
	void exitExpressionStatement(SolidityParser.ExpressionStatementContext ctx);
	
	void enterMappingType(SolidityParser.MappingTypeContext ctx);
	
	void exitMappingType(SolidityParser.MappingTypeContext ctx);
	
	void enterMappingKeyType(SolidityParser.MappingKeyTypeContext ctx);
	
	void exitMappingKeyType(SolidityParser.MappingKeyTypeContext ctx);
}