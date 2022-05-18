package Week8; /*
 * Course: CS-1011-011
 * Fall 2020
 * Homework 8 - ElevatorDriver
 * Name: Derek Richards
 * Created: 10/29/2020
 */

import java.util.Scanner;

public class ElevatorDriver {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Derek's elevator simulator!\n");
        Elevator elevator = new Elevator();
        String input = "";

        do { // program loop
            System.out.println("Options: (s)elect floor, (f)ire alarm, (q)uit");
            System.out.print("Enter s, f, or q ==> ");
            input = in.nextLine();
            switch (input) {
                case "s":
                    elevator.selectFloor();
                    break;
                case "f":
                    elevator.fireAlarm();
                    break;
                case "q":
                    System.out.println("Thank you for using the program!");
                    break;
                default:
                    System.out.println("Invalid entry.");
                    break;
            }
        } while (!input.equalsIgnoreCase("q"));
    }
}
