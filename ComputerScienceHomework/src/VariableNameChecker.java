/*
 * Course: CS-1011-011
 * Fall 2020
 * Homework 4 - VariableNameChecker
 * Name: Derek Richards
 * Created: 10/01/2020
 */

import java.util.Scanner;
public class VariableNameChecker {

    public static void main(String[] args){

        // Declaring variables
        String var = "";
        Scanner scan = new Scanner(System.in);

        // Asking the user for inputs
        System.out.println("This program checks the properness of a proposed Java variable name.");
        System.out.print("Enter a variable name (press q to quit): ");
        var = scan.nextLine();

        // As long as the user doesn't type in the single letter 'q' the loop will run.
        while (!var.equalsIgnoreCase("q")){
            int nonLetters = 0;

            // Counts the amount of characters that aren't numbers or letters.
            for (int x = 0; x < var.length(); x++){
                if (Character.isLetterOrDigit(var.charAt(x)) == false){
                    nonLetters++;
                }
            }

            if (Character.isDigit(var.charAt(0))){
                System.out.println("Illegal.");
            }
            else if (var.indexOf(" ") != -1){
                System.out.println("Illegal.");
            }
            else if (Character.isUpperCase(var.charAt(0))){
                System.out.println("Legal, but uses poor style.");
            }
            else if (nonLetters > 0){
                System.out.println("Legal, but uses poor style.");
            }
            else {
                System.out.println("Good!");
            }



            System.out.print("Enter a variable name (press q to quit): ");
            var = scan.nextLine();
        }


    }
}
