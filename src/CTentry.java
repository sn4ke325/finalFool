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

	public void addField(FieldNode field, int nl) {
		boolean overrides = false;
		int index = 0;
		int offset = offsetFields;
		for (Node n : allFields) {
			if (field.getId().equals(((FieldNode) n).getId())) {
				overrides = true;
				index = allFields.indexOf(n);
				offset = ((FieldNode) n).getOffset();
				break;
			}
		}
		if (overrides) {
			field.setOffset(offset);
			allFields.set(index, field);
			vTable.put(field.getId(), new STentry(nl, field.getType(), offset));
		} else {
			field.setOffset(offsetFields);
			allFields.add(field);
			vTable.put(field.getId(), new STentry(nl, field.getType(), offsetFields--));
		}

	}

	public void addMethod(MethodNode method, ArrowTypeNode atn, int nl) {
		boolean overrides = false;
		int index = 0;
		int offset = offsetMethods;
		for (Node n : allMethods) {
			if (method.getId().equals(((MethodNode) n).getId())) {
				overrides = true;
				index = allMethods.indexOf(n);
				offset = ((MethodNode) n).getOffset();
				break;
			}
		}
		if (overrides) {
			method.setOffset(offset);
			allMethods.add(method);
			STentry entry = new STentry(nl, atn, offset);
			entry.setAsMethod(true);
			vTable.put(method.getId(), entry);

		} else {
			method.setOffset(offsetMethods);
			allMethods.add(method);
			STentry entry = new STentry(nl, atn, offsetMethods++);
			entry.setAsMethod(true);
			vTable.put(method.getId(), entry);
		}

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
