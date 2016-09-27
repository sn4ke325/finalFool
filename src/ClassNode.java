import java.util.ArrayList;

public class ClassNode implements Node {
	private String id;
	private ArrayList<Node> methods = new ArrayList<Node>();
	private ArrayList<Node> fields = new ArrayList<Node>();
	private CTentry classEntry;
	private CTentry superEntry;

	public ClassNode(String l, CTentry cl) {
		id = l;
		classEntry = cl;
		superEntry = null;
	}

	public ClassNode(String l, CTentry cl, CTentry su) {
		id = l;
		classEntry = cl;
		superEntry = su;
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

	public ArrayList<Node> getFields() {
		return fields;
	}

	public ArrayList<Node> getMethods() {
		return methods;
	}

	@Override
	public String toPrint(String indent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node typeCheck() {
		for (Node n : methods) {
			n.typeCheck();
		}
		if (superEntry != null) {
			// devo controllare che overriding di campi e metodi sia corretto usando le due CTentry
			
		}
		return null;
	}

	@Override
	public String codeGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

}
