package Week8; /*
* Course: CS-1011-011
* Fall 2020
* Homework 8 - Elevator
* Name: Derek Richards
* Created: 10/29/2020
*/
import java.util.Scanner;

/**
 * This class simulates an elevator in a 100 floor building.
 */
public class Elevator {
    /**
     * Represents the amount of floors in the building.
     */
    public static final int NUMBER_OF_FLOORS = 100;

    private final int[] floors;
    private Scanner in;
    private int currentFloor;

    /**
     * The constructor for the elevator class.
     */
    public Elevator(){

        floors = new int[NUMBER_OF_FLOORS];
        setFloors();
        currentFloor = 1;
        in = new Scanner(System.in);
    } // end constructor

    private void setFloors(){
        for (int x = 1; x <= floors.length; x++){
            floors[x - 1] = x;
        }
    } // end setFloors

    /**
     * Prompts the user for a floor and simulates going to that
     * floor as long as the user inputs a value between 1 and 100.
     */
    public void selectFloor(){
        System.out.print("Enter the floor you would like to go to ==> ");
        int input = in.nextInt();
        if (input < 1 || input > NUMBER_OF_FLOORS){
            System.out.println("Invalid floor selection - must be between 1 and 100.");
        } else if (input > currentFloor){
            goingUp(currentFloor, input);
            currentFloor = input;
        } else if (input < currentFloor){
            goingDown(currentFloor, input);
            currentFloor = input;
        }

    } // end selectFloor

    private void goingUp(int currentFloor, int targetFloor){
        System.out.print("Going up . .");
        for (int x = currentFloor; x <= targetFloor; x++){
            System.out.print(x + ". .");
        }
        System.out.println("Ding!");
    } // end goingUp

    private void goingDown(int currentFloor, int targetFloor){
        System.out.print("Going down . .");
        for (int x = currentFloor; x >= targetFloor; x--){
            System.out.print(x + ". .");
        }
        System.out.println("Ding!");
    } // end goingDown

    /**
     * Prints out a danger message and has the user go down to the first floor.
     */
    public void fireAlarm(){
        System.out.println("Danger! You must exit the building now!");
        goingDown(currentFloor, 1);
    } // end fireAlarm

}
