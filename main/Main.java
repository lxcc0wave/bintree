package main;

import tree.Abs;
import tree.Add;
import tree.Data;
import tree.Factorial;
import tree.Minus;
import tree.Multiply;
import tree.Node;

public class Main {
	public static void main(String[] args){
		// -4! + 3 * (2 + 4)
		Node test = new Add(
				new Minus(new Factorial(new Data(4))),
				new Multiply(
						new Data(3),
						new Add(
								new Data(2),
								new Data(4)
								)
						)
				);
		test = new Abs(test);
		System.out.println("Dump:");
		test.dump(0);
		System.out.println("Eval:" + test.eval());
	}
}
