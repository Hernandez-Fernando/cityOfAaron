/*
 * The main() class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Sara Compoverde, Annika Rau, Fernando Hernandez 
 */
package model;

import java.io.Serializable;

/**
 *
 * @author fernando
 */

public class Game implements Serializable {
   private Player thePlayer;
   private CropData cropData;
   private Map theMap;

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

    
   
   
   
}
