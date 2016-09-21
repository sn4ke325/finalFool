
public class EmptyNode implements Node {

	public EmptyNode() {

	}

	public String toPrint(String s) {

		return s + "null\n";
	}

	public Node typeCheck() {
		return new EmptyTypeNode();
	}

	public String codeGeneration() {

		return "push null\n";
	}

}
