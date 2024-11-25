package games;

import players.*;
import views.View;
import display.*;

/**
 * A concrete implementation of {@link BoardGame} for the Gomoku game.
 * Gomoku is played on a 15x15 board, with the objective of forming a sequence of 5 symbols.
 */
public class Gomoku extends BoardGame {

    /**
     * The view used to display the game board and messages.
     */
    private View view;

    /**
     * Constructs a Gomoku game instance with two players and a view.
     *
     * @param player1 the first player.
     * @param player2 the second player.
     * @param view    the view for displaying the game board and messages.
     */
    public Gomoku(Player player1, Player player2, View view) {
        super(15, 15, player1, player2); // A 15x15 board for Gomoku
        this.view = view;
    }

    /**
     * Starts and manages the Gomoku game. Alternates turns between the two players,
     * checks for win conditions or a draw, and ends the game appropriately.
     */
    @Override
    public void play() {
        int turn = 0; // 0 for player1, 1 for player2
        boolean gameWon = false;

        while (!gameWon) {
            Player currentPlayer = players[turn % 2];
            System.out.println("C'est au tour de " + currentPlayer.getSymbol() + " de jouer.");
            view.displayBoard(tab);
            int[] move = currentPlayer.getMove(tab); // The getMove() method must be implemented in Player
            tab[move[0]][move[1]].setEtat(currentPlayer.getSymbol());

            // Check for a win
            gameWon = checkWin(currentPlayer.getSymbol(), 5);
            if (gameWon) {
                view.displayBoard(tab);
                System.out.println(currentPlayer.getSymbol() + " a gagné !");
                return;
            }

            // Check for a draw
            if (isBoardFull()) {
                view.displayBoard(tab);
                System.out.println("Match nul !");
                return;
            }

            turn++;
        }
    }
}


/**private boolean isBoardFull() {
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            if (tab[i][j].getEtat() == Representation.EMPTY) {
                return false;
            }
        }
    }
    return true;
}
private boolean checkWin(Representation currentPlayer) {
    // Vérifier les lignes
    for (int i = 0; i < size; i++) {
        if (allEqual(tab[i], currentPlayer)) return true;
    }

    // Vérifier les colonnes
    for (int j = 0; j < size; j++) {
        if (allEqual(getColumn(j), currentPlayer)) return true;
    }

    // Vérifier la diagonale principale
    boolean diag1 = true;
    for (int i = 0; i < size; i++) {
        if (tab[i][i].getEtat() != currentPlayer) {
            diag1 = false;
            break;
        }
    }
    if (diag1) return true;

    // Vérifier la diagonale secondaire
    boolean diag2 = true;
    for (int i = 0; i < size; i++) {
        if (tab[i][size - 1 - i].getEtat() != currentPlayer) {
            diag2 = false;
            break;
        }
    }
    if (diag2) return true;

    return false;
}



currentPlayer = (currentPlayer == Representation.X) ? Representation.O : Representation.X;

 */