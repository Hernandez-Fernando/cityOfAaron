/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import model.*;
import control.*;
import java.util.Scanner;
import cityofaaron.CityOfAaron;
import exceptions.CropException;
/**
 *
 * @author annika
 */
public class CropView extends MenuView {
    // Create a Scanner object
    private static Scanner keyboard = new Scanner(System.in);
    // Get references to the Game object and the CropData object
    private static Game theGame = CityOfAaron.getTheGame();
    private static CropData cropData = theGame.getCropData();
    
    // Display Manage CropData menu
    public CropView(){
        super("\n" +
            "**********************************\n" +
            "*        MANAGE CROPS MENU       *\n" + 
            "**********************************\n" +
            " 1 - Buy Land\n" +
            " 2 - Sell Land\n" +
            " 3 - Pay Tithes and Offerings\n" +
            " 4 - Feed People\n" +
            " 5 - Plant Crops\n" +
            " 6 - Show Starved\n" +
            " 7 - Runs Crops\n" +
            " 8 - Display Crop Report\n" +
            " 9 - Return to Game Menu\n",
            9);
    }
    
    /**
    *The doAction method
    * Purpose: performs the selected action * Parameters: none
    * Returns: none
    */
    // ===================================
    @Override public void doAction(int option) {
        switch(option) {
            // if the option is 1, call buyLandView( )
            case 1:
                buyLandView();
                break;
            // if the option is 2, call sellLandView( ) 
            case 2:
                sellLandView();
                break;
            // if the option is 3, call payOfferingsView( )
            case 3:
                payOfferingsView();
                break;
            // if the option is 4, call feedPeopleView( )
            case 4:
                feedPeopleView();
                break;
            // if the option is 5, call plantCropsView( )
            case 5:
                plantCropsView();
                break;
            // if the option is 6, call showStarvedView( )
            case 6:
                //showStarvedView();
                break;
            // if the option is 7, call runCropsView( )
            case 7:
                runCropsView();
                break;
            // if the option is 8, call displayCropReport( )
            case 8:
                //displayCropReport();
                break;
            // if the option is 9, return to Game Menu
            case 9:
                return;
        } 
    }
    
    /**
     * The runCropsView method()
     * Purpose: runs the City of Aaron game
     * Parameters: none
     * Returns: none
     */
    public static void runCropsView()
    {
        // call the buyLandView() method
        buyLandView();
        // call feedPeopleView() method
        feedPeopleView();
        //call plantCropsView() method
        plantCropsView();
        //call displayCropsReportView() method
        payOfferingsView();
}
  
    public static void buyLandView()
    {
        // Get the cost of land for this round.
        int price = CropControl.calcLandCost();
        
        // Prompt the user to enter the number of acres to buy
        System.out.format("Land is selling for %d bushels per acre.%n",price);
        
        int toBuy;
        boolean paramsNotOkay;
        
        do {
            paramsNotOkay = false;
            System.out.print("How many acres of land do you wish to buy? "); 

            // Get the user’s input and save it.

            toBuy = keyboard.nextInt();
            
            try {
                // Call the buyLand( ) method in the control layer to buy the land
                CropControl.buyLand(price, toBuy, cropData); // Parameters were in different order than the function in the CropData model
            }
            catch(CropException e) {
                System.out.println("I am sorry master, I cannot do this."); 
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        } while(paramsNotOkay);
            // output how much land we now own
            System.out.format("You now own %d acres of land. ", cropData.getAcresOwned());
    }
    
    public static void sellLandView()
    {
        // Get the cost of land for this round.
        int price = CropControl.calcLandCost();
        
        // Prompt the user to enter the number of acres to buy
        System.out.format("Land is selling for %d bushels per acre.%n",price);
        System.out.print("How many acres of land do you wish to sell? "); 
        
        // Get the user’s input and save it.
        int toSell;
        toSell = keyboard.nextInt();
        
        // Call the sellLand( ) method in the control layer to sell the land
        CropControl.sellLand(price, toSell, cropData);
        
        // output how much land we now own
        System.out.format("You now own %d acres of land. ", cropData.getAcresOwned());
    }
    
    /**
     * The feedPeopleView method
     * Purpose: interface with the user input for feeding people * Parameters: none
     * Returns: none
     */
    
    public static void feedPeopleView(){
        //ask user how many bushels of grain to give the people
        System.out.print("How many bushels of grain do you want to give to the people? ");
        //User enters a value
        int bushels;
        bushels = keyboard.nextInt();
        
        //check to make sure value is positive. if not, show a message and ask user to enter value again.
        if (bushels < 0) {
            do {
                System.out.print("Please insert a positive value for People to Feed:");
                bushels = keyboard.nextInt();
            } while (bushels < 0);
        }
        
        //make sure city has this much wheat in storage. if not, show a message and ask the user to enter value again.
        int wheatInStore = cropData.getWheatInStore();
        if (bushels > wheatInStore) {
            do {
                System.out.print("You dont have much weat in storage, please try a smaller number:");
                bushels = keyboard.nextInt();
            } while (bushels > wheatInStore);
        }
    
        //subract this amount from the wheat in storage. Display the amount of wheat you have left.
        CropControl.feedPeople(wheatInStore, bushels, cropData);
        System.out.format("You now have %d Weat in Store. ", cropData.getWheatInStore());
        
        //Update the game state to save how many bushels of wheat you have set aside to feed the people.
        System.out.format("You now have %d Weat for People. ", cropData.getWheatForPeople());
        
    }
    
    /**
     * The plantCropsView method
     * Purpose: interface with the user input for planting crops * Parameters: none
     * Returns: none
     */
    public static void plantCropsView(){
        //ask user how many acres of land they want to plant
        System.out.print("How many acres of land do you want to plant? ");
    
        //User enters a value
        //check to make sure value is positive. if not, show a message and ask user to enter value again.
        //make sure city has this much land. if not, show a message and ask the user to enter value again.
        //make sure the city has enough wheat in storage to plant this many acres. If not, show a message and ask user to enter value again.
        //calculate the number of bushels required to plant the crops
        //subtract this amount from the wheat in storage. Display the amount of wheat you have left.
        //Update the game state to save how acres have been planted.
    }
    
    /**
     * The payTithesAndOfferings method
     * Purpose: interface with the user input for feeding people * Parameters: none
     * Returns: none
     */
    public static void payOfferingsView(){
        //ask user what percentage of their harvest they want to pay in tithes and offerings
        System.out.print("What percentage of your harvest do you want to pay in tithes and offerings? ");
    
        //Get the user's input
        //Check to make sure the value entered is positive. if it is not, show a message and ask user to enter a new value.
        //Check to make sure that the value entered by the user is not greater than 100. If it is, display a message and ask the user to eneter a new value.
        //Save the value entered by the user
    }

}
