package tree;

import visitor.NodeVisitor;

/**
 * A node of the operator "+" on integer.
 *
 * @author lxcc0wave
 * @version 2017.3.15
 */
public class Add extends BinaryOperator {
	/**
	 * Constructs a "+" operator with the specified operands.
	 *
	 * @param left left operand(not {@code null})
	 * @param right right operand(not {@code null})
	 */
	public Add(Node left, Node right) {
		super(left, right);
	}

	@Override
	public int eval() {
		return this.getLeft().eval() + this.getRight().eval();
	}

	@Override
	public void dump(int n) {
		System.out.println(makeIndent(n) + "Add");
		this.getLeft().dump(n + 1);
		this.getRight().dump(n + 1);
	}

	public boolean equals(Add exp){
		if(exp == null)
			return false;
		return this.getLeft().equals(exp.getLeft())
				&& this.getRight().equals(exp.getRight());
	}

	@Override
	public boolean equals(Object obj){
		if(! (obj instanceof Add))
			return false;
		return equals((Add)obj);
	}

	@Override
	public String toString(){
		return "Add";
	}

	@Override
	public void accept(NodeVisitor v) {
		v.visit(this);
	}
}
