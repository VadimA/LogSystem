package nc.anosov.logsystem.util;

public final class Source {

	public Source(StackTraceElement [] ste){
		this.ste = ste;
	}
	
	static StackTraceElement [] ste;
    
    public static String getSourceClassName(){
        String callerClassName = null;
        int i =1;
        while(i<ste.length&&ste[i].getMethodName().startsWith("access$")){
        	++i;
        }
        if(i<ste.length){
        	callerClassName = ste[i].getClassName();
        }
        return callerClassName;
    }
    
    public static String getSourceMethodName(){
        String callerMethodName = null;
        int i =1;
        while(i<ste.length&&ste[i].getMethodName().startsWith("access$")){
        	++i;
        }
        if(i<ste.length){
        	callerMethodName = ste[i].getMethodName();
        }
        return callerMethodName;
    }
    public static int getLine(){
        int line = 0;
        int i =1;
        while(i<ste.length&&ste[i].getMethodName().startsWith("access$")){
        	++i;
        }
        if(i<ste.length){
        	line = ste[i].getLineNumber();
        }
        return line;
    }
	
}
