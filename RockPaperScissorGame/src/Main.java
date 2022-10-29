import java.util.Random;
import java.util.Scanner;

public class Main {
    private final static int maxRound = 10;// maximum number of rounds to be played
    private final static int minRound = 1;//minimum number of rounds to be played
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        //set accumulator to hold the number of Ties,wins and losses.
        int numberOfTies = 0, numberOfUserWins = 0, numberOfComputerWins = 0;
        //Ask user how many rounds they wnt to play
        int numberOfRounds;
        int playAgain = 0;
        int numberOFMorerounds;


        do {
            System.out.println("How many rounds you want to play?");
            numberOfRounds = input.nextInt();

            while (numberOfRounds < minRound || numberOfRounds > maxRound) {
                System.out.println(" Invalid number! Please enter number between 1 and 10");
                numberOfRounds = input.nextInt();

            }
            while(true) {
                for (int i = 0; i < numberOfRounds; i++)
                {
                    System.out.println("Please choose: 1 for Rock, 2 for Paper or 3 for Scissor");
                    int userPlay = input.nextInt();
                    if (userPlay >= 1 && userPlay <= 3) {
                        Random rand = new Random();
                        int computer = rand.nextInt(3);
                        if (userPlay == computer) {
                            System.out.println("The game is tie");
                            numberOfTies ++;
                        } else if (userPlay == 1 && computer == 3 || userPlay == 2 && computer == 1 || userPlay == 3 && computer == 2) {
                            System.out.println("Congratulation You Win");
                            numberOfUserWins ++;
                        } else {
                            System.out.println("Sorry You Lost! The computer Wins");
                            numberOfComputerWins ++;
                        }

                    } else {
                        System.out.println("please enter valid input.");
                        i--;
                    }
                }

                /**for each round of play, the user enters either rock,paper or Scissor and
                 the computer picks randomly either Rock, paper or Scissor */
                System.out.println("==================================");
                System.out.println("Number of ties:" + numberOfTies);
                System.out.println("You won:" + numberOfUserWins);
                System.out.println("The Computer won:" + numberOfComputerWins);
                System.out.println("======FINAL RESULT==============");

                if (numberOfUserWins > numberOfComputerWins) {
                    System.out.println("Congratulation!You are the winner of the game ");
                } else if (numberOfUserWins < numberOfComputerWins) {
                    System.out.println("You Lost! the computer won the game ");
                } else {
                    System.out.println("The game ended in tie");
                }
                System.out.println("Do you want to play again?");
                System.out.println("please enter 1 if you want to play again or any number if you are done.");
                playAgain = input.nextInt();

                break;
            }

        } while (playAgain == 1);
        System.out.println("Thanks for playing");

    }
}