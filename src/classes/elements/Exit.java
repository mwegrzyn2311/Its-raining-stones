package classes.elements;

import classes.gui.ElementImage;
import classes.stuff.Vector2d;

public class Exit extends AbstractMapElement{
    public Exit(Vector2d initialPosition) {
        super(initialPosition);
        this.image = ElementImage.EXIT;
    }

    @Override
    public String toString() {
        return "X";
    }
}
