package org.example;

public class IRAssignment extends IRStatement {
    private String variable;
    private IRNode value;

    public IRAssignment(String variable, IRNode value) {
        this.variable = variable;
        this.value = value;
    }

    public String getVariable() {
        return variable;
    }

    public IRNode getValue() {
        return value;
    }

    @Override
    public String toString() {
        return variable + " = " + value.toString();
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
