package visitor;

import tree.Abs;
import tree.Add;
import tree.Data;
import tree.Factorial;
import tree.Minus;
import tree.Multiply;
import tree.Node;

/**
 * Dump {@link tree.Node} as syntax tree using visitor pattern.
 * @author lxcc0wave
 * @version 2017.3.22
 */
public class NodeDumpVisitor implements NodeVisitor {
	private int indent = 0;
	private static String makeIndent(int n){
		String acc = "";
		for(int i = 0; i < n; i++){
			acc += "  ";
		}
		return acc;
	}
	private String makeIndent(){
		return makeIndent(indent);
	}

	@Override
	public void visit(Node n) {
		/* no operation */
	}

	@Override
	public void visit(Abs n) {
		System.out.println(makeIndent() + "Abs");
		indent++;
		n.getArg().accept(this);
		indent--;
	}

	@Override
	public void visit(Add n) {
		System.out.println(makeIndent() + "Add");
		indent++;
		n.getLeft().accept(this);
		n.getRight().accept(this);
		indent--;
	}

	@Override
	public void visit(Data n) {
		System.out.println(makeIndent() + "Data[" + n.getValue() + "]");
	}

	@Override
	public void visit(Factorial n) {
		System.out.println(makeIndent() + "Factorial");
		indent++;
		n.getArg().accept(this);
		indent--;
	}

	@Override
	public void visit(Minus n) {
		System.out.println(makeIndent() + "Minus");
		indent++;
		n.getArg().accept(this);
		indent--;
	}

	@Override
	public void visit(Multiply n) {
		System.out.println(makeIndent() + "Multiply");
		indent++;
		n.getLeft().accept(this);
		n.getRight().accept(this);
		indent--;
	}

}
