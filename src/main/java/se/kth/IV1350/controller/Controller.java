/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.controller;

import se.kth.IV1350.integration.*;
import se.kth.IV1350.model.Payment;
import se.kth.IV1350.model.Product;
import se.kth.IV1350.model.Sale;
import se.kth.IV1350.model.SaleObserver;
import se.kth.IV1350.model.ViewInfoDTO;


   
/**
 * Controller class. Very well known concept, no need to comment here.
 * @author jakobgotberg
 */
public class Controller {
    
    private Sale sale;
    private Inventory inventory;
    private Accounting accounting;

    
    /**
     * Initiates a sale, creating the necessary objects.
     */
    public void startSale(){
        this.sale = new Sale();
        this.inventory = new Inventory();
        this.accounting = Accounting.getAccounting();
    }
    
    /**
     * Checks if the product is in the DB, will return matching product if found. If not the method will throw an exception.
     * @param itemDescription
     * @return
     * @throws ProductRegistrationException Exception, the given String "itemDescription" has no match in the DB.
     */
    
    public ViewInfoDTO registerProduct(String itemDescription) throws ProductRegistrationException{
        
    	try{
        Product productInQuestion = inventory.lookUpProduct(itemDescription);
        return sale.registerProduct(productInQuestion); }
    	catch(InventoryException exc) {
    		throw new ProductRegistrationException(itemDescription);
    	}
    	catch(Exception exc) {
    		throw new SystemException("Lost connection with server.", exc);
    	}
    }
    
    /**
     * Ends the current sale.
     * @return Returns a DTO containing the total cost and total VAT.
     */
    public Payment endSale(){
        Payment payment = this.sale.getAmountToPay();
        this.accounting.registerSale(payment);
        return payment;
    }
    
    /**
     * If the paid amount is greater than total price, this method will return an amount equal or greater than zero in change.
     * If not it will throw an exception and return zero in change. The costumer can in that case try again until the amount is greater or equal to the total price.
     * @param amountPayed The paid amount.
     * @return <code>change</code>
     */
    public double pay(double amountPayed){
        
        
        double change = this.sale.pay(amountPayed);
        this.accounting.updateFinance( this.sale.getAmountToPay() );
        
        this.inventory.updateInventory( this.sale.getListOfProducts() );
        
        Printer printer = new Printer();
        
        printer.printReceipt( this.sale.creatSaleDTO() );
        
        return change;
        
    }
    
    /**
     * Adds observer for the <code>Sale</code> class.
     * @param obs The observer that will be added.
     */
    
    public void addProfitObserver(SaleObserver obs){
        sale.addObserver(obs);
    }
    
    /**
     * Get the potentially lower, new price for the purchase.
     * @param costumerID
     * @return The new price.
     */
    public double getDiscount(int costumerID){
        double discountedprice = sale.calculateDiscount(costumerID);
        return discountedprice;
    }
    
}
