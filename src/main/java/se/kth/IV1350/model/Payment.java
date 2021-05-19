/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.model;

/**
 * A DTO containing the the total price of the sale and the total VAT.
 * @author jakobgotberg
 */
public class Payment {
    
    private double totalPayment;
    private double totalVAT;
    
    /**
     * Creates instance of class.       
     * @param totalPayment The total price of the sale.
     * @param totalVAT The total VAT of the sale.
     */
    
    public Payment(double totalPayment, double totalVAT){
        this.totalPayment = totalPayment;
        this.totalVAT = totalVAT;
    }
    
    public double getAmount(){
        return this.totalPayment;
    }
    
    public double getVAT(){
        return this.totalVAT;
    }
}
