package richardsde; /*
 * Course: CS-1011-011
 * Fall 2020
 * Lab 9 - Lots of Parking
 * Name: Derek Richards
 * Created 11/3/2020
 */

/**
 * Manages parking lots within a district.
 * @author Derek Richards
 */
public class District {

    /**
     * The maximum amount of parking lots allowed in the district.
     */
    public static final int MAX_LOTS = 20;
    private ParkingLot[] lots;
    private int numLots;
    private int closingStart;
    private int closingEnd;
    private int closingTotal;


    /**
     * The Constructor for the District class. Creates an
     * array of ParkingLot objects of length 20.
     */
    public District(){
        lots = new ParkingLot[MAX_LOTS];
    } // end constructor

    /**
     * Adds a ParkingLot object to the array of ParkingLots.
     *
     * @param name - The name of the ParkingLot object.
     * @param capacity - The amount of vehicles that can fit in the parking lot.
     * @return - The index of the new lot or -1 if the lot was not added.
     */
    public int addLot(String name, int capacity){
        int newIndex = numLots;
        if(newIndex<MAX_LOTS) {
            lots[newIndex] = new ParkingLot(name, capacity);
            numLots++;
        }
        // return the index of the new lot or -1 if the lot was not added.
        return newIndex<MAX_LOTS ? newIndex : -1;
    } // end addLot

    /**
     * Returns a ParkingLot object from the "lots" array at the index.
     * Precondition: index is a valid number.
     * @param index - The index of the ParkingLot object
     * @return - The ParkingLot object.
     */
    public ParkingLot getLot(int index){
        return lots[index];
    } // end getLot


    /**
     * Returns the number of remaining parking spots in the district
     * @return the number of remaining parking spots in the district
     */
    public int getNumberOfSpotsRemaining() {
        int numSpots = 0;
        for(int i = 0; i < numLots; i++){
            numSpots += getLot(i).getNumberOfSpotsRemaining();
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
        for (int i = 0; i < numLots; i++){
            if (!getLot(i).isClosed()){
                return getLot(i).isClosed();
            }
        }
        return true;
    } // end isClosed

    /**
     * Record a vehicle entering a lot at a specified timestamp.
     * <p></p>
     * This calls ParkingLot.markVehicleEntry for the lot corresponding
     * to lotNumber (e.g., if lotNumber==1, call markVehicleEntry on getLot(0)).
     * <p></p>
     * If lotNumber is out of range, the method should return without
     * doing anything else.
     * @param lotNumber Number of lot (should be between 1 and 20)
     * @param timestamp Entry timestamp in minutes since all lots were opened.
     */
    public void markVehicleEntry(int lotNumber, int timestamp) {

        if (lotNumber < numLots){
            getLot(lotNumber).markVehicleEntry(timestamp);
        }
        if (isClosed() && closingStart == 0){
            // This part of the code will only run when all three lots are closed.
            closingStart = timestamp;
        }

    } // end markVehicleEntry

    /**
     * Record a vehicle exiting a lot at a specified timestamp.
     * <p></p>
     * This calls ParkingLot.markVehicleEntry for the lot corresponding
     * to lotNumber (e.g., if lotNumber==1, call markVehicleExit on getLot(0)).
     * <p></p>
     * If lotNumber is out of range, the method should return without
     * doing anything else.
     * @param lotNumber Number of lot (should be between 1 and 20)
     * @param timestamp Entry timestamp in minutes since all lots were opened.
     */
    public void markVehicleExit(int lotNumber, int timestamp) {
        if (lotNumber < numLots){
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
        for(int i = 0; i < numLots; i++){
            output += "  " + getLot(i) + "\n";
        }

        return output;

    } // end toString

    private int calculateClosingTotal(int closingStart, int closingEnd){
        return closingEnd - closingStart;
    } // end calculateClosingTotal
}