package org.example;

import org.example.gen.SolidityParser;
import org.example.gen.SolidityParserBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class SolidityIRGenerator extends SolidityParserBaseVisitor<IRNode> {

    private final List<IRFunction> functions = new ArrayList<>();
    private final List<IRVariableDeclaration> variables = new ArrayList<>();
    private String pragmaVersion;
    private String contractName;


    public List<IRFunction> getFunctions() {
        return functions;
    }

    public List<IRVariableDeclaration> getVariables() {
        return variables;
    }

    public String getPragmaVersion() {
        return pragmaVersion;
    }

    public String getContractName() {
        return contractName;
    }

    @Override
    public IRNode visitSourceUnit(SolidityParser.SourceUnitContext ctx) {

        for (SolidityParser.PragmaDirectiveContext pragmaCtx : ctx.pragmaDirective()) {
            visit(pragmaCtx);
        }
        for (SolidityParser.ImportDirectiveContext importCtx : ctx.importDirective()) {
            visit(importCtx);
        }
        for (SolidityParser.ContractDefinitionContext contractCtx : ctx.contractDefinition()) {
            visit(contractCtx);
        }

        return null;
    }

    @Override
    public IRNode visitConstructorDefinition(SolidityParser.ConstructorDefinitionContext ctx) {
        var functionName = "constructor";
        var irFunction = new IRFunction(functionName, new ArrayList<>(), new ArrayList<>());
        functions.add(irFunction);

        for (var stmtCtx : ctx.block().statement()) {
            var irStmt = (IRStatement) visit(stmtCtx);
            if (irStmt != null) {
                irFunction.addStatement(irStmt);
            }
        }

        return irFunction;
    }


    @Override
    public IRNode visitContractDefinition(SolidityParser.ContractDefinitionContext ctx) {
        contractName = ctx.identifier().getText();
        for (SolidityParser.ContractBodyElementContext partCtx : ctx.contractBodyElement()) {
            visit(partCtx);
        }

        return null;
    }

    @Override
    public IRNode visitStateVariableDeclaration(SolidityParser.StateVariableDeclarationContext ctx) {
        String type = ctx.typeName().getText();
        String name = ctx.identifier().getText();
        String accessModifier = "default";

        if (ctx.Public() != null) {
            accessModifier = "public";
        } else if (ctx.Private() != null) {
            accessModifier = "private";
        } else if (ctx.Internal() != null) {
            accessModifier = "internal";
        } else if (ctx.Constant() != null) {
            accessModifier = "constant";
        }

        IRVariableDeclaration variable = new IRVariableDeclaration(type, name, accessModifier);
        variables.add(variable);
        return variable;
    }


    @Override
    public IRNode visitPragmaDirective(SolidityParser.PragmaDirectiveContext ctx) {
        pragmaVersion = ctx.getText();
        return visitChildren(ctx);
    }

    @Override
    public IRNode visitImportDirective(SolidityParser.ImportDirectiveContext ctx) {

        if (ctx.path() != null) {
            visit(ctx.path());
        }
        if (ctx.Import() != null) {
            visit(ctx.symbolAliases());
        }

        return null;
    }

    @Override
    public IRNode visitFunctionDefinition(SolidityParser.FunctionDefinitionContext ctx) {
        String functionName = ctx.identifier().getText();

        List<IRParameter> parameters = new ArrayList<>();
        if (ctx.parameterList() != null) {
            for (SolidityParser.ParameterListContext paramCtx : ctx.parameterList()) {
                String type = paramCtx.parameterDeclaration.type.getText();
                String name = paramCtx.parameterDeclaration.identifier() != null ? paramCtx.parameterDeclaration.identifier().getText() : "";
                parameters.add(new IRParameter(type, name));
            }
        }

        IRFunction irFunction = new IRFunction(functionName, parameters, new ArrayList<>());

        if (ctx.block() != null) {
            for (SolidityParser.StatementContext stmtCtx : ctx.block().statement()) {
                IRStatement irStmt = (IRStatement) visit(stmtCtx);
                if (irStmt != null) {
                    irFunction.addStatement(irStmt);
                }
            }
        }

        functions.add(irFunction);
        return irFunction;
    }


    @Override
    public IRNode visitExpressionStatement(SolidityParser.ExpressionStatementContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public IRNode visitReturnStatement(SolidityParser.ReturnStatementContext ctx) {
        SolidityParser.ExpressionContext expression = ctx.expression();
        IRNode value = visit(expression);
        return new IRReturn(value);
    }

    @Override
    public IRNode visitVariableDeclaration(SolidityParser.VariableDeclarationContext ctx) {
        String type = ctx.typeName().getText();
        String name = ctx.identifier().getText();
        return new IRVariableDeclaration(type, name);
    }

    @Override
    public IRNode visitFunctionCall(SolidityParser.FunctionCallContext ctx) {
        String functionName = ctx.getText();
        List<IRNode> arguments = new ArrayList<>();
        if (ctx.callArgumentList() != null) {
            for (SolidityParser.ExpressionContext argCtx : ctx.callArgumentList().expression()) {
                arguments.add((IRNode) visit(argCtx));
            }
        }
        return new IRFunctionCall(functionName, arguments);
    }

    @Override
    public IRNode visitAssignment(SolidityParser.AssignmentContext ctx) {
        String variable = ctx.expression().getFirst().getText();
        String value = ctx.expression().getLast().getText();
        return new IRAssignment(variable, value);
    }

    @Override
    public IRNode visitPrimaryExpression(SolidityParser.PrimaryExpressionContext ctx) {
        if (ctx.getChildCount() == 1) {
            ParseTree child = ctx.getChild(0);
            if (child instanceof SolidityParser.IdentifierContext) {
                return new IRVariable(child.getText());
            } else if (child instanceof SolidityParser.LiteralContext) {
                return new IRLiteral(child.getText());
            }
        }
        return new IRExpressionStatement(new IRLiteral(ctx.getText()));
    }
}
