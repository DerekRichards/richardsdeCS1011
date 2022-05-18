package richardsde; /*
 * Course: CS-1011-011
 * Fall 2020
 * Lab 6 - Simple Class
 * Name: Derek Richards
 * Created: 10/13/2020
 */

import java.util.Scanner;

/**
 * Uses the BuildingCostEstimator class to estimate the
 * cost of building two houses.
 *
 */
public class House {

    private static final int SIMILAR_THRESHOLD = 5;
    private static final int DIFFERENT_THRESHOLD = 25;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);


        BuildingCostEstimator estimator1 = getBuildingCostEstimator(in);
        BuildingCostEstimator estimator2 = getBuildingCostEstimator(in);
        double cost1 = estimator1.costToBuild();
        double cost2 = estimator2.costToBuild();
        double percentDifference = 2 * Math.abs(cost1 - cost2)/(cost1 + cost2);

        String costDeltaDescription = "\nYou are comparing two houses that ";
        if(percentDifference < SIMILAR_THRESHOLD) {
            costDeltaDescription += "cost a similar amount.";
        } else if(percentDifference > DIFFERENT_THRESHOLD) {
            costDeltaDescription += "cost wildly different amounts.";
        } else {
            costDeltaDescription += "have significant cost differences.";
        }
        System.out.println(costDeltaDescription);
        if(estimator1.costToBuild()>=estimator2.costToBuild()) {
            System.out.println("\nThe first house is more expensive...\n");
            displayDetails(estimator1);
            System.out.println("\nThe second house is less expensive...\n");
            displayDetails(estimator2);
        } else {
            System.out.println("\nThe second house is more expensive...\n");
            displayDetails(estimator2);
            System.out.println("\nThe first house is less expensive...\n");
            displayDetails(estimator1);
        }

    }

    /**
     * Display characteristics and cost of the house
     * @param estimator - The BuildingCostEstimator object to display.
     */
    private static void displayDetails(BuildingCostEstimator estimator){
        System.out.print("The cost of building this house with ");
        System.out.printf("%d full baths, %d half baths, \n",
                estimator.getNumFullBaths(),
                estimator.getNumHalfBaths());
        System.out.printf("%d bedrooms, %d windows, \n",
                estimator.getNumBedrooms(),
                estimator.getNumWindows());
        System.out.printf("with a %.1f car garage and taking ",
                estimator.getNumGarages());
        System.out.printf("up %d square feet\n",
                estimator.getSquareFeet());
        System.out.printf("will take $%.2f to build.\n",
                estimator.costToBuild());
    }

    /** Gathers information about the user's ideal house
     * and creates a BuildingCostEstimator object.
     *
     * @param in - The scanner used to obtain user input.
     * @return - A BuildingCostEstimator object is returned.
     */
    private static BuildingCostEstimator getBuildingCostEstimator(Scanner in){
        BuildingCostEstimator estimator = new BuildingCostEstimator();

        // Setting up the variables in the estimator.
        System.out.println("This program will help you estimate the " +
                "cost of building a house.");
        System.out.println("For your desired house:");
        System.out.print("Enter the total number of square feet: ");
        estimator.setSquareFeet(Integer.parseInt(in.nextLine()));
        System.out.print("Enter the number of full bathrooms: ");
        estimator.setNumFullBaths(Integer.parseInt(in.nextLine()));
        System.out.print("Enter the number of half bathrooms: ");
        estimator.setNumHalfBaths(Integer.parseInt(in.nextLine()));
        System.out.print("Enter the number of bedrooms: ");
        estimator.setNumBedrooms(Integer.parseInt(in.nextLine()));
        System.out.print("Enter the number of windows: ");
        estimator.setNumWindows(Integer.parseInt(in.nextLine()));
        System.out.print("Enter the number of garage spaces (e.g., 2.5): ");
        estimator.setNumGarages(Double.parseDouble(in.nextLine()));
        while (estimator.getNumGarages() < 2.0){
            System.out.println("We are in Wisconsin.");
            System.out.println("Perhaps you should reconsider the amount of garage stalls.");
            System.out.print("Enter the number of garage spaces (e.g., 2.5): ");
            estimator.setNumGarages(Double.parseDouble(in.nextLine()));
        }

        return estimator;
    }

}
