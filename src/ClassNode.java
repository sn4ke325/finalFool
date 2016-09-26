import java.util.ArrayList;

public class ClassNode implements Node {
	private String id;
	private ArrayList<Node> methods = new ArrayList<Node>();
	private ArrayList<Node> fields = new ArrayList<Node>();

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
	
	public ArrayList<Node> getFields(){
		return fields;
	}
	
	public ArrayList<Node> getMethods(){
		return methods;
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
