import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private static final String[] CHOICES = { "rock", "paper", "scissors" };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println("Enter your choice (rock/paper/scissors) or 'quit' to stop playing:");
            String userChoice = scanner.nextLine().toLowerCase();

            if (userChoice.equals("quit")) {
                break;
            }

            if (!isValidChoice(userChoice)) {
                System.out.println("Invalid choice. Please enter rock, paper, or scissors.");
                continue;
            }

            String computerChoice = getComputerChoice(random);
            System.out.println("Computer chose: " + computerChoice);

            Result result = determineWinner(userChoice, computerChoice);
            System.out.println(result.getMessage());

            System.out.println("\nScore - You: " + result.getUserScore() + ", Computer: " + result.getComputerScore());
        }
    }

    private static boolean isValidChoice(String choice) {
        for (String validChoice : CHOICES) {
            if (validChoice.equals(choice)) {
                return true;
            }
        }
        return false;
    }

    private static String getComputerChoice(Random random) {
        return CHOICES[random.nextInt(CHOICES.length)];
    }

    private static Result determineWinner(String userChoice, String computerChoice) {
        int userScore = 0;
        int computerScore = 0;

        if (userChoice.equals(computerChoice)) {
            return new Result("It's a tie!", userScore, computerScore);
        }

        switch (userChoice) {
            case "rock":
                if (computerChoice.equals("scissors")) {
                    userScore = 1;
                    return new Result("Rock crushes scissors. You win!", userScore, computerScore);
                } else {
                    computerScore = 1;
                    return new Result("Paper covers rock. Computer wins!", userScore, computerScore);
                }
            case "paper":
                if (computerChoice.equals("rock")) {
                    userScore = 1;
                    return new Result("Paper covers rock. You win!", userScore, computerScore);
                } else {
                    computerScore = 1;
                    return new Result("Scissors cut paper. Computer wins!", userScore, computerScore);
                }
            case "scissors":
                if (computerChoice.equals("paper")) {
                    userScore = 1;
                    return new Result("Scissors cut paper. You win!", userScore, computerScore);
                } else {
                    computerScore = 1;
                    return new Result("Rock crushes scissors. Computer wins!", userScore, computerScore);
                }
            default:
                return new Result("Unknown result.", userScore, computerScore);
        }
    }

    private static class Result {
        private final String message;
        private final int userScore;
        private final int computerScore;

        public Result(String message, int userScore, int computerScore) {
            this.message = message;
            this.userScore = userScore;
            this.computerScore = computerScore;
        }

        public String getMessage() {
            return message;
        }

        public int getUserScore() {
            return userScore;
        }

        public int getComputerScore() {
            return computerScore;
        }
    }
}

