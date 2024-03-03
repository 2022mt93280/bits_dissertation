package com.dissertation.test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;


public class JavaFunctionExtractor {
    
    public static List<String> extractFunctions() {
        String filePath = "C:\\Users\\Administrator\\Documents\\test\\test\\src\\main\\java\\com\\dissertation\\test\\Calculator.java";
        List<String> functions = new ArrayList<>();
        try {
            String javaCode = new String(Files.readAllBytes(Paths.get(filePath)));
            CompilationUnit cu = StaticJavaParser.parse(javaCode);
            
            // Extract methods
            List<MethodDeclaration> methodDeclarations = cu.findAll(MethodDeclaration.class);
            long fileNameSalt = System.currentTimeMillis();
            String outputBasePath = "C:\\Users\\Administrator\\Desktop\\output\\";
            
            for (MethodDeclaration methodDeclaration : methodDeclarations) {
                String javaMethod = methodDeclaration.toString();
                String javaMethodName = methodDeclaration.getNameAsString();
                // Write functions to a file
                String outputFilePath = outputBasePath + javaMethodName + "_" + fileNameSalt + ".txt";
                Files.write(Paths.get(outputFilePath), javaMethod.getBytes());
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return functions;
    }


    public static void main(String[] args) {
        //String filePath = "C:\\Users\\Administrator\\Documents\\test\\test\\src\\main\\java\\com\\dissertation\\test\\Calculator.java";
        try {
            // Read Java code from the file
            //tring javaCode = new String(Files.readAllBytes(Paths.get(filePath)));

            // Extract functions from the Java code
            extractFunctions();
            
            // Print extracted functions
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
