package org.example;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.example.gen.SolidityLexer;
import org.example.gen.SolidityParser;
import org.example.gen.SolidityParserBaseVisitor;

public class Main {
    public static void main(String[] args) throws Exception {
        var sourceFilePath = "/Users/Jakub/Desktop/Solidity_Kompilatory/src/main/resources/contracts/example.sol";
        var input = CharStreams.fromFileName(sourceFilePath);
        var lexer = new SolidityLexer(input);
        var tokens = new CommonTokenStream(lexer);
        var parser = new SolidityParser(tokens);
        var tree = parser.sourceUnit();


        var irGenerator = new SolidityIRGenerator();
        irGenerator.visit(tree);

        var irFunctions = irGenerator.getFunctions();
        var irVariableDeclarations = irGenerator.getVariables();
        var irCodeGenerator = new IRCodeGenerator();
        irCodeGenerator.setPragmaVersion(irGenerator.getPragmaVersion());
        irCodeGenerator.setContractName(irGenerator.getContractName());

        irFunctions
                .forEach(function -> function.accept(irCodeGenerator));

        irVariableDeclarations
                .forEach(variable -> variable.accept(irCodeGenerator));

        System.out.println(irCodeGenerator.getBytecode());

        var evmCodeGenerator = new EVMCodeGenerator();

        irFunctions
                .forEach(function -> function.accept(evmCodeGenerator));

        irVariableDeclarations
                .forEach(variable -> variable.accept(evmCodeGenerator));

        System.out.println(evmCodeGenerator.getEVMCode());

    }
}