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
/**
 *
 * @author annika
 */
public class CropView {
    // Create a Scanner object
    private static Scanner keyboard = new Scanner(System.in);
    // Get references to the Game object and the CropData object
    private static Game theGame = CityOfAaron.getTheGame();
    private static CropData cropData = theGame.getCropData();
    
    /**
     * The runCropsView method()
     * Purpose: runs the Hamurabi game
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
        payTithesAndOfferingsView();
}
  
    public static void buyLandView()
    {
        // Get the cost of land for this round.
        int price = CropControl.calcLandCost();
        
        // Prompt the user to enter the number of acres to buy
        System.out.format("Land is selling for %d bushels per acre.%n",price);
        System.out.print("How many acres of land do you wish to buy? "); 
        
        // Get the user’s input and save it.
        int toBuy;
        toBuy = keyboard.nextInt();
        
        // Call the buyLand( ) method in the control layer to buy the land
        CropControl.buyLand(toBuy, price, cropData);
        
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
        //check to make sure value is positive. if not, show a message and ask user to enter value again.
        //make sure city has this much wheat in storage. if not, show a message and ask the user to enter value again.
        //subract this amount from the wheat in storage. Display the amount of wheat you have left.
        //Update the game state to save how many bushels of wheat you have set aside to feed the people.
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
    public static void payTithesAndOfferingsView(){
        //ask user what percentage of their harvest they want to pay in tithes and offerings
        System.out.print("What percentage of your harvest do you want to pay in tithes and offerings? ");
    
        //Get the user's input
        //Check to make sure the value entered is positive. if it is not, show a message and ask user to enter a new value.
        //Check to make sure that the value entered by the user is not greater than 100. If it is, display a message and ask the user to eneter a new value.
        //Save the value entered by the user
    }

}
