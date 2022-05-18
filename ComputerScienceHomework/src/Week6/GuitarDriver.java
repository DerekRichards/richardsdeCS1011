package Week6; /*
* Course: CS-1011-011
* Fall 2020
* Homework 6 - GuitarDriver
* Name: Derek Richards
* Created: 10/14/2020
*/

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * This uses the Guitar class to simulate
 * a guitar string being plucked.
 */
public class GuitarDriver {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        double stepSize;
        int numSteps;
        double time = 0;

        Guitar guitar1 = new Guitar();
        guitar1.initialize();
        System.out.print("Enter time step size: ");
        stepSize = scan.nextDouble();
        System.out.print("Enter the amount of steps in simulation: ");
        numSteps = scan.nextInt();

        for (int timeStep = 0; timeStep < numSteps; timeStep++){
            time += stepSize;
            double change = guitar1.findChange(stepSize);
            guitar1.makeChange(change);
            report(time, guitar1.getY());

        }


    }

    /**
     * Prints out the current time and position.
     *
     * @param time - The current time.
     * @param y - The current position.
     */
    private static void report(double time, double y){
        DecimalFormat formatTime = new DecimalFormat("##.##");
        DecimalFormat formatY = new DecimalFormat("##.########");

        System.out.println("at time = " + formatTime.format(time) +
                ", position = " + formatY.format(y));
    }

}
