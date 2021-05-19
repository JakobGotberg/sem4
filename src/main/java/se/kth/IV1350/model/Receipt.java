/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Prof of purchase.
 * @author jakobgotberg
 */
public class Receipt {
    
    private static final String RECEIPT = "receipt.txt";
    private Product[] listOfProducts;
    private static String nameOfStore = "The Store";
    private double totalPayment;
    private double amountPayed;
    private double change;
    private double totalVAT;
    private Date timeOfSale;
    
    /**
     * Creates a receipt with all the necessary information about the sale. 
     * @param infoForReceipt 
     */
    public Receipt(SaleDTO infoForReceipt){
    	
        this.listOfProducts = infoForReceipt.getProductList();
        this.totalPayment = infoForReceipt.getTotalPayment();
        this.amountPayed = infoForReceipt.getAmountPayed();
        this.change = infoForReceipt.getChange();
        this.totalVAT = infoForReceipt.getTotalVAT();
        this.timeOfSale = java.util.Calendar.getInstance().getTime();
        
    }
    
    /**
     * Prints information about the sale to a file.
     * @throws IOException Thrown if <code>PrintWriter</code> fails.
     */
    
    public void printReceipt() throws IOException{
    	PrintWriter receipt = new PrintWriter(new FileWriter(RECEIPT), true);
    	receipt.println(nameOfStore);
    	receipt.println(timeOfSale + "\n");
    	
    	for(int i = 0; i < listOfProducts.length; i++)
    	receipt.println(listOfProducts[i].getItemDescription());
    	
    	receipt.println("Total price: " + totalPayment);
    }
 
    
   
    

    
}
