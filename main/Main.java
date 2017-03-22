package main;

import parser.NodeParser;
import tree.Node;
import visitor.NodeDumpVisitor;
import visitor.NodeEvalVisitor;
import visitor.NodeVisitor;

public class Main {
	public static void main(String[] args){
		NodeParser parser = new NodeParser(System.in);
		NodeVisitor dump = new NodeDumpVisitor(),
				eval = new NodeEvalVisitor();
		try{
			while(true){
				System.out.print(">");
				Node x = parser.parse();
				System.out.println("DUMP:");
				x.accept(dump);
				System.out.println("EVAL:");
				x.accept(eval);
				System.out.println(eval.getValue());
			}
		} catch (Exception exception){
			exception.printStackTrace();
		}
	}
}
