package main;

import tree.Data;
import tree.Node;

public class Main {
	public static void main(String[] args){
		Node n1 = new Data(1);
		System.out.println("n1.getValue()=" + n1.getValue());
		if(n1.getLeft() == null){
			System.out.println("no left child.");
		} else {
			System.out.println("n1 has left child.");
		}
		if(n1.getRight() == null){
			System.out.println("no right child.");
		} else {
			System.out.println("n1 has right child.");
		}
	}
}
