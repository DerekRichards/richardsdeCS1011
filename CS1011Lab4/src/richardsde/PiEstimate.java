package richardsde;/*
 * Course: CS-1011-011
 * Fall 2020
 * Lab 4 - Pi Estimate
 * Name: Derek Richards
 * Created: 09/30/2020
 */

import java.util.Scanner;
public class PiEstimate {

    public static void main (String[] args){
        // Declaring variables
        int width;
        double error;
        int count;
        double estimate;
        Scanner scan = new Scanner(System.in);

        // Ask user for the desired width
        System.out.println("Enter the desired width: ");
        width = scan.nextInt();

        // Counting the number of pixels
        count = areaUnderCurve(width);

        // Estimates Pi using the amount of asterisks and the width squared
        estimate = 4.0 * (count/(Math.pow(width, 2)));
        System.out.println("4 * " + count + "/" + Math.pow(width, 2) + " = " + estimate);

        //Ask the user for the minimum error and store it in a double
        System.out.print("Enter the minimum desired error for the estimate of PI: ");
        error = scan.nextDouble();

        estimateError(error, width);
    }

// Calculating the estimate for Pi
    public static int areaUnderCurve(int width){
        // Creating the top border
        System.out.print("+");
        for (int i = 0; i < width; i++){
            System.out.print("-");
        }
        System.out.println("+");

        // Counting the pixels
        int count = 0;

        // Setting a limit for the distance
        double limit = (double) width - 0.5;

        // Setting the side borders, printing the pixels, and counting the pixels.
        for (int y = width - 1; y >= 0; y--){
            System.out.print("| ");
            for (int x = 0; x < width; x++){
                double distance = Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
                if (distance < limit){
                    System.out.print("*");
                    count++;
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println(" |");
        }

        //Creating the bottom border
        System.out.print("+");
        for (int i = 0; i < width; i++){
            System.out.print("-");
        }
        System.out.println("+");

        return count;
    }

//    // Calculates more estimates of pi within the margin of error
//    public static void errorEstimates(double error){
//        int width = 1;
//        double est = 0;
//        int count = 0;
//        double limit;
//
//        while (Math.abs((Math.PI) - est) > error){
//            limit = (double) width - 0.5;
//
//            for (int y = 0; y < width; y++){
//                for (int x= 0;x < width; x++){
//                    double distance = Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
//                    if (distance < limit ){
//                        count++;
//                    }
//                }
//            }
//            est = (4 * (count/(Math.pow(width, 2))));
//            width++;
//
//        }
//
//        System.out.println("An estimate of " + est + " was achieved with a width of " + width);
//    }



    // Trying to find an estimate for pi within the error range
    public static void estimateError(double error, int width){
        double est = 0;

        //Calling another method again and again until a value within the error range is found
        for (width = 1; Math.abs(Math.PI - est) > error; width++){
            est = areaWithoutPrinting(width);
        }

        System.out.println("An estimate of " + est + " was achieved with a width of " + width);

    }

    // This method calculates an estimate for Pi and returns it
    public static double areaWithoutPrinting(int width ){
        int count = 0;
        double limit = (double) width - 0.5;

        for (int y = width - 1; y >= 0; y--){
            for (int x = 0; x < width; x++){
                double distance = Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));

                if (distance < limit){
                    count++;
                }
            }
        }
        return 4.0 * (count/(Math.pow(width, 2)));
    }
}
