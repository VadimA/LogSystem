
package nc.anosov.logsystem.output;

import nc.anosov.logsystem.rec.LogRecord;

public class ConsoleOutput extends LogOutput{
	
	@Override
    public void write(LogRecord record) {
    	System.out.println(record.toString());
    }

	@Override
	public void write(LogRecord record, String trace) {
		System.out.println(record.toString() + trace);
	}

}
