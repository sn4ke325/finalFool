
public class ClassTypeNode implements Node {

	private String id;

	public ClassTypeNode(String s) {
		id = s;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toPrint(String s) {
		return s + id + " Type\n";
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
