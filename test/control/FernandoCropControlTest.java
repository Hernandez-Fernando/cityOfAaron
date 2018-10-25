/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.CropData;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fernando
 */
public class FernandoCropControlTest {
    
    public FernandoCropControlTest() {
    }


    /**
     * Test of setOffering method, of class CropControl.
     * Test Matrix 1
     */
    @Test
    public void testSetOfferingCase1() {
        System.out.println("setOffering - Case 1");
        int offering = 4;
        CropData cropData = new CropData();
        int expResult = 4;
        int result = CropControl.setOffering(offering, cropData);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setOffering method, of class CropControl.
     * Test Matrix 2
     */
    @Test
    public void testSetOfferingCase2() {
        System.out.println("setOffering - Case 2");
        int offering = -2;
        CropData cropData = new CropData();
        int expResult = -1;
        int result = CropControl.setOffering(offering, cropData);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setOffering method, of class CropControl.
     * Test Matrix 3
     */
    @Test
    public void testSetOfferingCase3() {
        System.out.println("setOffering - Case 3");
        int offering = 105;
        CropData cropData = new CropData();
        int expResult = -1;
        int result = CropControl.setOffering(offering, cropData);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setOffering method, of class CropControl.
     * Test Matrix 4
     */
    @Test
    public void testSetOfferingCase4() {
        System.out.println("setOffering - Case 4");
        int offering = 0;
        CropData cropData = new CropData();
        int expResult = 0;
        int result = CropControl.setOffering(offering, cropData);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setOffering method, of class CropControl.
     * Test Matrix 5
     */
    @Test
    public void testSetOfferingCase5() {
        System.out.println("setOffering - Case 5");
        int offering = 100;
        CropData cropData = new CropData();
        int expResult = 100;
        int result = CropControl.setOffering(offering, cropData);
        assertEquals(expResult, result);
    }
    
}
