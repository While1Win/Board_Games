package views;

import display.*;
import games.Cell;

/**
 * Handles the display of messages and the game board in the console.
 */
public class View {

    /**
     * Displays a simple message to the console.
     *
     * @param message the {@link Message} to display.
     */
    public void displayMessage(Message message) {
        System.out.println(message.getMessage());
    }

    /**
     * Displays a formatted message to the console.
     * Allows passing additional arguments to format the message string.
     *
     * @param message the {@link Message} to display.
     * @param args    the arguments to format the message string.
     */
    public void displayMessage(Message message, Object... args) {
        System.out.printf(message.getMessage(), args);
        System.out.println();
    }

    /**
     * Displays the game board in a grid format to the console.
     *
     * @param board a 2D array of {@link Cell} objects representing the game board.
     */
    public void displayBoard(Cell[][] board) {
        int size = board.length; // Number of rows in the board
        int width = board[0].length; // Number of columns in the board
        String bar = "|";

        // Iterates over each row
        for (int i = 0; i < size; i++) {
            System.out.println("-".repeat(width * 4 + 1)); // Prints a horizontal separator line
            System.out.print(bar); // Starts each row with a vertical bar
            for (int j = 0; j < width; j++) {
                System.out.print(board[i][j]); // Prints the cell content
                System.out.print(bar); // Adds a vertical bar after each cell
            }
            System.out.println(); // Moves to the next row
        }
        // Prints the bottom border of the board
        System.out.println("-".repeat(width * 4 + 1));
    }
}
