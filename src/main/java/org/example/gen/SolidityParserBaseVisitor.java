package org.example.gen;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("CheckReturnValue")
public class SolidityParserBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements SolidityParserVisitor<T> {

    private static StringBuilder visitorInfo = new StringBuilder();
    private static List<String> bytecode = new ArrayList<>();

    public List<String> getBytecode() {
        return bytecode;
    }

    public static StringBuilder visitorInfo() {
        return visitorInfo;
    }

    @Override
    public T visitSourceUnit(SolidityParser.SourceUnitContext ctx) {
        visitorInfo().append("sourceUnit: ").append(ctx.getText()).append("\n");

        // Przykładowa operacja przetwarzania kodu źródłowego
        bytecode.add("BEGIN SOURCE UNIT");

        // Przetwórz dzieci węzła (inne deklaracje w pliku Solidity)
        visitChildren(ctx);

        bytecode.add("END SOURCE UNIT");
        return null;
    }

    @Override
    public T visitPragmaDirective(SolidityParser.PragmaDirectiveContext ctx) {
        visitorInfo().append("pragmaDirective: ").append(ctx.getText()).append("\n");

        // Można tutaj dodać logikę do obsługi dyrektyw pragma, jeśli jest taka potrzeba
        bytecode.add("PRAGMA " + ctx.getText());

        return visitChildren(ctx);
    }

    @Override
    public T visitImportDirective(SolidityParser.ImportDirectiveContext ctx) {
        visitorInfo().append("importDirective: ").append(ctx.getText()).append("\n");

        if (ctx.path() != null) {
            visit(ctx.path());
        }
        if (ctx.Import() != null) {
            visit(ctx.symbolAliases());
        }

        bytecode.add("IMPORT " + ctx.getText());

        return null;
    }

    @Override
    public T visitImportAliases(SolidityParser.ImportAliasesContext ctx) {
        visitorInfo().append("importAliases: ").append(ctx.getText()).append("\n");


        bytecode.add("IMPORT ALIASES " + ctx.getText());

        return null;
    }

    @Override
    public T visitPath(SolidityParser.PathContext ctx) {
        visitorInfo.append("path: ").append(ctx.getText()).append("\n");

        bytecode.add("IMPORT PATH " + ctx.getText());

        return visitChildren(ctx);
    }

    @Override
    public T visitSymbolAliases(SolidityParser.SymbolAliasesContext ctx) {
        visitorInfo.append("symbolAliases: ").append(ctx.getText()).append("\n");

        bytecode.add("SYMBOL ALIAS " + ctx.getText());

        return visitChildren(ctx);
    }

    @Override
    public T visitContractDefinition(SolidityParser.ContractDefinitionContext ctx) {
        visitorInfo.append("contractDefinition: ").append(ctx.getText()).append("\n");

        bytecode.add("CONTRACT DEFINITION " + ctx.getText());

        return visitChildren(ctx);
    }

    @Override
    public T visitInterfaceDefinition(SolidityParser.InterfaceDefinitionContext ctx) {
        visitorInfo.append("interfaceDefinition: ").append(ctx.getText()).append("\n");

        bytecode.add("INTERFACE DEFINITION " + ctx.getText());

        return visitChildren(ctx);
    }

    @Override
    public T visitLibraryDefinition(SolidityParser.LibraryDefinitionContext ctx) {
        visitorInfo.append("libraryDefinition: ").append(ctx.getText()).append("\n");

        bytecode.add("LIBRARY DEFINITION " + ctx.getText());

        return visitChildren(ctx);
    }

    @Override
    public T visitInheritanceSpecifierList(SolidityParser.InheritanceSpecifierListContext ctx) {
        visitorInfo.append("inheritanceSpecifierList: ").append(ctx.getText()).append("\n");

        // Generate intermediate code for inheritance specifier list
        bytecode.add("INHERITANCE SPECIFIER LIST " + ctx.getText());

        return visitChildren(ctx);
    }

    @Override
    public T visitInheritanceSpecifier(SolidityParser.InheritanceSpecifierContext ctx) {
        visitorInfo.append("inheritanceSpecifier: ").append(ctx.getText()).append("\n");

        // Generate intermediate code for a single inheritance specifier
        bytecode.add("INHERITANCE SPECIFIER " + ctx.getText());

        return visitChildren(ctx);
    }

    @Override
    public T visitContractBodyElement(SolidityParser.ContractBodyElementContext ctx) {
        visitorInfo.append("contractBodyElement: ").append(ctx.getText()).append("\n");

        // Generate intermediate code for contract body element
        bytecode.add("CONTRACT BODY ELEMENT " + ctx.getText());

        return visitChildren(ctx);
    }

    @Override
    public T visitNamedArgument(SolidityParser.NamedArgumentContext ctx) {
        visitorInfo.append("namedArgument: ").append(ctx.getText()).append("\n");

        bytecode.add("NAMED ARGUMENT " + ctx.getText());

        return visitChildren(ctx);
    }

    @Override
    public T visitCallArgumentList(SolidityParser.CallArgumentListContext ctx) {
        visitorInfo.append("callArgumentList: ").append(ctx.getText()).append("\n");
        bytecode.add("CALL ARGUMENT LIST " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public T visitIdentifierPath(SolidityParser.IdentifierPathContext ctx) {
        visitorInfo.append("identifierPath: ").append(ctx.getText()).append("\n");
        bytecode.add("IDENTIFIER PATH " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public T visitModifierInvocation(SolidityParser.ModifierInvocationContext ctx) {
        visitorInfo.append("modifierInvocation: ").append(ctx.getText()).append("\n");
        bytecode.add("MODIFIER INVOCATION " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public T visitVisibility(SolidityParser.VisibilityContext ctx) {
        visitorInfo.append("visibility: ").append(ctx.getText()).append("\n");
        bytecode.add("VISIBILITY " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public T visitParameterList(SolidityParser.ParameterListContext ctx) {
        visitorInfo.append("parameterList: ").append(ctx.getText()).append("\n");
        bytecode.add("PARAMETER LIST " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public T visitParameterDeclaration(SolidityParser.ParameterDeclarationContext ctx) {
        visitorInfo.append("parameterDeclaration: ").append(ctx.getText()).append("\n");
        bytecode.add("PARAMETER DECLARATION " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public T visitConstructorDefinition(SolidityParser.ConstructorDefinitionContext ctx) {
        visitorInfo.append("constructorDefinition: ").append(ctx.getText()).append("\n");
        bytecode.add("CONSTRUCTOR DEFINITION " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public T visitStateMutability(SolidityParser.StateMutabilityContext ctx) {
        visitorInfo.append("stateMutability: ").append(ctx.getText()).append("\n");
        bytecode.add("STATE MUTABILITY " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public T visitOverrideSpecifier(SolidityParser.OverrideSpecifierContext ctx) {
        visitorInfo.append("overrideSpecifier: ").append(ctx.getText()).append("\n");
        bytecode.add("OVERRIDE SPECIFIER " + ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public T visitFunctionDefinition(SolidityParser.FunctionDefinitionContext ctx) {
        visitorInfo.append("functionDefinition: ").append(ctx.identifier().getText()).append("\n");
        bytecode.add("BEGIN FUNCTION " + ctx.identifier().getText());

        if (ctx.parameterList() != null) {
            for (int i = 0 ; i < ctx.parameterList().toArray().length; i++)
            {
                visit(ctx.parameterList(i));
            }
        }

        if (ctx.block() != null) {
            visit(ctx.block());
        }

        bytecode.add("END FUNCTION");
        return null;
    }

    @Override
    public T visitModifierDefinition(SolidityParser.ModifierDefinitionContext ctx) {
        visitorInfo.append("modifierDefinition: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitFallbackFunctionDefinition(SolidityParser.FallbackFunctionDefinitionContext ctx) {
        visitorInfo.append("fallbackFunctionDefinition: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitReceiveFunctionDefinition(SolidityParser.ReceiveFunctionDefinitionContext ctx) {
        visitorInfo.append("receiveFunctionDefinition: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitStructDefinition(SolidityParser.StructDefinitionContext ctx) {
        visitorInfo.append("structDefinition: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitStructMember(SolidityParser.StructMemberContext ctx) {
        visitorInfo.append("structMember: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitEnumDefinition(SolidityParser.EnumDefinitionContext ctx) {
        visitorInfo.append("enumDefinition: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitUserDefinedValueTypeDefinition(SolidityParser.UserDefinedValueTypeDefinitionContext ctx) {
        visitorInfo.append("userDefinedValueTypeDefinition: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitStateVariableDeclaration(SolidityParser.StateVariableDeclarationContext ctx) {
        visitorInfo.append("stateVariableDeclaration: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitConstantVariableDeclaration(SolidityParser.ConstantVariableDeclarationContext ctx) {
        visitorInfo.append("constantVariableDeclaration: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitEventParameter(SolidityParser.EventParameterContext ctx) {
        visitorInfo.append("eventParameter: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitEventDefinition(SolidityParser.EventDefinitionContext ctx) {
        visitorInfo.append("eventDefinition: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitErrorParameter(SolidityParser.ErrorParameterContext ctx) {
        visitorInfo.append("errorParameter: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitErrorDefinition(SolidityParser.ErrorDefinitionContext ctx) {
        visitorInfo.append("errorDefinition: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitUserDefinableOperator(SolidityParser.UserDefinableOperatorContext ctx) {
        visitorInfo.append("userDefinableOperator: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitUsingDirective(SolidityParser.UsingDirectiveContext ctx) {
        visitorInfo.append("usingDirective: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitUsingAliases(SolidityParser.UsingAliasesContext ctx) {
        visitorInfo.append("usingAliases: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitTypeName(SolidityParser.TypeNameContext ctx) {
        visitorInfo.append("typeName: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitElementaryTypeName(SolidityParser.ElementaryTypeNameContext ctx) {
        visitorInfo.append("elementaryTypeName: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitFunctionTypeName(SolidityParser.FunctionTypeNameContext ctx) {
        visitorInfo.append("functionTypeName: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitVariableDeclaration(SolidityParser.VariableDeclarationContext ctx) {
        visitorInfo.append("variableDeclaration: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitDataLocation(SolidityParser.DataLocationContext ctx) {
        visitorInfo.append("dataLocation: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitUnaryPrefixOperation(SolidityParser.UnaryPrefixOperationContext ctx) {
        visitorInfo.append("unaryPrefixOperation: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitPrimaryExpression(SolidityParser.PrimaryExpressionContext ctx) {
        visitorInfo.append("primaryExpression: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitOrderComparison(SolidityParser.OrderComparisonContext ctx) {
        visitorInfo.append("orderComparison: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitConditional(SolidityParser.ConditionalContext ctx) {
        visitorInfo.append("conditional: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitPayableConversion(SolidityParser.PayableConversionContext ctx) {
        visitorInfo.append("payableConversion: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitAssignment(SolidityParser.AssignmentContext ctx) {
        visitorInfo.append("assignment: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitUnarySuffixOperation(SolidityParser.UnarySuffixOperationContext ctx) {
        visitorInfo.append("unarySuffixOperation: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitShiftOperation(SolidityParser.ShiftOperationContext ctx) {
        visitorInfo.append("shiftOperation: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitBitAndOperation(SolidityParser.BitAndOperationContext ctx) {
        visitorInfo.append("bitAndOperation: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitFunctionCall(SolidityParser.FunctionCallContext ctx) {
        visitorInfo.append("functionCall: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitIndexRangeAccess(SolidityParser.IndexRangeAccessContext ctx) {
        visitorInfo.append("indexRangeAccess: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitIndexAccess(SolidityParser.IndexAccessContext ctx) {
        visitorInfo.append("indexAccess: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitAddSubOperation(SolidityParser.AddSubOperationContext ctx) {
        visitorInfo.append("addSubOperation: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitBitOrOperation(SolidityParser.BitOrOperationContext ctx) {
        visitorInfo.append("bitOrOperation: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitExpOperation(SolidityParser.ExpOperationContext ctx) {
        visitorInfo.append("expOperation: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitAndOperation(SolidityParser.AndOperationContext ctx) {
        visitorInfo.append("andOperation: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitInlineArray(SolidityParser.InlineArrayContext ctx) {
        visitorInfo.append("inlineArray: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitOrOperation(SolidityParser.OrOperationContext ctx) {
        visitorInfo.append("orOperation: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitMemberAccess(SolidityParser.MemberAccessContext ctx) {
        visitorInfo.append("memberAccess: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitMulDivModOperation(SolidityParser.MulDivModOperationContext ctx) {
        visitorInfo.append("mulDivModOperation: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitFunctionCallOptions(SolidityParser.FunctionCallOptionsContext ctx) {
        visitorInfo.append("functionCallOptions: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitNewExpr(SolidityParser.NewExprContext ctx) {
        visitorInfo.append("newExpr: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitBitXorOperation(SolidityParser.BitXorOperationContext ctx) {
        visitorInfo.append("bitXorOperation: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitTuple(SolidityParser.TupleContext ctx) {
        visitorInfo.append("tuple: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitEqualityComparison(SolidityParser.EqualityComparisonContext ctx) {
        visitorInfo.append("equalityComparison: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitMetaType(SolidityParser.MetaTypeContext ctx) {
        visitorInfo.append("metaType: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitAssignOp(SolidityParser.AssignOpContext ctx) {
        visitorInfo.append("assignOp: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitTupleExpression(SolidityParser.TupleExpressionContext ctx) {
        visitorInfo.append("tupleExpression: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitInlineArrayExpression(SolidityParser.InlineArrayExpressionContext ctx) {
        visitorInfo.append("inlineArrayExpression: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitIdentifier(SolidityParser.IdentifierContext ctx) {
        visitorInfo.append("identifier: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitLiteral(SolidityParser.LiteralContext ctx) {
        visitorInfo.append("literal: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitLiteralWithSubDenomination(SolidityParser.LiteralWithSubDenominationContext ctx) {
        visitorInfo.append("literalWithSubDenomination: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitBooleanLiteral(SolidityParser.BooleanLiteralContext ctx) {
        visitorInfo.append("booleanLiteral: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitStringLiteral(SolidityParser.StringLiteralContext ctx) {
        visitorInfo.append("stringLiteral: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitHexStringLiteral(SolidityParser.HexStringLiteralContext ctx) {
        visitorInfo.append("hexStringLiteral: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitUnicodeStringLiteral(SolidityParser.UnicodeStringLiteralContext ctx) {
        visitorInfo.append("unicodeStringLiteral: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitNumberLiteral(SolidityParser.NumberLiteralContext ctx) {
        visitorInfo.append("numberLiteral: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitBlock(SolidityParser.BlockContext ctx) {
        visitorInfo.append("block: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitUncheckedBlock(SolidityParser.UncheckedBlockContext ctx) {
        visitorInfo.append("uncheckedBlock: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitStatement(SolidityParser.StatementContext ctx) {
        visitorInfo.append("statement: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitSimpleStatement(SolidityParser.SimpleStatementContext ctx) {
        visitorInfo.append("simpleStatement: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitIfStatement(SolidityParser.IfStatementContext ctx) {
        visitorInfo.append("ifStatement: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitForStatement(SolidityParser.ForStatementContext ctx) {
        visitorInfo.append("forStatement: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitWhileStatement(SolidityParser.WhileStatementContext ctx) {
        visitorInfo.append("whileStatement: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitDoWhileStatement(SolidityParser.DoWhileStatementContext ctx) {
        visitorInfo.append("doWhileStatement: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitContinueStatement(SolidityParser.ContinueStatementContext ctx) {
        visitorInfo.append("continueStatement: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitBreakStatement(SolidityParser.BreakStatementContext ctx) {
        visitorInfo.append("breakStatement: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitTryStatement(SolidityParser.TryStatementContext ctx) {
        visitorInfo.append("tryStatement: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitCatchClause(SolidityParser.CatchClauseContext ctx) {
        visitorInfo.append("catchClause: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitReturnStatement(SolidityParser.ReturnStatementContext ctx) {
        visitorInfo.append("returnStatement: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitEmitStatement(SolidityParser.EmitStatementContext ctx) {
        visitorInfo.append("emitStatement: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitRevertStatement(SolidityParser.RevertStatementContext ctx) {
        visitorInfo.append("revertStatement: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitAssemblyStatement(SolidityParser.AssemblyStatementContext ctx) {
        visitorInfo.append("assemblyStatement: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitAssemblyFlags(SolidityParser.AssemblyFlagsContext ctx) {
        visitorInfo.append("assemblyFlags: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitVariableDeclarationList(SolidityParser.VariableDeclarationListContext ctx) {
        visitorInfo.append("variableDeclarationList: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitVariableDeclarationTuple(SolidityParser.VariableDeclarationTupleContext ctx) {
        visitorInfo.append("variableDeclarationTuple: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitVariableDeclarationStatement(SolidityParser.VariableDeclarationStatementContext ctx) {
        visitorInfo.append("variableDeclarationStatement: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitExpressionStatement(SolidityParser.ExpressionStatementContext ctx) {
        visitorInfo.append("expressionStatement: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitMappingType(SolidityParser.MappingTypeContext ctx) {
        visitorInfo.append("mappingType: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }

    @Override
    public T visitMappingKeyType(SolidityParser.MappingKeyTypeContext ctx) {
        visitorInfo.append("mappingKeyType: ").append(ctx.getText()).append("\n");
        return visitChildren(ctx);
    }
}