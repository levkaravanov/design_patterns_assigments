package assignments.state;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Dojo! What is your name, young student?");
        System.out.print("> ");
        String name = scanner.nextLine();

        GameCharacter hero = new GameCharacter(name);

        System.out.println("\nYour journey begins...");

        while (!(hero.getCurrentState() instanceof MasterState) && hero.getHealthPoints() > 0) {
            hero.printStatus();

            System.out.println("\nChoose your action:");
            System.out.println("1 - Train (Gain XP)");
            System.out.println("2 - Meditate (Restore HP)");
            System.out.println("3 - Fight (Risk HP for huge XP)");
            System.out.println("0 - Exit game");
            System.out.print("> ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    hero.train();
                    break;
                case "2":
                    hero.meditate();
                    break;
                case "3":
                    hero.fight();
                    break;
                case "0":
                    System.out.println("Giving up so soon? Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid action.");
            }

            System.out.println("\n--------------------------------------------------");
        }

        if (hero.getHealthPoints() <= 0) {
            System.out.println("\n[GAME OVER] You have lost all your health. The journey ends here.");
        } else {
            hero.printStatus();
            System.out.println("\n*** CONGRATULATIONS! ***");
            System.out.println("You have reached the ultimate level of Master. You have won!");
        }

        scanner.close();
    }
}
