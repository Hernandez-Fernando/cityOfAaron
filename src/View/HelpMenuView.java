/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Scanner;
/**
 *
 * @author BURGOS
 */
public class HelpMenuView extends MenuView {
    Scanner keyboard = new Scanner(System.in);
    private String helpMenu;
    private int max ;
    
    /**
     * The HelpMenuView constructor
     * Purpose: displays the list menu, gets the user's input, and does the * selected action
     * Parameters: none
     * Returns: none
     */
    // =========================================================
    
    public HelpMenuView() {
        super("\n" +
            "**********************************\n" +
            "* HELP MENU *\n" + 
            "**********************************\n" +
            " 1 - What are the goals of the game?\n" +
            " 2 - Where is the city of Aaron?\n" +
            " 3 - How do I view the map?\n" +
            " 4 - How do I move to another location?\n" +
            " 5 - How do I display a list of animals, provisions and tools in the city storehouse\n" +
            " 6 - Back to the Main Menu\n",
            6); 
        }
    
    
    /**
    *The doAction method
    * Purpose: performs the selected action 
    * Parameters: none
    * Returns: none
    */
    // ===================================
    @Override public void doAction(int option) {
        switch(option) {
            // if the option is 1, viewGoals()
            case 1:
                viewGoals();
                break;
            // if the option is 2, call viewLocation( ) 
            case 2:
                viewLocation( );
                break;
            // if the option is 3, call viewMapHelp()
            case 3:
                viewMapHelp();
                break;
            // if the option is 4, call viewMoveHelp()
            case 4:
                viewMoveHelp();
                break;
            // if the option is 5, call viewListHelp()
            case 5:
                viewListHelp();
                break;
            // if the option is 6, return to Main Menu
            case 6:
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
    public void viewGoals() {
        // Display the goals of the game.
        System.out.println("The game of City of Aaron lasts 10 years."
                + " being a year, one turn.\n "
                + "The game player will assume the role of the Aaron city leader.\n "
                + "Wheat is the staff of life, and is used as the main currency.\n "
                + "You must determine how to allocate your scarce bushels of grain:\n "
                + "buying and selling acres of land, feeding your population,\n "
                + "and planting seeds for next year's crops.\n "
                + "Each person needs 20 bushels of grain each year\n "
                + "to live and can till at most 10 acres of land.\n "
                + "The city is blessed when the people pay their tithes and offerings\n "
                + "After to have passed 10 years, you will be judged by the people\n "
                + "and you'll be ranked against great figures in history.\n");
    } 
    
    /**
    * The viewLocation method
    * Purpose: Inform about where the city of Aaron is located
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void viewLocation() {
        System.out.println("City of Aaron is located  in vicinity of Ammonihah City"); 
    } 
    
    /**
    * The viewMapHelp method
    * Purpose: Display instructions about how to view the map 
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void viewMapHelp() {
        System.out.println("To view the map:\n "
                + "Go to Main Menu by entering 6.\n "
                + "Then, input 1 to display the game menu.\n "
                + "Finally, view the map by entering 1\n"); 
    }
    
    /**
    * The viewMoveHelp method
    * Purpose: Display instructions about how to move to another location 
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void viewMoveHelp() {
        System.out.println("To move to a new location, you must:\n "
                + "Go to the Main Menu by entering 6.\n "
                + "Then, input 1 to display the game menu.\n "
                + "Finally, input 3 where you will be asked\n "
                + "to enter the coordinates of the location on the map you want to move to\n "); 
    }
    
    /**
    * The viewListHelp method
    * Purpose: Display a list of animals, provision and tools in the city storehouse
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void viewListHelp() {
        System.out.println("To view a list of items in inventory, you must:\n "
                + "Go to the Main Menu by entering 6.\n "
                + "Then, input 1 to display the game menu.\n "
                + "Finally, input 2 where you will view a set of list options.\n "
                + "Enter the number according list you want to view.\n ");        
    }
    

    
}
