 /**
*The CropControl class - part of the control layer
* class contains all of the calculation methods for managing the crops 
* Author: Sara Compoverde, Annika Rau, Fernando Hernandez
* Date last modified: October 2018
*/
package control;

import model.CropData;
import java.util.Random;
/**
 *
 * @author fernando
 */
public class CropControlControl {

    // constants
    private static final int LAND_BASE = 17; 
    private static final int LAND_RANGE = 10;
    // random number generator
    private static Random random = new Random();


    /**
    * calcLandCost() method
    * Purpose: Calculate a random land price between 17 and 26 bushels/acre * Parameters: none
    * Returns: the land cost
    */
    public static int calcLandCost() {
        int landPrice = random.nextInt(LAND_RANGE) + LAND_BASE;
        return landPrice;
    }
    
    /**
    * The sellLand method
    * Purpose: To sell land
    * Parameters: the price of land, the number of acres to sell, and 
    * a reference to a CropData object
    * Returns: the number of acres owned after the sale
    * Pre-conditions: acres to sell must be positive
    * and <= acresOwned
    */
    
    public static int sellLand(int landPrice, int acresToSell, CropData cropData) {
        //if acresToSell < 0, return -1
        if(acresToSell < 0)
            return -1;

        //if acresToSell > acresOwned, return -1
        int acresOwned = cropData.getAcresOwned();
        if(acresToSell > acresOwned)
            return -1;

        //acresOwned = acresOwned - acresToSell
        acresOwned -= acresToSell;
        cropData.setAcresOwned(acresOwned); // Insert new value into the cropData class.

        //wheatInStore = wheatInStore + acresToSell * landPrice
        int wheatInStore = cropData.getWheatInStore();
        wheatInStore += (acresToSell * landPrice);
        cropData.setWheatInStore(wheatInStore); // Insert new value into the cropData class.

        //return acresOwned
        return acresOwned; // Value storage or display it to the calling method
    }
}
