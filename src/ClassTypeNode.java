
public class ClassTypeNode implements Node {

	private String id;

	public ClassTypeNode(String s) {
		id = s;
	}

	@Override
	public String toPrint(String s) {
		// TODO Auto-generated method stub
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
