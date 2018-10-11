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
public class CropData implements Serializable {
    private Integer year, population, acresOwned, cropYield, wheatInStore, 
         numberWhoDied, newPeople, harvest, harvestAfterOffering, offering, 
         offeringBushels, peopleFed, acresPlanted, numStarved, eatenByRats, 
         wheatForPeople;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getAcresOwned() {
        return acresOwned;
    }

    public void setAcresOwned(Integer acresOwned) {
        this.acresOwned = acresOwned;
    }

    public Integer getCropYield() {
        return cropYield;
    }

    public void setCropYield(Integer cropYield) {
        this.cropYield = cropYield;
    }

    public Integer getWheatInStore() {
        return wheatInStore;
    }

    public void setWheatInStore(Integer wheatInStore) {
        this.wheatInStore = wheatInStore;
    }

    public Integer getNumberWhoDied() {
        return numberWhoDied;
    }

    public void setNumberWhoDied(Integer numberWhoDied) {
        this.numberWhoDied = numberWhoDied;
    }

    public Integer getNewPeople() {
        return newPeople;
    }

    public void setNewPeople(Integer newPeople) {
        this.newPeople = newPeople;
    }

    public Integer getHarvest() {
        return harvest;
    }

    public void setHarvest(Integer harvest) {
        this.harvest = harvest;
    }

    public Integer getHarvestAfterOffering() {
        return harvestAfterOffering;
    }

    public void setHarvestAfterOffering(Integer harvestAfterOffering) {
        this.harvestAfterOffering = harvestAfterOffering;
    }

    public Integer getOffering() {
        return offering;
    }

    public void setOffering(Integer offering) {
        this.offering = offering;
    }

    public Integer getOfferingBushels() {
        return offeringBushels;
    }

    public void setOfferingBushels(Integer offeringBushels) {
        this.offeringBushels = offeringBushels;
    }

    public Integer getPeopleFed() {
        return peopleFed;
    }

    public void setPeopleFed(Integer peopleFed) {
        this.peopleFed = peopleFed;
    }

    public Integer getAcresPlanted() {
        return acresPlanted;
    }

    public void setAcresPlanted(Integer acresPlanted) {
        this.acresPlanted = acresPlanted;
    }

    public Integer getNumStarved() {
        return numStarved;
    }

    public void setNumStarved(Integer numStarved) {
        this.numStarved = numStarved;
    }

    public Integer getEatenByRats() {
        return eatenByRats;
    }

    public void setEatenByRats(Integer eatenByRats) {
        this.eatenByRats = eatenByRats;
    }

    public Integer getWheatForPeople() {
        return wheatForPeople;
    }

    public void setWheatForPeople(Integer wheatForPeople) {
        this.wheatForPeople = wheatForPeople;
    }
    
    

}
