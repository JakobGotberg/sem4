/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.model;

/**
 * This interface is used to implement the observer pattern in this program.
 * @author jakobgotberg
 */
public interface SaleObserver {
    
    /**
     * This method is used to transfer data to the observers.
     * @param profit 
     */
    
    void newProfit(double profit);
    
}
