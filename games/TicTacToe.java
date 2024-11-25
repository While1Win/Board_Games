package games;

import players.Player;
import views.View;
import display.*;

/**
 * A concrete implementation of {@link BoardGame} for the game Tic Tac Toe.
 * Tic Tac Toe is played on a 3x3 board where players aim to align three of their symbols
 * horizontally, vertically, or diagonally.
 */
public class TicTacToe extends BoardGame {

    /**
     * The view used to display the game board and messages.
     */
    private View view;

    /**
     * Constructs a TicTacToe game instance with two players and a view.
     *
     * @param player1 the first player.
     * @param player2 the second player.
     * @param view    the view for displaying the game board and messages.
     */
    public TicTacToe(Player player1, Player player2, View view) {
        super(3, 3, player1, player2); // A 3x3 board for Tic Tac Toe
        this.view = view;
    }

    /**
     * Starts and manages the Tic Tac Toe game. Alternates turns between the two players,
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

            // Retrieve the player's move
            int[] move = currentPlayer.getMove(tab); // The move must be in the format [row, column]
            tab[move[0]][move[1]].setEtat(currentPlayer.getSymbol());

            // Check for a win (sequence of 3 symbols)
            gameWon = checkWin(currentPlayer.getSymbol(), 3);
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

    // method to check lines and colonnes to verify if we have a 
    // consecutive 4 of the same symbol, it return true if we have 4 of the same symbol
    /*public boolean verify ( int line, int col, int linePlus, int colPlus, Representation symbol){
        int count = 0;

        // check the 4 cells in a given direction
        for (int i =0; i<4; i++){
            int newline = line + i * linePlus;
            int newcol = col + i * colPlus;

            // this if checks if the next cell ne déborde pas
            if (newline >= 0 && newline < tab.length && newcol>= 0 &&  newcol < tab[0].length ){
                // here we check if the symbol match
                if ( tab[newline][newcol].getEtat() == symbol) {
                    count++;
                }
                else {
                    // entering this else means the sequence was interrupted
                    break;
                }
            } else {
                // entering this else means index out of bound
                break;
            }
        }
        return count == 4;
    }

    public boolean checkWin ( Representation symbol) {
        // board dimensions
        int line = tab.length; // combien de ligne ( 6 par ex pour puissance 4)
        int cols = tab[0].length; // combien de cols ( 7 )

        // using the verify method we iterate everywhere
        for (int i=0; i<line; i++){
            for (int j=0 ; j<cols; j++){
                // check if the current cell contain the player symbol
                if ( tab[i][j].getEtat() == symbol ) {
                    // checking 4 directions
                    if (verify(i,j,1,0,symbol)   || 
                        verify(i, j, 0, 1, symbol)  ||
                        verify(i, j, 1, 1, symbol)  ||
                        verify(i, j, 1, -1, symbol)){
                            return true;
                    }
                }
            }
        }
        return false;
    }*/
    
    
    


