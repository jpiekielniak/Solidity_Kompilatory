package org.example;

public interface IRVisitor {
    void visit(IRFunction function);
    void visit(IRExpressionStatement expressionStatement);
    void visit(IRVariableDeclaration variableDeclaration);
    void visit(IRVariable variable);
    void visit(IRLiteral literal);
    void visit(IRAssignment assignment);
    void visit(IRReturn returnStatement);
    void visit(IRFunctionCall functionCall);
    void visit(IRSourceUnit sourceUnit);
    void visit(IRContract contract);
    void visit(IRConstructor constructor);
    void visit(IRParameter parameter);
}
