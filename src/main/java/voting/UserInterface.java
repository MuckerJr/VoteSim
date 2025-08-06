package main.java.voting;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);

    public void printWelcomeMessage() {
        System.out.println("Welcome to the Election Simulator!");
    }

    public int askForVoterCount() {
        System.out.print("Enter the number of voters: ");
        while(true) {
            String input = scanner.nextLine();
            try {
                int count = Integer.parseInt(input);
                if (count > 0) return count;
                System.out.println("Please enter a positive number.");
            } catch (NumberFormatException e) {
                System.out.println("That wasn't a number, try again.");
            }
        }
    }
}
