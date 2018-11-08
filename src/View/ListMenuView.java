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
 * @author annikarau
 */
public class ListMenuView {
    Scanner keyboard = new Scanner(System.in);
    private String listMenu; 
    private int max;

/**
    * The MainMenuView constructor
    * Purpose: displays the list menu, gets the user's input, and does the * selected action
    * Parameters: none
    * Returns: none
    */
    // =========================================================

    public ListMenuView() {
            listMenu = "\n" +
                "**********************************\n" +
                "* View/Print a list *\n" + "**********************************\n" +
                " 1 - List or view the animals in the storehouse\n" +
                " 2 - List or view the tools in the storehouse\n" +
                " 3 - List or view the provisions in the storehouse\n" +
                " 4 - List or view the authors of this game\n" +
                " 5 - Return to the Main Menu";
            max = 5; 
        }
    
    public void displayListMenu() {
        int listMenuOption;
        do {
            // Display the menu
            System.out.println(listMenu);
            
            // Prompt the user and get the userâ€™s input // Perform the desired action
            listMenuOption = getListMenuOption();
            
            // Perform the desired action
            doAction(listMenuOption);
            
            // Determine and display the next view
        } while (listMenuOption != max);
    }
    
    /**
    * The getListMenuOption method
    * Purpose: gets the user's input
    * Parameters: none
    * Returns: integer - the option selected */
    // ===================================
    public int getListMenuOption(){
        // declare a variable to hold userâ€™s input // begin loop
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
    * Purpose: performs the selected action * Parameters: none
    * Returns: none
    */
    // ===================================
    public void doAction(int option) {
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
        System.out.println("You have ");
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
        System.out.println("You have ");
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
        System.out.println("You have ");
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
        System.out.println("You have ");
    } 

}
