package tree;

/**
 * A node of the factorial "!" operator.
 *
 * @author lxcc0wave
 * @version 2017.3.14
 */
public class Factorial extends RightOperator {
	/**
	 * Constructs a factorial "!" operator with the specified operand.
	 *
	 * @param arg operand(not {@code null})
	 */
	public Factorial(Node arg) {
		super(arg);
	}

	@Override
	public int eval() {
		return calc(this.getArg().eval(), 1);
	}

	@Override
	public void dump(int n) {
		System.out.println(makeIndent(n) + "Factorial");
		this.getArg().dump(n + 1);
	}

	private int calc(int n, int acc){
		return n <= 0 ? acc : calc(n - 1, n * acc);
	}

	public boolean equals(Factorial exp){
		if(exp == null)
			return false;
		return this.getArg().equals(exp.getArg());
	}

	@Override
	public boolean equals(Object obj){
		if(! (obj instanceof Factorial))
			return false;
		return equals((Factorial)obj);
	}

	@Override
	public String toString(){
		return "Factorial";
	}
}
