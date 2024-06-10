package org.example;

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
        bytecode.append("Function: ").append(function.getName()).append("\n");
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
}
