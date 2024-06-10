package org.example;

public abstract class IRNode {
    public abstract void accept(IRVisitor visitor);
}
