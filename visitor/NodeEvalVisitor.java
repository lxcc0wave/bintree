package visitor;

import tree.Abs;
import tree.Add;
import tree.Data;
import tree.Factorial;
import tree.Minus;
import tree.Multiply;
import tree.Node;

/**
 * Evaluate {@link tree.Node} as syntax tree using visitor pattern.
 *
 * <p>usage:</p>
 * <pre>
 * Node node = parser.parse();<br>
 * NodeVisitor nv = new NodeEvalVisitor();<br>
 * node.accpet(nv);<br>
 * int result = nv.getValue();<br>
 * </pre>
 * @author lxcc0wave
 * @version 2017.3.22
 */
public class NodeEvalVisitor implements NodeVisitor {
	private int acc = 0;

	@Override
	public int getValue(){
		return acc;
	}

	@Override
	public void visit(Node n) {
		/* no operation */
	}

	@Override
	public void visit(Abs n) {
		n.getArg().accept(this);
		acc = Math.abs(acc);
	}

	@Override
	public void visit(Add n) {
		n.getLeft().accept(this);
		int left = acc;
		n.getRight().accept(this);
		acc = left + acc;
	}

	@Override
	public void visit(Data n) {
		acc = n.getValue();
	}

	private static int factorial(int n, int acc){
		return n <= 0 ? acc : factorial(n - 1, n * acc);
	}
	private static int factorial(int n){
		return factorial(n, 1);
	}
	@Override
	public void visit(Factorial n) {
		n.getArg().accept(this);
		acc = factorial(acc);
	}

	@Override
	public void visit(Minus n) {
		n.getArg().accept(this);;
		acc = -acc;
	}

	@Override
	public void visit(Multiply n) {
		n.getLeft().accept(this);
		int left = acc;
		n.getRight().accept(this);
		acc = left * acc;
	}

}
