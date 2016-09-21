import java.util.HashMap;

public class FOOLlib {

	private static int labCount = 0;

	private static int funLabCount = 0;

	private static String funCode = "";

	private static HashMap<String, String> superType = null;

	public void putSuperType(HashMap<String, String> hm) {
		superType = hm;
	}

	public static boolean isSubtype(ClassNode a, ClassNode b) {

		return b.getId().equals(superType.get(a.getId()));
	}

	// valuta se il tipo "a" � <= al tipo "b", dove "a" e "b" sono tipi di
	// base: int o bool
	public static boolean isSubtype(Node a, Node b) {
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