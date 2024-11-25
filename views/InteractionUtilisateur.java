package views;

import java.util.Scanner;
import display.Message;
import display.Representation;
import games.Cell;

/**
 * Handles user interactions to retrieve input for game actions such as coordinates and moves.
 */
public class InteractionUtilisateur {

    /**
     * Scanner for reading user input from the console.
     */
    private final Scanner scanner;

    /**
     * Constructs an instance of {@code InteractionUtilisateur}.
     * Initializes a {@link Scanner} to read user input.
     */
    public InteractionUtilisateur() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Prompts the user for a coordinate (row or column) within a valid range.
     *
     * @param max   the maximum allowable value for the coordinate.
     * @param view  the {@link View} instance used to display messages to the user.
     * @param message the {@link Message} to display when prompting the user.
     * @return the valid coordinate entered by the user.
     */
    public int getCoordinate(int max, View view, Message message) {
        int coordinate = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                view.displayMessage(message, max); // Displays the prompt message.
                String input = scanner.nextLine();
                coordinate = Integer.parseInt(input);

                if (coordinate < 0 || coordinate > max) {
                    view.displayMessage(Message.INVALID_COORDINATES); // Notify if out of range.
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                view.displayMessage(Message.INVALID_INPUT); // Notify if input is not a number.
            }
        }

        return coordinate;
    }

    /**
     * Retrieves a valid move from the user by prompting for row and column coordinates.
     *
     * @param board the current game board represented as a 2D array of {@link Cell}.
     * @param view  the {@link View} instance used to display messages to the user.
     * @return an array containing the row and column of the valid move.
     */
    public int[] getMove(Cell[][] board, View view) {
        int row, col;
        boolean validMove = false;

        while (!validMove) {
            row = getCoordinate(board.length - 1, view, Message.ENTER_ROW); // Prompt for row.
            col = getCoordinate(board.length - 1, view, Message.ENTER_COLUMN); // Prompt for column.

            if (board[row][col].getEtat() != Representation.EMPTY) {
                view.displayMessage(Message.CELL_OCCUPIED); // Notify if the cell is already occupied.
            } else {
                validMove = true;
                return new int[]{row, col}; // Return valid move coordinates.
            }
        }
        return null; // This line is redundant as the loop ensures a valid move.
    }
}
