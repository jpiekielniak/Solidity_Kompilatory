package org.example;

public class IRLiteral extends IRNode {
    private String value;

    public IRLiteral(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}

