/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.view;

import java.io.IOException;

import se.kth.IV1350.controller.*;
import se.kth.IV1350.model.Payment;
import se.kth.IV1350.model.ViewInfoDTO;
import se.kth.IV1350.util.ExceptionLogHandler;
import se.kth.IV1350.util.TotalRevenueFileOutput;

/**
 *There is some bad smell in this class because of the duplicated code, but I didn't want to write any extra functions here,
 * since the view shouldn't have any logic in it.
 * @author jakobgotberg
 */
public class View {
    
    private Controller contr;
    private ExceptionMessageHandler excMsgHandler = new ExceptionMessageHandler();
    private ExceptionLogHandler excLogHandler;
    private TotalRevenueView profitObs;
    private TotalRevenueFileOutput profitObsLogger;
    
    /**
     * Creates instance of class. <code>profitObs</code> and <code>profitObsLogger</code> are observers, who observes the <code>Sale</code> class.
     * If the <code>ExceptionLogHandler</code> or the <code>TotalRevenueFileOutput</code> fails and an <code>IOException</code> is thrown, 
     * the system will be shut down. 
     * @param contr <code>Controller</code> created in the <code>Main</code> class.
     */
    
    public View(Controller contr){
        this.contr = contr;
        profitObs = new TotalRevenueView();
        
        
        try {
        this.excLogHandler =  new ExceptionLogHandler();
        }catch(IOException e) {
            systemShutDown();
        }
        
        try{
        profitObsLogger = new TotalRevenueFileOutput();
        }catch(IOException exc){
            excLogHandler.logException(exc);
            systemShutDown();
        }
    }
    
    private void systemShutDown(){
        excMsgHandler.generateErrorMsg("Failed to run system.");
        System.exit(1);
    }
    
    /**
     * Simulated transaction, to run the program without an actual front end.
     */
    
    public void hardCodedSale(){
        contr.startSale();
        contr.addProfitObserver(profitObs);
        contr.addProfitObserver(profitObsLogger);
        
        String[] itemDescriptionList = {"Bread", "bred", "Bread", "EggCarton", "Offerings for the Golden Calf", "Milk", 
        		"connectionFailureSimulationString", "CookBook", null};
        ViewInfoDTO product;
        int index = 0;
       
        while(itemDescriptionList[index] != null) {
        	
        try {
        	product = contr.registerProduct( itemDescriptionList[index] );
        	printProductInfoToConsole( product );
        
        }catch(ProductRegistrationException exc) {
        	excMsgHandler.generateErrorMsg( exc );
        }catch(Exception exc) {
        	excLogHandler.logException(exc);
        	excMsgHandler.generateErrorMsg( exc );
        	}
        index++;
        }
            
        System.out.println("Ending sale.\n");
        Payment toPayAndTax = contr.endSale();
        
        double toPay = toPayAndTax.getAmount();
        System.out.println("Total: " + toPay);
        
        System.out.println("\nDiscount check requested, please enter costumer ID number.\n");
        System.out.println("New price is: " + contr.getDiscount(101) + "$.");
        
        double change = contr.pay(toPay + 4);
        System.out.println("Thank you, your change is: " + change + "$. Please take your receipt.");
        
    }
    
    /**
     * prints the given objects attributes to System.out.
     * @param productToPrint 
     */
    
    void printProductInfoToConsole(ViewInfoDTO productToPrint) {
    	
    	System.out.println("itemDescription: " + productToPrint.getItemDescription() );
        System.out.println("Price: " + productToPrint.getPriceForProduct() + "$");
        System.out.println("Running total: " + productToPrint.getRunningTotal() + "$");
        System.out.println("Running VAT: " + productToPrint.getRunningVAT() + "$\n");
        
    }
    
    
    
}
