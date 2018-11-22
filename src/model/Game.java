/*
 * The main() class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Sara Compoverde, Annika Rau, Fernando Hernandez 
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */

public class Game implements Serializable {
   private Player thePlayer;
   private CropData cropData;
   private Map theMap;
   private ArrayList<ListItem> tools;

    public Player getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }

    public CropData getCropData() {
        return cropData;
    }

    public void setCropData(CropData cropData) {
        this.cropData = cropData;
    }

    public void setPlayer(Player player) {
        
    }
    
    public Map getMap() {
        return this.theMap;
    }
    
    public void setMap(Map map) {
        this.theMap = map;
    }

    public ArrayList<ListItem> getTools() {
        return tools;
    }

    public void setTools(ArrayList<ListItem> tools) {
        this.tools = tools;
    }

    
   
   
   
}
