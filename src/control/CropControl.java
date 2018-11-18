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
    private static final int POPULATION_ALLOWED_PER_ACRE = 10;
    private static final int BUSHELS_PER_ACRE = 2;
    // random number generator
    private static Random random = new Random();


    /**
    * calcLandCost() method
    * Purpose: Calculate a random land price between 17 and 26 bushels/acre 
    * Parameters: none
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
        if(acresToBuy > (population / POPULATION_ALLOWED_PER_ACRE))
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
    
    /*
    * This function gets the user input of the percent of offering he wants
    * to pay and set that value into the cropData class.
    * It validate the number entered by chencking that is a number between
    * 0 and 100.
    */
    
    public static int setOffering(int offering, CropData cropData) {
        // If offering is less than 0 or negative value, return -1
        if(offering < 0)
            return -1;
        
        // If offering is greater than 100, return -1
        if(offering > 100)
            return -1;
        
        // Set offering into the cropData Class
        cropData.setOffering(offering);
        
        // Return offering
        return offering;
        
    }
    
    /*
    * feedPeople() method
    * Purpose: Feed the People
    * Parameters: The number of wheat for people, the number of wheat in storage, 
    * and a reference to a CropData object.
    * Returns: the amount of wheat left. 
    * Pre-Conditions: 
    * 1.Number of wheat for people must be greater than 0. 
    * 2.Amount of wheat in storage must be equal or greater than wheat for people
    */
    
    public static int feedPeople(int wheatInStore, int wheatForPeople, CropData cropData)
    {
        //If wheatForPeople < 0, return -1
        if (wheatForPeople < 0)
            return -1;
        
	//If wheatInStore < wheatForPeople, returns -1
        if (wheatInStore < wheatForPeople)
            return -1;
        
	//wheatInStore = wheatInStore - wheatForPeople
        wheatInStore -= wheatForPeople;
        cropData.setWheatInStore(wheatInStore);
        //cropWheatForPeple += wheatForPeople;
        wheatForPeople += cropData.getWheatForPeople();
        cropData.setWheatForPeople(wheatForPeople);
        
	//returns wheatInStore
        return wheatInStore;
    }
    
    /**
    * The plantCrops method
    * Purpose: To plant crops
    * Parameters:  The number of acres to plant (an integer), the number of 
    * bushels of wheat required to plant an acre (an integer), a reference to a 
    * CropData object.
    * Returns: the amount of wheat left in storage after the sale, the number of 
    * acres planted.
    * Pre-conditions: acres to plant must be positive and great than or equal to 
    * the number of acres owned, acres to plant must be less than or equal to the
    * land owned minus the land already planted, and the city must have enough 
    * wheat in store. 
    * Annika Rau
    */ 

    public static int plantCrops(int acresToPlant, int bushelsPerAcre, CropData cropData) {
        //If acresToPlant < 1, returns -1
        if (acresToPlant < 1)
            return -1;
        
        // If acresToPlant > wheatInStore – (bushelsPerAcre * acresToPlant), returns -1
        int wheatInStore = cropData.getWheatInStore();
        if (acresToPlant > wheatInStore - (bushelsPerAcre * acresToPlant))
            return -1;
        
        //If acresToPlant > acresOwned, returns -1
        int acresOwned = cropData.getAcresOwned();
        if (acresToPlant > acresOwned)
            return -1;
        
        // If wheatInStore < bushelsNeeded, returns -1
        int bushelsNeeded = acresToPlant * bushelsPerAcre;
        if (wheatInStore < bushelsNeeded)
            return -1;
        
        //Set acresPlanted into the cropData Class
        int acresPlanted = cropData.getAcresPlanted();
        acresPlanted += acresPlanted;
        cropData.setAcresPlanted(acresPlanted);
        
        //wheatInStore = wheatInStore - (acresToPlant * bushelsNeeded)
        wheatInStore -= bushelsNeeded;
        cropData.setWheatInStore(wheatInStore);
        
        //returns acresOwned
        return acresPlanted;    
    }
}

