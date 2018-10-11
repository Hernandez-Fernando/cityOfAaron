/*
 * The main() class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Sara Compoverde, Annika Rau, Fernando Hernandez 
 */
package model;

/**
 *
 * @author fernando
 */

public enum TeamMembers {
    Member1("Fernando","Arizona"),
    Member2("Sara","Guayaquil"),
    Member3("Annika","Oregon");
    private String name;
    private String title;
        
    TeamMembers(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "TeamMembers{" + "name=" + name + ", title=" + title + '}';
    }
    
    
}
