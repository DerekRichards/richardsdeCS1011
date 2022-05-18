package richardsde; /*
 * Course: CS-1011-011
 * Fall 2020
 * Lab 10 - Lots of Parking Revisited
 * Name: Derek Richards
 * Created 11/10/2020
 */

import java.util.ArrayList;

/**
 * Manages parking lots within a district.
 * @author Derek Richards
 */
public class District {


    private ArrayList<ParkingLot> lots;
    private int closingStart;
    private int closingEnd;
    private int closingTotal;


    /**
     * The Constructor for the District class. Creates an
     * ArrayList of ParkingLot objects.
     */
    public District(){
        lots = new ArrayList<ParkingLot>();
    } // end constructor

    /**
     * Adds a ParkingLot object to the array of ParkingLots.
     *
     * @param name - The name of the ParkingLot object.
     * @param capacity - The amount of vehicles that can fit in the parking lot.
     * @return - The index of the new lot or -1 if the lot was not added.
     */
    public int addLot(String name, int capacity){
        lots.add(new ParkingLot(name, capacity));
        // return the index of the new lot or -1 if the lot was not added.
        return lots.indexOf(new ParkingLot(name, capacity));
    } // end addLot

    /**
     * Returns a ParkingLot object from the "lots" ArrayList at the index.
     * Precondition: index is a valid number.
     * @param index - The index of the ParkingLot object
     * @return - The ParkingLot object.
     */
    public ParkingLot getLot(int index){
        return lots.get(index);
    } // end getLot


    /**
     * Returns the number of remaining parking spots in the district
     * @return the number of remaining parking spots in the district
     */
    public int getNumberOfSpotsRemaining() {
        int numSpots = 0;
        for (ParkingLot parkingLot : lots){
            numSpots += parkingLot.getNumberOfSpotsRemaining();
        }
        return numSpots;
    } // end getNumberOfSpotsRemaining

    /**
     * Returns the amount of time that the entire district has been closed.
     * @return number of minutes that the entire district has been closed.
     */
    public int getMinutesClosed() {
        return closingTotal;
    } // end getMinutesClosed

    /**
     * Checks the status of every lot in the district and returns
     * false if any of the the lots are open. Returns true otherwise.
     *
     * @return Whether every lot in the district is closed.
     */
    public boolean isClosed() {
        for (ParkingLot parkingLot : lots){
            if (!parkingLot.isClosed()){
                return parkingLot.isClosed();
            }
        }
        return true;
    } // end isClosed

    /**
     * Record a vehicle entering a lot at a specified timestamp.
     * <p></p>
     * This calls ParkingLot.markVehicleEntry for the lot corresponding
     * to lotNumber (e.g., if lotNumber==1, call markVehicleEntry on getLot(1)).
     * <p></p>
     * If lotNumber is out of range, the method should return without
     * doing anything else.
     * @param lotNumber Number of lot 
     * @param timestamp Entry timestamp in minutes since all lots were opened.
     */
    public void markVehicleEntry(int lotNumber, int timestamp) {

        if (lotNumber < lots.size()){
            getLot(lotNumber).markVehicleEntry(timestamp);
        }
        if (isClosed() && closingStart == 0){
            // This part of the code will only run when all lots are closed.
            closingStart = timestamp;
        }

    } // end markVehicleEntry

    /**
     * Record a vehicle exiting a lot at a specified timestamp.
     * <p></p>
     * This calls ParkingLot.markVehicleEntry for the lot corresponding
     * to lotNumber (e.g., if lotNumber==1, call markVehicleExit on getLot(1)).
     * <p></p>
     * If lotNumber is out of range, the method should return without
     * doing anything else.
     * @param lotNumber Number of lot
     * @param timestamp Entry timestamp in minutes since all lots were opened.
     */
    public void markVehicleExit(int lotNumber, int timestamp) {
        if (lotNumber < lots.size()){
            getLot(lotNumber).markVehicleExit(timestamp);
        }
        if (!isClosed() && closingStart != 0){
            // This part of the code will only run when at least one lot is open.
            closingEnd = timestamp;
            closingTotal += calculateClosingTotal(closingStart, closingEnd);
            closingStart = 0;
            closingEnd = 0;
        }
    } // end markVehicleExit

    @Override
    public String toString(){
        String output = "District status:\n";
        for(ParkingLot parkingLot : lots){
            output += " " + parkingLot.toString() + "\n";
        }

        return output;

    } // end toString

    private int calculateClosingTotal(int closingStart, int closingEnd){
        return closingEnd - closingStart;
    } // end calculateClosingTotal
}