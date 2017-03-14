package tree;

/**
 * A node of the operator "*" on integer.
 *
 * @author lxcc0wave
 * @version 2017.3.14
 */
public class Multiply extends BinaryOperator{
	/**
	 * Constructs a "*" oeprator with the specified operands.
	 *
	 * @param left left operand(not {@code null})
	 * @param right right operand(not {@code null})
	 */
	public Multiply(Node left, Node right) {
		super(left, right);
	}

	@Override
	public int eval() {
		return this.getLeft().eval() * this.getRight().eval();
	}

	@Override
	public void dump(int n) {
		System.out.println(makeIndent(n) + "Multiply");
		this.getLeft().dump(n + 1);
		this.getRight().dump(n + 1);
	}

	public boolean equals(Multiply exp){
		if(exp == null)
			return false;
		return this.getLeft().equals(exp.getLeft())
				&& this.getRight().equals(exp.getRight());
	}

	@Override
	public boolean equals(Object obj){
		if(! (obj instanceof Multiply))
			return false;
		return equals((Multiply)obj);
	}

	@Override
	public String toString(){
		return "Multiply";
	}
}
