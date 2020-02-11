package classes.elements;

import classes.gui.ElementImage;
import classes.stuff.MoveDirection;
import classes.stuff.Vector2d;

public class Tunnel extends AbstractMapElement{
    public MoveDirection dir;
    public Tunnel(Vector2d initialPosition, MoveDirection dir) {
        super(initialPosition);
        this.dir = dir;
        this.destructible = false;
        switch (dir) {
            case NORTH:
                this.image = ElementImage.NORTHTUNNEL;
                break;
            case EAST:
                this.image = ElementImage.EASTTUNNEL;
                break;
            case WEST:
                this.image = ElementImage.WESTTUNNEL;
                break;
            case SOUTH:
                this.image = ElementImage.SOUTHTUNNEL;
                break;
            default:
        }
    }

    public String toString(){
        return "T";
    }
}
