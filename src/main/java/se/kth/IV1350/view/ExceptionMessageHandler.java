package se.kth.IV1350.view;

public class ExceptionMessageHandler {
    /**
     * Prints out an error message to System.out, using the "getMessage" method.
     * @param exc Exception thrown by controller.
     */
	void generateErrorMsg(Exception exc) {
		String errorMsg = "System failure! " + exc.getMessage();
		System.out.println(errorMsg + "\n");
		
	}
	
      /**
     * Prints out an error message to System.out.
     * @param msg Given String to print out.
     */
        void generateErrorMsg(String msg) {
		String errorMsg = "System failure! " + msg;
		System.out.println(errorMsg + "\n");
		
	}
}
