/*
 * The main() class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Sara Compoverde, Annika Rau, Fernando Hernandez 
 */
package cityofaaron;

import model.CropData;
import model.ListItem;
import model.Location;
import model.Player;
import model.TeamMembers;

/**
 *
 * @author fernando
 */
public class CityOfAaron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        
        playerOne.setName("Charlie");
        
        System.out.println("********** Player Class Testing ********");
        String playerOneName = playerOne.getName();
        System.out.println("Name = " + playerOneName);
        
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
        
         // CropData Testing
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
    
}
