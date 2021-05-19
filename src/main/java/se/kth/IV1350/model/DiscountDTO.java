/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.model;

/**
 * DTO with data about the sale and the costumer.
 * @author jakobgotberg
 */
public class DiscountDTO {
    
    private int costumerID;
    private double totalPrice;
    private double totalVAT;
    private Product[] listOfProducts;
    
    /**
     * Creates instance of class.
     * @param costumerID
     * @param listOfProducts
     * @param totalPrice
     * @param totalVAT 
     */
    
    public DiscountDTO(int costumerID, Product[] listOfProducts, double totalPrice, double totalVAT){
        this.costumerID = costumerID;
        this.totalPrice = totalPrice;
        this.totalVAT = totalVAT;
        this.listOfProducts = listOfProducts;
    }
    
    public int getCotumerID(){
        return costumerID;
    }
    
    public double getTotalPrice(){
        return totalPrice;
    }
    
    public double getTotalVAT(){
        return totalVAT;
    }
    
    public Product[] getListOfProducts(){
        return listOfProducts;
    }
}
