package tree;

/**
 * A node of operator for {@code Node}.<br>
 *
 * Type :
 * <ul>
 *   <li>{@code Node -> Node}</li>
 *   <li>{@code Node -> Node -> Node}</li>
 * </ul>
 *
 * {@code Operator} have a child(not {@code null}) at least.
 *
 * @author lxcc0wave
 * @version 2017.3.13
 */
public interface Operator extends Node {
	/**
	 * Returns zero unless otherwise stated.
	 *
	 * @return zero
	 */
	@Override
	default int getValue(){
		return 0;
	}
}
