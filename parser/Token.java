package parser;

/**
 * Token set for {@code parser.NodeParser}.
 *
 * @author sin
 * @version 2017.3.15
 * @see parser.NodeParser
 */
public enum Token {
	/**
	 * {@code +}
	 */
	PLUS,
	/**
	 * {@code -}
	 */
	MINUS,
	/**
	 * {@code *}
	 */
	AST,
	/**
	 * {@code !}
	 */
	EXCL,
	/**
	 * {@code |}
	 */
	VERT,
	/**
	 * {@code (}
	 */
	LPAR,
	/**
	 * {@code )}
	 */
	RPAR,
	/**
	 * non-negative integer
	 */
	NUMBER,
	/**
	 * initial state of {@link parser.NodeParser}
	 */
	START,
	/**
	 * {@code .}
	 */
	END,
}
