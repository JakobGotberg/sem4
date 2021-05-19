/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.integration;

import se.kth.IV1350.model.Product;

/**
 * This class is the external inventory system.
 * @author jakobgotberg
 */
public class Inventory {
    
    private Product[] allProducts;
	
    
    /**
     * Creates instance of class.
     */
	public Inventory(){
            
		this.allProducts = new Product[4];
		allProducts[0] = new Product(15, 0.12, "Milk");
		allProducts[1] = new Product(25, 0.12, "EggCarton");
		allProducts[2] = new Product(20, 0.12, "Bread");
		allProducts[3] = new Product(50, 0.25, "CookBook");
		
	}
        
        /**
         * Checks if given item description matches a product in the DB. Will return the first element in list if there is no match, instead of using an exception.
         * @param itemDescription
         * @return Will return the corresponding product if found.
         */
        public Product lookUpProduct(String itemDescription) throws InventoryException{
		
        if(itemDescription.equalsIgnoreCase("connectionFailureSimulationString"))
        	throw new ConnectionException(this);
           
		for(int i = 0; i < allProducts.length; i++)
			if( equalDescription( allProducts[i].getItemDescription(), itemDescription)) 
                            { return allProducts[i]; }
            
                throw new InventoryException(itemDescription);
               
		
	}
	
        private boolean equalDescription(String itemDescriptionInDB, String itemDescriptionSearched){
            return itemDescriptionInDB.equalsIgnoreCase(itemDescriptionSearched);
        }
        
        /**
         * Updates the inventory DB.
         * @param listOfProducts 
         */
	public void updateInventory(Product[] listOfProducts) {
		return;
	}
	
        
    
}
