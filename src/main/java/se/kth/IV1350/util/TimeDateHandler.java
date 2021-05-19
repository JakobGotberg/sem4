/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Handles the current time and date. Since both the <code>ExceptionLogHandler</code> and the <code>TotalRevenueFileOutput</code> 
 * needs the current time, it prevents duplicated code to have this class.
 * @author jakobgotberg
 */
public class TimeDateHandler {
    
    /**
     * Returns a string with the current time and date.
     * @return String with time and date.
     */
         String getTime() {
            SimpleDateFormat currentTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
            Date date = new Date(); 
            return currentTime.format(date);
    }
    
}
