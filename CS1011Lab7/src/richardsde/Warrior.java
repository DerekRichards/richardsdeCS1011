package richardsde; /*
 * Course: CS-1011-011
 * Fall 2020
 * Lab 7 - Battle Simulator 3000
 * Name: Derek Richards
 * Created: 10/19/20
 */

/**
 * This class represents the player character in the Battle Simulator
 */
public class Warrior {
    private int hitPoints;
    private Die d20;
    private Die d10;
    private Die d8;
    private Die d4;

    /**
     * The constructor for the Warrior class. Calls the
     * setInitialHitPoints method to initialize the amount of HP.
     */
    public Warrior(){
        // Creating local final variables because these are magic numbers otherwise
        final int die20 = 20;
        final int die10 = 10;
        final int die8 = 8;

        d20 = new Die(die20);
        d10 = new Die(die10);
        d8 = new Die(die8);
        d4 = new Die(4);
        // Calling another method to generate the player's HP
        hitPoints = setInitialHitPoints();
    }

    public int getHitPoints(){
        return hitPoints;
    }

    /**
     * Lowers the users hit points by the amount of damage taken.
     *
     * @param damage - The amount of damage taken.
     */
    public void takeDamage(int damage){
        hitPoints -= damage;
    }

    /**
     * This method determines what attack type the player wants to use,
     * calculates whether or not it hits, and returns the damage.
     *
     * @param type - The type of attack that the user will do (1 or 2)
     * @return - The damage that the player does to the enemy.
     * If the player misses, 0 is returned.
     */
    public int attack(int type){
        int damage = 0;
        if (type == 1){
            // The player chooses the Trusty Sword
            final int minimumHit = 12;
            d20.roll();
            // Checking whether the player hits or not
            if (d20.getCurrentSide() >= minimumHit){
                d8.roll();
                damage += d8.getCurrentSide();
                d8.roll();
                damage += d8.getCurrentSide();
                System.out.println("You swing your sword and hit the Mugwump!");
            } else {
                System.out.println("You swing your sword and miss your attack!");
            }
        } else if (type == 2){
            // The player chooses the Shield of Light
            final int minimumHit = 8;
            d20.roll();
            // Checks whether the player hits or not
            if (d20.getCurrentSide() >= minimumHit){
                d8.roll();
                damage += d8.getCurrentSide();
                System.out.println("You raise your shield and hit the Mugwump!");
            } else {
                System.out.println("You raise your shield and miss your attack!");
            }
        }

        return damage;
    }

    /**
     * Rolls a 10-sided die 6 times in order to
     * calculate the Warrior's starting HP.
     *
     * @return - The Warrior's initial hit points
     */
    private int setInitialHitPoints(){
        int count = 0;
        final int numRolls = 6;
        for (int x = 0; x < numRolls; x++){
            d10.roll();
            count += d10.getCurrentSide();
        }
        return count;
    }


}
