
public class MethodNode extends FunNode {

	private int offset;
	private String label;

	public MethodNode(String i, Node t) {
		super(i, t);
	}

	public void setOffset(int o) {
		offset = o;
	}

	public int getOffset() {
		return offset;
	}

	public void setLabel(String l) {
		label = l;
	}

	public String getLabel() {
		return label;
	}

	public String toPrint(String s) {
		String parlstr = "";
		for (Node par : parlist)
			parlstr += par.toPrint(s + "  ");
		String declstr = "";
		for (Node dec : declist)
			declstr += dec.toPrint(s + "  ");
		return s + "Method:" + id  + type.toPrint(" ") + parlstr + declstr + body.toPrint(s + "  ");
	}

	public String codeGeneration() {

		FOOLlib.putCode(label + ":\n" + "codice del metodo");
		return "";
	}

}
