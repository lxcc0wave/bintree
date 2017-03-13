package tree;

/**
 * A binary tree node that has an {@code int} value.
 *
 * @author lxcc0wave
 * @version 2017.3.12
 */
public interface Node {
	/**
	 * Returns the value of node.
	 *
	 * @return value of {@code this}
	 */
	int getValue();
	/**
	 * Returns the left child of node.
	 *
	 * @return left child of {@code this} or {@code null} if no left child.
	 */
	Node getLeft();
	/**
	 * Returns the right child of node.
	 *
	 * @return right child of {@code this} or {@code null} if no right child.
	 */
	Node getRight();
}
