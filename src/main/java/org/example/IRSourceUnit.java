package org.example;

import java.util.List;

public class IRSourceUnit extends IRNode {
    private final String pragmaVersion;
    private final List<IRContract> contracts;

    public IRSourceUnit(String pragmaVersion, List<IRContract> contracts) {
        this.pragmaVersion = pragmaVersion;
        this.contracts = contracts;
    }

    public String getPragmaVersion() {
        return pragmaVersion;
    }

    public List<IRContract> getContracts() {
        return contracts;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}