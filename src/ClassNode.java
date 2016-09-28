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
			// controllo campi
			for (int i = 0; i < superEntry.getAllFields().size(); i++) {
				if (!FOOLlib.isSubtype(((FieldNode) classEntry.getAllFields().get(i)).getType(),
						((FieldNode) superEntry.getAllFields().get(i)).getType())) {
					System.out.println("Wrong type for " + (i + 1) + "-th field. Incorrect inheritance of fields");
					System.exit(0);
				}
			}
			// controllo metodi
			// verifico che il tipo di ritorno di ciascun metodo corrisponda a
			// quello ereditato
			// inoltre controllo che i tipi e il numero dei parametri per
			// ciascun metodo corrisponda con quello ereditato
			for (int i = 0; i < superEntry.getAllMethods().size(); i++) {
				if (!FOOLlib.isSubtype(((MethodNode) classEntry.getAllMethods().get(i)).getType(),
						((MethodNode) superEntry.getAllMethods().get(i)).getType())) {
					System.out.println(
							"Wrong return type for " + (i + 1) + "-th method. Incorrect inheritance of methods");
					System.exit(0);
				}
				ArrayList<Node> cplist = ((MethodNode) classEntry.getAllMethods().get(i)).getParList();
				ArrayList<Node> splist = ((MethodNode) superEntry.getAllMethods().get(i)).getParList();
				if (cplist.size() != splist.size()) {
					System.out.println("Wrong number of parameters for the " + (i + 1)
							+ "-th method. Wrong inheritance of method");
					System.exit(0);
				}
				for (int j = 0; j < splist.size(); j++) {
					if (!FOOLlib.isSubtype(cplist.get(j), splist.get(j))) {
						System.out.println(
								"Wrong parameter type for the " + (i + 1) + "-th method. Wrong inheritance of method");
						System.exit(0);
					}
				}
			}
		}
		return null;
	}

	@Override
	public String codeGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

}
