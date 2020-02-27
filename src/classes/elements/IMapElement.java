package classes.elements;

import classes.gui.ElementImage;
import classes.stuff.Vector2d;

import java.awt.*;

public interface IMapElement {
    /**
     * Gives elements' position
     *
     * @return position of the element
     */
    Vector2d getPosition();
    /**
     * Changes elements' position
     *
     * @param newPosition
     *              A position that we want element to be at
     */
    void setPosition(Vector2d newPosition);
    /**
     * Gives elements' image
     *
     * @return image corresponding to the element
     */
    Image getImage();
    /**
     * If the element has just been pushed, make it wait (so that it does not move two tiles at a time)
     */
    void makeItWait();
    /**
     * Informs if elements is waiting after being pushed, before falling down
     *
     * @return true if wait == true
     */
    boolean isWaiting();
    /**
     * Informs if element can be moved
     *
     * @return true if element is of such type that it can be moved
     */
    boolean isMovable();
    /**
     * Mark element as a falling element (so that it cannot be pushed while falling down)
     */
    void startFalling();
    /**
     * Inform if the element is currently falling down
     *
     * @return true if element is currently falling
     */
    boolean isFalling();
    /**
     * Mark element as not-falling anymore
     */
    void stopFalling();
    /**
     * Informs if the element can be destroyed by an explosion
     *
     * @return true if element can be destroyed by an explosion
     */
    boolean isDestructible();
}
