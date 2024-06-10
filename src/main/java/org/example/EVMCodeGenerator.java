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
    public void visit(IRSourceUnit sourceUnit) {
        for (IRContract contract : sourceUnit.getContracts()) {
            contract.accept(this);
        }
    }

    @Override
    public void visit(IRContract contract) {
        // Initialize the contract
        evmCode.append("PUSH1 0x60\n");
        evmCode.append("PUSH1 0x40\n");
        evmCode.append("MSTORE\n");

        // Handle variable declarations
        for (IRVariableDeclaration declaration : contract.getVariableDeclarations()) {
            declaration.accept(this);
        }

        // Handle constructor
        if (contract.getConstructor() != null) {
            contract.getConstructor().accept(this);
        }

        // Handle functions
        for (IRFunction function : contract.getFunctions()) {
            function.accept(this);
        }
    }

    @Override
    public void visit(IRConstructor constructor) {
        // Initialize the constructor
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

        for (IRParameter parameter : constructor.getParameters()) {
            parameter.accept(this);
        }

        for (IRStatement statement : constructor.getStatements()) {
            statement.accept(this);
        }

        // Use PUSH2 0x0187 instead of PUSH1 0x00
        evmCode.append("PUSH2 0x0187\n");
        evmCode.append("SSTORE\n");
    }

    @Override
    public void visit(IRParameter parameter) {

    }

    @Override
    public void visit(IRFunctionDefinition functionDefinition) {

    }

    @Override
    public void visit(IRVariableDeclaration variableDeclaration) {
        String accessModifier = variableDeclaration.getAccessModifier();
        String variableName = variableDeclaration.getName();

        if ("storage".equals(accessModifier)) {
            generatePushInstruction(getStorageIndex(variableName));
            evmCode.append("SSTORE\n");
        } else {
            generatePushInstruction(getStorageIndex(variableName));
            evmCode.append("MSTORE\n");
            memoryOffset += 0x20;
        }
    }

    @Override
    public void visit(IRFunction function) {
        evmCode.append("PUSH1 0x\n");
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
            assignment.accept(this);
            evmCode.append("PUSH1 ").append(getStorageIndex(assignment.getVariable())).append("\n");
            evmCode.append("SSTORE\n");
        } else if (expression instanceof IRFunctionCall) {
            IRFunctionCall functionCall = (IRFunctionCall) expression;
            for (IRNode arg : functionCall.getArguments()) {
                visitFunctionArgument(arg);
            }
            evmCode.append("CALL\n");
        } else if (expression instanceof IRVariable) {
            IRVariable variable = (IRVariable) expression;
            evmCode.append("PUSH1 ").append(getStorageIndex(variable.getName())).append("\n");
            evmCode.append("SLOAD\n");
        } else if (expression instanceof IRLiteral) {
            IRLiteral literal = (IRLiteral) expression;
            generatePushInstruction(encodeLiteral(literal.getValue()));
        }
    }

    @Override
    public void visit(IRAssignment assignment) {
        IRNode value = assignment.getValue();
        if (value instanceof IRLiteral) {
            generatePushInstruction(encodeLiteral(((IRLiteral) value).getValue()));
        } else if (value instanceof IRVariable) {
            IRVariable variable = (IRVariable) value;
            evmCode.append("PUSH1 ").append(getStorageIndex(variable.getName())).append("\n");
            evmCode.append("SLOAD\n");
        } else {
            value.accept(this);
        }

        String variableName = assignment.getVariable();
        if (isStorageVariable(variableName)) {
            evmCode.append("PUSH1 ").append(getStorageIndex(variableName)).append("\n");
            evmCode.append("SSTORE\n");
        } else {
            evmCode.append("PUSH1 0x").append(Integer.toHexString(memoryOffset)).append("\n");
            evmCode.append("MSTORE\n");
        }
    }

    @Override
    public void visit(IRVariable variable) {
        String variableName = variable.getName();

        if (isStorageVariable(variableName)) {
            evmCode.append("PUSH1 ").append(getStorageIndex(variableName)).append("\n");
            evmCode.append("SLOAD\n");
        } else {
            evmCode.append("PUSH1 0x").append(Integer.toHexString(memoryOffset)).append("\n");
            evmCode.append("MLOAD\n");
        }
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

        evmCode.append("PUSH1 0xFFFFFFFF\n");
        evmCode.append("PUSH1 0x00\n");
        evmCode.append("PUSH1 0x00\n");
        evmCode.append("PUSH1 0x40\n");
        evmCode.append("PUSH1 0x20\n");
        evmCode.append("PUSH1 0x60\n");
        evmCode.append("PUSH1 0x20\n");
        evmCode.append("CALL\n");
    }

    @Override
    public void visit(IRReturn returnStatement) {
        if (returnStatement.getValue() != null) {
            returnStatement.getValue().accept(this);

            evmCode.append("PUSH1 0x40\n");
            evmCode.append("PUSH1 0x20\n");
        } else {
            evmCode.append("PUSH1 0x00\n");
            evmCode.append("PUSH1 0x00\n");
        }

        evmCode.append("RETURN\n");
    }

    private void visitFunctionArgument(IRNode argument) {
        if (argument instanceof IRLiteral) {
            generatePushInstruction(encodeLiteral(((IRLiteral) argument).getValue()));
        } else if (argument instanceof IRVariable) {
            evmCode.append("PUSH1 ").append(getStorageIndex(((IRVariable) argument).getName())).append("\n");
            evmCode.append("SLOAD\n");
        } else {
            argument.accept(this);
        }
    }

    private void generatePushInstruction(String hexValue) {
        int length = hexValue.length() / 2;
        if (length <= 1) {
            evmCode.append("PUSH1 0x").append(hexValue).append("\n");
        } else if (length <= 32) {
            evmCode.append("PUSH").append(length).append(" 0x").append(hexValue).append("\n");
        } else {
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

    private boolean isStorageVariable(String variableName) {
        return storageIndexMap.containsKey(variableName);
    }
}
