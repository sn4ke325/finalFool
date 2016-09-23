
public class ClassCallNode implements Node {

	private String id1;
	private String id2;
	private CTentry entry;
	private CTentry methodEntry;
	private int nl;

	public ClassCallNode(String s1, String s2, CTentry e, CTentry me, int n) {
		id1 = s1;
		id2 = s2;
		entry = e;
		methodEntry = me;
		nl = n;
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
