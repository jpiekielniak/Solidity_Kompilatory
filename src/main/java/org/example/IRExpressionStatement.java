package org.example;


public class IRExpressionStatement extends IRStatement {
    private IRNode expression;

    public IRExpressionStatement(IRNode expression) {
        this.expression = expression;
    }

    public IRNode getExpression() {
        return expression;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}