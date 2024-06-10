package org.example;

import java.util.List;

public class IRFunctionDefinition extends IRNode {
    private final String name;
    private final List<IRParameter> parameters;
    private final List<IRStatement> body;

    public IRFunctionDefinition(String name, List<IRParameter> parameters, List<IRStatement> body) {
        this.name = name;
        this.parameters = parameters;
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public List<IRParameter> getParameters() {
        return parameters;
    }

    public List<IRStatement> getBody() {
        return body;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
