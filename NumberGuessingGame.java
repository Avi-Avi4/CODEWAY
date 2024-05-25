import java.util.Random;
import java.util.Scanner;

class NumberGuessingGame 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attempts = 0;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Random Number Guessing Game!");

        while (playAgain) 
        {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int guess;

            System.out.println("\nI have generated a random number between " + minRange + " and " + maxRange + ".");
            System.out.println("\nCan you guess the number?");

            while (attempts < 5) 
            {
                System.out.print("\nEnter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) 
                {
                    System.out.println("\nCongratulations! Your guess is correct.");
                    score++;
                    break;
                } 
                else if (guess < randomNumber) 
                {
                    System.out.println("\nToo low. Try again.");
                } 
                else 
                {
                    System.out.println("\nToo high. Try again.");
                }
            }
            if(attempts >= 5)
            {
                System.out.println("\nSorry, you exceedes the limit of attempts...");  
            }
            else
            {
                System.out.println("\nNumber of attempts: " + attempts);
            }
            System.out.println("\nYour score: " + score);
            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();

            if (playAgainInput.equalsIgnoreCase("no")) {
                playAgain = false;
            }

            attempts = 0;
        }

        System.out.println("\nThank you for playing the Random Number Guessing Game!");
    }
}
