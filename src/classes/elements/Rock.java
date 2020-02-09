package classes.elements;

import classes.gui.ElementImage;
import classes.stuff.Vector2d;

public class Rock extends AbstractMapElement {

    public Rock(Vector2d initialPosition) {
        super(initialPosition);
        this.image = ElementImage.ROCK;
        this.movable = true;
    }

    @Override
    public String toString() {
        return "R";
    }
}
