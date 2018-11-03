 /**
* Source code for the GameControl class
* The GameControl class is a member of the controllayer
* Methods in the GameControl class manage Game objects 
* Author: Sara Compoverde, Annika Rau, Fernando Hernandez
* Date last modified: October 2018
*/
// ==============================================================
package control;
import model.*;
import cityofaaron.CityOfAaron;

/**
 *
 * @author annikarau
 */
public class GameControl {
    // createNewGame method
    public static void createNewGame(String _name) { 
        
        // create the game object Game game = new Game();
        Game game = new Game();
        
        // create the player object
        Player player = new Player(); 
        
        //save player name in the Player object
        player.setName(_name);
        
        // save reference to the player object in the Game object
        game.setPlayer(player);
        
        // create a CropData object
        CropData cropData = new CropData();
        
        // Initialize the data values in the CropData object
        cropData.setYear(0); 
        cropData.setPopulation(100); 
        cropData.setNewPeople(5); 
        cropData.setCropYield(3); 
        cropData.setNumberWhoDied(0); 
        cropData.setWheatInStore(2700); 
        cropData.setAcresOwned(1000); 
        cropData.setAcresPlanted(1000); 
        cropData.setHarvest(3000); 
        cropData.setAcresPlanted(1000);
        
        // save a reference to it in the Game object
        game.setCropData(cropData);
        
        // Save a reference to the Game object in the static variable declared
        //in the CityofAaron class.
        CityOfAaron.setGame(game);
    }
}
