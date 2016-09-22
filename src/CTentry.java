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
		offsetFields = -2;
		offsetMethods = 0;
	}

	public void extendsClass(CTentry sc) {// sc=superclass
		vTable = new HashMap<String, STentry>(sc.getVTable());
		offsetFields = sc.getOffsetFields();
		offsetMethods = sc.getOffsetMethods();
		allFields = new ArrayList<Node>(sc.getAllFields());
		allMethods = new ArrayList<Node>(sc.getAllMethods());

	}

	public void addField(FieldNode f) {

	}

	public void addMethod(MethodNode m) {
		
		if(vTable.get(m.getId()) != null){
			//vTable.put(m.getId(), new STentry())
		}
		
		allMethods.add(m);

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
