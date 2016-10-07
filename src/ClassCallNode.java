import java.util.ArrayList;

public class ClassCallNode implements Node {

	private String id1;
	private String id2;
	private STentry entry;
	private STentry methodEntry;
	private ArrayList<Node> parlist;
	private int nl;

	public ClassCallNode(String s1, String s2, STentry e, STentry me, ArrayList<Node> par, int n) {
		id1 = s1;
		id2 = s2;
		entry = e;
		methodEntry = me;
		parlist = par;
		nl = n;
	}

	@Override
	public String toPrint(String s) {
		String parl = "";
		for(Node n: parlist)
			parl+=n.toPrint(s + "  ");

		return s + "Class Call: " + id1 + " to method "+ id2 + " at nestlev " + nl +"\n" + entry.toPrint(s + "  ") + methodEntry.toPrint(s + "  ") + parl;
	}

	@Override
	public Node typeCheck() {
		ArrowTypeNode t = null;

		if (methodEntry.getType() instanceof ArrowTypeNode) {
			// System.out.println("ho fatto instance of di ArrowTypeNode");
			t = (ArrowTypeNode) methodEntry.getType();
		} else {
			System.out.println("Invocation of a non-function " + id2);
			System.exit(0);
		}
		// controllo i parametri
		ArrayList<Node> p = t.getParList();
		if (!(p.size() == parlist.size())) {
			System.out.println("Wrong number of parameters in the invocation of " + id2);
			System.exit(0);
		}
		for (int i = 0; i < parlist.size(); i++)
			if (!(FOOLlib.isSubtype((parlist.get(i)).typeCheck(), p.get(i)))) {
				System.out.println("Wrong type for " + (i + 1) + "-th parameter in the invocation of " + id2);
				System.exit(0);
			}
		return t.getRet();
	}

	@Override
	public String codeGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

}
