package org.example;

public class IRVariable extends IRNode {
    private String name;

    public IRVariable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}

