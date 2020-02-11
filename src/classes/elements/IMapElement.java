package classes.elements;

import classes.gui.ElementImage;
import classes.stuff.Vector2d;

import java.awt.*;

public interface IMapElement {
    /**
     * @return position of the element
     */
    Vector2d getPosition();
    /**
     * @param newPosition of the element
     */
    void setPosition(Vector2d newPosition);
    /**
     * @return image corresponding to the element
     */
    Image getImage();
    /**
     * If the element has just been pushed, make it wait
     */
    void makeItWait();
    /**
     * @return true if wait == true
     */
    boolean isWaiting();
    /**
     * @return true if element is of such type that it can be moved
     */
    boolean isMovable();
    /**
     *
     */
    void startFalling();
    /**
     * @return true if element is currently falling
     */
    boolean isFalling();
    /**
     *
     */
    void stopFalling();
    /**
     *
     */
    boolean isDestructible();
}
