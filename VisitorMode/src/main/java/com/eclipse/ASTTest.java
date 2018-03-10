package com.eclipse;

import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class ASTTest {
    public static void main(String[] args) throws IOException {
        ASTParser astParser = ASTParser.newParser(AST.JLS9); // 非常慢
        String filePath="G:\\IntellijHome\\rupengImprove\\designer\\VisitorMode\\src\\main\\java\\Dom4JTest1.java";
        String source = FileUtils.readFileToString(new File(filePath), Charset.forName("UTF-8"));
        astParser.setSource(source.toCharArray());//分析源代码
        CompilationUnit cm = (CompilationUnit) (astParser.createAST(null)); //解析源代码成为CompilationUnit
        CheckVisitor checkVisitor = new CheckVisitor();
        cm.accept(checkVisitor);
        for(String msg : checkVisitor.getProblems())
        {
            System.out.println(msg);
        }

    }
}
