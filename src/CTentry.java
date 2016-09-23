import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//entry che memorizza le informazioni di un campo all'interno della classe
public class CTentry<V, K> {
	private HashMap<String, STentry> vTable = new HashMap<String, STentry>();
	private int offsetFields;
	private int offsetMethods;
	private ArrayList<Node> allFields = new ArrayList<Node>();
	private ArrayList<Node> allMethods = new ArrayList<Node>();

	public CTentry() {
		offsetFields = -2;// decrementa
		offsetMethods = 0;// incrementa
	}

	public void extendsClass(CTentry sc) {// sc=superclass
		vTable = new HashMap<String, STentry>(sc.getVTable());
		offsetFields = sc.getOffsetFields();
		offsetMethods = sc.getOffsetMethods();
		allFields = new ArrayList<Node>(sc.getAllFields());
		allMethods = new ArrayList<Node>(sc.getAllMethods());

	}

	public Node addField(String id, Node ty, int nl) {
		FieldNode n = new FieldNode(id, ty);
		allFields.add(n);
		vTable.put(id, new STentry(nl, ty, offsetFields--));
		return n;
	}

	public Node addMethod(String id, Node ty, int nl) {
		MethodNode n = new MethodNode(id, ty);
		allMethods.add(n);
		STentry entry = new STentry(nl, ty, offsetMethods++);
		entry.setAsMethod(true);
		vTable.put(id, entry);
		return n;

	}

	public HashMap<String, STentry> getVTable() {
		return vTable;
	}

	public ArrayList<Node> getAllFields() {
		return allFields;
	}

	public ArrayList<Node> getAllMethods() {
		return allMethods;
	}

	public int getOffsetFields() {
		return offsetFields;
	}

	public int getOffsetMethods() {
		return offsetMethods;
	}
}
