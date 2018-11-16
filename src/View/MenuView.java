/*
 * The MenuView abstract class - part of the view layer
 * CIT-260
 * Fall 2018
 * Team members: Sara Compoverde, Annika Rau, Fernando Hernandez 
 */
package View;

import java.util.Scanner;

/**
 *
 * @author fernando
 */
public abstract class MenuView implements ViewInterface {
    // the data members common to all menu views
    protected final static Scanner keyboard = new Scanner(System.in);
    protected String menu; // this string holds the menu string protected int max; // this int holds the max input value
    protected int max; // this int hold the max input value
    
    /**
    * MenuView Constructor
    * Purpose: Initialize the view object with the menu string * Parameters: the menu string and the max value
    * Returns: none
    */
    public MenuView(String _menu, int _max) {
        this.menu = _menu;
        this.max = _max;
    }
    
    @Override public void displayMenu() {
        int menuOption = 0;
        do {
            // Display the menu
            System.out.println(menu);
            
            // Prompt the user and get the userâ€™s input // Perform the desired action
            menuOption = getMenuOption();
            
            // Perform the desired action
            doAction(menuOption);
            
            // Determine and display the next view
        } while (menuOption != max);
    }   
        
    /**
    * The getMenuOption method
    * Purpose: gets the user's input
    * Parameters: none
    * Returns: integer - the option selected */
    // ===================================
    @Override public int getMenuOption(){
        // declare a variable to hold userâ€™s input // begin loop
        int userInput;
        // begin loop
        do {
            // get user input from the keyboard
            userInput = keyboard.nextInt();
            // if it is not a valid value, output an error message // loop back to the top if input was not valid
            if (userInput < 1 || userInput > max) {
            System.out.println("Option must be between 1 and " + max);
            }
        // loop back to the top if input was not valid.
        } while(userInput < 1 || userInput > max);       
        // return the value input by the user
        return userInput;
    }
}
