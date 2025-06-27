package com.example;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main <program_file>");
            System.exit(1);
        }

        String fileName = args[0];
        
        try {
            String program = new String(Files.readAllBytes(Paths.get(fileName)));
            
            LangoLexer lexer = new LangoLexer(CharStreams.fromString(program));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            
            LangoParser parser = new LangoParser(tokens);
            ParseTree tree = parser.program();
            
            if (parser.getNumberOfSyntaxErrors() > 0) {
                System.err.println("Syntax errors found!");
                System.exit(1);
            }
            
            Interpreter interpreter = new Interpreter();
            interpreter.visit(tree);
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Runtime error: " + e.getMessage());
            System.exit(1);
        }
    }
} 
