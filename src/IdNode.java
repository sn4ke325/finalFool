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
		if (entry.getType() == null || entry.isMethod()) { //
			System.out.println("Wrong usage of function identifier");
			System.exit(0);
		}
		return entry.getType();
	}

	public String codeGeneration() {
		//work in progress
		String getAR = "";
		for (int i = 0; i < nl - entry.getNestinglevel(); i++)
			getAR += "lw\n";
		
		String code="push " + entry.getOffset() + "\n" + "lfp\n" + getAR + "add\n" + "lw\n";
		
		if(entry.getType() instanceof ArrowTypeNode)
			code+= "push " + (entry.getOffset()-1)+ "\n"+"lfp\n" +getAR+ "add\n" + ""
			
		
		return code;
	}

}