/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.model;

/**
 * This class is a description of the actual product, with all necessary data and functions 
 * needed to preform the sale.
 * @author jakobgotberg
 */
public class Product {
    
    private int quantity;
    private double price;
    private double VAT;
    private String itemDescription;
    
    /**
     * Creates instance of a DTO representing a product.
     * @param price
     * @param VAT
     * @param itemDescription 
     */
    
    public Product(double price, double VAT, String itemDescription){
	this.price = price;
	this.VAT = VAT;
        this.quantity = 1;
	this.itemDescription = itemDescription;
		
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public String getItemDescription() {
		return this.itemDescription;
	}
	
	public double getVAT() {
		return this.VAT;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
        /**
         * Increases the integer field "quantity" by 1.
         */
	public void incrementQuantity() {
		this.quantity++;
	}
	
}
