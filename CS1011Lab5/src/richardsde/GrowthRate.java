package richardsde; /*
* Course: CS-1011-011
* Fall 2020
* Lab 5 - GrowthRate
* Name: Derek Richards
* Created: 10/6/2020
*/

import java.util.Scanner;

/** Compares two methods of increasing money: Linear growth and exponential growth */
public class GrowthRate {

    public static void main(String[] args){
        int play = 1;
        Scanner scan = new Scanner(System.in);

        //This method will call another method and stop if the user enters a value other than 1.
        while (play == 1){
            growth();
            System.out.println("Would you like to play again? (Press 1 for yes, 0 for no)");
            play = scan.nextInt();
        }
    } // end main


    /**
     * This method will call one of two other methods
     * depending on the user's input.
     *
     *
     */
    public static void growth(){

        Scanner scan = new Scanner(System.in);
        int typeOfGrowth;

        // The scenario that I'm using
        System.out.println("You are currently interested in buying a brand new house," +
                " and your employer is going to help you get the money to pay for it" +
                " for a limited (but unknown) amount of time.");
        System.out.println("You have two different options regarding how your employer pays you:");
        System.out.println("You have the option to get paid a set amount (between 0 and 5000) " +
                "each week or you can have your employer double the amount of money" +
                " you get each week, starting at 1 penny.");
        System.out.print("Which option would you prefer?" +
                " (Press 1 for linear growth, 2 for exponential growth): ");
        typeOfGrowth = scan.nextInt();


        if (typeOfGrowth == 1) {
            // Calls the method if the user chooses linear growth
            linear();
        } else if (typeOfGrowth == 2){
            //Calls the method if the user chooses exponential growth
            exponential();
        }
    } // end growth

    /**
     * If the user chose linear growth, this method will calculate
     * both linear growth and exponential growth. If linear growth
     * results in a higher amount of money, the user will know that
     * they chose the better option. If not, they chose the worse option.
     *
     *
     */
    public static void linear(){
        // Setting the starting value of the amount of
        // for linear growth from (0.0, 5000.0]
        final double linearStart = -5000 * Math.random() + 5000;
        double linearAmount = linearStart;

        // Setting the exponential growth value as one cent ($0.01) to start.
        final double exponentialStart = 0.01;
        double exponentialAmount = exponentialStart;

        // Setting the amount of weeks to be from [1, 40]
        final int numberOfWeeks = (int) (-40 * Math.random() + 40);
        double difference;

        // Printing out the first values for the first week
        System.out.printf("Week %2d Linear: $%.2f, Exponential: " +
                "$%.2f\n", 1, linearAmount, exponentialAmount);


        // Calculating the values for linear and exponential growth until the final week is reached.
        // Printing out both values if the value for linear growth
        // is still greater than the value for exponential growth.
        // If the value for exponential growth is higher,
        // nothing will be printed, but the values will still be calculated.
        for (int x = 2; x <= numberOfWeeks; x++){
            if (linearAmount > exponentialAmount){
                linearAmount += linearStart;
                exponentialAmount *= 2;
                System.out.printf("Week %2d Linear: $%.2f, Exponential: " +
                        "$%.2f\n", x, linearAmount, exponentialAmount);
            } else {
                linearAmount += linearStart;
                exponentialAmount *= 2;
            }

        }

        // Calculating the difference between the two final values
        difference = Math.abs(linearAmount - exponentialAmount);

        // Checks if the the user picked the better option or not
        if (linearAmount > exponentialAmount){
            System.out.printf("Your employer ends their payment on Week %2d, " +
                    "and they gave you an extra $%.2f" +
                    " that you wouldn't have gotten " +
                    "with the other option\n", numberOfWeeks, difference);
        } else if (exponentialAmount > linearAmount){
            System.out.printf("Your employer ends their payment on Week %2d, " +
                            "and you missed out an extra $%.2f\n", numberOfWeeks, difference);
        }


    } // end linear

    /**
     * If the user chose exponential growth, this method will
     * calculate both linear and exponential growth. If exponential growth
     * results in a higher amount of money, the user will know that
     * they took the better option. If not, they picked the wrong option.
     *
     *
     */
    public static void exponential(){
        // Setting the starting value of the amount of
        // for linear growth from (0.0, 5000.0]
        final double linearStart = -5000 * Math.random() + 5000;
        double linearAmount = linearStart;

        // Setting the exponential growth value as one cent ($0.01) to start.
        final double exponentialStart = 0.01;
        double exponentialAmount = exponentialStart;

        // Setting the amount of weeks to be from [1, 40]
        final int numberOfWeeks = (int) (-40 * Math.random() + 40);
        double difference;

        // Printing out the first values for the first week
        System.out.printf("Week %2d Linear: $%.2f, Exponential: " +
                "$%.2f\n", 1, linearAmount, exponentialAmount);


        // Calculating the values for linear and exponential growth until the final week is reached.
        // Printing out both values if the value for linear growth
        // is still greater than the value for exponential growth.
        // If the value for exponential growth is higher,
        // nothing will be printed, but the values will still be calculated.
        for (int x = 2; x <= numberOfWeeks; x++){
            if (linearAmount > exponentialAmount){
                linearAmount += linearStart;
                exponentialAmount *= 2;
                System.out.printf("Week %2d Linear: $%.2f, Exponential: " +
                        "$%.2f\n", x, linearAmount, exponentialAmount);
            } else {
                linearAmount += linearStart;
                exponentialAmount *= 2;
            }

        }

        // Calculating the difference between the two final values
        difference = Math.abs(linearAmount - exponentialAmount);

        // Checking if the user picked the better option or not
        if (exponentialAmount > linearAmount){
            System.out.printf("Your employer ends their payment on Week %2d, " +
                    "and they gave you an extra $%.2f that you wouldn't have gotten " +
                    "with the other option.\n", numberOfWeeks, difference);
        } else if (linearAmount > exponentialAmount){
            System.out.printf("Your employer ends their payment on Week %2d," +
                    " and you missed out an extra $%.2f\n", numberOfWeeks, difference);
        }
    } // end exponential
}
