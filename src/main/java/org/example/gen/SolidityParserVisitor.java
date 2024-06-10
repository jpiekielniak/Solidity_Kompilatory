package org.example.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;


public interface SolidityParserVisitor<T> extends ParseTreeVisitor<T> {
	
	T visitSourceUnit(SolidityParser.SourceUnitContext ctx);
	
	T visitPragmaDirective(SolidityParser.PragmaDirectiveContext ctx);
	
	T visitImportDirective(SolidityParser.ImportDirectiveContext ctx);
	
	T visitImportAliases(SolidityParser.ImportAliasesContext ctx);
	
	T visitPath(SolidityParser.PathContext ctx);
	
	T visitSymbolAliases(SolidityParser.SymbolAliasesContext ctx);
	
	T visitContractDefinition(SolidityParser.ContractDefinitionContext ctx);
	
	T visitInterfaceDefinition(SolidityParser.InterfaceDefinitionContext ctx);
	
	T visitLibraryDefinition(SolidityParser.LibraryDefinitionContext ctx);
	
	T visitInheritanceSpecifierList(SolidityParser.InheritanceSpecifierListContext ctx);
	
	T visitInheritanceSpecifier(SolidityParser.InheritanceSpecifierContext ctx);
	
	T visitContractBodyElement(SolidityParser.ContractBodyElementContext ctx);
	
	T visitNamedArgument(SolidityParser.NamedArgumentContext ctx);
	
	T visitCallArgumentList(SolidityParser.CallArgumentListContext ctx);
	
	T visitIdentifierPath(SolidityParser.IdentifierPathContext ctx);
	
	T visitModifierInvocation(SolidityParser.ModifierInvocationContext ctx);
	
	T visitVisibility(SolidityParser.VisibilityContext ctx);
	
	T visitParameterList(SolidityParser.ParameterListContext ctx);
	
	T visitParameterDeclaration(SolidityParser.ParameterDeclarationContext ctx);
	
	T visitConstructorDefinition(SolidityParser.ConstructorDefinitionContext ctx);
	
	T visitStateMutability(SolidityParser.StateMutabilityContext ctx);
	
	T visitOverrideSpecifier(SolidityParser.OverrideSpecifierContext ctx);
	
	T visitFunctionDefinition(SolidityParser.FunctionDefinitionContext ctx);
	
	T visitModifierDefinition(SolidityParser.ModifierDefinitionContext ctx);
	
	T visitFallbackFunctionDefinition(SolidityParser.FallbackFunctionDefinitionContext ctx);
	
	T visitReceiveFunctionDefinition(SolidityParser.ReceiveFunctionDefinitionContext ctx);
	
	T visitStructDefinition(SolidityParser.StructDefinitionContext ctx);
	
	T visitStructMember(SolidityParser.StructMemberContext ctx);
	
	T visitEnumDefinition(SolidityParser.EnumDefinitionContext ctx);
	
	T visitUserDefinedValueTypeDefinition(SolidityParser.UserDefinedValueTypeDefinitionContext ctx);
	
	T visitStateVariableDeclaration(SolidityParser.StateVariableDeclarationContext ctx);
	
	T visitConstantVariableDeclaration(SolidityParser.ConstantVariableDeclarationContext ctx);
	
	T visitEventParameter(SolidityParser.EventParameterContext ctx);
	
// Generated from /Users/Jakub/Desktop/SolidityCompiler/src/main/java/org/example/grammar/SolidityParser.g4 by ANTLR 4.13.1
	T visitEventDefinition(SolidityParser.EventDefinitionContext ctx);
	
	T visitErrorParameter(SolidityParser.ErrorParameterContext ctx);
	
	T visitErrorDefinition(SolidityParser.ErrorDefinitionContext ctx);
	
	T visitUserDefinableOperator(SolidityParser.UserDefinableOperatorContext ctx);
	
	T visitUsingDirective(SolidityParser.UsingDirectiveContext ctx);
	
	T visitUsingAliases(SolidityParser.UsingAliasesContext ctx);
	
	T visitTypeName(SolidityParser.TypeNameContext ctx);
	
	T visitElementaryTypeName(SolidityParser.ElementaryTypeNameContext ctx);
	
	T visitFunctionTypeName(SolidityParser.FunctionTypeNameContext ctx);
	
	T visitVariableDeclaration(SolidityParser.VariableDeclarationContext ctx);
	
	T visitDataLocation(SolidityParser.DataLocationContext ctx);
	
	T visitUnaryPrefixOperation(SolidityParser.UnaryPrefixOperationContext ctx);
	
	T visitPrimaryExpression(SolidityParser.PrimaryExpressionContext ctx);
	
	T visitOrderComparison(SolidityParser.OrderComparisonContext ctx);
	
	T visitConditional(SolidityParser.ConditionalContext ctx);
	
	T visitPayableConversion(SolidityParser.PayableConversionContext ctx);
	
	T visitAssignment(SolidityParser.AssignmentContext ctx);
	
	T visitUnarySuffixOperation(SolidityParser.UnarySuffixOperationContext ctx);
	
	T visitShiftOperation(SolidityParser.ShiftOperationContext ctx);
	
	T visitBitAndOperation(SolidityParser.BitAndOperationContext ctx);
	
	T visitFunctionCall(SolidityParser.FunctionCallContext ctx);
	
	T visitIndexRangeAccess(SolidityParser.IndexRangeAccessContext ctx);
	
	T visitIndexAccess(SolidityParser.IndexAccessContext ctx);
	
	T visitAddSubOperation(SolidityParser.AddSubOperationContext ctx);
	
	T visitBitOrOperation(SolidityParser.BitOrOperationContext ctx);
	
	T visitExpOperation(SolidityParser.ExpOperationContext ctx);
	
	T visitAndOperation(SolidityParser.AndOperationContext ctx);
	
	T visitInlineArray(SolidityParser.InlineArrayContext ctx);
	
	T visitOrOperation(SolidityParser.OrOperationContext ctx);
	
	T visitMemberAccess(SolidityParser.MemberAccessContext ctx);
	
	T visitMulDivModOperation(SolidityParser.MulDivModOperationContext ctx);
	
	T visitFunctionCallOptions(SolidityParser.FunctionCallOptionsContext ctx);
	
	T visitNewExpr(SolidityParser.NewExprContext ctx);
	
	T visitBitXorOperation(SolidityParser.BitXorOperationContext ctx);
	
	T visitTuple(SolidityParser.TupleContext ctx);
	
	T visitEqualityComparison(SolidityParser.EqualityComparisonContext ctx);
	
	T visitMetaType(SolidityParser.MetaTypeContext ctx);
	
	T visitAssignOp(SolidityParser.AssignOpContext ctx);
	
	T visitTupleExpression(SolidityParser.TupleExpressionContext ctx);
	
	T visitInlineArrayExpression(SolidityParser.InlineArrayExpressionContext ctx);
	
	T visitIdentifier(SolidityParser.IdentifierContext ctx);
	
	T visitLiteral(SolidityParser.LiteralContext ctx);
	
	T visitLiteralWithSubDenomination(SolidityParser.LiteralWithSubDenominationContext ctx);
	
	T visitBooleanLiteral(SolidityParser.BooleanLiteralContext ctx);
	
	T visitStringLiteral(SolidityParser.StringLiteralContext ctx);
	
	T visitHexStringLiteral(SolidityParser.HexStringLiteralContext ctx);
	
	T visitUnicodeStringLiteral(SolidityParser.UnicodeStringLiteralContext ctx);
	
	T visitNumberLiteral(SolidityParser.NumberLiteralContext ctx);
	
	T visitBlock(SolidityParser.BlockContext ctx);
	
	T visitUncheckedBlock(SolidityParser.UncheckedBlockContext ctx);
	
	T visitStatement(SolidityParser.StatementContext ctx);
	
	T visitSimpleStatement(SolidityParser.SimpleStatementContext ctx);
	
	T visitIfStatement(SolidityParser.IfStatementContext ctx);
	
	T visitForStatement(SolidityParser.ForStatementContext ctx);
	
	T visitWhileStatement(SolidityParser.WhileStatementContext ctx);
	
	T visitDoWhileStatement(SolidityParser.DoWhileStatementContext ctx);
	
	T visitContinueStatement(SolidityParser.ContinueStatementContext ctx);
	
	T visitBreakStatement(SolidityParser.BreakStatementContext ctx);
	
	T visitTryStatement(SolidityParser.TryStatementContext ctx);
	
	T visitCatchClause(SolidityParser.CatchClauseContext ctx);
	
	T visitReturnStatement(SolidityParser.ReturnStatementContext ctx);
	
	T visitEmitStatement(SolidityParser.EmitStatementContext ctx);
	
	T visitRevertStatement(SolidityParser.RevertStatementContext ctx);
	
	T visitAssemblyStatement(SolidityParser.AssemblyStatementContext ctx);
	
	T visitAssemblyFlags(SolidityParser.AssemblyFlagsContext ctx);
	
	T visitVariableDeclarationList(SolidityParser.VariableDeclarationListContext ctx);
	
	T visitVariableDeclarationTuple(SolidityParser.VariableDeclarationTupleContext ctx);
	
	T visitVariableDeclarationStatement(SolidityParser.VariableDeclarationStatementContext ctx);
	
	T visitExpressionStatement(SolidityParser.ExpressionStatementContext ctx);
	
	T visitMappingType(SolidityParser.MappingTypeContext ctx);
	
	T visitMappingKeyType(SolidityParser.MappingKeyTypeContext ctx);
}