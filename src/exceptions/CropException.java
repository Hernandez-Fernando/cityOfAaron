/*
 * The Exception class file for the cityOfAaron project
 * CIT-260
 * Fall 2018
 * Team members: Sara Compoverde, Annika Rau, Fernando Hernandez 
 */
package exceptions;

/**
 *
 * @author fernando
 */
public class CropException extends Exception {
    /**
    * Default constructor
    * Purpose: Initializes data members to default values * Parameters: none
    * Returns: none
    */
    public CropException() { }
    /**
    * Parameterized constructor
    * Purpose: Initializes data members to value passed as a parameter * Parameters: A string containing the error message
    * Returns: none
    */
    public CropException(String string)
    {
        super(string); // passes the error message to the base class constructor.
    
     }
    
}
