package richardsde; /*
 * Course: CS-1011-011
 * Fall 2020
 * Lab 9 - Lots of Parking
 * Name: Derek Richards
 * Created 11/3/2020
 */

import java.text.DecimalFormat;

/**
 * This class is designed to determine the amount
 * of vehicles that can park in the parking lot.
 */
public class ParkingLot {
    /**
     * Determines when the lot is closed
     */
    public static final double CLOSED_THRESHOLD = 80;
    private final String name;
    private int[] vehicles;
    private int numVehicles;
    private int closingStart;
    private int closingEnd;
    private int closingTotal;
    private int previousEntryTime;

    /**
     * If no name is specified, this constructor will call the other constructor.
     *
     * @param capacity - The maximum amount of cars in the parking lot.
     */
    public ParkingLot(int capacity){
        this("test", capacity);
    } // end constructor

    /**
     * The primary constructor of the class.
     *
     * @param name - The name of the parking lot.
     * @param capacity - The maximum amount of vehicles in the parking lot.
     */
    public ParkingLot(String name, int capacity){
        this.name = name;
        vehicles = new int[capacity];
        numVehicles = 0;
        closingStart = 0;
        closingEnd = 0;
        closingTotal = 0;
        previousEntryTime = 0;
    } // end constructor


    /**
     * Returns how long the parking lot has been closed in total.
     *
     * @return - The total amount of minutes the lot has been closed for.
     */
    public int getMinutesClosed(){
        return closingTotal;
    } // end getMinutesClosed

    public String getName(){
        return name;
    } // end getName

    /**
     * Calculates how many vehicles can still be placed in the parking lot.
     *
     * @return - The amount of spots available in the parking lot.
     */
    public int getNumberOfSpotsRemaining(){
        return vehicles.length - numVehicles;
    } // end getNumberOfSpotsRemaining

    /**
     * Checks the percentage of parking spots that have been taken.
     *
     * @return - Returns the number of vehicles in the parking lot
     * divided by the maximum number of vehicles.
     */
    public double getPercentFull(){
        final int decimalToPercent = 100;
        return (double)numVehicles/vehicles.length * decimalToPercent;
    } // end getPercentFull

    /**
     * Determines whether or not the parking lot is closed.
     *
     * @return - If the percentage of filled up parking spaces is greater
     * than or equal to 80.0, return true. Otherwise, return false.
     */
    public boolean isClosed(){
        return (getPercentFull() >= CLOSED_THRESHOLD);
    } // end isClosed

    /**
     * Adds to the 'vehicles' array as long as the array
     * is not full and checks if the lot starts closing.
     *
     * @param timestamp - The time in minutes when the vehicle parks into the lot.
     */
    public void markVehicleEntry(int timestamp){

        if (timestamp >= previousEntryTime){
            if (numVehicles < vehicles.length){
                vehicles[numVehicles++] = timestamp;
            }
            previousEntryTime = timestamp;
            // To make sure that the right time is taken
            // for when the parking lot closes.
            final int decimalToPercent = 100;
            if (isClosed() && ((double)(numVehicles - 1)/vehicles.length) *
                    decimalToPercent < CLOSED_THRESHOLD){
                // This part of the code will only run if the lot has only closed now.
                closingStart = timestamp;
            }
        }

    } // end markVehicleEntry

    /**
     * Subtracts from the 'vehicles' array and checks if the lot finishes closing.
     *
     * @param timestamp - The time in minutes when the vehicle exits the lot.
     */
    public void markVehicleExit(int timestamp){
        if (timestamp >= previousEntryTime){
            vehicles[--numVehicles] = 0;
            // To make sure that the right time is taken
            // for when the parking lot is no longer closed.
            final int decimalToPercent = 100;
            if (!isClosed() && ((double)(numVehicles + 1)/vehicles.length *
                    decimalToPercent >= CLOSED_THRESHOLD)){
                // This part of the code will only run if the lot has only now opened.
                closingEnd = timestamp;
                closingTotal += calculateMinutesClosed(closingStart, closingEnd);
            }
        }


    } // end markVehicleExit

    private int calculateMinutesClosed(int start, int end){
        return end - start;
    } // end calculateMinutesClosed

    @Override
    public String toString(){
        String percentage;
        DecimalFormat formatPercent = new DecimalFormat("#.#");

        if (isClosed()){
            percentage = "CLOSED";
        } else {
            percentage = formatPercent.format(getPercentFull()) + "%";
            // Formats the percentage to one decimal place.
        }

        return "Status for " + name + " parking lot: " +
                numVehicles + " vehicles (" + percentage + ")";
    } // end toString

}