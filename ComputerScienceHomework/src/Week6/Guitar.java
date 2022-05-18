package Week6; /*
* Course: CS-1011-011
* Fall 2020
* Homework 6 - Guitar
* Name: Derek Richards
* Created: 10/14/2020
*/

import java.util.Scanner;

/**
 * This program simulates the motion
 * of plucking a Guitar string.
 */
public class Guitar {

    private double dampingFactor;
    private double y;
    private double oldY;
    Scanner scan = new Scanner(System.in);

    /**
     * Initializes a guitar object, since the
     * guitar class lacks a constructor.
     */
    public void initialize(){
        System.out.print("Enter damping factor: ");
        dampingFactor = scan.nextDouble();
        System.out.print("Enter initial previous position: ");
        oldY = scan.nextDouble();
        System.out.print("Enter initial current position: ");
        y = scan.nextDouble();
    }


    /**
     * Calculates the total change in
     * a guitar string's position.
     *
     * @param stepSize - A desired time interval
     * @return - The total change in the
     * position of the guitar string.
     */
    public double findChange(double stepSize){
        int dampingSign;
        if (dampingFactor >= 0){
            dampingSign = 1;
        } else {
            dampingSign = -1;
        }

        double change = (y - oldY) - y * stepSize * stepSize;
        change -= dampingSign * dampingFactor * change * change;
        return change;

    }

    /**
     * Implements the change in position
     * by updating the variables.
     *
     * @param change - The calculated change
     * from the findChange method.
     */
    public void makeChange(double change){
        oldY = y;
        y += change;
    }

    public double getY(){
        return y;
    }

    /**
     * Prints the out the instance variables
     * and replaces the built-in toString method.
     *
     * @return - The parameters of the Guitar object
     */
    @Override
    public String toString(){
        return "dampingFactor: " + dampingFactor
                + "\nprevious position: " + oldY
                + "\ncurrent position: " + y;
    }

    /**
     * Checks whether the values of two Guitar
     * objects' instance variables are the same.
     *
     * @param other - Another Guitar object
     * @return - Returns whether or not the two
     * Guitar objects have the same instance variables.
     */
    @Override
    public boolean equals(Object other){
        return this.dampingFactor == ((Guitar)other).dampingFactor
                && this.oldY == ((Guitar)other).oldY
                && this.y == ((Guitar)other).y;
    }

}
