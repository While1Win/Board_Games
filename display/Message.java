package display;

/**
 * Enumération des messages utilisés dans le jeu pour afficher des informations à l'utilisateur.
 */
public enum Message {
    
    /**
     * Message de bienvenue affiché au début du jeu.
     */
    WELCOME("Welcome to Tic Tac Toe!"),
    
    /**
     * Message indiquant le tour du joueur. Le joueur est remplacé par un symbole de joueur (%s).
     */
    PLAYER_TURN("Player %s's turn."),
    
    /**
     * Message demandant à l'utilisateur d'entrer une ligne valide (entre 0 et la taille du tableau).
     * Le %d sera remplacé par la taille maximale de la ligne.
     */
    ENTER_ROW("Enter row (0 to %d): "),
    
    /**
     * Message demandant à l'utilisateur d'entrer une colonne valide (entre 0 et la taille du tableau).
     * Le %d sera remplacé par la taille maximale de la colonne.
     */
    ENTER_COLUMN("Enter column (0 to %d): "),
    
    /**
     * Message d'erreur affiché lorsque l'entrée n'est pas valide (par exemple, non numérique).
     */
    INVALID_INPUT("Invalid input! Please enter integers only."),
    
    /**
     * Message d'erreur affiché lorsque les coordonnées entrées sont en dehors des limites du tableau.
     */
    INVALID_COORDINATES("Invalid coordinates! Please enter values within the board size."),
    
    /**
     * Message affiché lorsque l'utilisateur essaie de jouer dans une case déjà occupée.
     */
    CELL_OCCUPIED("Cell is already occupied! Please choose another one."),
    
    /**
     * Message affiché lorsque le jeu est terminé et qu'un joueur a gagné.
     * Le %s est remplacé par le symbole du joueur gagnant.
     */
    WINNER("Congratulations! Player %s wins!"),
    
    /**
     * Message affiché lorsque la partie est terminée par un match nul.
     */
    DRAW("It's a draw!");

    private final String message;

    /**
     * Constructeur de l'énumération qui initialise le message associé à chaque constante.
     *
     * @param message Le texte du message à afficher.
     */
    Message(String message) {
        this.message = message;
    }

    /**
     * Retourne le message associé à chaque constante de l'énumération.
     *
     * @return Le message sous forme de chaîne de caractères.
     */
    public String getMessage() {
        return message;
    }
}

