
public class MethodNode extends FunNode {

	private int offset;

	public MethodNode(String i, Node t) {
		super(i, t);
	}

	public void setOffset(int o) {
		offset = o;
	}

	public int getOffset() {
		return offset;
	}

}
