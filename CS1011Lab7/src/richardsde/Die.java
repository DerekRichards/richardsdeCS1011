package richardsde; /*
 * Course: CS-1011-011
 * Fall 2020
 * Lab 7 - Battle Simulator 3000
 * Name: Derek Richards
 * Created: 10/19/20
 */

import java.util.Random;

/**
 * This class simulates the process of rolling a die.
 */
public class Die {
    private int numSides;
    private int currentSide;
    private Random generator;
    private final int maxNumSides = 100;
    /**
     *  This the constructor for the die class.
     *
     * @param numSides - The amount of sides on the die.
     */
    public Die(int numSides){
        if (numSides < 2 || numSides > maxNumSides){
            final int defaultNumSides = 6;
            this.numSides = defaultNumSides;
        } else {
            this.numSides = numSides;
        }
        generator = new Random();
        currentSide = generator.nextInt(this.numSides) + 1;
    }

    public int getCurrentSide(){
        return currentSide;
    }

    /**
     *  This method sets the current side to a value
     *  from 1 to the number of total sides.
     */
    public void roll(){
        currentSide = generator.nextInt(numSides) + 1;
    }


}
