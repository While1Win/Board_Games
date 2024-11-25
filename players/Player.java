package players;

import display.Representation;
import display.*;
import games.*;

/**
 * Abstract representation of a player in a board game.
 * Each player is associated with a specific symbol and can make moves
 * on the game board.
 */
public abstract class Player {
    
    /**
     * The symbol representing the player on the board.
     */
    private Representation symbol;

    /**
     * Constructs a player with a specified symbol.
     *
     * @param symbol the symbol representing the player on the board.
     */
    public Player(Representation symbol) {
        this.symbol = symbol;
    }

    /**
     * Gets the symbol of the player.
     *
     * @return the player's symbol as a {@link Representation}.
     */
    public Representation getSymbol() {
        return symbol;
    }

    /**
     * Abstract method to retrieve a valid move for the player.
     * Each implementation must ensure the move is valid (i.e., targets an empty cell).
     *
     * @param board the current state of the game board as a 2D array of {@link Cell}.
     * @return an array of two integers representing the row and column of the chosen move.
     */
    public abstract int[] getMove(Cell[][] board);
}
