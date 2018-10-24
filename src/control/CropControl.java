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
public class CropControl {

    // constants
    private static final int LAND_BASE = 17; 
    private static final int LAND_RANGE = 10;
    private static final int POPULATION_ALLOW_PER_ACRE = 10;
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
    
/**    
 * The function is calculating the total amount of acres owned. It will have four inputs (acresToBuy, landPrice, acresOwned, wheatInStore) 
 * and it will return two values; the amount of acresOwned and wheatInStore after the purchase. 
 * The following validation rules need to be enforced: 
 * The number of acres of land to buy must be greater than 0. 
 * The city population divided by 10 must be equal or greater than number of acres to buy.
 * The Wheat In Store must be equal or greater than the Price of Land.
 * The Price of the land must be equal or greater than 17 and less or equal to 27.
 */
    
    public static int buyLand(int landPrice, int acresToBuy, CropData cropData) {
        //If acresToBuy < 1, return -1
         if(acresToBuy < 1)
             return -1;
             
        //If acresToBuy > (City population / 10), returns -1
        int population = cropData.getPopulation();
        if(acresToBuy > (population / POPULATION_ALLOW_PER_ACRE))
            return -1;
       
        //If wheatInStore < (acresToBuy * landPrice), returns -1
        int finalPrice = acresToBuy * landPrice;
        int wheatInStore = cropData.getWheatInStore();
        if(wheatInStore < finalPrice)
            return -1;
        
        //acresOwned = acresOwned + acresToBuy
        int acresOwned = cropData.getAcresOwned();
        acresOwned += acresToBuy;
        cropData.setAcresOwned(acresOwned);
        
        //wheatInStore = wheatInStore - (acresToBuy * landPrice)
        wheatInStore -= finalPrice;
        cropData.setWheatInStore(wheatInStore);
        
        //returns acresOwned
        return acresOwned;
        
    }
            
    
}
