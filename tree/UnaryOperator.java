package tree;

/**
 * A node of unary operator for {@code Node}.<br>
 *
 * {@code UnaryOperator} has a child(not {@code null}).
 *
 * @author lxcc0wave
 * @version 2017.3.13
 */
public abstract class UnaryOperator implements Operator {
	private Node arg;

	/**
	 * Constructs a unary operator with the specified operand.
	 *
	 * @param arg operand(not {@code null})
	 */
	public UnaryOperator(Node arg){
		this.arg = arg;
	}

	/**
	 * Returns the operand of {@code UnaryOperator}.
	 *
	 * @return operand of {@code this}(not {@code null})
	 */
	public Node getArg(){
		return arg;
	}
}
