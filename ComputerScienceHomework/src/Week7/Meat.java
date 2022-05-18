package Week7; /*
* Course: CS-1011-011
* Fall 2020
* Name: Derek Richards
* Created: 10/23/2020
*/

/**
 * This class represents a sandwich that contains meat
 */
public class Meat {
    private String type;
    private int calories;
    private double pricePerPound;

    /**
     * A constructor that only takes in the meat type.
     *
     * @param type - The type of meat
     */
    public Meat(String type){
        this.type = type;
        calories = 0;
        pricePerPound = 0;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public void setCalories(int calories){
        this.calories = calories;
    }

    public int getCalories(){
        return calories;
    }

    public void setPricePerPound(double pricePerPound){
        this.pricePerPound = pricePerPound;
    }

    public double getPricePerPound(){
        return pricePerPound;
    }
}
