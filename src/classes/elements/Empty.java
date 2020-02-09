package classes.elements;

import classes.gui.ElementImage;
import classes.stuff.Vector2d;

public class Empty extends AbstractMapElement{

    public Empty(Vector2d initialPosition) {
        super(initialPosition);
        this.image = ElementImage.EMPTY;
    }

    @Override
    public String toString() {
        return "E";
    }
}
