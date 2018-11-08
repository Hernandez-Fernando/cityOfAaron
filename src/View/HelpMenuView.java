/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import cityofaaron.CityOfAaron;
import control.*;
import model.*;
import java.util.Scanner;
/**
 *
 * @author BURGOS
 */
public class HelpMenuView {
    Scanner keyboard = new Scanner(System.in);
    private String helpMenu;
    private int max;
    
    /**
     * The HelpMenuView constructor
     * Purpose: displays the list menu, gets the user's input, and does the * selected action
     * Parameters: none
     * Returns: none
     */
    // =========================================================
    
    public HelpMenuView() {
        helpMenu = "\n" +
            "**********************************\n" +
            "* HELP MENU *\n" + "**********************************\n" +
            " 1 - What are the goals of the game?\n" +
            " 2 - Where is the city of Aaron?\n" +
            " 3 - How do I view the map?\n" +
            " 4 - How do I move to another location?\n" +
            " 5 - How do I display a list of animals, provisions and tools in the city storehouse\n" +
            " 6 - Back to the Main Menu";
        max = 6; 
        }
    public void displayHelpMenu() {
        int helpMenuOption;
        do {
            // Display the menu
            System.out.println(helpMenu);
            
            // Prompt the user and get the userâ€™s input // Perform the desired action
            helpMenuOption = getHelpMenuOption();
            
            // Perform the desired action
            doAction(helpMenuOption);
            
            // Determine and display the next view
        } while (helpMenuOption != max);
    }
    
    /**
    * The getMenuOption method
    * Purpose: gets the user's input
    * Parameters: none
    * Returns: integer - the option selected */
    // ===================================
    public int getHelpMenuOption(){
        // declare a variable to hold users input 
        int userInput;
        // begin loop
        do {
            // get user input from the keyboard
            userInput = keyboard.nextInt();
            // if it is not a valid value, output an error message // loop back to the top if input was not valid
            if (userInput < 1 || userInput > max)
            {
            System.out.println("Option must be between 1 and " + max);
            }
        // loop back to the top if input was not valid.
        } while(userInput < 1 || userInput > max);       
        // return the value input by the user
        return userInput;
    }
    
    /**
    *The doAction method
    * Purpose: performs the selected action 
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void doAction(int option) {
        switch(option) {
            // if the option is 1, call gameGoals( )
            case 1:
                gameGoals();
                break;
            // if the option is 2, call aaronCityLocation( ) 
            case 2:
                aaronCityLocation( );
                break;
            // if the option is 3, call displayMap( )
            case 3:
                displayMap();
                break;
            // if the option is 4, call moveLocation()
            case 4:
                moveLocation();
                break;
            // if the option is 5, call displayCityStorehouse()
            case 5:
                displayCityStorehouse();
                break;
            // if the option is 6, return to mainMenuView()
            case 6:
                displayMainMenuView();
                break;
        } 
    }
    
    /**
    * The startNewGame method
    * Purpose: creates game object and starts the game 
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void gameGoals() {
        // Display the goals of the game.
        System.out.println("The game of City of Aaron lasts 10 years."
                + " being a year, one turn "
                + "Your must determine how to allocate your scarce bushels of grain: "
                + "buying and selling acres of land, feeding your population, "
                + "and planting seeds for next year's crops "
                + "Each person needs 20 bushels of grain each year "
                + "to live and can till at most 10 acres of land. "
                + "If you make it to the 11th year, your rule will be evaluated "
                + "and you'll be ranked against great figures in history.");
        
        // Display the Help menu 
        
    } 
    
    /**
    * The aaronCityLocation method
    * Purpose: Inform about where the city of Aaron is located
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void aaronCityLocation() {
        System.out.println("Location of City of Aaron option selected."); 
    } 
    
    /**
    * The displayMap method
    * Purpose: Display instructions about how to view the map 
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void displayMap() {
        System.out.println("How do I view the map? option selected."); 
    }
    
    /**
    * The moveLocation method
    * Purpose: Display instructions about how to move to another location 
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void moveLocation() {
        System.out.println("How do I move to another location option selected."); 
    }
    
    /**
    * The displayCityStorehouse method
    * Purpose: Display a list of animals, provision and tools in the city storehouse
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void displayCityStorehouse() {
        System.out.println("How do I display a list of animals, provisions, "
                + "and tools in the city storehouse option selected.");        
    }
    
    /**
    * The displayMainMenuView method
    * Purpose: Display the main menu
    * Parameters: none
    * Returns: none
    */
    // ===================================
    void displayMainMenuView() {
        // main function - entry point for the program 
        MainMenuView mmv = new MainMenuView();
        
        // runs the main menu
        mmv.displayMenu(); 
    }

    
}
