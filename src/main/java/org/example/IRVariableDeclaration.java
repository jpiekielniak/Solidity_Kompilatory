package org.example;

public class IRVariableDeclaration extends IRStatement {
    private String type;
    private String name;
    private String accessModifier;

    public IRVariableDeclaration(String type, String name, String accessModifier) {
        this.type = type;
        this.name = name;
        this.accessModifier = accessModifier;
    }

    public IRVariableDeclaration(String type, String name) {
        this.type = type;
        this.name = name;
        this.accessModifier = "default";
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getAccessModifier() {
        return accessModifier;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
