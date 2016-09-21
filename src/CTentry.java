import java.util.ArrayList;
import java.util.HashMap;

//entry che memorizza le informazioni di un campo all'interno della classe
public class CTentry {
	private HashMap<String, STentry> vTable;
	private int offsetFields;
	private int offsetMethods;
	private ArrayList<Node> allFields;
	private ArrayList<Node> allMethods;

	public CTentry() {
		vTable = new HashMap<String, STentry>();
		offsetFields = -2;
		offsetMethods = 0;
		allFields = new ArrayList<Node>();
		allMethods = new ArrayList<Node>();
	}
	
	public CTentry(CTentry sc){//sc=superclass
		
		
	}

	public boolean addField(Node f){
		return false;
	}
	
	public boolean addMethod(Node m){
		return false;
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
