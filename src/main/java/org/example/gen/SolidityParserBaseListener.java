package org.example.gen;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;




@SuppressWarnings("CheckReturnValue")
public class SolidityParserBaseListener implements SolidityParserListener {
	
	@Override public void enterSourceUnit(SolidityParser.SourceUnitContext ctx) { }
	
	@Override public void exitSourceUnit(SolidityParser.SourceUnitContext ctx) { }
	
	@Override public void enterPragmaDirective(SolidityParser.PragmaDirectiveContext ctx) {
    }
	
	@Override public void exitPragmaDirective(SolidityParser.PragmaDirectiveContext ctx) {
	}
	
	@Override public void enterImportDirective(SolidityParser.ImportDirectiveContext ctx) { }
	
	@Override public void exitImportDirective(SolidityParser.ImportDirectiveContext ctx) { }
	
	@Override public void enterImportAliases(SolidityParser.ImportAliasesContext ctx) { }
	
	@Override public void exitImportAliases(SolidityParser.ImportAliasesContext ctx) { }
	
	@Override public void enterPath(SolidityParser.PathContext ctx) { }
	
	@Override public void exitPath(SolidityParser.PathContext ctx) { }
	
	@Override public void enterSymbolAliases(SolidityParser.SymbolAliasesContext ctx) { }
	
	@Override public void exitSymbolAliases(SolidityParser.SymbolAliasesContext ctx) { }
	
	@Override public void enterContractDefinition(SolidityParser.ContractDefinitionContext ctx) { }
	
	@Override public void exitContractDefinition(SolidityParser.ContractDefinitionContext ctx) { }
	
	@Override public void enterInterfaceDefinition(SolidityParser.InterfaceDefinitionContext ctx) { }
	
	@Override public void exitInterfaceDefinition(SolidityParser.InterfaceDefinitionContext ctx) { }
	
	@Override public void enterLibraryDefinition(SolidityParser.LibraryDefinitionContext ctx) { }
	
	@Override public void exitLibraryDefinition(SolidityParser.LibraryDefinitionContext ctx) { }
	
	@Override public void enterInheritanceSpecifierList(SolidityParser.InheritanceSpecifierListContext ctx) { }
	
	@Override public void exitInheritanceSpecifierList(SolidityParser.InheritanceSpecifierListContext ctx) { }
	
	@Override public void enterInheritanceSpecifier(SolidityParser.InheritanceSpecifierContext ctx) { }
	
	@Override public void exitInheritanceSpecifier(SolidityParser.InheritanceSpecifierContext ctx) { }
	
	@Override public void enterContractBodyElement(SolidityParser.ContractBodyElementContext ctx) { }
	
	@Override public void exitContractBodyElement(SolidityParser.ContractBodyElementContext ctx) { }
	
	@Override public void enterNamedArgument(SolidityParser.NamedArgumentContext ctx) { }
	
	@Override public void exitNamedArgument(SolidityParser.NamedArgumentContext ctx) { }
	
	@Override public void enterCallArgumentList(SolidityParser.CallArgumentListContext ctx) { }
	
	@Override public void exitCallArgumentList(SolidityParser.CallArgumentListContext ctx) { }
	
	@Override public void enterIdentifierPath(SolidityParser.IdentifierPathContext ctx) { }
	
	@Override public void exitIdentifierPath(SolidityParser.IdentifierPathContext ctx) { }
	
	@Override public void enterModifierInvocation(SolidityParser.ModifierInvocationContext ctx) { }
	
	@Override public void exitModifierInvocation(SolidityParser.ModifierInvocationContext ctx) { }
	
	@Override public void enterVisibility(SolidityParser.VisibilityContext ctx) { }
	
	@Override public void exitVisibility(SolidityParser.VisibilityContext ctx) { }
	
	@Override public void enterParameterList(SolidityParser.ParameterListContext ctx) { }
	
	@Override public void exitParameterList(SolidityParser.ParameterListContext ctx) { }
	
	@Override public void enterParameterDeclaration(SolidityParser.ParameterDeclarationContext ctx) { }
	
	@Override public void exitParameterDeclaration(SolidityParser.ParameterDeclarationContext ctx) { }
	
	@Override public void enterConstructorDefinition(SolidityParser.ConstructorDefinitionContext ctx) { }
	
	@Override public void exitConstructorDefinition(SolidityParser.ConstructorDefinitionContext ctx) { }
	
	@Override public void enterStateMutability(SolidityParser.StateMutabilityContext ctx) { }
	
	@Override public void exitStateMutability(SolidityParser.StateMutabilityContext ctx) { }
	
	@Override public void enterOverrideSpecifier(SolidityParser.OverrideSpecifierContext ctx) { }
	
	@Override public void exitOverrideSpecifier(SolidityParser.OverrideSpecifierContext ctx) { }

	@Override
	public void enterFunctionDefinition(SolidityParser.FunctionDefinitionContext ctx) {
	}


	@Override public void exitFunctionDefinition(SolidityParser.FunctionDefinitionContext ctx) { }
	
	@Override public void enterModifierDefinition(SolidityParser.ModifierDefinitionContext ctx) { }
	
	@Override public void exitModifierDefinition(SolidityParser.ModifierDefinitionContext ctx) { }
	
	@Override public void enterFallbackFunctionDefinition(SolidityParser.FallbackFunctionDefinitionContext ctx) { }
	
	@Override public void exitFallbackFunctionDefinition(SolidityParser.FallbackFunctionDefinitionContext ctx) { }
	
	@Override public void enterReceiveFunctionDefinition(SolidityParser.ReceiveFunctionDefinitionContext ctx) { }
	
	@Override public void exitReceiveFunctionDefinition(SolidityParser.ReceiveFunctionDefinitionContext ctx) { }
	
	@Override public void enterStructDefinition(SolidityParser.StructDefinitionContext ctx) { }
	
	@Override public void exitStructDefinition(SolidityParser.StructDefinitionContext ctx) { }
	
	@Override public void enterStructMember(SolidityParser.StructMemberContext ctx) { }
	
	@Override public void exitStructMember(SolidityParser.StructMemberContext ctx) { }
	
	@Override public void enterEnumDefinition(SolidityParser.EnumDefinitionContext ctx) { }
	
	@Override public void exitEnumDefinition(SolidityParser.EnumDefinitionContext ctx) { }
	
	@Override public void enterUserDefinedValueTypeDefinition(SolidityParser.UserDefinedValueTypeDefinitionContext ctx) { }
	
	@Override public void exitUserDefinedValueTypeDefinition(SolidityParser.UserDefinedValueTypeDefinitionContext ctx) { }
	
	@Override public void enterStateVariableDeclaration(SolidityParser.StateVariableDeclarationContext ctx) { }
	
	@Override public void exitStateVariableDeclaration(SolidityParser.StateVariableDeclarationContext ctx) { }
	
	@Override public void enterConstantVariableDeclaration(SolidityParser.ConstantVariableDeclarationContext ctx) { }
	
	@Override public void exitConstantVariableDeclaration(SolidityParser.ConstantVariableDeclarationContext ctx) { }
	
	@Override public void enterEventParameter(SolidityParser.EventParameterContext ctx) { }
	
	@Override public void exitEventParameter(SolidityParser.EventParameterContext ctx) { }
	
	@Override public void enterEventDefinition(SolidityParser.EventDefinitionContext ctx) { }
	
	@Override public void exitEventDefinition(SolidityParser.EventDefinitionContext ctx) { }
	
	@Override public void enterErrorParameter(SolidityParser.ErrorParameterContext ctx) { }
	
	@Override public void exitErrorParameter(SolidityParser.ErrorParameterContext ctx) { }
	
	@Override public void enterErrorDefinition(SolidityParser.ErrorDefinitionContext ctx) { }
	
	@Override public void exitErrorDefinition(SolidityParser.ErrorDefinitionContext ctx) { }
	
	@Override public void enterUserDefinableOperator(SolidityParser.UserDefinableOperatorContext ctx) { }
	
	@Override public void exitUserDefinableOperator(SolidityParser.UserDefinableOperatorContext ctx) { }
	
	@Override public void enterUsingDirective(SolidityParser.UsingDirectiveContext ctx) { }
	
	@Override public void exitUsingDirective(SolidityParser.UsingDirectiveContext ctx) { }
	
	@Override public void enterUsingAliases(SolidityParser.UsingAliasesContext ctx) { }
	
	@Override public void exitUsingAliases(SolidityParser.UsingAliasesContext ctx) { }
	
	@Override public void enterTypeName(SolidityParser.TypeNameContext ctx) { }
	
	@Override public void exitTypeName(SolidityParser.TypeNameContext ctx) { }
	
	@Override public void enterElementaryTypeName(SolidityParser.ElementaryTypeNameContext ctx) { }
	
	@Override public void exitElementaryTypeName(SolidityParser.ElementaryTypeNameContext ctx) { }
	
	@Override public void enterFunctionTypeName(SolidityParser.FunctionTypeNameContext ctx) { }
	
	@Override public void exitFunctionTypeName(SolidityParser.FunctionTypeNameContext ctx) { }
	
	@Override public void enterVariableDeclaration(SolidityParser.VariableDeclarationContext ctx) { }
	
	@Override public void exitVariableDeclaration(SolidityParser.VariableDeclarationContext ctx) { }
	
	@Override public void enterDataLocation(SolidityParser.DataLocationContext ctx) { }
	
	@Override public void exitDataLocation(SolidityParser.DataLocationContext ctx) { }
	
	@Override public void enterUnaryPrefixOperation(SolidityParser.UnaryPrefixOperationContext ctx) { }
	
	@Override public void exitUnaryPrefixOperation(SolidityParser.UnaryPrefixOperationContext ctx) { }
	
	@Override public void enterPrimaryExpression(SolidityParser.PrimaryExpressionContext ctx) { }
	
	@Override public void exitPrimaryExpression(SolidityParser.PrimaryExpressionContext ctx) { }
	
	@Override public void enterOrderComparison(SolidityParser.OrderComparisonContext ctx) { }
	
	@Override public void exitOrderComparison(SolidityParser.OrderComparisonContext ctx) { }
	
	@Override public void enterConditional(SolidityParser.ConditionalContext ctx) { }
	
	@Override public void exitConditional(SolidityParser.ConditionalContext ctx) { }
	
	@Override public void enterPayableConversion(SolidityParser.PayableConversionContext ctx) { }
	
	@Override public void exitPayableConversion(SolidityParser.PayableConversionContext ctx) { }
	
	@Override public void enterAssignment(SolidityParser.AssignmentContext ctx) { }
	
	@Override public void exitAssignment(SolidityParser.AssignmentContext ctx) { }
	
	@Override public void enterUnarySuffixOperation(SolidityParser.UnarySuffixOperationContext ctx) { }
	
	@Override public void exitUnarySuffixOperation(SolidityParser.UnarySuffixOperationContext ctx) { }
	
	@Override public void enterShiftOperation(SolidityParser.ShiftOperationContext ctx) { }
	
	@Override public void exitShiftOperation(SolidityParser.ShiftOperationContext ctx) { }
	
	@Override public void enterBitAndOperation(SolidityParser.BitAndOperationContext ctx) { }
	
	@Override public void exitBitAndOperation(SolidityParser.BitAndOperationContext ctx) { }
	
	@Override public void enterFunctionCall(SolidityParser.FunctionCallContext ctx) { }
	
	@Override public void exitFunctionCall(SolidityParser.FunctionCallContext ctx) { }
	
	@Override public void enterIndexRangeAccess(SolidityParser.IndexRangeAccessContext ctx) { }
	
	@Override public void exitIndexRangeAccess(SolidityParser.IndexRangeAccessContext ctx) { }
	
	@Override public void enterIndexAccess(SolidityParser.IndexAccessContext ctx) { }
	
	@Override public void exitIndexAccess(SolidityParser.IndexAccessContext ctx) { }
	
	@Override public void enterAddSubOperation(SolidityParser.AddSubOperationContext ctx) { }
	
	@Override public void exitAddSubOperation(SolidityParser.AddSubOperationContext ctx) { }
	
	@Override public void enterBitOrOperation(SolidityParser.BitOrOperationContext ctx) { }
	
	@Override public void exitBitOrOperation(SolidityParser.BitOrOperationContext ctx) { }
	
	@Override public void enterExpOperation(SolidityParser.ExpOperationContext ctx) { }
	
	@Override public void exitExpOperation(SolidityParser.ExpOperationContext ctx) { }
	
	@Override public void enterAndOperation(SolidityParser.AndOperationContext ctx) { }
	
	@Override public void exitAndOperation(SolidityParser.AndOperationContext ctx) { }
	
	@Override public void enterInlineArray(SolidityParser.InlineArrayContext ctx) { }
	
	@Override public void exitInlineArray(SolidityParser.InlineArrayContext ctx) { }
	
	@Override public void enterOrOperation(SolidityParser.OrOperationContext ctx) { }
	
	@Override public void exitOrOperation(SolidityParser.OrOperationContext ctx) { }
	
	@Override public void enterMemberAccess(SolidityParser.MemberAccessContext ctx) { }
	
	@Override public void exitMemberAccess(SolidityParser.MemberAccessContext ctx) { }
	
	@Override public void enterMulDivModOperation(SolidityParser.MulDivModOperationContext ctx) { }
	
	@Override public void exitMulDivModOperation(SolidityParser.MulDivModOperationContext ctx) { }
	
	@Override public void enterFunctionCallOptions(SolidityParser.FunctionCallOptionsContext ctx) { }
	
	@Override public void exitFunctionCallOptions(SolidityParser.FunctionCallOptionsContext ctx) { }
	
	@Override public void enterNewExpr(SolidityParser.NewExprContext ctx) { }
	
	@Override public void exitNewExpr(SolidityParser.NewExprContext ctx) { }
	
	@Override public void enterBitXorOperation(SolidityParser.BitXorOperationContext ctx) { }
	
	@Override public void exitBitXorOperation(SolidityParser.BitXorOperationContext ctx) { }
	
	@Override public void enterTuple(SolidityParser.TupleContext ctx) { }
	
	@Override public void exitTuple(SolidityParser.TupleContext ctx) { }
	
	@Override public void enterEqualityComparison(SolidityParser.EqualityComparisonContext ctx) { }
	
	@Override public void exitEqualityComparison(SolidityParser.EqualityComparisonContext ctx) { }
	
	@Override public void enterMetaType(SolidityParser.MetaTypeContext ctx) { }
	
	@Override public void exitMetaType(SolidityParser.MetaTypeContext ctx) { }
	
	@Override public void enterAssignOp(SolidityParser.AssignOpContext ctx) { }
	
	@Override public void exitAssignOp(SolidityParser.AssignOpContext ctx) { }
	
	@Override public void enterTupleExpression(SolidityParser.TupleExpressionContext ctx) { }
	
	@Override public void exitTupleExpression(SolidityParser.TupleExpressionContext ctx) { }
	
	@Override public void enterInlineArrayExpression(SolidityParser.InlineArrayExpressionContext ctx) { }
	
	@Override public void exitInlineArrayExpression(SolidityParser.InlineArrayExpressionContext ctx) { }
	
	@Override public void enterIdentifier(SolidityParser.IdentifierContext ctx) { }
	
	@Override public void exitIdentifier(SolidityParser.IdentifierContext ctx) { }
	
	@Override public void enterLiteral(SolidityParser.LiteralContext ctx) { }
	
	@Override public void exitLiteral(SolidityParser.LiteralContext ctx) { }
	
	@Override public void enterLiteralWithSubDenomination(SolidityParser.LiteralWithSubDenominationContext ctx) { }
	
	@Override public void exitLiteralWithSubDenomination(SolidityParser.LiteralWithSubDenominationContext ctx) { }
	
	@Override public void enterBooleanLiteral(SolidityParser.BooleanLiteralContext ctx) { }
	
	@Override public void exitBooleanLiteral(SolidityParser.BooleanLiteralContext ctx) { }
	
	@Override public void enterStringLiteral(SolidityParser.StringLiteralContext ctx) { }
	
	@Override public void exitStringLiteral(SolidityParser.StringLiteralContext ctx) { }
	
	@Override public void enterHexStringLiteral(SolidityParser.HexStringLiteralContext ctx) { }
	
	@Override public void exitHexStringLiteral(SolidityParser.HexStringLiteralContext ctx) { }
	
	@Override public void enterUnicodeStringLiteral(SolidityParser.UnicodeStringLiteralContext ctx) { }
	
	@Override public void exitUnicodeStringLiteral(SolidityParser.UnicodeStringLiteralContext ctx) { }
	
	@Override public void enterNumberLiteral(SolidityParser.NumberLiteralContext ctx) { }
	
	@Override public void exitNumberLiteral(SolidityParser.NumberLiteralContext ctx) { }
	
	@Override public void enterBlock(SolidityParser.BlockContext ctx) { }
	
	@Override public void exitBlock(SolidityParser.BlockContext ctx) { }
	
	@Override public void enterUncheckedBlock(SolidityParser.UncheckedBlockContext ctx) { }
	
	@Override public void exitUncheckedBlock(SolidityParser.UncheckedBlockContext ctx) { }
	
	@Override public void enterStatement(SolidityParser.StatementContext ctx) { }
	
	@Override public void exitStatement(SolidityParser.StatementContext ctx) { }
	
	@Override public void enterSimpleStatement(SolidityParser.SimpleStatementContext ctx) { }
	
	@Override public void exitSimpleStatement(SolidityParser.SimpleStatementContext ctx) { }
	
	@Override public void enterIfStatement(SolidityParser.IfStatementContext ctx) { }
	
	@Override public void exitIfStatement(SolidityParser.IfStatementContext ctx) { }
	
	@Override public void enterForStatement(SolidityParser.ForStatementContext ctx) { }
	
	@Override public void exitForStatement(SolidityParser.ForStatementContext ctx) { }
	
	@Override public void enterWhileStatement(SolidityParser.WhileStatementContext ctx) { }
	
	@Override public void exitWhileStatement(SolidityParser.WhileStatementContext ctx) { }
	
	@Override public void enterDoWhileStatement(SolidityParser.DoWhileStatementContext ctx) { }
	
	@Override public void exitDoWhileStatement(SolidityParser.DoWhileStatementContext ctx) { }
	
	@Override public void enterContinueStatement(SolidityParser.ContinueStatementContext ctx) { }
	
	@Override public void exitContinueStatement(SolidityParser.ContinueStatementContext ctx) { }
	
	@Override public void enterBreakStatement(SolidityParser.BreakStatementContext ctx) { }
	
	@Override public void exitBreakStatement(SolidityParser.BreakStatementContext ctx) { }
	
	@Override public void enterTryStatement(SolidityParser.TryStatementContext ctx) { }
	
	@Override public void exitTryStatement(SolidityParser.TryStatementContext ctx) { }
	
	@Override public void enterCatchClause(SolidityParser.CatchClauseContext ctx) { }
	
	@Override public void exitCatchClause(SolidityParser.CatchClauseContext ctx) { }
	
	@Override public void enterReturnStatement(SolidityParser.ReturnStatementContext ctx) { }
	
	@Override public void exitReturnStatement(SolidityParser.ReturnStatementContext ctx) { }
	
	@Override public void enterEmitStatement(SolidityParser.EmitStatementContext ctx) { }
	
	@Override public void exitEmitStatement(SolidityParser.EmitStatementContext ctx) { }
	
	@Override public void enterRevertStatement(SolidityParser.RevertStatementContext ctx) { }
	
	@Override public void exitRevertStatement(SolidityParser.RevertStatementContext ctx) { }
	
	@Override public void enterAssemblyStatement(SolidityParser.AssemblyStatementContext ctx) { }
	
	@Override public void exitAssemblyStatement(SolidityParser.AssemblyStatementContext ctx) { }
	
	@Override public void enterAssemblyFlags(SolidityParser.AssemblyFlagsContext ctx) { }
	
	@Override public void exitAssemblyFlags(SolidityParser.AssemblyFlagsContext ctx) { }
	
	@Override public void enterVariableDeclarationList(SolidityParser.VariableDeclarationListContext ctx) { }
	
	@Override public void exitVariableDeclarationList(SolidityParser.VariableDeclarationListContext ctx) { }
	
	@Override public void enterVariableDeclarationTuple(SolidityParser.VariableDeclarationTupleContext ctx) { }
	
	@Override public void exitVariableDeclarationTuple(SolidityParser.VariableDeclarationTupleContext ctx) { }
	
	@Override public void enterVariableDeclarationStatement(SolidityParser.VariableDeclarationStatementContext ctx) { }
	
	@Override public void exitVariableDeclarationStatement(SolidityParser.VariableDeclarationStatementContext ctx) { }
	
	@Override public void enterExpressionStatement(SolidityParser.ExpressionStatementContext ctx) { }
	
	@Override public void exitExpressionStatement(SolidityParser.ExpressionStatementContext ctx) { }
	
	@Override public void enterMappingType(SolidityParser.MappingTypeContext ctx) { }
	
	@Override public void exitMappingType(SolidityParser.MappingTypeContext ctx) { }
	
	@Override public void enterMappingKeyType(SolidityParser.MappingKeyTypeContext ctx) { }
	
	@Override public void exitMappingKeyType(SolidityParser.MappingKeyTypeContext ctx) { }

	
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	
	@Override public void visitTerminal(TerminalNode node) { }
	
	@Override public void visitErrorNode(ErrorNode node) { }
}