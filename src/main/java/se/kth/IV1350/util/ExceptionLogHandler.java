package se.kth.IV1350.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Logs all runtime exception, only the lower level exceptions are logged, not the ones printed with System.out.
 * @author jakobgotberg
 */

public class ExceptionLogHandler {

    private static final String EXCEPTION_LOG = "sem4_exception_log.txt";
    private PrintWriter logger;
    private TimeDateHandler tdHandler = new TimeDateHandler();
    
    /**
     * Creates instance of object. The PrintWriter <code>logger</code> will log the given exceptions to a .txt file.
     * @throws IOException Thrown if file can not be created/ found.
     */
    
    public ExceptionLogHandler() throws IOException {
        
        logger = new PrintWriter(new FileWriter(EXCEPTION_LOG), true);
    }  
    
    /**
     * Logs exception and time of exception to given .txt file.
     * @param exc This is the exception thrown by the <code>Controller</code> class, the "getCause" method is used to get the original message.
     */
    public void logException(Exception exc) {
    	logger.println(tdHandler.getTime() + " Exception: " + exc.getCause());
    }
}
