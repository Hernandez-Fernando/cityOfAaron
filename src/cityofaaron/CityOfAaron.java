/*
 * The main() class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Sara Compoverde, Annika Rau, Fernando Hernandez 
 */
package cityofaaron;

import model.ListItem;
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
        
        String playerOneName = playerOne.getName();
        System.out.println("Name = " + playerOneName);
        
        String memberTwoName = TeamMembers.Member2.getName();
        String memberTwoTitle = TeamMembers.Member2.getTitle();
        
        System.out.println("Member Name = " + memberTwoName);
        System.out.println("Member Title = " + memberTwoTitle);
        
        
        //ListItem Test        
        String itemOneName = ListItem.ItemOne.getName();
        Integer itemOneNumber = ListItem.ItemOne.getNumber();
        
        System.out.println("Item Name = " + itemOneName);
        System.out.println("Item Number = " + itemOneNumber);
    }
    
}
