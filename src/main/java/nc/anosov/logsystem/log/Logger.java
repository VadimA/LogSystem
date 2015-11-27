
package nc.anosov.logsystem.log;

import nc.anosov.logsystem.level.Level;
import nc.anosov.logsystem.output.LogOutput;
import nc.anosov.logsystem.output.OutputConst;
import nc.anosov.logsystem.output.Record;
import nc.anosov.logsystem.rec.LogRecord;
import nc.anosov.logsystem.util.Source;
import nc.anosov.logsystem.util.StackTraceUtil;

public class Logger {
	
    private final String nameLog;
    private LogRecord record;
    private LogOutput output;
    private Level level;
    private String message;
    
    public Logger(String name){
        record = new LogRecord(this);
        nameLog = name;
        output  = Record.getWriter(OutputConst.CONSOLE);
        level = Level.DEBUG;
    }
    
    public LogOutput getOutput() {
        return output;
    }

    public void setOutput(OutputConst out) {
       output = Record.getWriter(out);
    }

    public String getLevel() {
        return level.toString();
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public void info(String msg){
        System.out.println("[INFO] - " + msg);
    }
    public void warning(String msg){
        System.out.println("[WARNING] - " + msg);
    }
    public void log(String message){
        this.message = message;
    	Throwable th = new Throwable();
    	StackTraceElement [] ste = th.getStackTrace();
    	Source sc = new Source(ste);
        output.write(record);
    }

    public void log(String message, Throwable th){
        this.message = message;
    	Throwable th2 = new Throwable();
    	StackTraceElement [] ste2 = th2.getStackTrace();
    	Source sc = new Source(ste2);
    	output.write(record,StackTraceUtil.getStackTrace(th));
    }
}
