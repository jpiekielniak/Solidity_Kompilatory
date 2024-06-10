package org.example;

import java.util.List;

public class IRFunctionCall extends IRNode {
    private String functionName;
    private List<IRNode> arguments;

    public IRFunctionCall(String functionName, List<IRNode> arguments) {
        this.functionName = functionName;
        this.arguments = arguments;
    }

    public String getFunctionName() {
        return functionName;
    }

    public List<IRNode> getArguments() {
        return arguments;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append(functionName).append("(");
        for (var i = 0; i < arguments.size(); i++) {
            sb.append(arguments.get(i));
            if (i < arguments.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
