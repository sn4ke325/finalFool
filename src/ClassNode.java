import java.util.ArrayList;

public class ClassNode implements Node {
	private String id;
	private ArrayList<Node> methods = new ArrayList<Node>();
	private ArrayList<Node> fields = new ArrayList<Node>();
	private Node body;

	public ClassNode(String l) {
		id = l;
	}

	public void addMethod(Node m) {
		methods.add(m);
	}

	public void addField(Node f) {
		fields.add(f);
	}

	public String getId() {
		return id;
	}

	public void addBody(Node b) {
		body = b;
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
