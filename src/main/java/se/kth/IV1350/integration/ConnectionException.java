package se.kth.IV1350.integration;

        /**
	 * Unchecked exception, is thrown if the connection with the server fails. Runtime exception
	 */
public class ConnectionException extends RuntimeException{
    
        /**
         * Creates instance of exception when connection with server has failed.
         * @param obj Specifies the class.
         */
	public ConnectionException(Object obj) {
                
		super("SQL-ERROR " + obj.getClass().toString() + " SERVER_CONNECTION_FAILURE");
	}
        
        

}
