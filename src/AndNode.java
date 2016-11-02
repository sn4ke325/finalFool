public class AndNode implements Node {

	private Node left;
	private Node right;

	public AndNode(Node l, Node r) {
		left = l;
		right = r;

	}

	public String toPrint(String s) {
		return s + "And\n" + left.toPrint(s + "  ") + right.toPrint(s + "  ");
	}

	public Node typeCheck() {
		if (!(FOOLlib.isSubtype(left.typeCheck(), new BoolTypeNode())
				&& FOOLlib.isSubtype(right.typeCheck(), new BoolTypeNode()))) {
			System.out.println("Non boolean in AND");
			System.exit(0);
		}
		return new BoolTypeNode();
	}

	public String codeGeneration() {
		String labelFalse = FOOLlib.freshLabel();
		String labelEnd = FOOLlib.freshLabel();

		/*
		 * return left.codeGeneration() + "push 1\n" + "beq " + labelTrue2 +
		 * "\n" + "push 0\n" + "b " + labelEnd + "\n" +
		 * 
		 * labelTrue2 + ":\n" + "push 1\n" + right.codeGeneration() + "beq " +
		 * labelTrue + "\n" + "push 0\n" + "b " + labelEnd + "\n" +
		 * 
		 * labelTrue + ":\n" + "push 1\n" +
		 * 
		 * labelEnd + ":\n";
		 */

		return left.codeGeneration() + "push 0\n" + "beq " + labelFalse + "\n" + right.codeGeneration() + "push 0\n"
				+ "beq " + labelFalse + "\n" + "push 1\n" + "b " + labelEnd + "\n" + labelFalse + ":\n" + "push 0\n"
				+ labelEnd + ":\n";
	}

}