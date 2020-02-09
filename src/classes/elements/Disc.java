package classes.elements;

import classes.gui.ElementImage;
import classes.stuff.Vector2d;

public class Disc extends AbstractMapElement {

    public Disc(Vector2d initialPosition) {
        super(initialPosition);
        this.image = ElementImage.DISC;
        this.movable = true;
    }

    @Override
    public String toString() {
        return "D";
    }
}
