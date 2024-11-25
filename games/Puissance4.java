package games;

import players.*;
import views.View;
import display.*;

/**
 * A concrete implementation of {@link BoardGame} for the game Puissance4 (Connect Four).
 * Puissance4 is played on a 6x7 board where players aim to connect four of their symbols
 * either horizontally, vertically, or diagonally.
 */
public class Puissance4 extends BoardGame {

    /**
     * The view used to display the game board and messages.
     */
    private View view;

    /**
     * Constructs a Puissance4 game instance with two players and a view.
     *
     * @param player1 the first player.
     * @param player2 the second player.
     * @param view    the view for displaying the game board and messages.
     */
    public Puissance4(Player player1, Player player2, View view) {
        super(6, 7, player1, player2); // A 6x7 board for Puissance4
        this.view = view;
    }

    /**
     * Starts and manages the Puissance4 game. Alternates turns between the two players,
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

            // Retrieve the player's move (column-based for Connect Four logic)
            int[] move = currentPlayer.getMove(tab); // The move must be in the format [row, column]
            tab[move[0]][move[1]].setEtat(currentPlayer.getSymbol());

            // Check for a win (sequence of 4 symbols)
            gameWon = checkWin(currentPlayer.getSymbol(), 4);
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

        /*    private int dropInColumn(int col) {
        for (int i = size - 1; i >= 0; i--) {
            if (tab[i][col].getEtat() == Representation.EMPTY) {
                return i;
            }
        } */
       /* public void play() {
        int turn = 0; // 0 pour player1, 1 pour player2
        boolean gameWon = false;
        boolean draw = false;

        while (!gameWon && !draw) {
            Player currentPlayer = players[turn % 2];
            System.out.println("C'est au tour de " + currentPlayer.getSymbol() + " de jouer.");
            view.displayBoard(tab);

            // Récupérer un coup valide
            int[] move = currentPlayer.getMove(tab); 
            int row = dropInColumn(move[1]); // Gérer la gravité des jetons
            tab[row][move[1]].setEtat(currentPlayer.getSymbol());

            // Vérification de la victoire
            gameWon = checkWin(currentPlayer.getSymbol(), 4);

            if (gameWon) {
                view.displayBoard(tab);
                System.out.println(currentPlayer.getSymbol() + " a gagné !");
            } else if (isBoardFull()) {
                draw = true;
                view.displayBoard(tab);
                System.out.println("Match nul !");
            } else {
                turn++;
            }
        }
    }

    private int dropInColumn(int col) {
        for (int i = size - 1; i >= 0; i--) {
            if (tab[i][col].getEtat() == Representation.EMPTY) {
                return i;
            }
        }
        throw new IllegalArgumentException("Colonne pleine !");
    }
} */

