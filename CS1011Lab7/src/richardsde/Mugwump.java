package richardsde; /*
 * Course: CS-1011-011
 * Fall 2020
 * Lab 7 - Battle Simulator 3000
 * Name: Derek Richards
 * Created: 10/19/20
 */

/**
 * This class represents the enemy character in Battle Simulator 3000.
 */
public class Mugwump {
    private int hitPoints;
    private int maxHitPoints;
    private Die d100;
    private Die d20;
    private Die d10;
    private Die d6;

    /**
     * The constructor of the Mugwump class. Calls the setInitialHitPoints
     * method to initialize the amount of max HP.
     */
    public Mugwump(){
        // Creating local final variables because these are magic numbers otherwise.
        final int die100 = 100;
        final int die20 = 20;
        final int die10 = 10;
        final int die6 = 6;

        d100 = new Die(die100);
        d20 = new Die(die20);
        d10 = new Die(die10);
        d6 = new Die(die6);
        // Calling another method in order to set the player's HP.
        maxHitPoints = setInitialHitPoints();
        hitPoints = maxHitPoints;
    }

    public int getHitPoints(){
        return hitPoints;
    }

    /**
     * Lowers the Mugwump's hit points by the amount of damage taken. If the amount of damage taken
     * is negative, the amount of hit points increases. If the total hit points would be greater
     * than the maximum hit points, then the hit points are set to the maximum.
     *
     * @param damage - The amount of damage taken. Can be positive or negative.
     */
    public void takeDamage(int damage){
        hitPoints -= damage;
    }

    /**
     * Determines which attack the Mugwump uses and
     * calculates the damage dealt to the opponent.
     *
     * @return - The amount of damage dealt. If the mugwump healed
     * itself or missed, the damaged will be zero.
     */
    public int attack(){
        int damage = 0;
        if (ai() == 1){
            final int minimumHit = 12;
            d20.roll();
            // Calculates whether or not the mugwump hits.
            if (d20.getCurrentSide() >= minimumHit){
                for (int x = 0; x < 2; x++){
                    d6.roll();
                    damage += d6.getCurrentSide();
                }
                System.out.println("The Mugwump uses its claws and hits!");
            } else {
                System.out.println("The Mugwump uses its claws and misses!");
            }
        } else if (ai() == 2){
            final int minimumHit = 16;
            d20.roll();
            // Calculates whether or not the mugwump hits.
            if (d20.getCurrentSide() >= minimumHit){
                for (int x = 0; x < 3; x++){
                    d6.roll();
                    damage += d6.getCurrentSide();
                }
                System.out.println("The Mugwump uses its claws and damages the warrior!");
            } else {
                System.out.println("The Mugwump uses its claws and misses!");
            }
        } else if (ai() == 3){
            d6.roll();
            System.out.println("The Mugwump chooses to heal itself!");
            if (d6.getCurrentSide() + hitPoints > maxHitPoints){
                hitPoints = maxHitPoints;
            } else {
                hitPoints += d6.getCurrentSide();
            }
        }
        return damage;
    }

    /**
     * Rolls a 10-sided die 10 times in order to
     * calculate the initial max HP of the Mugwump.
     *
     * @return - The total amount of hit points.
     */
    private int setInitialHitPoints(){
        int count = 0;
        final int numRolls = 10;
        for (int x = 0; x < numRolls; x++){
            d10.roll();
            count += d10.getCurrentSide();
        }
        return count;
    }

    /**
     * Determines what action the Mugwump performs.
     *
     * @return - 1 for the claw attack, 2 for the bite, and 3 if it's healing itself.
     */
    private int ai(){
        d100.roll();
        final int attack1Range = 75;
        final int attack2Range = 85;
        // Depending on what the value of d100.getCurrentSide() is,
        // this method will decide what the mugwump does in a turn.
        if (d100.getCurrentSide() <= attack1Range){
            return 1;
        } else if (d100.getCurrentSide() > attack1Range && d100.getCurrentSide() <= attack2Range){
            return 2;
        } else if (d100.getCurrentSide() > attack2Range){
            return 3;
        } else{
            // Just so the method runs correctly.
            return 0;
        }
    }
}
