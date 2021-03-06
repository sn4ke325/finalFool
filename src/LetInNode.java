import java.util.ArrayList;

public class LetInNode implements Node {

	private ArrayList<Node> declist;
	private Node exp;

	public LetInNode(ArrayList<Node> d, Node e) {
		declist = d;
		exp = e;
	}

	public String toPrint(String s) {
		String declstr = "";
		for (Node dec : declist)
			declstr += dec.toPrint(s + "  ");
		return s + "LetIn\n" + declstr + exp.toPrint(s + "  ");
	}

	public Node typeCheck() {
		for (Node dec : declist)
			dec.typeCheck();
		return exp.typeCheck();
	}

	public String codeGeneration() {
		String declcode = "";
		for (Node dec : declist)
			declcode += dec.codeGeneration();
		return "push 0\n" + declcode + exp.codeGeneration() + "halt\n" + FOOLlib.getCode();
	}

}