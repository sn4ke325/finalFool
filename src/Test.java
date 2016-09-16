import java.io.*;

import org.antlr.runtime.*;

public class Test {
    public static void main(String[] args) throws Exception {
      
        String fileName = "prova.fool";
      
        ANTLRFileStream input = new ANTLRFileStream(fileName);
        FOOLLexer lexer = new FOOLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FOOLParser parser = new FOOLParser(tokens);
         
        Node ast = parser.prog(); //generazione AST con Id associate a relative entry symbol table
        System.out.println("You had: "+lexer.lexicalErrors+" lexical errors and "+parser.getNumberOfSyntaxErrors()+" syntax errors.");
        System.out.println(ast.toPrint(""));

        Node type = ast.typeCheck(); //type-checking bottom-up 
        System.out.println(type.toPrint("Type checking ok! Type of the program is: "));
        
        String code = ast.codeGeneration();
        
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName+".asm"));
        out.write(code);
        out.close();
        System.out.println("Code generated! Assembling and running generated code.");
        
        ANTLRFileStream inputVM = new ANTLRFileStream(fileName+".asm");
        SVMLexer lexerVM = new SVMLexer(inputVM);
        CommonTokenStream tokensVM = new CommonTokenStream(lexerVM);
        SVMParser parserVM = new SVMParser(tokensVM);
        
        parserVM.assembly();
        
        ExecuteVM vm = new ExecuteVM(parserVM.code);
        vm.cpu();  
        
    }
}
