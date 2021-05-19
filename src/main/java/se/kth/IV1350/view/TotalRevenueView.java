/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.view;
import se.kth.IV1350.model.SaleObserver;

/**
 * Observes the sale class, through the <code>SaleObserver</code> interface to preserve the encapsulation.
 * @author jakobgotberg
 */
public class TotalRevenueView implements SaleObserver{
    
    /**
     * Prints out the new profit to System.out every time the observers are notified that a new profit has been made.
     * @param profit This is the argument given by the observed class.
     */
    @Override
    public void newProfit(double profit){
        StringBuilder printOut = new StringBuilder();
        printOut.append("**** new profit: ");
        printOut.append(profit);
        printOut.append("$ ****");
       
        System.out.println(printOut.toString());
    }
    
}
