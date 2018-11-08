/*
 * The main() class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Sara Compoverde, Annika Rau, Fernando Hernandez 
 */
package cityofaaron;
import View.*;
import model.*;

/**
 *
 * @author Annika
 */
public class CityOfAaron {
    // variable for keeping a reference to the Game object
    private static Game theGame = null;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // main function - entry point for the program 
        MainMenuView mmv = new MainMenuView();
        
        // runs the main menu
        mmv.displayMenu(); 
    }
    /**
     * Purpose: get the game
     * @return the game instance
     */
    public static Game getTheGame() {
        return theGame;
    }

    /**
     * Purpose: Set game instance
     * @param _theGame the game instance
     * @ return void
     */
    public static void setGame(Game _theGame) {
        theGame = _theGame;
    }
    
}
