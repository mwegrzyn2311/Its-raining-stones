package classes.elements;

import classes.gui.ElementImage;
import classes.stuff.Vector2d;

public class Grass extends AbstractMapElement {

    public Grass(Vector2d initialPosition) {
        super(initialPosition);
        this.image = ElementImage.GRASS;
    }

    @Override
    public String toString() {
        return "G";
    }
}
