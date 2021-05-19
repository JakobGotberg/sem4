/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.model;

import java.util.Date;

/**
 * A DTO class with data about the sale.
 * @author jakobgotberg
 */
public class SaleDTO {
    
    private Product[] listOfProducts;
    private double totalPayment;
    private double amountPayed;
    private double change;
    private double totalVAT;
    
    /**
     * Creates instance of the DTO.
     * @param listOfPrducts
     * @param totalPayment
     * @param amountPayed
     * @param change
     * @param totalVAT 
     */
    
    public SaleDTO(Product[] listOfPrducts, double totalPayment, double amountPayed, double change, double totalVAT){
        
        this.listOfProducts = listOfPrducts;
        this.totalPayment = totalPayment;
        this.amountPayed = amountPayed;
        this.change = change;
        this.totalVAT = totalVAT;
    }
    
    public Product[] getProductList(){
        return this.listOfProducts;
    }
    
    public double getTotalPayment(){
        return this.totalPayment;
    }
    
    public double getAmountPayed(){
        return this.amountPayed;
    }
    
    public double getChange(){
        return this.change;
    }
    
    public double getTotalVAT(){
        return this.totalVAT;
    }
}
