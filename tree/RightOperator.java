package tree;

/**
 * A node of the right unary operator.
 *
 * @author lxcc0wave
 * @version 2017.3.14
 */
public abstract class RightOperator extends UnaryOperator {
	/**
	 * Constructs a right unary operator with the specified operand.
	 *
	 * @param arg operand(not {@code null})
	 */
	public RightOperator(Node arg) {
		super(arg);
	}
	/**
	 * Returns {@code null}.
	 *
	 * @return {@code null}
	 * @deprecated use {@link tree.UnaryOperator#getArg()} instead.
	 */
	@Override
	public Node getRight(){
		return null;
	}
	/**
	 * Returns opernad of {@code this}.
	 *
	 * @return operand
	 * @deprecated use {@link tree.UnaryOperator#getArg()} instead.
	 */
	@Override
	public Node getLeft(){
		return this.getArg();
	}
}
