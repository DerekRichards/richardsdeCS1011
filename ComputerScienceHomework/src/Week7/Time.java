package Week7; /*
* Course: CS-1011-011
* Fall 2020
* Homework 7 - Time
* Name: Derek Richards
* Created: 10/22/2020
*/

/**
 *  This class records a certain amount of time, specifically hours, minutes, and seconds.
 */
public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    /**
     * Sets the amount of hours to a certain amount.
     *
     * @param hours - An amount of hours
     * @return - A Time Object
     */
    public Time setHours(int hours){
        this.hours = hours;
        return this;
    } // end setHours

    /**
     * Sets the amount of minutes to a certain amount.
     *
     * @param minutes - An amount of minutes
     * @return - A Time Object
     */
    public Time setMinutes(int minutes){
        this.minutes = minutes;
        return this;
    } // end setMinutes

    /**
     * Sets the amount of seconds to a certain amount.
     *
     * @param seconds - An amount of seconds.
     * @return - A Time Object
     */
    public Time setSeconds(int seconds){
        this.seconds = seconds;
        return this;
    } // end setSeconds


    /**
     * Prints out the amount of hours, minutes, and seconds.
     */
    public void printTime(){
        System.out.printf("%02d:%02d:%02d\n", hours, minutes, seconds);
    } // end printTime

}
