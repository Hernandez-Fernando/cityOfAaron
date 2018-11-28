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
public class CropControlTest {
    
    public CropControlTest() {
    }

    /**
     * Test of calcLandCost method, of class CropControl.
     */
//    @Test
//    public void testCalcLandCost() {
//        System.out.println("calcLandCost");
//        int expResult = 0;
//        int result = CropControl.calcLandCost();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of sellLand method, of class CropControlControl.
     * Test Matrix 1
     */
    @Test
    public void testSellLandCase1() {
        
        System.out.println("sellLand - Test  Case 1");
        CropData cropData = new CropData();
        cropData.setAcresOwned(2800);
        
        int landPrice = 20;
        int acresToSell = 10;
        int expResult = 2790;
        int result = CropControl.sellLand(landPrice, acresToSell, cropData);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of sellLand method, of class CropControlControl.
     * Test Matrix 2
     */
    @Test
    public void testSellLandCase2() {
        System.out.println("sellLand - Test Case 2");
        CropData cropData = new CropData();
        cropData.setAcresOwned(2800);
        
        int landPrice = 20;
        int acresToSell = -5;
        int expResult = -1;
        int result = CropControl.sellLand(landPrice, acresToSell, cropData);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of sellLand method, of class CropControlControl.
     * Test Matrix 3
     */
    @Test
    public void testSellLandCase3() {
        System.out.println("sellLand - Test Case 3");
        CropData cropData = new CropData();
        cropData.setAcresOwned(2800);
        
        int landPrice = 20;
        int acresToSell = 3000;
        int expResult = -1;
        int result = CropControl.sellLand(landPrice, acresToSell, cropData);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of sellLand method, of class CropControlControl.
     * Test Matrix 4
     */
    @Test
    public void testSellLandCase4() {
        System.out.println("sellLand - Test Case 4");
        CropData cropData = new CropData();
        cropData.setAcresOwned(2000);
        
        int landPrice = 10;
        int acresToSell = 2000;
        int expResult = 0;
        int result = CropControl.sellLand(landPrice, acresToSell, cropData);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of sellLand method, of class CropControlControl.
     * Test Matrix 5
     */
    @Test
    public void testSellLandCase5() {
        System.out.println("sellLand - Test Case 5");
        CropData cropData = new CropData();
        cropData.setAcresOwned(2000);
        
        int landPrice = 10;
        int acresToSell = 0;
        int expResult = 2000;
        int result = CropControl.sellLand(landPrice, acresToSell, cropData);
        assertEquals(expResult, result);
    }


    /**
     * Test of buyLand method, of class CropControl.
     * Test Matrix 1
     */
//    @Test
//    public void testBuyLandCase1() {
//        System.out.println("buyLand - Test Case 1");
//        int landPrice = 25;
//        int acresToBuy = 20;
//        CropData cropData = new CropData();
//        cropData.setAcresOwned(100);
//        cropData.setWheatInStore(510);
//        cropData.setPopulation(250);
//        int expResult = 120;
//        int result = CropControl.buyLand(landPrice, acresToBuy, cropData);
//        assertEquals(expResult, result);
//    }
//    
//     /**
//     * Test of buyLand method, of class CropControl.
//     * Test Matrix 2
//     */
//    @Test
//    public void testBuyLandCase2() {
//        System.out.println("buyLand - Test Case 2");
//        int landPrice = 25;
//        int acresToBuy = -5;
//        CropData cropData = new CropData();
//        cropData.setAcresOwned(1000);
//        cropData.setWheatInStore(510);
//        cropData.setPopulation(250);
//        int expResult = -1;
//        int result = CropControl.buyLand(landPrice, acresToBuy, cropData);
//        assertEquals(expResult, result);
//    }
//    
//     /**
//     * Test of buyLand method, of class CropControl.
//     * Test Matrix 3
//     */
//    @Test
//    public void testBuyLandCase3() {
//        System.out.println("buyLand - Test Case 3");
//        int landPrice = 20;
//        int acresToBuy = 15;
//        CropData cropData = new CropData();
//        cropData.setAcresOwned(2);
//        cropData.setWheatInStore(270);
//        cropData.setPopulation(250);
//        int expResult = -1;
//        int result = CropControl.buyLand(landPrice, acresToBuy, cropData);
//        assertEquals(expResult, result);
//    }
    
}
