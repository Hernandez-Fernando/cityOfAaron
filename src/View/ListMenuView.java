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
import java.util.ArrayList;

import java.util.Scanner;
/**
 *
 * @author annikarau
 */
public class ListMenuView extends MenuView {
    private Game theGame = CityOfAaron.getTheGame();
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
        // Display a message
        System.out.println("\nView list of Animals");
        
        // Displays the animals.
        GameControl al = new GameControl();
        al.displayAnimalList();
     
    } 
    
    /**
    * The listTools method
    * Purpose: Displays list of tools
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void listTools() {
        // Displays tool list
        
        ArrayList<ListItem> toolList = theGame.getTools();
         
         System.out.println("\n-----------------------------------"
            + "\n         List of Tools        "
            + "\n-----------------------------------");
        System.out.printf("%s %20s", "Tools", "Quantity");
        System.out.println("\n-----------------------------------");
         for (int i = 0; i < toolList.size(); i++) {
             System.out.format("%-20s %-10d\n",toolList.get(i).getName(), toolList.get(i).getNumber());
             
         }
         
         System.out.println("\n-----------------------------------");
         
              
        System.out.println("Would you like to export this list to a file? Y / N");
        String option = keyboard.next();
        
        if(option.equals("y") || option.equals("Y")) {
            String listName = "Tool List";
            System.out.println("Please enter the file path to export:");
            String path = keyboard.next();
            GameControl gc = new GameControl();
            gc.printWriter(path, toolList, listName);
        }
        
    } 
    
    /**
    * The listProvisions method
    * Purpose: Displays list of provisions
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void listProvisions() {
        // Displays the provisions (Gets ArrayList from theGame object)
        ArrayList<ListItem> provisionsList = theGame.getProvisions();  

        System.out.println("\n-----------------------------------"
            + "\n         List of Provisions        "
            + "\n-----------------------------------");
        System.out.printf("%s %17s", "Provision", "Quantity");
        System.out.println("\n-----------------------------------");
        System.out.println();
            for (int i = 0; i < provisionsList.size(); i++) {
                System.out.format("%-20s %-10d\n", provisionsList.get(i).getName(), provisionsList.get(i).getNumber());
                System.out.println();
            }
    }
    
    
    /**
    * The listTeam method
    * Purpose: Displays list of Team Members
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
