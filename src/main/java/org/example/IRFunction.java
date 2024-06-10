package org.example;

import java.util.ArrayList;
import java.util.List;

public class IRFunction extends IRNode {
    private final String name;
    private final List<IRParameter> parameters;
    private final List<IRStatement> statements;

    public IRFunction(String name, List<IRParameter> parameters, List<IRStatement> statements) {
        this.name = name;
        this.parameters = parameters;
        this.statements = statements;
    }

    public String getName() {
        return name;
    }

    public List<IRParameter> getParameters() {
        return parameters;
    }

    public List<IRStatement> getStatements() {
        return statements;
    }

    public void addParameter(IRParameter parameter) {
        parameters.add(parameter);
    }

    public void addStatement(IRStatement statement) {
        statements.add(statement);
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
