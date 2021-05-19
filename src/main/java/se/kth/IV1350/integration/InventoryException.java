package se.kth.IV1350.integration;

/**
 * Thrown when the process in the inventory fails. The name is quite general in order to make it more versatile in case it the program expanded
 * and the exception was at more than one place.
 * @author jakobgotberg
 */

public class InventoryException extends Exception{
    
    /**
     * Creates instance of exception when the given item description does not match any of the products in the inventory.  
     * @param itemDescription Given String containing item description.
     */

	public InventoryException(String itemDescription) {
		super("Item description \"" + itemDescription + "\" is an invalid item description.");
	}

	

}
