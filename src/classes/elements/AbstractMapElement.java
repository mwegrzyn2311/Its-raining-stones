package classes.elements;

import classes.gui.ElementImage;
import classes.stuff.Vector2d;

import java.awt.*;

public abstract class AbstractMapElement implements IMapElement {
    protected Vector2d position;
    protected ElementImage image;
    protected boolean wait = false;
    protected boolean falling = false;
    protected boolean movable = false;
    protected boolean destructible = true;
    public AbstractMapElement(Vector2d initialPosition){
        this.position = initialPosition;
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public void setPosition(Vector2d newPosition){this.position = newPosition;}

    public Image getImage(){
        return this.image.image;
    }

    public void makeItWait(){
        this.wait = true;
    }

    public boolean isWaiting() {
        if(wait) {
            wait = false;
            return true;
        }
        return false;
    }

    public boolean isMovable(){
        return this.movable;
    }

    public boolean isFalling(){
        return this.falling;
    }

    public void startFalling(){
        this.falling = true;
    }

    public void stopFalling(){this.falling = false;}

    public boolean isDestructible(){return this.destructible;}
}
