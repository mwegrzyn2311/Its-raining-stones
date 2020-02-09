package classes.elements;

import classes.gui.ElementImage;
import classes.stuff.Vector2d;

public class Wall extends AbstractMapElement{

    public Wall(Vector2d initialPosition) {
        super(initialPosition);
        this.image = ElementImage.WALL;
    }

    public String toString(){
        return "W";
    }
}
