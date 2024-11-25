package players;

import display.State;
import games.Cell;
import views.InteractionUtilisateur;
import views.View;

/**
 * Represents a human-controlled player in a board game.
 * The player provides moves interactively through user input.
 */
public class HumanPlayer extends Player {

    /**
     * Handles user interactions to retrieve input for moves.
     */
    private final InteractionUtilisateur interactionUtilisateur;

    /**
     * Handles the display of messages and the game board to the user.
     */
    private final View view;

    /**
     * Constructs a human player with a specified symbol, user interaction handler, and view.
     *
     * @param symbol                 the symbol representing the human player on the board.
     * @param interactionUtilisateur the handler for user input interactions.
     * @param view                   the handler for displaying messages and the board.
     */
    public HumanPlayer(State symbol, InteractionUtilisateur interactionUtilisateur, View view) {
        super(symbol);
        this.interactionUtilisateur = interactionUtilisateur;
        this.view = view;
    }

    /**
     * Retrieves a valid move from the user via the {@link InteractionUtilisateur} component.
     *
     * @param board the current state of the game board as a 2D array of {@link Cell}.
     * @return an array of two integers representing the row and column of the chosen move.
     */
    @Override
    public int[] getMove(Cell[][] board) {
        return interactionUtilisateur.getMove(board, view);
    }
}
