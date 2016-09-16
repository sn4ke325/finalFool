import java.util.ArrayList;

public class CallNode implements Node {

  private String id;
  private STentry entry; 
  private ArrayList<Node> parlist; 
  private int nl;
  
  public CallNode (String i, STentry e, ArrayList<Node> p, int n) {
    id=i;
    entry=e;
    parlist = p;
    nl =n;
  }
  
  public String toPrint(String s) {  //
    String parlstr="";
	for (Node par:parlist)
	  parlstr+=par.toPrint(s+"  ");		
	return s+"Call:" + id + " at nestlev " + nl + "\n" 
           +entry.toPrint(s+"  ")
           +parlstr;        
  }
  
  public Node typeCheck () {  //                           
	 ArrowTypeNode t=null;
     if (entry.getType() instanceof ArrowTypeNode) t=(ArrowTypeNode) entry.getType(); 
     else {
       System.out.println("Invocation of a non-function "+id);
       System.exit(0);
     }
     ArrayList<Node> p = t.getParList();
     if ( !(p.size() == parlist.size()) ) {
       System.out.println("Wrong number of parameters in the invocation of "+id);
       System.exit(0);
     } 
     for (int i=0; i<parlist.size(); i++) 
       if ( !(FOOLlib.isSubtype( (parlist.get(i)).typeCheck(), p.get(i)) ) ) {
         System.out.println("Wrong type for "+(i+1)+"-th parameter in the invocation of "+id);
         System.exit(0);
       } 
     return t.getRet();
  }
  
  public String codeGeneration() {
		return "";
  }
    
}  