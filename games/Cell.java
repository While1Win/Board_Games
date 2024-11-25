package games;
import display.*;
public class Cell {
    //private String space ="   ";
    private State etat;

    public Cell(){
        this.etat = State.EMPTY;
    }
    

    public State getEtat (){return etat;}

    public void setEtat (State etat){
        this.etat = etat;
    }



    public String toString (){

        return etat.getRepresentation();
    }
}