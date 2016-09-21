import java.util.ArrayList;

public class ClassNode implements Node {
	private String id;
	private ArrayList<Node> methods = new ArrayList<Node>();
	private ArrayList<Node> parlist = new ArrayList<Node>();
	private Node letin;

	public ClassNode(String l) {
		id = l;
	}

	public void addLetIn(Node n) {
		letin = n;
	}

	public void addPar(Node par) {
		parlist.add(par);
	}

	public void addMethod(Node m) {
		methods.add(m);
	}

	public String getId() {
		return id;
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
