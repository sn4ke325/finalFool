
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
		return s + "Method:" + id + type.toPrint(" ") + parlstr + declstr + body.toPrint(s + "  ");
	}

	public String codeGeneration() {

		String methl = FOOLlib.freshFunLabel();
		String popParSequence = "";
		for (Node n : parlist) {
			popParSequence += "pop\n";
			if (((DecNode) n).getSymType() instanceof ArrowTypeNode)
				popParSequence += "pop\n";
		}

		String popDecSequence = "";
		for (Node n : declist) {
			popDecSequence += "pop\n";
			if (((DecNode) n).getSymType() instanceof ArrowTypeNode)
				popDecSequence += "pop\n";
		}

		String declCode = "";
		for (Node n : declist)
			declCode += n.codeGeneration();

		FOOLlib.putCode(methl + ":\n" + "cfp\n" + "lra\n" + declCode + body.codeGeneration() + "srv\n" + popDecSequence
				+ "sra\n" + "sfp\n" + popParSequence + "pop\n" + "lrv\n" + "lra\n" + "js\n");
		return "";
	}

}
