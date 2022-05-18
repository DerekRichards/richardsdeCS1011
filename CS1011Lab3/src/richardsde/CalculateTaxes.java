package richardsde;/*
 * Course: CS-1011-011
 * Fall 2020
 * Lab 3 - Calculate Taxes
 * Name: Derek Richards
 * Created: 09/23/2020
 */

import java.util.Scanner;
public class CalculateTaxes {


    public static void main (String[] args){
        Scanner stdIn = new Scanner(System.in);
        String maritalStatus;
        double income;
        double taxes = 0.0;
        double taxRate = 0.0;

        System.out.print("Are you a single filer or a married joint filer (enter 's' or 'j')?: ");
        maritalStatus = stdIn.nextLine();
        System.out.print("What was your earned income in 2019?: ");
        income = stdIn.nextDouble();

        // if the user is a single filer
        if (maritalStatus.equalsIgnoreCase("s")) {
            if (income >= 510301) {
                taxes = .1 * 9700 + .12 * 29775 + .22 * 44725
                        + .24 * 76525 + .32 * 43375 + .35 * 306200
                        + .37 * (income - 510300);

            } else if (income <= 510301 && income >= 204101) {
                taxes = .1 * 9700 + .12 * 29775 + .22 * 44725
                        + .24 * 76525 + .32 * 43375 + .35 * (income - 204100);
            } else if (income <= 204100 && income >= 160726) {
                taxes = .1 * 9700 + .12 * 29775 + .22 * 44725
                        + .24 * 76525 + .32 * (income - 160725);
            } else if (income <= 160725 && income >= 84201) {
                taxes = .1 * 9700 + .12 * 29775 + .22 * 44725 + .24 * (income - 84200);
            } else if (income <= 84200 && income >= 39476) {
                taxes = .1 * 9700 + .12 * 29775 + .22 * (income - 39475);
            } else if (income <= 39475 && income >= 9701) {
                taxes = .1 * 9700 + .12 * (income - 9700);
            } else {
                taxes = .1 * income;
            }

        } // if the user is a married joint filer
        else if (maritalStatus.equalsIgnoreCase("j")){
            if (income >= 612351){
                taxes = .1 * 19400 + .12 * 59550 + .22 * 89450
                        + .24 * 153050 + .32 * 86750 + .35 * 204150
                        + .37 * (income - 612350);
            }
            else if (income <= 612350 && income >= 408201){
                taxes = .1 * 19400 + .12 * 59550 + .22 * 89450
                        + .24 * 153050 + .32 * 86750 + .35 * (income - 408200);
            }
            else if (income <= 408200 && income >= 321451){
                taxes = .1 * 19400 + .12 * 59550 + .22 * 89450
                        + .24 * 153050 + .32 * (income - 321450);
            }
            else if (income <= 321450 && income >= 168401){
                taxes = .1 * 19400 + .12 * 59550 + .22 * 89450
                        + .24 * (income - 168400);
            }
            else if (income <= 168400 && income >= 78951){
                taxes = .1 * 19400 + .12 * 59550 + .22 * (income - 78950);
            }
            else if (income <= 78950 && income >= 19401){
                taxes = .1 * 19400 + .12 * (income - 19400);
            }
            else{
                taxes = .1 * (income);
            }

        }
        taxRate = taxes/income * 100;
        System.out.println("Your estimated taxes for 2019 are: $" + taxes);
        System.out.println("This results in a " + taxRate + "% effective tax rate");
    }
}
