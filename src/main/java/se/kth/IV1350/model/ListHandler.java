/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.model;

/**
 *
 * @author jakobgotberg
 */
public class ListHandler {
    
    /**
     * Package private constructor.
     */
    ListHandler(){
    }
    
    /**
     * The coder was not very familiar with ArrayLists and LinkedLists in java. This way seemed easiest at the time.
     * Creates new list with room for one more element than <code>listOfProducts</code>, assigns all the old products to new list.
     * Adds <code>newProduct</code> at the last place. Clears old list from memory, thanks to GB.
     * @param listOfProducts List of all registered products.
     * @param newProduct Product to add to the list.
     * @return <code>newListOfProducts</code>
     */
    public Product[] addProduct(Product[] listOfProducts, Product newProduct) {
		
		Product[] newListOfProducts = new Product[listOfProducts.length + 1];
		
		for(int i = 0; i < listOfProducts.length; i++) 
			newListOfProducts[i] = listOfProducts[i];
			
		newListOfProducts[newListOfProducts.length-1] = newProduct;
		listOfProducts = null;
		
		return newListOfProducts;
		
	}
}
