/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import se.kth.IV1350.model.SaleObserver;

/**
 * 
 * @author jakobgotberg
 */
public class TotalRevenueFileOutput implements SaleObserver{
    
    private static final String PROFIT_LOG = "profit_retail_store.txt";
    private PrintWriter logger;
    private TimeDateHandler tdHandler = new TimeDateHandler();
    
    public TotalRevenueFileOutput() throws IOException{
        logger = new PrintWriter(new FileWriter(PROFIT_LOG), true);
    }
    
    @Override
    public void newProfit(double profit){
        logger.print(tdHandler.getTime() + " ");
        logger.println("New profit: " + profit + "$");
    }
}
