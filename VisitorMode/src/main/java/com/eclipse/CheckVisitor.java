package com.eclipse;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import java.util.LinkedList;

public class CheckVisitor extends ASTVisitor {
	//有问题的信息
	private LinkedList<String> problems = new LinkedList<>();
	
	@Override
	public boolean visit(VariableDeclarationFragment node) {
		String varName = node.getName().getIdentifier();
		char firstCh = varName.charAt(0);
		if (Character.isUpperCase(firstCh)) {
			problems.add(varName + "变量是大写开头，应该是小写开头");
		}
		return super.visit(node);
	}
	
	@Override
	public boolean visit(MethodDeclaration node) {
		String methodName = node.getName().getIdentifier();
		char firstCh = methodName.charAt(0);
		if (Character.isUpperCase(firstCh)) {
			problems.add(methodName + "方法名是大写开头，应该是小写开头");
		}
		return super.visit(node);
	}
	
	public String[] getProblems() {
		return problems.toArray(new String[problems.size()]);
	}
	
}
