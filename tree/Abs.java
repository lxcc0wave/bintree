package tree;

import visitor.NodeVisitor;

/**
 * A node of the absolute value operator |.|.
 *
 * @author lxcc0wave
 * @version 2017.3.15
 */
public class Abs extends UnaryOperator {
	/**
	 * Constructs an absolute value operator with the specified operand.
	 *
	 * @param arg operand
	 */
	public Abs(Node arg) {
		super(arg);
	}
	/**
	 * Returns {@code null}.
	 *
	 * @return {@code null}
	 * @deprecated use {@link tree.UnaryOperator#getArg()} instead.
	 */
	@Override
	public Node getLeft() {
		return null;
	}
	/**
	 * Returns {@code null}.
	 *
	 * @return {@code null}
	 * @deprecated use {@link tree.UnaryOperator#getArg()} instead.
	 */
	@Override
	public Node getRight() {
		return null;
	}

	@Override
	public int eval() {
		return this.abs(this.getArg().eval());
	}

	private int abs(int x){
		return x > 0 ? x : -x;
	}

	@Override
	public void dump(int n) {
		System.out.println(makeIndent(n) + "Abs");
		this.getArg().dump(n + 1);
	}
	@Override
	public void accept(NodeVisitor v) {
		v.visit(this);
	}

}
