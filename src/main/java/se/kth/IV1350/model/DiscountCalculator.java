/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.model;

/**
 * This interface is the foundation on which the strategy pattern is build.
 * @author jakobgotberg
 */
public interface DiscountCalculator {
    
     String[] discountedProducts = {"Milk", "Bread"};
     int[] goldMemberList = {100,101,102,103,104,105,106};
     int[] memberList = {12,14,15,16,17,19,10};
     
     /**
      * Calculates the discount.
      * @param discountData DTO with data about the sale and the costumer.
      * @return <code>Payment</code> with altered or non-altered data. 
      */
    
   Payment getDiscount(DiscountDTO discountData);
    
}
