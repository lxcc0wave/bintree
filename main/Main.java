package main;

import parser.NodeParser;
import tree.Node;

public class Main {
	public static void main(String[] args){
		NodeParser parser = new NodeParser(System.in);
		try{
			while(true){
				System.out.print(">");
				Node x = parser.parse();
				System.out.println("DUMP:");
				x.dump(0);
				System.out.println("EVAL:");
				System.out.println(x.eval());
			}
		} catch (Exception exception){
			exception.printStackTrace();
		}
	}
}
