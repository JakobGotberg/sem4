/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.IV1350.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.IV1350.model.Product;

/**
 *
 * @author jakobgotberg
 */
public class InventoryTest {
    
    public InventoryTest() {
    }
    
    

    @Test
    public void testLookUpProductCheckedException() throws InventoryException {
        Inventory instance = new Inventory();
        String faultyItemDesc = "testString";
        String correctExcMsg = "Item description \"" + faultyItemDesc + "\" is an invalid item description.";
        
        try{
        instance.lookUpProduct(faultyItemDesc);
        fail("Could register a non existant product.");
        }catch(InventoryException exc){
            assertTrue(exc.getMessage().contains(correctExcMsg), "Not the correct exception message.");
        }
        
    }
    
    @Test
    public void testLookUpProductRunTimeException() throws InventoryException {
        Inventory anotherInstance = new Inventory();
        String simulationString = "connectionFailureSimulationString";
        String correctExcMsg = "SQL-ERROR " + anotherInstance.getClass().toString() + " SERVER_CONNECTION_FAILURE";
        
        try{
        anotherInstance.lookUpProduct(simulationString);
        fail("Failed, should have simulated a connection failure.");
        }catch(Exception exc){
            assertTrue(exc.getMessage().contains(correctExcMsg), "Not the correct exception message.");
        }
        
    }
    
        
    }
    

