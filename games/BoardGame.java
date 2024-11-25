package games;

import players.Player;
import display.Representation;

/**
 * An abstract class representing the base structure for board games.
 * It includes logic for verifying win conditions and managing the game board.
 */
public abstract class BoardGame {
    /**
     * The game board represented as a 2D array of {@link Cell}.
     */
    protected Cell[][] tab;

    /**
     * The players participating in the game.
     */
    protected Player[] players;

    /**
     * The number of rows in the board.
     */
    protected int size;

    /**
     * The number of columns in the board.
     */
    protected int width;

    /**
     * Constructs a BoardGame with the specified dimensions and players.
     *
     * @param size    the number of rows in the board.
     * @param width   the number of columns in the board.
     * @param player1 the first player.
     * @param player2 the second player.
     */
    public BoardGame(int size, int width, Player player1, Player player2) {
        this.size = size;
        this.width = width;
        this.tab = new Cell[size][width];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < width; j++) {
                tab[i][j] = new Cell();
            }
        }
        this.players = new Player[]{player1, player2};
    }

    /**
     * Verifies if a specific sequence of cells matches the given symbol.
     *
     * @param line           the starting row index.
     * @param col            the starting column index.
     * @param linePlus       the row increment for each step in the sequence.
     * @param colPlus        the column increment for each step in the sequence.
     * @param symbol         the symbol to verify.
     * @param sequenceLength the length of the sequence to verify.
     * @return true if the sequence matches the symbol, false otherwise.
     */
    public boolean verify(int line, int col, int linePlus, int colPlus, Representation symbol, int sequenceLength) {
        int count = 0;

        for (int i = 0; i < sequenceLength; i++) {
            int newline = line + i * linePlus;
            int newcol = col + i * colPlus;

            if (newline >= 0 && newline < size && newcol >= 0 && newcol < width) {
                if (tab[newline][newcol].getEtat() == symbol) {
                    count++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return count == sequenceLength;
    }

    /**
     * Checks if a player with the given symbol has won the game by forming a sequence.
     *
     * @param symbol         the symbol of the player.
     * @param sequenceLength the length of the winning sequence.
     * @return true if the player has won, false otherwise.
     */
    public boolean checkWin(Representation symbol, int sequenceLength) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < width; j++) {
                if (tab[i][j].getEtat() == symbol) {
                    if (verify(i, j, 1, 0, symbol, sequenceLength) || // Vertical
                        verify(i, j, 0, 1, symbol, sequenceLength) || // Horizontal
                        verify(i, j, 1, 1, symbol, sequenceLength) || // Diagonal \
                        verify(i, j, 1, -1, symbol, sequenceLength)) { // Diagonal /
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks if the board is completely filled with no empty cells.
     *
     * @return true if the board is full, false otherwise.
     */
    protected boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < width; j++) {
                if (tab[i][j].getEtat() == Representation.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Starts and manages the game flow.
     * Must be implemented by subclasses to define specific game rules.
     */
    public abstract void play();
}
