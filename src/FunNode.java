import java.util.ArrayList;

public class FunNode implements Node {

	private String id;
	private Node type;
	private ArrayList<Node> parlist = new ArrayList<Node>();
	private ArrayList<Node> declist = new ArrayList<Node>();
	private Node body;

	public FunNode(String i, Node t) {
		id = i;
		type = t;
	}

	public void addDec(ArrayList<Node> d) {
		declist = d;
	}

	public void addBody(Node b) {
		body = b;
	}

	public void addPar(Node p) {
		parlist.add(p);
	}

	public String toPrint(String s) {
		String parlstr = "";
		for (Node par : parlist)
			parlstr += par.toPrint(s + "  ");
		String declstr = "";
		for (Node dec : declist)
			declstr += dec.toPrint(s + "  ");
		return s + "Fun:" + id + "\n" + type.toPrint(s + "  ") + parlstr + declstr + body.toPrint(s + "  ");
	}

	public String codeGeneration() {

		String funl = FOOLlib.freshFunLabel();

		FOOLlib.putCode(funl + ":\n" + "codice della funzione");

		return "push " + funl + "\n";
	}

	// valore di ritorno non utilizzato
	public Node typeCheck() {
		for (Node dec : declist)
			dec.typeCheck();
		if (!(FOOLlib.isSubtype(body.typeCheck(), type))) {
			System.out.println("Wrong return type for function " + id);
			System.exit(0);
		}
		return null;
	}

}