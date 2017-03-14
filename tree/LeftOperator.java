package tree;

/**
 * A node of the left unary operator.
 *
 * @author lxcc0wave
 * @version 2017.3.14
 */
public abstract class LeftOperator extends UnaryOperator {
	/**
	 * Constructs a left unary operator with the specified operand.
	 *
	 * @param arg operand(not {@code null})
	 */
	public LeftOperator(Node arg) {
		super(arg);
	}
	/**
	 * Returns {@code null}.
	 *
	 * @return {@code null}
	 * @deprecated use {@link tree.UnaryOperator#getArg()} instead.
	 */
	@Override
	public Node getLeft(){
		return null;
	}
	/**
	 * Returns opernad of {@code this}.
	 *
	 * @return operand
	 * @deprecated use {@link tree.UnaryOperator#getArg()} instead.
	 */
	@Override
	public Node getRight(){
		return this.getArg();
	}

}
