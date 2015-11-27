
package nc.anosov.logsystem.output;

import nc.anosov.logsystem.rec.LogRecord;

public abstract class LogOutput {
    
    public abstract void write(LogRecord record);
    public abstract void write(LogRecord record, String trace);
}
