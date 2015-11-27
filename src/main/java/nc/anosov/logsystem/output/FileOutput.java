
package nc.anosov.logsystem.output;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import nc.anosov.logsystem.rec.LogRecord;

public class FileOutput extends LogOutput{
	@Override
    public void write(LogRecord record) {
        File file = new File("test.txt");
        try{
        	if(!file.exists()){
        		file.createNewFile();
        	}
        	PrintWriter out = new PrintWriter(file.getAbsoluteFile());
        	try{
        		out.print(record.toString());
        	}finally{
        		out.close();
        	}
        }catch(IOException e){
        	System.out.println(e);
        }
    }

	@Override
	public void write(LogRecord record, String trace) {
        File file = new File("test.txt");
        try{
        	if(!file.exists()){
        		file.createNewFile();
        	}
        	PrintWriter out = new PrintWriter(file.getAbsoluteFile());
        	try{
        		out.print(record.toString() + trace);
        	}finally{
        		out.close();
        	}
        }catch(IOException e){
        	System.out.println(e);
        }
	}
}
