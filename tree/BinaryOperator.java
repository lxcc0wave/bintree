package tree;

/**
 * A node of binary operator for {@code Node}.<br>
 *
 * {@code BinaryOperator} has 2 children(not {@code null}).
 *
 * @author lxcc0wave
 * @version 2017.3.13
 */
public abstract class BinaryOperator implements Operator {
	private Node left, right;

	/**
	 * Constructs a binary operator with the specified operands.<br>
	 *
	 * @param left left operand(not {@code null})
	 * @param right right operand(not {@code null})
	 */
	public BinaryOperator(Node left, Node right){
		this.left = left;
		this.right = right;
	}

	/**
	 * Returns the left operand.
	 *
	 * @return left operand(not {@code null})
	 */
	@Override
	public Node getLeft(){
		return left;
	}

	/**
	 * Returns the right operand.
	 *
	 * @return right operand(not {@code null})
	 */
	@Override
	public Node getRight(){
		return right;
	}
}
