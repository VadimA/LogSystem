
package nc.anosov.logsystem.rec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import nc.anosov.logsystem.log.*;
import nc.anosov.logsystem.util.Source;

public class LogRecord {
    
    private static Logger logger;
    private static DateFormat dateFormat;
    private static Date date = new Date();
    
    public LogRecord(Logger logger){
    	this.logger = logger;
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        date = new Date();
    }
    
    public static String getLevel(){
        return logger.getLevel();
    }
    
    public String getLoggerName(){
        return logger.getClass().getName();
    }
    
    public String getMessage(){
        return logger.getMessage();
    }
   
    public static String getTime(){
       return dateFormat.format(date);
    }
    
    public String toString(){
        return "[" + getMessage() +"]" + "\n" + "[" + getLevel() + "] " + "- " + getTime() +
                "-" + Source.getSourceClassName() + "." + Source.getSourceMethodName() + " : " + Source.getLine();
    }
}
