public class STentry {

	private int nl;
	private Node type;
	private int offset;

	public STentry(int n, int o) {
		nl = n;
		offset = o;
	}

	public STentry(int n, Node t, int o) {
		nl = n;
		type = t;
		offset = o;
	}

	public void addType(Node t) {
		type = t;
	}

	public Node getType() {
		return type;
	}

	public int getOffset() {
		return offset;
	}

	public int getNestinglevel() {
		return nl;
	}

	public String toPrint(String s) { //
		return s + "STentry: nestlev " + Integer.toString(nl) + "\n" + s + "STentry: offset " + Integer.toString(offset)
				+ "\n" + s + "STentry: type\n" + type.toPrint(s + "  ");
	}

}