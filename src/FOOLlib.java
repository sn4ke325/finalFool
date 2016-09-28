import java.util.HashMap;

public class FOOLlib {

	private static int labCount = 0;

	private static int funLabCount = 0;

	private static String funCode = "";

	private static HashMap<String, String> superType = null;

	public static void putSuperType(HashMap<String, String> hm) {
		superType = hm;
	}

	// valuta se il tipo "a" � <= al tipo "b", dove "a" e "b" sono tipi di
	// base: int o bool
	public static boolean isSubtype(Node a, Node b) {
		if (a instanceof EmptyTypeNode && b instanceof ClassTypeNode)
			return true;
		if (a instanceof ClassTypeNode && b instanceof ClassTypeNode) {
			String ida = ((ClassTypeNode) a).getId();
			String idb = ((ClassTypeNode) b).getId();
			return (ida.equals(idb)) || superType.get(ida).equals(idb);
		}
		return a.getClass().equals(b.getClass()) || ((a instanceof BoolTypeNode) && (b instanceof IntTypeNode)); //
	}

	public static String freshLabel() {
		return "label" + (labCount++);
	}

	public static String freshFunLabel() {
		return "function" + (funLabCount++);
	}

	public static void putCode(String c) {
		funCode += "\n" + c;
	}

	public static String getCode() {
		return funCode;
	}
}