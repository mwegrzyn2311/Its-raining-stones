package classes.elements;

import classes.gui.ElementImage;
import classes.stuff.Vector2d;

public class GamePoint extends AbstractMapElement{
    public int pointValue = 1;

    public GamePoint(Vector2d initialPosition){
        super(initialPosition);
        this.image = ElementImage.POINT;
        this.movable = true;
    }

    @Override
    public String toString() {
        return "P";
    }
}
