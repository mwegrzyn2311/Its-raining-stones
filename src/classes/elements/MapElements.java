package classes.elements;

public enum MapElements {
    EMPTY,
    GRASS,
    ROCK,
    POINT,
    EXIT,
    PLAYER;
    public String toString(){
        switch (this){
            case EMPTY: return "E";
            case GRASS: return "G";
            case ROCK: return "R";
            case POINT: return "P";
            case EXIT: return "X";
            case PLAYER: return "O";
            default: return null;
        }
    }

}
