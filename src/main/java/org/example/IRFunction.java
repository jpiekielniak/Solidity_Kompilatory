package org.example;

import java.util.ArrayList;
import java.util.List;

public class IRFunction extends IRNode {
    private String name;
    private List<IRStatement> statements;

    public IRFunction(String name) {
        this.name = name;
        this.statements = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<IRStatement> getStatements() {
        return statements;
    }

    public void addStatement(IRStatement statement) {
        statements.add(statement);
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
