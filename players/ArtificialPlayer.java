package players;

import java.util.Random;
import games.*;
import display.*;

/**
 * Represents an AI-controlled player in a board game.
 * The player generates random valid moves until it finds an empty cell.
 */
public class ArtificialPlayer extends Player {

    /**
     * Random number generator used to select moves.
     */
    private Random random;

    /**
     * Constructs an AI player with a specified symbol.
     *
     * @param symbol the symbol representing the AI player on the board.
     */
    public ArtificialPlayer(State symbol) {
        super(symbol);
        this.random = new Random();
    }

    /**
     * Generates a valid move by randomly selecting a row and column
     * from the board until an empty cell is found.
     *
     * @param board the current state of the game board as a 2D array of {@link Cell}.
     * @return an array of two integers representing the row and column of the chosen move.
     */
    @Override
    public int[] getMove(Cell[][] board) {
        int row, col;
        do {
            row = random.nextInt(board.length); // Generate a random row index
            col = random.nextInt(board.length); // Generate a random column index
        } while (board[row][col].getEtat() != State.EMPTY); // Ensure the cell is empty
        return new int[]{row, col};
    }
}
