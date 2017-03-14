package tree;

/**
 * A binary tree node that has an {@code int} value.
 *
 * @author lxcc0wave
 * @version 2017.3.14
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
	/**
	 * Returns the value of node as syntax tree.
	 *
	 * @return value of tree
	 */
	int eval();
	/**
	 * Print the node in pre-order.
	 *
	 * @param n indent level
	 */
	void dump(int n);
	/**
	 * Returns the indent string of level {@code n}.
	 *
	 * @param n indent level
	 * @return indent string
	 */
	default String makeIndent(int n){
		String acc = "";
		for(int i = 0; i < n; i++)
			acc += "  ";
		return acc;
	}
}
