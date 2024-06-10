package org.example;

import java.util.HashMap;
import java.util.Map;

public class EVMCodeGenerator implements IRVisitor {
    private StringBuilder evmCode = new StringBuilder();
    private int memoryOffset = 0x40;
    private final Map<String, Integer> storageIndexMap = new HashMap<>();
    private int storageIndexCounter = 0;

    public String getEVMCode() {
        return evmCode.toString();
    }

    @Override
    public void visit(IRFunction function) {
        evmCode.append("DUP1\n");
        evmCode.append("PUSH1 0x40\n");
        evmCode.append("MSTORE\n");
        evmCode.append("CALLVALUE\n");
        evmCode.append("DUP1\n");
        evmCode.append("ISZERO\n");
        evmCode.append("PUSH2 0x0010\n");
        evmCode.append("JUMPI\n");
        evmCode.append("PUSH1 0x00\n");
        evmCode.append("DUP1\n");
        evmCode.append("REVERT\n");
        evmCode.append("JUMPDEST\n");
        evmCode.append("POP\n");

        for (IRStatement statement : function.getStatements()) {
            statement.accept(this);
        }

        evmCode.append("STOP\n");
    }

    @Override
    public void visit(IRExpressionStatement expressionStatement) {
        IRNode expression = expressionStatement.getExpression();
        if (expression instanceof IRAssignment) {
            IRAssignment assignment = (IRAssignment) expression;
            generatePushInstruction(encodeLiteral(assignment.getValue()));
            evmCode.append("PUSH1 ").append(getStorageIndex(assignment.getVariable())).append("\n");
            evmCode.append("SSTORE\n");
        } else if (expression instanceof IRFunctionCall) {
            IRFunctionCall functionCall = (IRFunctionCall) expression;
            // Generate code for function call arguments
            for (IRNode arg : functionCall.getArguments()) {
                visitFunctionArgument(arg);
            }
            evmCode.append("CALL\n");
        } else if (expression instanceof IRVariable) {
            expression.accept(this);
        } else if (expression instanceof IRLiteral) {
            expression.accept(this);
        }
    }

    @Override
    public void visit(IRVariableDeclaration variableDeclaration) {
        if ("storage".equals(variableDeclaration.getAccessModifier())) {
            evmCode.append("PUSH1 0x00\n");
            evmCode.append("PUSH1 ").append(getStorageIndex(variableDeclaration.getName())).append("\n");
            evmCode.append("SSTORE\n");
        } else {
            evmCode.append("PUSH1 0x00\n");
            evmCode.append("PUSH1 0x").append(Integer.toHexString(memoryOffset)).append("\n");
            evmCode.append("MSTORE\n");
            memoryOffset += 0x20;
        }
    }

    @Override
    public void visit(IRAssignment assignment) {
        generatePushInstruction(encodeLiteral(assignment.getValue()));
        evmCode.append("PUSH1 ").append(getStorageIndex(assignment.getVariable())).append("\n");
        evmCode.append("SSTORE\n");
    }

    @Override
    public void visit(IRVariable variable) {
        evmCode.append("PUSH1 ").append(getStorageIndex(variable.getName())).append("\n");
        evmCode.append("SLOAD\n");
    }

    @Override
    public void visit(IRLiteral literal) {
        generatePushInstruction(encodeLiteral(literal.getValue()));
    }

    @Override
    public void visit(IRFunctionCall functionCall) {
        for (IRNode arg : functionCall.getArguments()) {
            visitFunctionArgument(arg);
        }
        evmCode.append("CALL\n");
    }

    @Override
    public void visit(IRSourceUnit sourceUnit) {
        // Visit all top-level statements and functions
        for (IRNode node : sourceUnit.getContracts()) {
            node.accept(this);
        }
    }

    @Override
    public void visit(IRContract contract) {

    }

    @Override
    public void visit(IRConstructor constructor) {

    }

    @Override
    public void visit(IRParameter parameter) {

    }

    @Override
    public void visit(IRReturn returnStatement) {
        evmCode.append("PUSH1 0x00\n");
        if (returnStatement.getValue() != null) {
            returnStatement.getValue().accept(this);
        }
        evmCode.append("RETURN\n");
    }

    // New method to handle function call arguments
    private void visitFunctionArgument(IRNode argument) {
        if (argument instanceof IRLiteral) {
            generatePushInstruction(encodeLiteral(((IRLiteral) argument).getValue()));
        } else if (argument instanceof IRVariable) {
            evmCode.append("PUSH1 ").append(getStorageIndex(((IRVariable) argument).getName())).append("\n");
            evmCode.append("SLOAD\n");
        } else {
            argument.accept(this); // For other types of nodes, fallback to generic accept method
        }
    }

    private void generatePushInstruction(String hexValue) {
        int length = hexValue.length() / 2; // Each byte is represented by 2 hex characters
        if (length <= 1) {
            evmCode.append("PUSH1 0x").append(hexValue).append("\n");
        } else if (length <= 32) {
            evmCode.append("PUSH").append(length).append(" 0x").append(hexValue).append("\n");
        } else {
            // Trim or handle cases where the hex value is larger than 32 bytes
            evmCode.append("PUSH32 0x").append(hexValue.substring(0, 64)).append("\n");
        }
    }

    private String encodeLiteral(String value) {
        if (value.startsWith("0x")) {
            return value.substring(2);
        } else if (value.matches("-?\\d+(\\.\\d+)?")) {
            return Integer.toHexString(Integer.parseInt(value));
        } else {
            StringBuilder hex = new StringBuilder();
            for (char c : value.toCharArray()) {
                hex.append(String.format("%02x", (int) c));
            }
            return hex.toString();
        }
    }

    private String getStorageIndex(String variable) {
        return Integer.toHexString(storageIndexMap.computeIfAbsent(variable, k -> storageIndexCounter++));
    }
}
