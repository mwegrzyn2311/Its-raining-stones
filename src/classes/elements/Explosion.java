package classes.elements;

import classes.gui.ElementImage;
import classes.stuff.Vector2d;

public class Explosion extends AbstractMapElement {

    public Explosion(Vector2d initialPosition) {
        super(initialPosition);
        this.image = ElementImage.EXPLOSION;
    }

    @Override
    public String toString() {
        return "@";
    }
}
