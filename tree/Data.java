package tree;

import visitor.NodeVisitor;

/**
 * A leaf that has an {@code int} value.
 *
 * @author lxcc0wave
 * @version 2017.03.15
 */
public class Data implements Node{
	private int value;

	/**
	 * Constructs a leaf with the specified {@code int} value.
	 * @param value value of this leaf
	 */
	public Data(int value){
		this.value = value;
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public Node getLeft() {
		return null;
	}

	@Override
	public Node getRight() {
		return null;
	}

	public boolean equals(Data data){
		if(data == null)
			return false;
		return value == data.getValue();
	}

	@Override
	public boolean equals(Object obj){
		if(! (obj instanceof Data))
			return false;
		return equals((Data)obj);
	}

	@Override
	public String toString(){
		return "" + value;
	}

	@Override
	public int eval() {
		return value;
	}

	@Override
	public void dump(int n) {
		System.out.println(makeIndent(n) + "Data[" + value + "]");
	}

	@Override
	public void accept(NodeVisitor v) {
		v.visit(this);
	}
}
