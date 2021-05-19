package se.kth.IV1350.controller;

/**
 * Thrown when the system is not working as intended, as the name suggests it can be applied to a variety of errors. 
 * Since it is so general, the exception has no hardcoded message itself. Unchecked exception.
 * @author jakobgotberg
 */

public class SystemException extends RuntimeException{
	

    /**
     * Creates instance if lower level classes throws a runtime exception.
     * @param msg Appropriate message containing information about the exception.
     * @param exc Lower level exception.
     */
	public SystemException(String msg, Exception exc) {
		super(msg, exc);
	}

}
