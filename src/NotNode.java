
public class NotNode implements Node {

	private Node exp;

	public NotNode(Node e) {

		exp = e;

	}

	@Override
	public String toPrint(String s) {
		// TODO Auto-generated method stub
		return s + "not\n" + exp.toPrint(s + " ");
	}

	@Override
	public Node typeCheck() {
		if (!(FOOLlib.isSubtype(exp.typeCheck(), new BoolTypeNode()))){
			System.out.println("Non boolean in not");
			System.exit(0);
		}
		return new BoolTypeNode();
	}

	@Override
	public String codeGeneration() {
		String labelTrue = FOOLlib.freshLabel();
		String labelEnd = FOOLlib.freshLabel();
		
		return exp.codeGeneration() +
				"push 0\n"+
				"beq " + labelTrue + "\n"+
				"push 0\n" + 
				"b " + labelEnd + "\n"+				
				labelTrue + ":\n"+
				"push 1\n"+
				labelEnd + ":\n";
	}

}
