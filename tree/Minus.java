package tree;

import visitor.NodeVisitor;

/**
 * A node of the unary "-" operator.
 *
 * @author lxcc0wave
 * @version 2017.3.15
 */
public class Minus extends LeftOperator {
	/**
	 * Constructs a unary "-" operator with the specified operand.
	 *
	 * @param arg operand(not {@code null})
	 */
	public Minus(Node arg) {
		super(arg);
	}

	@Override
	public int eval() {
		return - this.getArg().eval();
	}

	@Override
	public void dump(int n) {
		System.out.println(makeIndent(n) + "Minus");
		this.getArg().dump(n + 1);
	}

	public boolean equals(Minus exp){
		if(exp == null)
			return false;
		return this.getArg().equals(exp.getArg());
	}

	@Override
	public boolean equals(Object obj){
		if(! (obj instanceof Minus))
			return false;
		return equals((Minus)obj);
	}

	@Override
	public String toString(){
		return "Minus";
	}

	@Override
	public void accept(NodeVisitor v) {
		v.visit(this);
	}
}
