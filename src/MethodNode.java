
public class MethodNode extends FunNode {

	private int offset;

	public MethodNode(String i, Node t, int o) {
		super(i, t);
		offset = o;
		// TODO Auto-generated constructor stub
	}

	public int getOffset() {
		return offset;
	}

}
