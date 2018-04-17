package com.com.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class TestDom {
	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		// 从DOM工厂中获得DOM解析器
		DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
		// 把要解析的xml文档读入DOM解析器
		//Document doc = dbBuilder.parse(new File("G:\\JAVA\\apache-maven-3.3.9\\conf\\settings.xml"));
		Document doc = dbBuilder.parse(new File("G:\\IntellijHome\\rupengImprove\\designer\\pom.xml"));

		printNode(doc, 0);

	}

	private static void printNode(Node node, int depth) {
		//只输出普通节点，不输出注释、文本等
		if (node.getNodeType() == 1) {
			System.out.println(repeatTab(depth) + node.getNodeName());
		}
		//获取节点的子节点
		NodeList childNodes = node.getChildNodes();
		//看似没有“递归终止条件”，当没有子节点的时候就终止了
		for (int i = 0; i < childNodes.getLength(); i++) {
			Node childNode = childNodes.item(i);
			printNode(childNode, depth + 1);//缩进深入一层
		}
	}

	/**
	 * 返回由count个Tab键组成的字符串
	 *
	 * @param count
	 * @return
	 */
	static String repeatTab(int count) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append("\t");
		}
		return sb.toString();
	}
}
