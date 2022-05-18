package richardsde; /*
* Course: CS-1011-011
* Fall 2020
* Lab 7 - Battle Simulator 3000
* Name: Derek Richards
* Created: 10/19/20
*/

import java.util.Scanner;
/**
 * This is the driver class for Battle Simulator 3000. It simulates a battle
 * in a tabletop role-playing game between a
 * Warrior (the player) and a Mugwump (their enemy)
 */
public class BattleSim {
    /**
     * A 10-sided die used to roll for initiative.
     */
    public static final Die INITIATIVE_DIE = new Die(10);

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        // Setting the value for the game loop.
        boolean play = true;
        // String used to determine the winner of the fight.
        String victor;
        do {
            intro();
            Warrior warrior = new Warrior();
            Mugwump mugwump = new Mugwump();
            victor = "none";

            System.out.println("Let the battle begin!\n");
            report(warrior, mugwump);
            while (victor.equalsIgnoreCase("none")){
                System.out.println();
                victor = battle(warrior, mugwump, scan);
            }
            victory(victor);
            play = playAgain(scan);
        } while (play);

    }

    /**
     * The introduction to the game.
     */
    private static void intro(){
        System.out.println("Welcome to Battle Simulator 3000! " +
                "The world's more low tech battle simulator!");
        System.out.println("Your are a valiant Warrior defending your " +
                "humble village from an evil Mugwump! Fight bravely, ");
        System.out.println("or the citizens of your town will be the Mugwump's dinner!\n");
        System.out.println("You have your Trusty Sword, which deals decent damage, " +
                "but can be tough to hit with sometimes.");
        System.out.println("You also have your Shield of Light, which is not " +
                "as strong as your sword, but is easier to deal");
        System.out.println("damage with.\n");
    }

    /**
     * Handles the battle logic for the game.
     *
     * @param warrior - The player's character.
     * @param mugwump - The player's enemy.
     * @param in - Standard scanner object.
     * @return - The victor of the battle or "none" if no one has won yet.
     */
    private static String battle(Warrior warrior, Mugwump mugwump, Scanner in){
        int initiative = initiative();
        if (initiative == 1){
            System.out.println("The Warrior attacks first!");
            // If these attacks hit, the damage will be calculated.
            int damage = warrior.attack(attackChoice(in));
            mugwump.takeDamage(damage);
            if (mugwump.getHitPoints() > 0){
                report(warrior, mugwump);
                damage = mugwump.attack();
                warrior.takeDamage(damage);
                report(warrior, mugwump);
            }

        } else {
            System.out.println("The Mugwump strikes first!");
            // If these attacks hit, the damage will be calculated.
            int damage = mugwump.attack();
            warrior.takeDamage(damage);
            if (warrior.getHitPoints() > 0){
                report(warrior, mugwump);
                damage = warrior.attack(attackChoice(in));
                mugwump.takeDamage(damage);
                report(warrior, mugwump);
            }

        }
        if (warrior.getHitPoints() <= 0){
            return "Mugwump";
        } else if (mugwump.getHitPoints() <= 0){
            return "Warrior";
        } else {
            System.out.println("The battle rages on!");
            return "none";
        }

    }

    /**
     * Reports the current status of the warrior and the mugwump.
     *
     * @param warrior - The player's character
     * @param mugwump - The player's opponent.
     */
    private static void report(Warrior warrior, Mugwump mugwump){
        System.out.println("Warrior HP: " + warrior.getHitPoints());
        System.out.println("Mugwump HP: " + mugwump.getHitPoints());
    }

    /**
     * Asks the user for how they want to attack and returns the result.
     *
     * @param in - A standard scanner variable.
     * @return - 1 for the Trusty Sword, 2 for the Shield of Light
     */
    private static int attackChoice(Scanner in){
        System.out.println("How would you like to attack?");
        System.out.println("1. Your Trusty Sword");
        System.out.println("2. Your Shield of Light");
        System.out.print("Enter choice: ");
        return in.nextInt();
    }

    /**
     * Determines who attacks first and returns the result. If there is a tie, the method re-rolls.
     *
     * @return - 1 for the player character, 2 for the enemy character.
     */
    private static int initiative(){
        int warriorRoll = 0;
        int mugwumpRoll = 0;

        do {
            INITIATIVE_DIE.roll();
            warriorRoll = INITIATIVE_DIE.getCurrentSide();
            INITIATIVE_DIE.roll();
            mugwumpRoll = INITIATIVE_DIE.getCurrentSide();
        } while (warriorRoll == mugwumpRoll);

        if (warriorRoll > mugwumpRoll){
            return 1;
        } else {
            return 2;
        }

    }

    /**
     * This method declares the victor of the battle.
     *
     * @param victor - The name of the victor of the epic battle.
     */
    private static void victory(String victor){
        if (victor.equalsIgnoreCase("Warrior")){
            System.out.println("The citizens cheer and invite you back to town for " +
                    "a feast as thanks for saving their lives (again)!\n");
        } else {
            System.out.println("The mugwump won and you failed to protect the village.\n");
        }
    }

    private static boolean playAgain(Scanner in){
        System.out.println("Would you like to play again(y/n)?: ");
        // For some reason, if you type in "Yes", then this method returns false.
        if (in.next().equalsIgnoreCase("y") || in.nextLine().equalsIgnoreCase("yes")){
            return true;
        } else{
            System.out.println("Thank you for playing Battle Simulator 3000!");
            return false;
        }
    }

}
