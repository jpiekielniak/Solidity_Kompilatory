package org.example;

import java.util.List;

public class IRContract extends IRNode {
    private final String name;
    private final List<IRVariableDeclaration> variableDeclarations;
    private final IRConstructor constructor;
    private final List<IRFunction> functions;

    public IRContract(String name, List<IRVariableDeclaration> variableDeclarations, IRConstructor constructor, List<IRFunction> functions) {
        this.name = name;
        this.variableDeclarations = variableDeclarations;
        this.constructor = constructor;
        this.functions = functions;
    }

    public String getName() {
        return name;
    }

    public List<IRVariableDeclaration> getVariableDeclarations() {
        return variableDeclarations;
    }

    public IRConstructor getConstructor() {
        return constructor;
    }

    public List<IRFunction> getFunctions() {
        return functions;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
