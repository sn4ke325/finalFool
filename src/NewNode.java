import java.util.ArrayList;

public class NewNode implements Node {

	private String id;
	private ArrayList<Node> param = new ArrayList<Node>();
	private CTentry entry;

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
		ArrayList<Node> f = entry.getAllFields();
		if (!(param.size() == f.size())) {
			System.out.println("Wrong number of parameters in the invocation of " + id);
			System.exit(0);
		}
		for (int i = 0; i < param.size(); i++)
			if (!(FOOLlib.isSubtype((param.get(i)).typeCheck(), f.get(i)))) {
				System.out.println("Wrong type for " + (i + 1) + "-th parameter in the invocation of " + id);
				System.exit(0);
			}
		return new ClassTypeNode(id);
	}

	@Override
	public String codeGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

}
