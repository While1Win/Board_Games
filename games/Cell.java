package games;
import display.*;
public class Cell {
    //private String space ="   ";
    private Representation etat;

    public Cell(){
        this.etat = Representation.EMPTY;
    }
    

    public Representation getEtat (){return etat;}

    public void setEtat (Representation etat){
        this.etat = etat;
    }



    public String toString (){

        return etat.getRepresentation();
    }
}