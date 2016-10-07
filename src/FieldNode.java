
public class FieldNode extends ParNode {

	private int offset;

	public FieldNode(String i, Node t) {
		super(i, t);
	}

	public void setOffset(int o) {
		offset = o;
	}

	public int getOffset() {
		return offset;
	}

	public String toPrint(String s) {
		return s + "Field: " + id + type.toPrint(" ");
	}

}
