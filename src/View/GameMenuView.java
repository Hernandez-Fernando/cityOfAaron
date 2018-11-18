 /**
* Source code for the GameControl class
* The GameControl class is a member of the controllayer
* Methods in the GameControl class manage Game objects 
* Author: Sara Compoverde, Annika Rau, Fernando Hernandez
* Date last modified: November 2018
*/
// ==============================================================
package View;
import cityofaaron.CityOfAaron;
import control.*;
import model.*;

import java.util.Scanner;

/**
 *
 * @author fernando
 */
public class GameMenuView extends MenuView {
    Scanner keyboard = new Scanner(System.in);
    private String theGameMenu; 
    private final int MAX = 5;
    
    /**
    * The GameMenuView constructor
    * Purpose: displays the menu, gets the user's input, and does the * selected action
    * Parameters: none
    * Returns: none
    */
    // =========================================================
    
    public GameMenuView() {
        super("\n" +
            "**********************************\n" +
            "*    CITY OF AARON: GAME MENU    *\n" + 
            "**********************************\n" +
            " 1 - View the map\n" +
            " 2 - View / Print a list\n" +
            " 3 - Move to a new location\n" +
            " 4 - Manage the Crops\n" +
            " 5 - Return to the Main menu\n",
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
            // if the option is 1, call viewMap( )
            case 1:
                viewMap();
                break;
            // if the option is 2, call viewList( ) 
            case 2:
                viewList();
                break;
            // if the option is 3, call moveToNewLocation( )
            case 3:
                moveToNewLocation();
                break;
            // if the option is 4, call manageCrops( )
            case 4:
                manageCrops();
                break;
            // if the option is 5, return to the Main Menu
            case 5:
                return;
        } 
    }
    
    public void viewMap() {
        System.out.println("Display Map option selected.");
    }
    
    public void viewList() {
        System.out.println("Display List option selected.");
        // Display the List menu
        //ListMenuView lmv = new ListMenuView();
        //lmv.displayListMenu();
    }
    
    public void moveToNewLocation() {
        System.out.println("Move to a New Location option selected.");
    }
    
    public void manageCrops() {
        System.out.println("Manage Crops option selected.");
        CropView cmv = new CropView();
        cmv.displayMenu();
    }
}
