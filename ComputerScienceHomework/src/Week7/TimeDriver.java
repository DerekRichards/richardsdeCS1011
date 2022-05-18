package Week7; /*
 * Course: CS-1011-011
 * Fall 2020
 * Homework 7 - TimeDriver
 * Name: Derek Richards
 * Created: 10/22/2020
 */

/**
 * Creates an object of the Time class and uses it to print out the current amount of time
 */
public class TimeDriver {

    public static void main(String[] args){
        Time time = new Time();
        // Magic number without local final variable.
        final int minuteAmount = 30;
        time.setHours(3).setMinutes(minuteAmount).setSeconds(4).printTime();
    }
}
