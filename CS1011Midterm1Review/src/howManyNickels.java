

import java.util.Scanner;
public class howManyNickels {

    public static void main(String[] args){
        // declare variables to use later
        String input = "";
        double dollars = 0;
        int nickels = 0;
        Scanner scan = new Scanner(System.in);

        // Ask the user for input
        System.out.print("Enter a dollar amount (no $) : ");
        input = scan.nextLine();
        dollars = Double.parseDouble(input);

        // Calculate the amount of nickels
        nickels = (int) (dollars / .05);

        // Print out the amount of nickels
        System.out.println("That is equivalent to " + nickels + " nickels.");
    }
}
