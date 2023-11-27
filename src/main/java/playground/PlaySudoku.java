package playground;

import org.example.sudoku.Card;
import org.example.sudoku.Game;
import org.example.sudoku.Player;

import java.util.Arrays;
import java.util.Scanner;

public class PlaySudoku {
    public static void main(String[] args) {
//        int[][] gameMatrix = {
//                {0, 4, 6, 2, 8, 7, 3, 5, 1}, // 9
//                {5, 0, 3, 6, 1, 9, 7, 4, 2}, // 8
//                {2, 0, 0, 0, 4, 3, 6, 9, 8}, // 7, 5... removed 1 at row 2 col 1 and 7 at row 6 col 1
//                {8, 6, 5, 4, 3, 2, 0, 7, 9}, // 1
//                {7, 2, 0, 9, 6, 5, 4, 8, 3}, // 1 ...
//                {4, 3, 9, 0, 7, 8, 5, 2, 6},
//                {6, 0, 8, 3, 2, 4, 9, 0, 5},
//                {3, 9, 4, 8, 5, 0, 2, 6, 7},
//                {0, 5, 2, 7, 9, 6, 8, 3, 4}
//        };

        int[][] gameMatrix = {
                {0, 0, 0, 8, 0, 0, 0, 0, 9}, // 9
                {0, 1, 9, 0, 0, 5, 8, 3, 0}, // 8
                {0, 4, 3, 0, 1, 0, 0, 0, 7}, // 7, 5... removed 1 at row 2 col 1 and 7 at row 6 col 1
                {4, 0, 0, 1, 5, 0, 0, 0, 3}, // 1
                {0, 0, 2, 7, 0, 4, 0, 1, 0}, // 1 ...
                {0, 8, 0, 0, 9, 0, 6, 0, 0},
                {0, 7, 0, 0, 0, 6, 3, 0, 0},
                {0, 3, 0, 0, 7, 0, 0, 8, 0},
                {9, 0, 4, 5, 0, 0, 0, 0, 1}
        };

        Card sudokuCard = new Card(gameMatrix);
        Game sudokuGame = new Game(sudokuCard);
        Player playerOne = new Player(sudokuCard);

        System.out.println("|0, 1, 2, 3, 4, 5, 6, 7, 8|");
        System.out.println("---------------------------");
        System.out.println(Arrays.deepToString(gameMatrix).replace("], ",
                "]\n").replace("[[", "[").replace("]]", "]"));

        boolean gameOver = false;

        while (!gameOver) {
            boolean updatingPlayedNumber = false;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Are you going to update a played number? (y/n)");
            String isUpdate = scanner.nextLine();
            if (isUpdate.trim().equals("y")) updatingPlayedNumber = true;

            System.out.println("Please enter the row number (\"Q\" or \"q\" to quit): ");
            String selection = scanner.nextLine();
            if (selection.trim().equals("Q") || selection.trim().equals("q")) gameOver = true;

            if (gameOver) break;
            int rowSelected;
            try {
                rowSelected = Integer.parseInt(selection.trim());
            } catch (NumberFormatException e) {
                System.out.println("Could not convert the provided number. Please try again.");
                rowSelected = scanner.nextInt();
            }

            System.out.println("Please enter the column number: ");
            int columnSelected = scanner.nextInt();

            System.out.println("Please enter the number: ");
            int numberSelected = scanner.nextInt();

            int playResult = playerOne.play(rowSelected, columnSelected, numberSelected, updatingPlayedNumber);
            if (playResult == 0) System.out.println("The game matrix was updated! Your choice was correct!");
            if (playResult == -1) System.out.println("Invalid choice! You're trying to change a default number from this card or providing invalid number!");
            if (playResult == -2) System.out.println("You're trying to add a repeated number!");

            System.out.println("The current game matrix is: ");
            System.out.println("|0, 1, 2, 3, 4, 5, 6, 7, 8|");
            System.out.println("---------------------------");
            System.out.println(Arrays.deepToString(gameMatrix).replace("], ",
                    "]\n").replace("[[", "[").replace("]]", "]"));
            System.out.println("---------------------------");
            System.out.println("|0, 1, 2, 3, 4, 5, 6, 7, 8|");

            gameOver = sudokuGame.isGameOver();

            if (gameOver) {
                System.out.println("---------------------------------");
                System.out.println("Game Over! Thank you for playing!");
                System.out.println("---------------------------------");
            }
        }
    }
}
