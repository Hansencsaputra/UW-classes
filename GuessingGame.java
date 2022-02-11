// Student Hansen C. Saputra
// 2.8.2022
// CSE 142 Section BI
// TA: Kyler Gray
// Guessing Game
// Runs multiple/one game(s) of guessing a random number generated based on 
// how many times the user wishes to play
// Then, prints out the statistics of user's performance

import java.util.*;
public class GuessingGame 
{
    public static final int MAX_VALUE = 100;  
    
    public static void main(String[] args)
    {
        // initiate objects
        Scanner console = new Scanner(System.in);
        Random r = new Random();
    
        printHaiku();

        // trackers
        int totalGame = 0;
        int totalGuess = 0;
        int bestGameGuess = 1000000;
        boolean play = true;

        // ...
        while (play)
        {
            totalGame++;
            int existingGameGuess = playGame(console, r);
            totalGuess = totalGuess + existingGameGuess;

            if (Math.min(existingGameGuess, bestGameGuess) == existingGameGuess)
            {
                bestGameGuess = existingGameGuess;
            }

            play = playAgain(console);
        }
        printStatistics(totalGame, totalGuess, bestGameGuess);
    }
    
    // Prints the introduction of the game, i.e., a Haiku
    public static void printHaiku()
    {
        System.out.println("Game makes life awesome");
        System.out.println("guessing may do so either");
        System.out.println("So, we combine them");
        System.out.println();
    }

    // Play the game once
    // Returns how many times the user guesses to guess the correct number
    // Parameters:
    //  Scanner console - user's prompter
    //  Random r - random generator
    public static int playGame(Scanner console, Random r)
    {
        // generate random number
        int randomNum = r.nextInt(MAX_VALUE) + 1;
        System.out.println("I'm thinking of a number between 1 and " +
                MAX_VALUE + "...");
        
        int userGuess = 0;
        int existingGameGuess = 0;
        while (userGuess != randomNum)
        {
            // ask for num
            System.out.print("Your guess? ");
            userGuess = console.nextInt();
            existingGameGuess++;

            // respond based on the answer
            if (userGuess > randomNum)
            {
                System.out.println("It's lower.");
            } else if (userGuess < randomNum)
            {
                System.out.println("It's higher.");
            }  
        } 
        System.out.print("You got it right in " + existingGameGuess);
        if (existingGameGuess == 1)
        {
            System.out.println(" guess!");
        } else
        {
            System.out.println(" guesses!");
        }
        return existingGameGuess;   
    }

    // Accepts if the user wish to play again
    // Returns true if the user would like to play again
    // Parameters:
    //  Scanner console - user's prompter
    public static boolean playAgain(Scanner console)
    {
        System.out.print("Do you want to play again? ");
        String playAgain = console.next();
        char playAgainFirst = playAgain.toLowerCase().charAt(0);

        System.out.println();
        return playAgainFirst == 'y';
    }

    // Prints out the statistics of user's game performance
    // Parameters:
    //  int totalGame - total number of games the user plays
    //  int totalGuess - total guess(es) of the user in a/multiple game(s)
    //  int bestGameGuess - the smallest number of guesses needed in a game to guess the correct figure
    public static void printStatistics(int totalGame, int totalGuess, int bestGameGuess)
    {
        System.out.println("Overall results:");
        System.out.println("Total games   = " + totalGame);
        System.out.println("Total guesses = " + totalGuess);
        System.out.println("Guesses/game  = " +
                roundToOneDecimal((double)totalGuess / totalGame));
        System.out.println("Best game     = " + bestGameGuess);
    }
    
    // Rounds a figure to a decimal place
    // Returns the rounded digits
    // Parameters:
    // double num - a decimal to be rounded
    public static double roundToOneDecimal(double num) 
    {
        return Math.round(num * 10.0) / 10.0;
    }
}
