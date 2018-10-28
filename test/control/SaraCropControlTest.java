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
 * @author BURGOS
 */
public class SaraCropControlTest {
    
    public SaraCropControlTest() {
    }

    /**
     * Test of feedPeople method, of class CropControl.
     * Test Case 1
     */
    @Test
    public void testFeedPeopleCase1() 
    {
        System.out.println("feedPeople - Test case 1");
        CropData cropData = new CropData();
        int wheatInStore = 75;
        int wheatForPeople = 25;
        int expResult = 50;
        int result = CropControl.feedPeople(wheatInStore, wheatForPeople, cropData);
        assertEquals(expResult, result);
    }

    /**
     * Test of feedPeople method, of class CropControl.
     * Test Case 2
     */
    @Test
    public void testFeedPeopleCase2() 
    {
        CropData cropData = new CropData();
        int wheatInStore = 100;
        int wheatForPeople = -15;
        int expResult = -1;
        int result = CropControl.feedPeople(wheatInStore, wheatForPeople, cropData);
        assertEquals(expResult, result);
    }

    /**
     * Test of feedPeople method, of class CropControl.
     * Test Case 3
     */
    @Test
    public void testFeedPeopleCase3() 
    {
        CropData cropData = new CropData();
        int wheatInStore = 25;
        int wheatForPeople = 35;
        int expResult = -1;
        int result = CropControl.feedPeople(wheatInStore, wheatForPeople, cropData);
        assertEquals(expResult, result);
    }

    /**
     * Test of feedPeople method, of class CropControl.
     * Test Case 4
     */
    @Test
    public void testFeedPeopleCase4() 
    {
        CropData cropData = new CropData();
        int wheatInStore = 25;
        int wheatForPeople = 25;
        int expResult = 0;
        int result = CropControl.feedPeople(wheatInStore, wheatForPeople, cropData);
        assertEquals(expResult, result);
    }
    
}
