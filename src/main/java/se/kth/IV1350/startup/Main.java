/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.startup;

import se.kth.IV1350.controller.*;
import se.kth.IV1350.view.*;

/**
 * Start up class, will be run once every time the program is started.
 * @author jakobgotberg
 */
public class Main {
    
    public static void main(String[] args){
        
        Controller contr = new Controller();
        View view = new View(contr);
        
        view.hardCodedSale();
        
        
        
    }
    
}
