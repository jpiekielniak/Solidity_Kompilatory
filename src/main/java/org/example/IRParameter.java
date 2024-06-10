package org.example;

public class IRParameter extends IRNode {
    private String type;
    private String name;

    public IRParameter(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}