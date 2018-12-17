 /**
*The CropControl class - part of the control layer
* class contains all of the calculation methods for managing the crops 
* Author: Sara Compoverde, Annika Rau, Fernando Hernandez
* Date last modified: October 2018
*/
package control;

import exceptions.CropException;
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
    private static final int HARVEST_BASE_ONE = 1;
    private static final int HARVEST_BASE_TWO = 2;
    private static final int HARVEST_RANGE = 3;
    private static final int EATEN_RATS_BASE = 1;
    private static final int EATEN_RATS_RANGE = 100;
    private static final int EATEN_WHEAT_BASE_ONE = 3;
    private static final int EATEN_WHEAT_BASE_TWO = 6;
    private static final int EATEN_WHEAT_RANGE_ONE = 4;
    private static final int EATEN_WHEAT_RANGE_TWO = 2;
    private static final int PEOPLE_BASE = 1;
    private static final int PEOPLE_RANGE = 5;
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
    
    public static void sellLand(int landPrice, int acresToSell, CropData cropData) throws CropException {
        //if acresToSell < 0, return -1
        if(acresToSell < 0)
            throw new CropException("A negative value was input");

        //if acresToSell > acresOwned, return -1
        int acresOwned = cropData.getAcresOwned();
        if(acresToSell > acresOwned)
            throw new CropException("You cannot sell more acres than you own.");

        //acresOwned = acresOwned - acresToSell
        acresOwned -= acresToSell;
        cropData.setAcresOwned(acresOwned); // Insert new value into the cropData class.

        //wheatInStore = wheatInStore + acresToSell * landPrice
        int wheatInStore = cropData.getWheatInStore();
        wheatInStore += (acresToSell * landPrice);
        cropData.setWheatInStore(wheatInStore); // Insert new value into the cropData class.

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
    
    public static void buyLand(int landPrice, int acresToBuy, CropData cropData) throws CropException {
        //If acresToBuy < 0, return -1
         if(acresToBuy < 0)
             throw new CropException("A negative value was input.");
             
        //If acresToBuy > (City population / 10), returns -1
        /*
        int population = cropData.getPopulation();
        if(acresToBuy > (population / POPULATION_ALLOWED_PER_ACRE))
            throw new CropException("There is insufficient population to take care of this amount of land.");
       */
        
        //If wheatInStore < (acresToBuy * landPrice), returns -1
        int finalPrice = acresToBuy * landPrice;
        int wheatInStore = cropData.getWheatInStore();
        if(wheatInStore < finalPrice)
            throw new CropException("There is insufficient wheat to buy this much land.");
        
        //acresOwned = acresOwned + acresToBuy
        int acresOwned = cropData.getAcresOwned();
        acresOwned += acresToBuy;
        cropData.setAcresOwned(acresOwned);
        
        //wheatInStore = wheatInStore - (acresToBuy * landPrice)
        wheatInStore -= finalPrice;
        cropData.setWheatInStore(wheatInStore);
        
    }
    
    /*
    * This function gets the user input of the percent of offering he wants
    * to pay and set that value into the cropData class.
    * It validate the number entered by chencking that is a number between
    * 0 and 100.
    */
    
    public static void setOffering(int offering, CropData cropData) throws CropException {
        // If offering is less than 0 or negative value, return -1
        if(offering < 0)
            throw new CropException("A negative value was input.Insert a number between 0 and 100");
        
        // If offering is greater than 100, return -1
        if(offering > 100)
            throw new CropException("This number is too high, insert a number between 0 and 100.");
        
        // Set offering into the cropData Class
        cropData.setOffering(offering);
        
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
    
    public static void feedPeople(int wheatInStore, int wheatForPeople, CropData cropData)throws CropException{
        //If wheatForPeople < 0, return -1
        if (wheatForPeople < 0)
            throw new CropException("A negative value was input");
        
	//If wheatInStore < wheatForPeople, returns -1
        if (wheatInStore < wheatForPeople)
            throw new CropException("There is insufficient wheat to feed the people");
        
	//wheatInStore = wheatInStore - wheatForPeople
        wheatInStore -= wheatForPeople;
        cropData.setWheatInStore(wheatInStore);
        //cropWheatForPeple += wheatForPeople;
        wheatForPeople += cropData.getWheatForPeople();
        cropData.setWheatForPeople(wheatForPeople);
        
	//returns wheatInStore
        
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
    * Modified for Fernando Hernandez
    */ 

    public static void plantCrops(int acresToPlant, CropData cropData) throws CropException{
        //If acresToPlant < 1, returns -1
        if (acresToPlant < 0)
            throw new CropException("A negative value was input. Try again using a positive value:");
       
        //If acresToPlant > acresOwned, returns -1
        int acresOwned = cropData.getAcresOwned();
        if (acresToPlant > acresOwned)
            throw new CropException("You don't owned sufficient land to plant, try a lower number.");
        
        // If acresToPlant > wheatInStore – (bushelsPerAcre * acresToPlant), returns -1
        int wheatInStore = cropData.getWheatInStore();
//        if (acresToPlant > wheatInStore - (bushelsPerAcre * acresToPlant))
//            throw new CropException("A negative value was input.");
        
        // If wheatInStore < bushelsNeeded, returns -1
        int bushelsNeeded = acresToPlant * BUSHELS_PER_ACRE;
        if (wheatInStore < bushelsNeeded)
            throw new CropException("You don't have enough Wheat in Store to plant this amound of land, try planting less land:");
        
        //Set acresPlanted into the cropData Class
        int acresPlanted = cropData.getAcresPlanted();
        acresPlanted += acresToPlant;
        cropData.setAcresPlanted(acresPlanted);
        
        //wheatInStore = wheatInStore - (acresToPlant * bushelsNeeded)
        wheatInStore -= bushelsNeeded;
        cropData.setWheatInStore(wheatInStore);
            
    }
    
    /**
    *The harvestCrops method
    * Purpose: Calculate crop yield
    *@param offering
    *@param cropYield
    *@param acresOwned
    *@param cropData 
    *@ return harvestAfterOffering
    *Pre-conditions: the value of tithes and offerings must be >= than 0 
    *the random value of crop yield must be a number between 2 and 4 when the paid 
    *percentage of tithes and offerings is equal or greater than 8 and less or equal to 12 
    *the random value of crop yield must be a number between 1 and 3 when the paid 
    *percentage of tithes and offerings is less than 8
    *the random value of crop yield must be a number between 2 and 5 when the paid 
    *percentage of tithes and offerings is greater than 12
    */
    public static void harvestCrops(int offering, int cropYield, int acresOwned, CropData cropData) throws CropException {
        //if offering < 0, return -1
        offering = cropData.getOffering();
        if (offering < 0)
            throw new CropException("A negative value was input. Try again using a positive value:");
        
        if (offering <= 8 && offering >= 12) {
            int yieldEightTwelve = HARVEST_BASE_ONE + random.nextInt(HARVEST_BASE_TWO);
            cropData.setCropYield(yieldEightTwelve);
            int harvestAfterOffering = cropYield * acresOwned;
            cropData.setHarvest(harvestAfterOffering);
        } 
        if (offering < 8) {
            int yieldBelowEight = HARVEST_BASE_ONE + random.nextInt(HARVEST_BASE_TWO);
            cropData.setCropYield(yieldBelowEight);
            int harvestAfterOffering = cropYield * acresOwned;
            cropData.setHarvest(harvestAfterOffering);
        } 
        if (offering >= 12) {
            int yieldAboveTwelve = HARVEST_BASE_TWO + random.nextInt(HARVEST_RANGE);;
            cropData.setCropYield(yieldAboveTwelve);
            int harvestAfterOffering = cropYield * acresOwned;
            cropData.setHarvest(harvestAfterOffering);
        }
        
        int harvestAfterOffering = cropData.getHarvest();
        cropData.setHarvestAfterOffering(harvestAfterOffering);
        System.out.println("The number of bushels of wheat harvested are " + harvestAfterOffering);
    }
    
    /**
    *The calcEatenByRats method
    * Purpose: calculate the amount of bushels of wheat eaten by rates 
    *@param eatenByRats
    *@param wheatInStore
    *@param offeringBushels
    *@param cropData 
    *@ return wheatInStore
    *Pre-conditions: the generated random number must be less than 30 so that some of 
    *the wheat in store be eaten by rats. 
    *the amount of wheatInStore must be > than 0
    *the paid offering bushels must be equal or greater than 8, and equal or less than 12 so that 
    *amount of bushels of wheat eaten by rats be a random number between 3% and 7% of the *wheat in store 
    *the paid offering bushels must be less than 8 so that amount of bushels of wheat eaten by 
    *rats be a random number between 6% and 10% of the wheat in store
    *the paid offering bushels must be greater than 12 so that amount of bushels of wheat eaten 
    *by rats be a random number between 3% and 5% of the wheat in store.
    */
    public static void calcEatenByRats(int eatenByRats, int wheatInStore, int offeringBushels, CropData cropData) throws CropException {
        //if wheatInStore < 0, return -1 
        wheatInStore = cropData.getWheatInStore();
        if (wheatInStore < 0)
            throw new CropException("It is not possible calculate the amount of wheat eaten "
                                  + "by rats because you have 0 bushels of wheat");
        //generate a random number between 1 and 100
        int eatenRatsPercentage;
        int randomNumberRats = EATEN_RATS_BASE + random.nextInt(EATEN_RATS_RANGE);
        if (randomNumberRats < 30) {
            int tithesOfferings = cropData.getOfferingBushels();
            if (tithesOfferings < 8) {
                int randomWheat = EATEN_WHEAT_BASE_TWO + random.nextInt(EATEN_WHEAT_RANGE_ONE);
                eatenRatsPercentage = randomWheat / 100;
            }
            else if (tithesOfferings > 12) {
                int randomWheat = EATEN_WHEAT_BASE_ONE + random.nextInt(EATEN_WHEAT_RANGE_TWO);
                eatenRatsPercentage = randomWheat / 100;
            }
            else if (tithesOfferings >= 8 && tithesOfferings <= 12) { 
                int randomWheat = EATEN_WHEAT_BASE_ONE + random.nextInt(EATEN_WHEAT_RANGE_ONE);
                eatenRatsPercentage = randomWheat / 100;
            }
            else {
                eatenRatsPercentage = 0;
            }
	//eatenByRats = wheatInStore * eatenRatsPercentage
        eatenByRats = wheatInStore * eatenRatsPercentage;
        cropData.setEatenByRats(eatenByRats);
	//wheatInStore = wheatInStore – eatenByRats
        wheatInStore = wheatInStore - eatenByRats;
        cropData.setWheatInStore(wheatInStore);
        }
    }
        
    /**
    *The payOffering method
    * Purpose: calculate the value of offerings to pay. 
    *@param offering
    *@param harvest
    *@param payOffering
    *@param cropData 
    *Pre-conditions: It gets the values of offering and harvest 
    *to multiply among them and then divide it by 100. 
    */   
    public static void payOffering(int offering, int harvest, int payOffering, CropData cropData) throws CropException{
        
        offering = cropData.getOffering(); 
        harvest = cropData.getHarvest(); 
        payOffering = (offering * harvest) / 100; 
        
        cropData.setOfferingBushels(payOffering); 
        harvest -= payOffering; 
        cropData.setHarvestAfterOffering(harvest);
        int wheatInStore = cropData.getWheatInStore() + harvest;
        cropData.setWheatInStore(wheatInStore);
        
        System.out.println("Thank you for paying the offerings. "
                         + "The paid total amount was: " + payOffering);
        //return wheatInStore;
    }
    
    /**
    *The growPopulation method
    * Purpose: determine how much grew the population. 
    *@param population
    *@param newPeople
    *@param cropData 
    *Pre-conditions: Generate a random number between 1 and 5 %.
    * Calculate the number of people who moved into the city.
    */
    public static void growPopulation(int population, int newPeople, CropData cropData) throws CropException {
        int peopleRandom = PEOPLE_BASE + random.nextInt(PEOPLE_RANGE);
        int peopleRandomPercentage = peopleRandom / 100;
        int currentPopulation = cropData.getPopulation();
        newPeople = currentPopulation * peopleRandomPercentage;
        cropData.setNewPeople(newPeople);
        population += newPeople;
        cropData.setPopulation(population);
        System.out.println("The city is growing. Current population is " + population);
    }
    
    /**
    *The calcStarved method
    * Purpose: calculate how many people were adequately fed during the year. 
    *@param numberWhoDied
    *@param numStarved
    *@param peopleFed
    *@param cropData 
    *Pre-conditions: It takes 20 bushels of wheat to feed each person.
    *Calculate people who died of starvation by substract people adequately
    *fed, from current population.
    */
    public static void calcStarved(int numberWhoDied, int numStarved, int peopleFed, CropData cropData) throws CropException {
        
        int currentPeople = cropData.getPopulation();
        int wheatPeople = cropData.getWheatForPeople();
        peopleFed = wheatPeople / 20; 
        //cropData.setPeopleFed(peopleFed);
        
        if (peopleFed < currentPeople) {
            numStarved = currentPeople - peopleFed;
            numberWhoDied = cropData.getNumStarved();
            cropData.setNumberWhoDied(numberWhoDied);   
        }
        int peopleAfterStarve = currentPeople - numberWhoDied;
        cropData.setPopulation(peopleAfterStarve);
    }
}
    
    
    


