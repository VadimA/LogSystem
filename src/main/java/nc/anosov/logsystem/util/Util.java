package nc.anosov.logsystem.util;

import nc.anosov.logsystem.level.Level;
import nc.anosov.logsystem.output.LogOutput;
import nc.anosov.logsystem.output.OutputConst;
import nc.anosov.logsystem.output.Record;

public final class Util {

	public static OutputConst getOutput(String out)throws IllegalArgumentException{
		if(OutputConst.CONSOLE.toString().equalsIgnoreCase(out)){
			return OutputConst.CONSOLE;
		}
		else if(OutputConst.FILE.toString().equalsIgnoreCase(out)){
			return OutputConst.FILE;
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	public static Level getLevel(String level)throws IllegalArgumentException{
		if(Level.DEBUG.name().equalsIgnoreCase(level)){
			return Level.DEBUG;
		}
		else if(Level.INFO.name().equalsIgnoreCase(level)){
			return Level.INFO;
		}
		else if(Level.WARNING.name().equalsIgnoreCase(level)){
			return Level.WARNING;
		}
		else if(Level.ERROR.name().equalsIgnoreCase(level)){
			return Level.ERROR;
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	public static String getMessage(String out){
		return out;
	}
	
}
