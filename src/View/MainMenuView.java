/*
 * The MainMenuView class - part of the view layer
 * Object of this class manages the main menu.
 * CIT-260
 * Fall 2018
 * Team members: Sara Compoverde, Annika Rau, Fernando Hernandez 
 */
package View;
import cityofaaron.CityOfAaron;
import control.*;
import model.*;

import java.util.Scanner;
/**
 *
 * @author annikarau
 */
public class MainMenuView extends MenuView {
    Scanner keyboard = new Scanner(System.in);
    private String theMenu; 
    private final int MAX = 5; // This will prevent any function to update the value and create a bug.
    
    /**
    * The MainMenuView constructor
    * Purpose: displays the menu, gets the user's input, and does the * selected action
    * Parameters: none
    * Returns: none
    */
    // =========================================================
    
    public MainMenuView() {
        super("\n" +
            "**********************************\n" +
            "* CITY OF AARON: MAIN GAME MENU  *\n" + 
            "**********************************\n" +
            " 1 - Start new game\n" +
            " 2 - Get and start a saved game\n" +
            " 3 - Get help on playing the game\n" +
            " 4 - Save game\n" +
            " 5 - Quit\n",
            5);
    }
    
    /**
    *The doAction method
    * Purpose: performs the selected action * Parameters: none
    * Returns: none
    */
    // ===================================
    @Override public void doAction(int option) {
        switch(option) {
            // if the option is 1, call startNewGame( )
            case 1:
                startNewGame();
                break;
            // if the option is 2, call startExistingGame( ) 
            case 2:
                startSavedGame();
                break;
            // if the option is 3, call displayHelpMenu( )
            case 3:
                displayHelpMenuView();
                break;
            // if the option is 4, call displaySaveGame( )
            case 4:
                displaySaveGameView();
                break;
            // if the option is 5, display a goodbye message
            case 5:
                System.out.println("Thanks for playing. Goodbye.");
        } 
    }
      
        
    /**
    * The startNewGame method
    * Purpose: creates game object and starts the game 
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void startNewGame() {
        // Display the Banner Page.
        System.out.println("Welcome to the City of Aaron. You have been found worthy"
                + " of assuming your role as Chief Judge. As the head ruler, you "
                + "will be responsible for buying and selling land, determining how "
                + "much wheat to plant each year, and how much wheat to store to feed "
                + "the people. You will also be responsible for paying the annual "
                + "tithe on the harvested wheat. If you fail in your duties to provide "
                + "wheat for your people, they will starve and die. Plan carefully "
                + "for unforseen thieves.");
        
        // Prompt for and get the users name.
        String name;
        System.out.println("Please type in your first name: ");
        name = keyboard.next();
        
        // Call the CreateNewGame() method in the GameControl class
        // pass the name as a parameter
        GameControl.createNewGame(name);
        
        // Display a welcome message
        System.out.println("Welcome, " + name + ". Have fun!");
        
// Display the Game menu 
        GameMenuView gmv = new GameMenuView();
        gmv.displayMenu();
    } 
    
    /**
    * The startSavedGame method
    * Purpose: Starts a saved game from where user ended
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void startSavedGame() {
        System.out.println("Start saved game option selected."); 
    } 
    
    /**
    * The displayHelpMenuView method
    * Purpose: Displays help menu of game 
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void displayHelpMenuView() {
        System.out.println("Start display help menu view option selected.");
        // Display the Help menu 
           HelpMenuView hmv = new HelpMenuView();
           hmv.displayMainMenuView();
    }
    
    /**
    * The displaySaveGameView method
    * Purpose: Displays the save menu of game 
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void displaySaveGameView() {
        System.out.println("Start save game view option selected."); 
    }

   
    
    
}
