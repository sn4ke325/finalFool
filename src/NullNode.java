
public class NullNode implements Node {

	public NullNode() {

	}

	public String toPrint(String s) {

		return s + "null\n";
	}

	public Node typeCheck() {
		return null;
	}

	public String codeGeneration() {

		return "push null\n";
	}

}
