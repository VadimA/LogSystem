package nc.anosov.logsystem.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class StackTraceUtil {

	public static String getStackTrace(Throwable aThrowable) {
	    Writer result = new StringWriter();
	    PrintWriter printWriter = new PrintWriter(result);
	    aThrowable.printStackTrace(printWriter);
	    return result.toString();
	  }
}
