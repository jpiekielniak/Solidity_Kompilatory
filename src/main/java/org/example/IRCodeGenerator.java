package org.example;

import java.util.List;

public class IRCodeGenerator implements IRVisitor {
    private final StringBuilder bytecode = new StringBuilder();

    public String getBytecode() {
        return bytecode.toString();
    }

    public void setPragmaVersion(String pragmaVersion) {
        bytecode.append("Pragma Version: ").append(pragmaVersion).append("\n");
    }

    public void setContractName(String contractName) {
        bytecode.append("Contract: ").append(contractName).append("\n");
    }

    @Override
    public void visit(IRFunction function) {
        bytecode.append("Function: ").append(function.getName()).append("(");
        List<IRParameter> parameters = function.getParameters();
        for (int i = 0; i < parameters.size(); i++) {
            IRParameter parameter = parameters.get(i);
            bytecode.append(parameter.toString());
            if (i < parameters.size() - 1) {
                bytecode.append(", ");
            }
        }
        bytecode.append(")\n");
        for (IRStatement statement : function.getStatements()) {
            if (statement != null) {
                statement.accept(this);
            }
        }
    }

    @Override
    public void visit(IRExpressionStatement expressionStatement) {
        IRNode expression = expressionStatement.getExpression();
        bytecode.append("  Expression: ").append(expression.toString()).append("\n");
    }

    @Override
    public void visit(IRVariable variable) {
        bytecode.append(variable.getName());
    }

    @Override
    public void visit(IRLiteral literal) {
        bytecode.append(literal.getValue());
    }

    @Override
    public void visit(IRVariableDeclaration variableDeclaration) {
        bytecode.append("  Declare: ").append(variableDeclaration.getAccessModifier()).append(" ")
                .append(variableDeclaration.getType()).append(" ").append(variableDeclaration.getName()).append("\n");
    }

    @Override
    public void visit(IRAssignment assignment) {
        bytecode.append("  Assign: ").append(assignment.getVariable())
                .append(" = ").append(assignment.getValue()).append("\n");
    }

    @Override
    public void visit(IRReturn returnStatement) {
        bytecode.append("  Return: ");
        if (returnStatement.getValue() != null) {
            returnStatement.getValue().accept(this);
        }
        bytecode.append("\n");
    }

    @Override
    public void visit(IRFunctionCall functionCall) {
        bytecode.append("  Function Call: ").append(functionCall.getFunctionName()).append(" with arguments: ");
        for (IRNode arg : functionCall.getArguments()) {
            bytecode.append(arg.toString()).append(", ");
        }
        bytecode.append("\n");
    }

    @Override
    public void visit(IRSourceUnit sourceUnit) {
        setPragmaVersion(sourceUnit.getPragmaVersion());
        for (IRContract contract : sourceUnit.getContracts()) {
            contract.accept(this);
        }
    }

    @Override
    public void visit(IRContract contract) {
        bytecode.append("Contract: ").append(contract.getName()).append("\n");
        for (IRVariableDeclaration declaration : contract.getVariableDeclarations()) {
            declaration.accept(this);
        }
        for (IRFunction function : contract.getFunctions()) {
            function.accept(this);
        }
    }

    @Override
    public void visit(IRConstructor constructor) {
        bytecode.append("Constructor:\n");
        for (IRStatement statement : constructor.getStatements()) {
            statement.accept(this);
        }
        for (IRParameter parameter : constructor.getParameters()) {
            parameter.accept(this);
        }
    }

    @Override
    public void visit(IRParameter parameter) {
        bytecode.append(parameter.getType()).append(" ").append(parameter.getName());
    }

    @Override
    public void visit(IRInstruction instruction) {
        bytecode.append("  Instruction: ").append(instruction.getType()).append(" ").append(instruction.getOperands()).append("\n");
    }

    @Override
    public void visit(IRFunctionDefinition functionDefinition) {
        bytecode.append("Function: ").append(functionDefinition.getName()).append(" (");

        for (IRParameter parameter : functionDefinition.getParameters()) {
            parameter.accept(this);
            bytecode.append(", ");
        }

        if (!functionDefinition.getParameters().isEmpty()) {
            bytecode.setLength(bytecode.length() - 2);
        }
        bytecode.append(")\n");

        for (IRStatement statement : functionDefinition.getBody()) {
            statement.accept(this);
        }
    }
}