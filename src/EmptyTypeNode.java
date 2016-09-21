
public class EmptyTypeNode implements Node {

	@Override
	public String toPrint(String s) {

		return s + "EmptyType\n";
	}

	@Override
	public Node typeCheck() {

		return null;
	}

	@Override
	public String codeGeneration() {

		return "";
	}

}
