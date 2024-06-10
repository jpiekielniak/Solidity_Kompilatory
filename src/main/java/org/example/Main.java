package org.example;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.gen.SolidityLexer;
import org.example.gen.SolidityParser;
import org.example.gen.SolidityParserBaseVisitor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final List<String> errors = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        var sourceFilePath = "./src/main/resources/contracts/test.sol";
        var input = CharStreams.fromFileName(sourceFilePath);
        var lexer = new SolidityLexer(input);
        var tokens = new CommonTokenStream(lexer);
        var parser = new SolidityParser(tokens);
        var tree = parser.sourceUnit();
        var visitor = new SolidityParserBaseVisitor<Parser>();
        visitor.visit(tree);
        showTree(tree, parser, new StringBuilder(), visitor);

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
        System.out.println(EVMAssembler.assemble(evmCodeGenerator.getEVMCode()));

    }

    private static void showTree(ParseTree tree, SolidityParser parser, StringBuilder bytecodeBuilder, SolidityParserBaseVisitor<Parser> visitor) {
        var frame = new JFrame("Solidity AST Viewer");
        var panel = new JPanel(new BorderLayout());
        var errorArea = new JTextArea();
        errorArea.setEditable(false);

        var errorMessage = new StringBuilder();
        for (String error : errors) {
            errorMessage.append(error).append("\n");
        }
        errorArea.setLineWrap(true);
        errorArea.setText(errorMessage.isEmpty() ? bytecodeBuilder.toString() : errorMessage.toString());

        var viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
        viewer.setScale(0.65);
        panel.add(viewer, BorderLayout.CENTER);
        panel.add(errorArea, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setVisible(true);
    }
}