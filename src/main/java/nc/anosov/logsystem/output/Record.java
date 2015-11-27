package nc.anosov.logsystem.output;

import java.io.Console;
import java.io.File;

public abstract class Record {

	public static LogOutput getWriter(OutputConst out){
		LogOutput writer = null;
		if(out == OutputConst.FILE){
			writer = new FileOutput();
		}
		else if( out == OutputConst.CONSOLE){
			writer = new ConsoleOutput();
		}
		return writer;
	}
}
