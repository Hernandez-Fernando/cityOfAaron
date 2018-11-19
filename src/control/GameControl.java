 /**
* Source code for the GameControl class
* The GameControl class is a member of the controllayer
* Methods in the GameControl class manage Game objects 
* Author: Sara Compoverde, Annika Rau, Fernando Hernandez
* Date last modified: October 2018
*/
// ==============================================================
package control;
import java.util.ArrayList;
import model.*;
import cityofaaron.CityOfAaron;

/**
 *
 * @author annikarau
 */
public class GameControl {
    private static final int MAX_ROW = 5;
    private static final int MAX_COL = 5;
    private static Game theGame;
    
    // createNewGame method
    public static void createNewGame(String _name) { 
        
        // create the game object Game game = new Game();
        Game theGame = new Game();
        // Save a reference to the Game object in the static variable declared
        //in the CityofAaron class.
        CityOfAaron.setGame(theGame);
        
        // create the player object
        Player player = new Player(); 
        
        //save player name in the Player object
        player.setName(_name);
        
        // save reference to the player object in the Game object
        theGame.setPlayer(player);
        
        createMap();
        createCropDataObject();
    
    }
    
    public static void createCropDataObject(){
        // create a CropData object
        CropData theCrops = new CropData();
        
        // Initialize the data values in the CropData object
        theCrops.setYear(0); 
        theCrops.setPopulation(100); 
        theCrops.setNewPeople(5); 
        theCrops.setCropYield(3); 
        theCrops.setNumberWhoDied(0); 
        theCrops.setWheatInStore(2700); 
        theCrops.setAcresOwned(1000); 
        theCrops.setAcresPlanted(1000); 
        theCrops.setHarvest(3000);
        theCrops.setOfferingBushels(300);
        theCrops.setAcresPlanted(1000);
        
        // save a reference to it in the Game object
        theGame.setCropData(theCrops);
    }
  
    /**
    * The createMap method
    * Purpose: creates the location objects and the map 
    * Parameters: none
    * Returns: none
    */
    public static void createMap() {
        //private final String displaytheMap = "\n"
//            + "\n--------------------------------------"
//            + "\n        ||City of Aaron Map||         "
//            + "\n--------------------------------------"
//            + "\n        0     1     2     3     0     "
//            + "\n      _____ _____ _____ _____ _____   "
//            + "\n   0 | ^^^ | ^^^ | ___ | !!! | ~~~ |  "
//            + "\n   1 | ^^^ | $$$ | ___ | !!! | ~~~ |  "
//            + "\n   2 | ... | 000 | ___ | !!! | ~~~ |  "
//            + "\n   3 | ... | 000 | ___ | !!! | ~~~ |  "
//            + "\n   4 | === | 000 | ___ | !!! | ~~~ |  "
//            + "\n                                      "
//            + "\n   Key:                               "
//            + "\n   ^^^ - Mountains                    "
//            + "\n   000 - Village                      "
//            + "\n   === - Storehouse                   "
//            + "\n   !!! - wheat                        "
//            + "\n   ~~~ - River                        "
//            + "\n   ... - Desert                       "
//            + "\n   ___ - Undeveloped Land             "
//            + "\n   $$$ - Ruler's Court                "
//            + "\n--------------------------------------"; 
        
        
        // create the Map object,
        // refer to the Map constructor
        Map theMap = new Map(MAX_ROW, MAX_COL);
        
        // create a new Location object
        Location loc = new Location();
        
        // Fill map from left-top to right-bottom
        
        // Define the string for mountains location
        String mountains = "Add text";
        loc = new Location();
        loc.setDescription(mountains + "\n Add trick");
        loc.setSymbol("^^^");
        theMap.setLocation(0, 0, loc);
        theMap.setLocation(0, 1, loc);
        theMap.setLocation(1, 0, loc);
        
        // Define the string for desert location
        String desert = "Add text";
        loc = new Location();
        loc.setDescription(desert + "\n Add trick");
        loc.setSymbol("...");
        theMap.setLocation(2, 0, loc);
        theMap.setLocation(3, 0, loc);
        
        // Define the string for Storehouse location
        String storehouse = "Add text";
        loc = new Location();
        loc.setDescription(storehouse + "\n Add trick");
        loc.setSymbol("===");
        theMap.setLocation(4, 0, loc);
       
        // Define the string for Rulers Court location
        String court = "Add text";
        loc = new Location();
        loc.setDescription(court + "\n Add trick");
        loc.setSymbol("$$$");
        theMap.setLocation(1, 1, loc);
        
        // Define the string for Village location
        String village = "Add text";
        loc = new Location();
        loc.setDescription(village + "\n Add trick");
        loc.setSymbol("000");
        theMap.setLocation(2, 1, loc);
        theMap.setLocation(3, 1, loc);
        theMap.setLocation(4, 1, loc);
 
        // define the string for a undeveloped land location
        String undevelopedLand = "Add text";
        
        // set a farmland location with a hint
        loc = new Location();
        loc.setDescription(undevelopedLand + "\nAdd text");
        loc.setSymbol("___");
        for(int i = 0; i < MAX_ROW; i++)
        {
            theMap.setLocation(i, 2, loc);
        }
        
        // define the string for a farm land location
        String farmland = "You are on the fertile banks of the River.\n" + 
        "In the spring, this low farmland floods and is covered with rich\n" + 
        "new soil. Wheat is planted as far as you can see.";
        
        // set a farmland location with a hint
        loc = new Location();
        loc.setDescription(farmland + "\nOne bushel will plant two acres of wheat.");
        loc.setSymbol("!!!");
        for(int i = 0; i < MAX_ROW; i++)
        {
            theMap.setLocation(i, 3, loc);
        }
        
        // create a string that will go in the Location objects
        // that contain the river
        String river = "You are on the River. The river is the source\n" +
        "of life for our city. The river marks the eastern\n " + 
        "boundary of the city - it is wilderness to the East.\n";
        
        
        // use setters in the Location class to set the description and symbol
        loc.setDescription(river); loc.setSymbol("~~~");
        // set this location object in each cell of the array in column 4
        for(int i = 0; i < MAX_ROW; i++)
        {
            theMap.setLocation(i, 4, loc);
        }
        
        // Add locations to the map object
        theGame.setMap(theMap);
        
    }
    
    public void displayMap() {
        //Game theGame = CityOfAaron.getTheGame();
        Map map = theGame.getMap();
        System.out.println("\n** . The City of Aaron Map  **\n");
               
        //print each line (row)
        for(int i = 0; i < 5; i++){
            //print column of each row
            for(int j = 0; j< 5; j++){
            //column += "|" + map.getLocation(i, j).getSymbol();
            System.out.print(map.getLocation(i, j).getSymbol()+ " ");
            }
           
                        
        }
            System.out.println("\n"
                + "  Map Key:\n"
                + "  ^^^ - Village\n"
                + "  !!! - Farmland\n"
                + "  ~~~ - River\n"
                + "  === - Granary and Storehouse\n"
                + "  $$$ - Rulers Court\n"
                + "  ### - Undeveloped Land");
                    
        }
                
    }