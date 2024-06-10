package org.example;

public class IRAssignment extends IRStatement {
    private String variable;
    private String value;

    public IRAssignment(String variable, String value) {
        this.variable = variable;
        this.value = value;
    }

    public String getVariable() {
        return variable;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return variable + " = " + value;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
