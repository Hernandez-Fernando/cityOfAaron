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
        
        // game object
        Game myGame = new Game();

        // Player object
        Player myPlayer = new Player();
        
        //Set player name
        myPlayer.setName("Charlie");
        
        

        System.out.println("********** Player Class Testing ********");
        String myPlayerName = myPlayer.getName();
        System.out.println("Name = " + myPlayerName);

        String memberTwoName = TeamMembers.Member2.getName();
        String memberTwoTitle = TeamMembers.Member2.getTitle();

        System.out.println("\n\n********** TeamMembers Class Testing ********");
        System.out.println("Member Name = " + memberTwoName);
        System.out.println("Member Title = " + memberTwoTitle);


        //ListItem Test        
        String itemOneName = ListItem.ItemOne.getName();
        int itemOneNumber = ListItem.ItemOne.getNumber();

        System.out.println("\n\n********** ListItem Class Testing ********");
        System.out.println("Item Name = " + itemOneName);
        System.out.println("Item Number = " + itemOneNumber);

        //CropData Test
        CropData theCropData = new CropData();
        theCropData.setYear(1993);
        theCropData.setPopulation(12464);
        theCropData.setAcresOwned(12);
        theCropData.setCropYield(16);
        theCropData.setWheatInStore(123556);
        theCropData.setNumberWhoDied(19);
        theCropData.setNewPeople(47);
        theCropData.setHarvest(13);
        theCropData.setHarvestAfterOffering(3);
        theCropData.setOffering(10);
        theCropData.setOfferingBushels(193);
        theCropData.setPeopleFed(1345);
        theCropData.setAcresPlanted(90);
        theCropData.setNumStarved(1335);
        theCropData.setEatenByRats(63);
        theCropData.setWheatForPeople(1243);

        System.out.println("\n\n********** CropData Class Testing ********");
        System.out.println(theCropData.toString());

        // Location Testing
        Location theLocation = new Location();
        theLocation.setDescription("This is a game");
        theLocation.setSymbol("Shield");

        System.out.println("\n\n********** Location Class Testing ********");
        System.out.println(theLocation.toString());
        
       } 
    
    /**
     * Purpose: get the game
     * @return the game instance
     */
    public static Game getGame() {
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
