public class LENode implements Node {

	private Node left;
	private Node right;

	public LENode(Node l, Node r) {
		left = l;
		right = r;

	}

	public String toPrint(String s) {
		return s + "<=\n" + left.toPrint(s + "  ") + right.toPrint(s + "  ");

	}

	public Node typeCheck() {
		if (!(FOOLlib.isSubtype(left.typeCheck(), new IntTypeNode())
				&& FOOLlib.isSubtype(right.typeCheck(), new IntTypeNode()))) {
			System.out.println("Non integers in <=");
			System.exit(0);
		}
		return new BoolTypeNode();
	}

	public String codeGeneration() {
		String labelTrue = FOOLlib.freshLabel();
		String labelEnd = FOOLlib.freshLabel();

		return left.codeGeneration() + right.codeGeneration() + "bless " + labelTrue + "\n" + "push 0\n" + "b "
				+ labelEnd + "\n" + labelTrue + ":\n" + "push 1\n" + labelEnd + ":\n";

	}

}
