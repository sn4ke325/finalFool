public class OrNode implements Node {

	private Node left;
	private Node right;

	public OrNode(Node l, Node r) {
		left = l;
		right = r;

	}

	public String toPrint(String s) {
		return s + "Or\n" + left.toPrint(s + "  ") + right.toPrint(s + "  ");
	}

	public Node typeCheck() {
		if (!(FOOLlib.isSubtype(left.typeCheck(), new BoolTypeNode())
				&& FOOLlib.isSubtype(right.typeCheck(), new BoolTypeNode()))) {
			System.out.println("Non boolean in OR");
			System.exit(0);
		}
		return new BoolTypeNode();
	}

	public String codeGeneration() {
		String labelTrue = FOOLlib.freshLabel();
		String labelEnd = FOOLlib.freshLabel();

		return left.codeGeneration() + "push 1\n" + "beq " + labelTrue + "\n" +

				right.codeGeneration() + "push 1\n" + "beq " + labelTrue + "\n" +

				"push 0\n" + "b " + labelEnd + "\n" +

				labelTrue + ":\n" + "push 1\n" + labelEnd + ":\n";

	}

}
