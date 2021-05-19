/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the cash register in the store.
 * @author jakobgotberg
 */
public class CashRegister {
    
    private double amountInRegister;
    private double runningTotal;
    private double totalVAT;
    private double change;
    private double amountPayed;
    
    /**
     * Creates instance of class.
     */
    
    CashRegister(){
        this.runningTotal = 0;
        this.totalVAT = 0;
        this.change = 0;
        this.amountPayed = 0;
        
    }
    
    /**
     * Updates the running total and running VAT.
     * @param priceForProduct <code> priceForProduct</code>
     * @param VATForProduct <code> VATForProduct </code>
     */
    
    void update(double priceForProduct, double VATForProduct){
       this.runningTotal += priceForProduct;
       this.totalVAT += priceForProduct * VATForProduct;
    }
    
    /**
     * Calculates the change for the costumer. 
     * @param amountPayed
     * @return <code> change </code>
     * @throws Exception If <code> amountPayed </code> is less than <code> runningTotal </code>.
     */
    double calculateChange(double amountPayed){
        
        if(amountPayed >= this.runningTotal){
            this.amountPayed = amountPayed;
            this.change =  this.amountPayed - this.runningTotal;
            return this.change;
            
        }
        return 0;
    }
    
    double getRunningTotal(){
        return this.runningTotal;
    }
    
    double getTotalVAT(){
        return this.totalVAT;
    }
    
    double getChange(){
        return this.change;
    }
    
    double getAmountPayed(){
        return this.amountPayed;
    }
    
    /**
     * Updates the field with the potentially altered data.
     * @param discountedPayment 
     */
   void registerDiscount(Payment discountedPayment){
       runningTotal = discountedPayment.getAmount();
       totalVAT = discountedPayment.getVAT();
   }
    
}
