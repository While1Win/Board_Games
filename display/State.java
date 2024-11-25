package display;

/**
 * Enumération des différentes représentations possibles pour une case du jeu.
 * Les trois états sont : vide, X et O.
 */
public enum State {
    
    /**
     * Représentation d'une cellule vide sur le plateau.
     */
    EMPTY("   "),
    
    /**
     * Représentation d'une cellule occupée par le joueur X.
     */
    X(" X "),
    
    /**
     * Représentation d'une cellule occupée par le joueur O.
     */
    O(" O ");
    
    // La chaîne qui sera utilisée pour afficher le symbole dans la case.
    private final String etat;

    /**
     * Constructeur pour initialiser la représentation de chaque état.
     * 
     * @param etat La chaîne de caractères représentant l'état de la cellule (vide, X ou O).
     */
    State (String etat) {
        this.etat = etat;
    }

    /**
     * Retourne la chaîne de caractères qui représente l'état de la cellule.
     * 
     * @return La chaîne qui sera affichée dans la cellule.
     */
    public String getRepresentation() {
        return etat;
    }
}
