package game.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameService {
    // Fields
    private Game game;
    private Scanner scanner;

    //Constructor
    public GameService() {
        this.game = new Game();
        this.scanner = new Scanner(System.in);
    }

    // Methods
    public void start() {
        boolean gameWon;
        do {
            int guess = this.getPlayerGuess();
            gameWon = this.processGuess(guess);
        } while(!gameWon);
    }

    private int getPlayerGuess() {
        while(true) {
            IO.print("Please enter a guess from 1 - 100: ");
            try {
                int guess = scanner.nextInt();
                if(guess >= 1 && guess <= 100) {
                    return guess;
                } else {
                    IO.println("Number is out of bounds. Please try again.");
                }
            } catch (InputMismatchException e) {
                IO.println("Bad Input. Please enter an int:");
                scanner.next();
            } catch (Exception e) {
                IO.println(e);
                scanner.next();
            }
        }
    }

    private boolean processGuess(int guess) {
        if(guess > game.getSecretNumber()) {
            IO.println("Your guess was too high!");
            return false;
        } else if(guess < game.getSecretNumber()) {
            IO.println("Your guess was too low!");
            return false;
        } else {
            IO.println("You got it!");
            return true;
        }
    }
}
