package org.example;

import java.util.List;

public class IRInstruction extends IRNode {
    private String type;
    private List<Object> operands;

    public IRInstruction(String type, List<Object> operands) {
        this.type = type;
        this.operands = operands;
    }

    public String getType() {
        return type;
    }

    public List<Object> getOperands() {
        return operands;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
