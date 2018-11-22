/*
 * * The ListMenuView class - part of the view layer
 * Object of this class manages the List Menu.
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
public class ListMenuView extends MenuView {
    //import scanner to accept user's option
    Scanner keyboard = new Scanner(System.in);

    /**
    * The ListMenuView constructor
    * Purpose: displays the list menu, gets the user's input, and does the * selected action
    * Parameters: none
    * Returns: none
    */
    // =========================================================

    public ListMenuView() {
            super("\n" +
                "****************************************\n" +
                   "* CITY OF AARON: WELCOME LIST MENU  *\n" +
                "*****************************************\n" +
                " 1 - List or view the animals in the storehouse\n" +
                " 2 - List or view the tools in the storehouse\n" +
                " 3 - List or view the provisions in the storehouse\n" +
                " 4 - List or view the authors of this game\n" +
                " 5 - Return to the Main Menu\n",
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
            // if the option is 1, call listAnimals( )
            case 1:
                listAnimals();
                break;
            // if the option is 2, call listTools( ) 
            case 2:
                listTools();
                break;
            // if the option is 3, call listProvisions( )
            case 3:
                listProvisions();
                break;
            // if the option is 4, call listTeam( )
            case 4:
                listTeam();
                break;
            // return to the main menu
            case 5:
                return;
                
        } 
    }

    /**
    * The listAnimals method
    * Purpose: Displays list of animals
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void listAnimals() {
        // Displays the animals.
      
        // Display a message
        System.out.println("\nView list of Animals");
    } 
    
    /**
    * The listTools method
    * Purpose: Displays list of animals
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void listTools() {
        // Displays the tools.
      
        // Display a message
        GameControl gameControl = new GameControl();
        gameControl.displayToolList();
    } 
    
    /**
    * The listProvisions method
    * Purpose: Displays list of animals
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void listProvisions() {
        // Displays the provisions.
      
        // Display a message
        System.out.println("\nView list of Provisions");
    } 
    
    /**
    * The listTeam method
    * Purpose: Displays list of animals
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void listTeam() {
        // Displays the tools.
      
        // Display a message
        System.out.println("\nView list of Team Members");
    } 
}
