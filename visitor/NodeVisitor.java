package visitor;

import tree.Abs;
import tree.Add;
import tree.Data;
import tree.Factorial;
import tree.Minus;
import tree.Multiply;
import tree.Node;

/**
 * Visitor pattern : Visitor.
 * @author lxcc0wave
 * @version 2017.3.15
 * @see tree.Node
 */
public interface NodeVisitor {
	default int getValue(){
		return 0;
	}
	/**
	 * it will be error when this method is called.
	 * @param n Node
	 */
	void visit(Node n);
	void visit(Abs n);
	void visit(Add n);
	void visit(Data n);
	void visit(Factorial n);
	void visit(Minus n);
	void visit(Multiply n);
}
