package org.example;

public class IRReturn extends IRStatement {
    private IRNode value;

    public IRReturn(IRNode value) {
        this.value = value;
    }

    public IRNode getValue() {
        return value;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}

