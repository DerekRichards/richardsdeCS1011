package richardsde; /*
* Course: CS-1011-011
* Fall 2020
* Homework 5 - PhoneNumber
* Name: Derek Richards
* Created: 10/08/2020
*/

import java.util.Scanner;

/** Has the user enter in a phone number and outputs the country code,
 *  area code, and local number. */
public class PhoneNumber {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String phoneNumber = "";

        System.out.println("PHONE NUMBER DISSECTOR");
        // Empty print statements used throughout the program to give the output more space.
        System.out.println();

        // Program loop. If the user enters 'q', the loop ends.
        while (!phoneNumber.equalsIgnoreCase("q")){

            // if the user inputted a phone number, this method will run.
            if (!phoneNumber.equals("")){
                dissectPhoneNumber(phoneNumber);
            }

            System.out.println("Enter a phone number in the form of cc-area-local,");
            System.out.println("where cc = country code digits, area = area code digits,");
            System.out.println("and local = local phone digits");
            System.out.println("Or enter q to quit:");
            phoneNumber = scan.nextLine();
        }
    } // end main


    /** This method will take a phone number as a parameter
     * and output the country code, area code, and local number.
     *
     * @param phoneNumber - A phone number
     */
    public static void dissectPhoneNumber(String phoneNumber){

        String countryCode;
        String areaCode;
        String localNumber;
        int numberOfDashes = 0;
        int dash1 = 0;
        int dash2 = 0;

        // Checking the entire string for dashes to separate
        // the country code, area code, and local number.
        for (int x = 0; x < phoneNumber.length(); x++){
            if (phoneNumber.charAt(x) == '-'){
                numberOfDashes++;
                // Checking how many dashes have been detected in the phone number so far.
                if (numberOfDashes == 1){
                    // Storing the index of the first dash
                    dash1 = x;
                } else {
                    // Storing the index of the second dash
                    dash2 = x;
                }
            }
        }

        // Separating the actual numbers.
        countryCode = phoneNumber.substring(0, phoneNumber.indexOf("-"));
        areaCode = phoneNumber.substring((dash1 + 1), dash2);
        localNumber = phoneNumber.substring(dash2 + 1);

        System.out.println();
        System.out.println("country code = " + countryCode);
        System.out.println("area code = " + areaCode);
        System.out.println("local phone number = " + localNumber);
        System.out.println();

    } // end dissectPhoneNumber

}
