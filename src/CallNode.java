import java.util.ArrayList;

public class CallNode implements Node {

	private String id;
	private STentry entry;
	private ArrayList<Node> parlist;
	private int nl;

	public CallNode(String i, STentry e, ArrayList<Node> p, int n) {
		id = i;
		entry = e; // entry della di chiarazione
		parlist = p;
		nl = n;
	}

	public String toPrint(String s) { //
		String parlstr = "";
		for (Node par : parlist)
			parlstr += par.toPrint(s + "  ");
		return s + "Call:" + id + " at nestlev " + nl + "\n" + entry.toPrint(s + "  ") + parlstr;
	}

	public Node typeCheck() { //
		ArrowTypeNode t = null;
		if (entry.getType() instanceof ArrowTypeNode)
			t = (ArrowTypeNode) entry.getType();
		else {
			System.out.println("Invocation of a non-function " + id);
			System.exit(0);
		}
		ArrayList<Node> p = t.getParList();
		if (!(p.size() == parlist.size())) {
			System.out.println("Wrong number of parameters in the invocation of " + id);
			System.exit(0);
		}
		for (int i = 0; i < parlist.size(); i++)
			if (!(FOOLlib.isSubtype((parlist.get(i)).typeCheck(), p.get(i)))) {
				System.out.println("Wrong type for " + (i + 1) + "-th parameter in the invocation of " + id);
				System.exit(0);
			}
		return t.getRet();
	}

	public String codeGeneration() {
		// String code = "";
		String parCode = "";
		for (Node n : parlist)
			parCode = n.codeGeneration() + parCode; //salvo i parametri in ordine inverso

		String getAR = "";
		for (int i = 0; i < nl - entry.getNestinglevel(); i++)
			getAR += "lw\n";

		if (entry.isMethod()) {
			return "push " + entry.getOffset() + "\n" + "lfp\n" + getAR + "add\n" + "lw\n";
		} else {
			return "push " + entry.getOffset() + "\n" + "lfp\n" + getAR + "add\n" + "lw\n" + "push " + entry.getOffset()
					+ "\n" + "lfp\n" + getAR + "add\n";

		}

		// return "lfp\n" + parCode + "lfp\n" + getAR + "lfp\n" + getAR + "push
		// " + entry.getOffset() + "\n" + "add\n"
		// + "lw\n" + "js\n";

	}

}