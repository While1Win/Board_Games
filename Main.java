import display.Representation;
import games.Gomoku;
import games.Puissance4;
import players.ArtificialPlayer;
import players.Player;
import views.View;

public class Main {
    public static void main(String[] args) {
       

    View view = new View();
    //  InteractionUtilisateur interactionUtilisateur = new InteractionUtilisateur();

    //  Player player1 = new HumanPlayer(Representation.X, interactionUtilisateur, view);
    //  Player player2 = new ArtificialPlayer(Representation.O);

    //  TicTacToe game = new TicTacToe(3, player1, player2, view);
    Player player1 = new ArtificialPlayer( Representation.X);  
    Player player2 = new ArtificialPlayer( Representation.O);  


    Gomoku game3 = new Gomoku(player1, player2,view);
    //Puissance4 game3 = new Puissance4(player1, player2,view);
    game3.play();
    //gomoku.play();

    //gomoku.play();
    }

}
