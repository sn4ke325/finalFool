import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//entry che memorizza le informazioni di un campo all'interno della classe
public class CTentry {
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

	/*public Node addField(String id, Node ty, int nl) {
		FieldNode n = new FieldNode(id, ty);
		allFields.add(n);
		vTable.put(id, new STentry(nl, ty, offsetFields--));
		return n;
	}*/

	public void addField(FieldNode field, int nl) {
		allFields.add(field);
		vTable.put(field.getId(), new STentry(nl, field.getType(), offsetFields--));
	}

	/*
	 * public Node addMethod(String id, Node ty, int nl) { MethodNode n = new
	 * MethodNode(id, ty); allMethods.add(n); STentry entry = new STentry(nl,
	 * ty, offsetMethods++); entry.setAsMethod(true); vTable.put(id, entry);
	 * return n;
	 * 
	 * }
	 */

	public void addMethod(MethodNode method, int nl) {
		allMethods.add(method);
		STentry entry = new STentry(nl, method.getType(), offsetMethods++);
		entry.setAsMethod(true);
		vTable.put(method.getId(), entry);

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

	public ArrayList<Node> fieldTypeList() {
		ArrayList<Node> types = new ArrayList<Node>();
		for (Node n : allFields) {
			types.add(n.typeCheck());
		}
		return types;
	}
}
