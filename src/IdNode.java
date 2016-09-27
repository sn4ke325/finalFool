public class IdNode implements Node {

	private String id;
	private STentry entry;
	private int nl;

	public IdNode(String i, STentry st, int n) {
		id = i;
		entry = st;
		nl = n;
	}

	public String toPrint(String s) {
		return s + "Id:" + id + " at nestlev " + nl + "\n" + entry.toPrint(s + "  ");
	}

	public Node typeCheck() {
		if (entry.getType() instanceof ArrowTypeNode || entry.getType() == null ||  entry.isMethod()) { //
			System.out.println("Wrong usage of function identifier");
			System.exit(0);
		}
		return entry.getType();
	}

	public String codeGeneration() {
		String getAR = "";
		for (int i = 0; i < nl - entry.getNestinglevel(); i++)
			getAR += "lw\n";
		return "push " + entry.getOffset() + "\n" + "lfp\n" + getAR + "add\n" + "lw\n";
	}

}