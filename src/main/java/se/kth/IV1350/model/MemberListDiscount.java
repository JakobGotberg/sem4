/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.model;

/**
 * This is the discount calculator for the regular members of the store.
 * @author jakobgotberg
 */
public class MemberListDiscount implements DiscountCalculator {
    
    private DiscountDTO discountData;
    
    /**
     * This method checks if the costumer is a member of the store. If they are it returns a new, discounted <code>Payment</code>.
     * @param _discountData DTO with data about costumer and sale.
     * 
     * @return <code>Payment</code> with new or unchanged data.
     */
    
    @Override
    public Payment getDiscount(DiscountDTO _discountData){
        this.discountData = _discountData;
        
        for(int match : memberList){
            if( discountData.getCotumerID() == match)
                return memberComfirmed();
        }
        Payment noDiscountApplied = new Payment(discountData.getTotalPrice(), discountData.getTotalVAT());
        return noDiscountApplied;
    }
    
    private Payment memberComfirmed(){
        
        double discountedPrice = discountData.getTotalPrice() * 0.975;
        double discountedVAT = discountData.getTotalVAT() * 0.975;
        
        Payment twoAndAHalfProcentDiscount = new Payment(discountedPrice, discountedVAT);
        return twoAndAHalfProcentDiscount;
    }
    
   
    
}
