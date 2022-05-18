package richardsde; /*
 * Course: CS-1011-011
 * Fall 2020
 * Lab 6 - Simple Class
 * Name: Derek Richards
 * Created: 10/13/2020
 */

/** Estimates the cost of building a house
 *
 */
public class BuildingCostEstimator {
    private int squareFeet;
    private int numFullBaths;
    private int numHalfBaths;
    private int numBedrooms;
    private int numWindows;
    private double numGarages;

    /** Constructor for the class. Gives the
     * variables a default value of 0
     *
     */
    public BuildingCostEstimator(){
        squareFeet = 0;
        numFullBaths = 0;
        numHalfBaths = 0;
        numBedrooms = 0;
        numWindows = 0;
        numGarages = 0.0;
    }

    public void setSquareFeet(int sqFeet){
        squareFeet = sqFeet;
    }

    public int getSquareFeet(){
        return squareFeet;
    }

    public void setNumFullBaths(int numFullBaths){
        this.numFullBaths = numFullBaths;
    }

    public int getNumFullBaths(){
        return numFullBaths;
    }

    public void setNumHalfBaths(int numHalfBaths){
        this.numHalfBaths = numHalfBaths;
    }

    public int getNumHalfBaths(){
        return numHalfBaths;
    }

    public void setNumBedrooms(int numBedrooms){
        this.numBedrooms = numBedrooms;
    }

    public int getNumBedrooms(){
        return numBedrooms;
    }

    public void setNumWindows(int numWindows){
        this.numWindows = numWindows;
    }

    public int getNumWindows(){
        return numWindows;
    }

    public void setNumGarages(double numGarages){
        this.numGarages = numGarages;
    }

    public double getNumGarages(){
        return numGarages;
    }

    /** Calculates the full cost to Build the house.
     *
     * @return - The full cost to build the house.
     */
    public double costToBuild(){
        final double squareFootCost = 135;
        final double fullBathroomCost = 20000;
        final double halfBathroomCost = 7000;
        final double bedroomCost = 3000;
        final double windowCost = 1000;
        final double garageCost = 8000;

        return squareFootCost * squareFeet + fullBathroomCost * numFullBaths
                + halfBathroomCost * numHalfBaths + bedroomCost * numBedrooms
                + windowCost * numWindows + garageCost * numGarages;
    }

    /**
     * Replaces the built-in toString() method and prints
     * out the values of the instance variables.
     *
     * @return - The parameters of the BuildCostEstimator object.
     */
    @Override
    public String toString(){
        return "Square Feet: " + squareFeet + "\nFull Bathrooms: " + numFullBaths
                + "\nHalf Bathrooms: " + numHalfBaths + "\nBedrooms: " + numBedrooms
                + "\nWindows: " + numWindows + "\nGarages: " + numGarages;
    }

    /**
     * Replaces the built-in equals() method and checks whether
     * or not two BuildCostEstimator objects have similar values
     * for their instance variables.
     *
     * @param other - A BuildingCostEstimator object that is
     *             being compared to the object calling the method.
     * @return - Returns whether or not the values of all of the instance
     *              variables are the same.
     */
    @Override
    public boolean equals(Object other){
        // Returns true if all of the instance variables of two objects are equal.
        return this.squareFeet == ((BuildingCostEstimator)other).squareFeet
                && this.numFullBaths == ((BuildingCostEstimator)other).numFullBaths
                && this.numHalfBaths == ((BuildingCostEstimator)other).numHalfBaths
                && this.numBedrooms == ((BuildingCostEstimator)other).numBedrooms
                && this.numWindows == ((BuildingCostEstimator)other).numWindows
                && this.numGarages == ((BuildingCostEstimator)other).numGarages;
    }


}
