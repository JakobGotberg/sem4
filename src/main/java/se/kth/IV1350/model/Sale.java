/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a representation of one sale.
 * @author jakobgotberg
 */
public class Sale {
    
        private Product[] listOfProducts;
        private ListHandler listHandler;
        private CashRegister cashregister;
        
        private List<SaleObserver> profitObservers = new ArrayList<>();
        private DiscountCalculator discountCalculator;
        
        /**
         * Creates instance of class.
         */
        
    public Sale(){
          
            this.listOfProducts = new Product[0];
            this.listHandler = new ListHandler();
            this.cashregister = new CashRegister();
    }
       
    /**
     * Adds product to list, if the list is empty it will add it without checking for other copies.
     * @param productInQuestion The product in question.
     * @return returns DTO, <code>ViewInfoDTO</code>.
     */
    
    public ViewInfoDTO registerProduct(Product productInQuestion){
        
        if( listOfProducts.length == 0 ){    
            return addToList(productInQuestion);
        }
        
        int indexForProduct = checkIfAlreadyScanned(productInQuestion);
        if( indexForProduct >= 0 ){
            listOfProducts[indexForProduct].incrementQuantity();
            this.cashregister.update(productInQuestion.getPrice(), productInQuestion.getVAT());
            return createViewInfoDTO(productInQuestion);
        }
        
        return addToList(productInQuestion);
        
    }
    
    /**
     * Adds product to list of product, updates running total and VAT. New list is created and old one destroyed, see <code>ListHandler</code> for more info.
     * @param productInQuestion The product in question.
     * @return returns DTO, <code>ViewInfoDTO</code>.
     */
    private ViewInfoDTO addToList(Product productInQuestion){
       this.cashregister.update(productInQuestion.getPrice(), productInQuestion.getVAT());
       this.listOfProducts = listHandler.addProduct(listOfProducts, productInQuestion);
        
        return createViewInfoDTO(productInQuestion);
    }
    
    /**
     * Creates a DTO containing data about the registered product and total price.
     * @param productInQuestion The product in question.
     * @return DTO.
     */
    
    private ViewInfoDTO createViewInfoDTO(Product productInQuestion){
        
        ViewInfoDTO DTO = new ViewInfoDTO(productInQuestion.getItemDescription(),
                                            productInQuestion.getPrice(),
                                            this.cashregister.getRunningTotal(),
                                            this.cashregister.getTotalVAT(),
                                            productInQuestion.getQuantity());
        
        return DTO;
        
    }
    
    /**
     * If already registered, will return -1.
     * @param productInQuestion The product in question.
     * @return Index for list of products.
     */
    private int checkIfAlreadyScanned(Product productInQuestion){
            
            for(int i = 0; i < this.listOfProducts.length; i++){
                if( compareIstemDescriptionWithList(productInQuestion, i))
                    { return i; }
            } 
            return -1;    
        }
    
    private boolean compareIstemDescriptionWithList(Product productInQuestion, int index){
       return listOfProducts[index].getItemDescription().equalsIgnoreCase(productInQuestion.getItemDescription());
    }
    
    /**
     * Gets the required payment for purchase, using the cash register to calculate. If the costumer wishes to end the sale with no products
     * the program terminates here, to avoid sending unnecessary info to the external systems.
     * @return Payment, containing the total and total VAT.
     */
    public Payment getAmountToPay(){
        
        if( this.listOfProducts.length == 0)
            System.exit(0);
        
        Payment payment = new Payment(this.cashregister.getRunningTotal(), this.cashregister.getTotalVAT() );
        return payment;
    }
    
    
    /**
     * This method will return change, calculated with the cash register. 
     * If the paid amount is lower than the total price it will throw an exception and the costumer can try again.
     * @param amountPayed The amount the costumer payed.
     * @return <code>change</code>
     */
    public double pay(double amountPayed){
        
        double change = cashregister.calculateChange(amountPayed);
        notifyObservers( cashregister.getRunningTotal() );
        return change;
    }
    
    /**
     * Gets the array of products that have been registered.
     * @return listOfProducts, found in this classes field.
     */
    
    public Product[] getListOfProducts(){
        return this.listOfProducts;
    }
    
    /**
     * Creates DTO containing data about the sale.
     * @return DTO
     */
    public SaleDTO creatSaleDTO(){
        SaleDTO saleInfoForReceipt = new SaleDTO(this.listOfProducts,
                                                    this.cashregister.getRunningTotal(),
                                                      this.cashregister.getAmountPayed(),
                                                        this.cashregister.getChange(),
                                                          this.cashregister.getTotalVAT());
        return saleInfoForReceipt;
    }
        
    /**
     * Adds observer to list of observers.
     * @param obs The observer to add.
     */
    public void addObserver(SaleObserver obs){
        profitObservers.add(obs);
    }
    
    /**
     * Informs all the observers that a new profit has been made.
     * @param profit The profit from the sale.
     */
    
    
    private void notifyObservers(double profit){
        for(SaleObserver obs : profitObservers)
            obs.newProfit(profit);
    }
    
    /**
     * Part of the strategy pattern. Notice that the gold member discount calculator is set to the default algorithm, which of course can be changed
     * if necessary.
     * @param costumerID The costumers unique code.
     * @return New potentially lower price for the purchase.
     */
    public double calculateDiscount(int costumerID){
        DiscountDTO discountData = new DiscountDTO(costumerID, listOfProducts, 
                cashregister.getRunningTotal(), cashregister.getTotalVAT());
        
        discountCalculator = new GoldMemberDiscount();
        Payment dicountedPayment = discountCalculator.getDiscount(discountData);
           
        cashregister.registerDiscount( dicountedPayment );
        return dicountedPayment.getAmount();
       
    }
}
