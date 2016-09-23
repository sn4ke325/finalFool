import java.util.ArrayList;

public class NewNode implements Node {

	private String id;
	private ArrayList<Node> param = new ArrayList<Node>();
	private CTentry entry;

	public NewNode(String s, CTentry e) {
		id = s;
		entry = e;
	}

	public NewNode(String s, ArrayList<Node> p, CTentry e) {
		id = s;
		param = p;
		entry = e;

	}

	@Override
	public String toPrint(String indent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node typeCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String codeGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

}
