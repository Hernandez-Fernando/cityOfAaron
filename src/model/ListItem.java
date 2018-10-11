/*
 * The main() class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Sara Compoverde, Annika Rau, Fernando Hernandez 
 */
package model;
/**
 *
 * @author annikarau
 */
public enum ListItem {
    ItemOne("First Item", 12345),
    ItemTwo("Second Item", 67890);
    private String name;
    private int number;

    ListItem(String name, int number) {
        this.name = name;
        this.number = number;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ListItem{" + "name=" + name + ", number=" + number + '}';
    }
}
