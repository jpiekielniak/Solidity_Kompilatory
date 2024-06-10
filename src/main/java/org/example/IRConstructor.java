package org.example;

import java.util.List;

public class IRConstructor extends IRFunction {
    public IRConstructor(List<IRStatement> statements, List<IRParameter> parameters) {
        super("constructor", parameters, statements);
    }
}