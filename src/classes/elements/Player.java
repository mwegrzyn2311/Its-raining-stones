package classes.elements;

import classes.gui.ElementImage;
import classes.stuff.Vector2d;

public class Player extends AbstractMapElement {
    public int points=0;

    public Player(Vector2d initialPosition) {
        super(initialPosition);
        this.image = ElementImage.PLAYER;
    }

    @Override
    public String toString() {
        return "O";
    }
}
