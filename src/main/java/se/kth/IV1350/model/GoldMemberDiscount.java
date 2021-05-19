/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.model;



/**
 * This class is the discount calculator for the gold members of the store.
 * @author jakobgotberg
 */
public class GoldMemberDiscount implements DiscountCalculator{
    
    
    private DiscountDTO discountData;
    private Product[] listOfProducts;
    
    /**
     * This method checks if the costumer is a gold member, if so it returns a potentially discounted <code>Payment</code>, based on the 
     * products the costumer has bought. If the costumer is not a gold member, the next algorithm will be used.
     * @param _discountData DTO with data about the sale and the costumer.
     * @return <code>Paymanet</code> with lower or unchanged price and VAT.
     */
    
    @Override
    public Payment getDiscount(DiscountDTO _discountData){
        
        this.discountData = _discountData;
        this.listOfProducts = discountData.getListOfProducts();
        
        
        for(int match : goldMemberList){
            if( discountData.getCotumerID() == match)
                return goldMemberComfirmed();
        }
        
        MemberListDiscount nextAlgorithm = new MemberListDiscount();
        return nextAlgorithm.getDiscount(_discountData);
    }
    
    private Payment goldMemberComfirmed(){
        
        for(int i = 0; i < discountData.getListOfProducts().length; i++){
            for(int j = 0; j < discountedProducts.length; j++ ){
                if(checkStringMatch(i,j))
                   return calculateNewPrice(i);
                }
            }
        
        Payment noDiscountAppliedPayment = new Payment(discountData.getTotalPrice(), discountData.getTotalVAT());
        return noDiscountAppliedPayment;
    }
    
    private boolean checkStringMatch(int i, int j){
        return listOfProducts[i].getItemDescription().equalsIgnoreCase(discountedProducts[j]);
    }
    
    private Payment calculateNewPrice(int index){
        
        double discountedPriceForProduct = listOfProducts[index].getPrice() * listOfProducts[index].getQuantity() / 2;
        double discountedVATForProduct = discountedPriceForProduct * listOfProducts[index].getVAT();
        double originalVATForProduct = listOfProducts[index].getPrice() * listOfProducts[index].getQuantity() * listOfProducts[index].getVAT();
        
        double discountedPrice = discountData.getTotalPrice() -  discountedPriceForProduct;
        double discountedVAT = discountData.getTotalVAT() - originalVATForProduct + discountedVATForProduct;
        
        Payment discountedPayment = new Payment(discountedPrice, discountedVAT);
        return discountedPayment;
    }
   
}
