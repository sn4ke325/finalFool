
public class DebugGlobal {

     static String debugInfo = "";
     static int tab = 0;

     public static void increaseTab (){
    	 tab += 1;
     }
     
     public static void decreaseTab (){
    	 tab -= 1;
     }
     
     public static String getdebugInfo(){
         return debugInfo;
     }

     public static void setdebugInfo(String s){
    	 for(int i=0; i<tab; i++){
    		 debugInfo += "\t";
        }
    	 
         debugInfo += s+"\n";
     }
     
     public static void setdebugInfoAndTab(String s){
    	 increaseTab ();
    	 setdebugInfo(s);
    	 decreaseTab ();
     }
     
     public static void initializedebugInfo(){
    	 debugInfo = "";
    	 tab = 0;
     }
     
     public static void setdebugInfoInLine(String s){
    	 for(int i=0; i<tab; i++){
    		 debugInfo += "\t";
        }
    	 
         debugInfo += s;
     }
     
     
}