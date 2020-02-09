package classes.elements;

import classes.gui.ElementImage;
import classes.stuff.Vector2d;

public class SolidWall extends AbstractMapElement{

    public SolidWall(Vector2d initialPosition) {
        super(initialPosition);
        this.image = ElementImage.SOLID;
    }

    public String toString(){
        return "S";
    }
}
