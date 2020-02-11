package classes.elements;

import classes.board.RectangularMap;
import classes.gui.ElementImage;
import classes.stuff.MoveDirection;
import classes.stuff.Vector2d;

import java.awt.*;

public class Player extends AbstractMapElement {
    public int points=0;

    private RectangularMap map;
    private ElementImage imageNorth;
    private ElementImage imageWest;
    private ElementImage imageSouth;
    private MoveDirection lastMove = MoveDirection.EAST;


    public Player(Vector2d initialPosition, RectangularMap map) {
        super(initialPosition);
        this.image = ElementImage.PLAYER;

        this.imageNorth = ElementImage.NORTHPLAYER;
        this.imageWest = ElementImage.WESTPLAYER;
        this.imageSouth = ElementImage.SOUTHPLAYER;

        this.map = map;

    }

    @Override
    public String toString() {
        return "O";
    }

    @Override
    public Image getImage() {
        MoveDirection dir = this.map.levelPanel.lastMove;
        if(dir == null)
            dir = this.map.levelPanel.oneMove;
        if(dir == null) {
            dir = this.map.levelPanel.lastEat;
        }
        if(dir == null) {
            dir = this.map.levelPanel.oneEat;
        }
        if(dir != null)
            this.lastMove = dir;
        switch(this.lastMove){
            case NORTH:
                return this.imageNorth.image;
            case EAST:
                return this.image.image;
            case SOUTH:
                return this.imageSouth.image;
            case WEST:
                return this.imageWest.image;
            default:
        }
        return this.image.image;
    }



}
