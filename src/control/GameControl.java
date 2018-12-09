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
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
/**
 *
 * @author annikarau
 */
public class GameControl {
    Scanner keyboard = new Scanner(System.in);
    //size of the Locations array
    private static final int MAX_ROW = 5;
    private static final int MAX_COL = 5;
    private static Game theGame;
    
    // createNewGame method
    public static void createNewGame(String _name) { 
        
        // create the game object Game game = new Game();
        theGame = new Game();
        
        // Save a reference to the Game object in the static variable declared
        //in the CityofAaron class.
        CityOfAaron.setGame(theGame);
        
        // create the player object
        Player player = new Player(); 
        
        //save player name in the Player object
        player.setName(_name);
        
        // save reference to the player object in the Game object
        theGame.setPlayer(player);
        
        //call to methods
        createMap();
        createCropDataObject();
        createToolList();
        createAnimalList();
        createProvisionsList();
    
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
//            + "\n        0     1     2     3     4     "
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
        String mountains = "You are in the mountains that mark the northwest boundary \n" + 
                "of the land. Enjoy your hike.";
        loc = new Location();
        loc.setDescription(mountains + "\n Add trick");
        loc.setSymbol("^^^");
        theMap.setLocation(0, 0, loc);
        theMap.setLocation(0, 1, loc);
        theMap.setLocation(1, 0, loc);
        
        // Define the string for desert location
        String desert = "You are in the desert on the western-most boundary of \n" +
                "the land. Nothing grows here and you're getting very thirsty.";
        loc = new Location();
        loc.setDescription(desert + "\n Nothing to do here.");
        loc.setSymbol("...");
        theMap.setLocation(2, 0, loc);
        theMap.setLocation(3, 0, loc);
        
        // Define the string for Storehouse location
        String storehouse = "This is the City's Granary and Storehouse\n "
                          + "where your wheat will be stored.";
        loc = new Location();
        loc.setDescription(storehouse + "\nEach person needs 20 bushels of wheat each year to live\n ");
        loc.setSymbol("===");
        theMap.setLocation(4, 0, loc);
       
        // Define the string for Rulers Court location
        String court = "This is the Ruler's Court, your court\n "
                     + "where you will rule over each one of their inhabitants.\n "
                     + "Always with wise, justice, and mercy";
        loc = new Location();
        loc.setDescription(court);
        loc.setSymbol("$$$");
        theMap.setLocation(1, 1, loc);
        
        // Define the string for Village location
        String village = "You are in the main village where all people are friendly\n" +
                "and live in peace. People love their lives and rulers and expect\n "
                +"to live a happy and righteous life.";
        loc = new Location();
        loc.setDescription(village + "\n People will follow according to your choices, always remember your people.");
        loc.setSymbol("000");
        theMap.setLocation(2, 1, loc);
        theMap.setLocation(3, 1, loc);
        theMap.setLocation(4, 1, loc);
 
        // define the string for a undeveloped land location
        String undevelopedLand = "This is an open land where there is nothing built or planted,\n"
                +"it's a land opened to different opoortunities. How are you going to take advantage of it?";
        
        // set a farmland location with a hint
        loc = new Location();
        loc.setDescription(undevelopedLand);
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
        
        loc = new Location();
        // use setters in the Location class to set the description and symbol
        loc.setDescription(river); 
        loc.setSymbol("~~~");
        // set this location object in each cell of the array in column 4
        for(int i = 0; i < MAX_ROW; i++)
        {
            theMap.setLocation(i, 4, loc);
        }
        
        // Add locations to the map object
        theGame.setMap(theMap);
        
    }
    
    public void displayMap() {
        Map map = theGame.getMap();
        System.out.println(  
                "\n--------------------------------------"
              + "\n          City of Aaron Map           "
              + "\n--------------------------------------"
              + "\n        0     1     2     3     4     "
              + "\n      _____ _____ _____ _____ _____   ");
               
        //print each row
        for(int i = 0; i < 5; i++){
            String row = "\n   "+i+" |"; 
            for(int j = 0; j< 5; j++){
                row += " " + map.getLocation(i, j).getSymbol()+ " |";
                System.out.print(row);
                row = "";
            }
        }
            System.out.println("\n"
                + "\n   Map Key:"
                + "\n   ^^^ - Mountains                "
                + "\n   000 - Village                  "
                + "\n   === - Storehouse               "
                + "\n   !!! - wheat                    "
                + "\n   ~~~ - River                    "
                + "\n   ... - Desert                   "
                + "\n   ___ - Undeveloped Land         "
                + "\n   $$$ - Ruler's Court");
                    
        }
    
     public static void createToolList() {
        ArrayList<ListItem> tools = new ArrayList<>();
 
        tools.add(new ListItem("Hammer", 20)); 
        tools.add(new ListItem("Shovel", 15)); 
        tools.add(new ListItem("Pitch Fork", 20)); 
        tools.add(new ListItem("Axe", 10));
        tools.add(new ListItem("Hoe", 10));
        
        theGame.setTools(tools);
     }
    
     //create arrayList to display animals in the storehouse
     public static void createAnimalList(){
         
         ArrayList<ListItem> animals = new ArrayList<>();
         
         animals.add(new ListItem("Cows", 12));
         animals.add(new ListItem("Horses", 24));
         animals.add(new ListItem("Pigs", 17));
         animals.add(new ListItem("Goats", 14));
         animals.add(new ListItem("Sheeps", 16));
         animals.add(new ListItem("Duck", 20));
         animals.add(new ListItem("Rabbit", 10));
         
         theGame.setAnimals(animals);
     }
     //display animal list
     public void displayAnimalList() {
         ArrayList<ListItem> animalList = theGame.getAnimals();  
         
         System.out.println("\n-----------------------------------"
                          + "\n         List of Animals           "
                          + "\n-----------------------------------"
                          + "\n    Quantity        Animal Name    "
                          + "\n-----------------------------------");
         for (int i = 0; i < animalList.size(); i++) {
             System.out.println("       " + animalList.get(i).getNumber() + 
                                "              " + animalList.get(i).getName()); 
         }    
     }
     
    //create arrayList to display list of provisions in the storehouse.
    public static void createProvisionsList() {
        ArrayList<ListItem>provisions = new ArrayList<>();

        provisions.add(new ListItem("Feathers", 50));
        provisions.add(new ListItem("Bows", 20));
        provisions.add(new ListItem("Arrows", 80));
        provisions.add(new ListItem("Cooking pots", 10));
        provisions.add(new ListItem("Fishing nets", 30));
        provisions.add(new ListItem("Spears", 40));
        provisions.add(new ListItem("Hides", 15));

        theGame.setProvisions(provisions);
    }
    
    //the saveGame() method
    // Purpose: saves a game to disk
    // Parameters: the file path
    // Returns: none
    public static void saveGame(String filepath) {
        Game theGame = null;
        
        try (FileOutputStream fops = new FileOutputStream(filepath)) {
           ObjectOutputStream output = new ObjectOutputStream(fops);
           output.writeObject(theGame);
           
           CityOfAaron.setGame(theGame);
       } catch (Exception e) {
           System.out.println("\nError saving the game file.");
       }
        
    }
    
    //the getSavedGame method
    //Purpose: load saved game from disk
    // Parameters: the file path
    //Returns: updates game reference on disk
    public static void getSavedGame(String filepath) {
       Game theGame = null;
       
       try (FileInputStream fips = new FileInputStream(filepath)) {
           ObjectInputStream input = new ObjectInputStream(fips);
           theGame = (Game)input.readObject();
           CityOfAaron.setGame(theGame);
       } catch (Exception e) {
           System.out.println("\nError reading the game file.");
       }
    }
    
    public static void printWriter(String filePath, ArrayList<ListItem> list, String listName) {
        
        try (PrintWriter pwout = new PrintWriter(filePath)) {
            // Add Header
            pwout.println("\n\n   " + listName + " Report");
            
            // Add Table data
            pwout.printf("%n%-20s%10s", listName, "Quantity");
            pwout.printf("%n%-20s%10s", "------", "--------"); 
            
            for (ListItem item : list) {
                pwout.printf("%n%-20s%7d", item.getName(), item.getNumber());
            }
            
            // Display Succesful report created.
            System.out.println("\nReport was saved to " + filePath + " successfully!");
            pwout.close();
        }
        catch(Exception e) {
        
            // Output Error Message
            System.out.println("\nThere was an error saving the the listlist to disk. " + e.getMessage());
        }
}
    
    
}
                
  