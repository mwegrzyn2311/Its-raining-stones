package classes.gui;

import classes.elements.Explosion;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public enum ElementImage {
    DISC("/images/disc.png"),
    POINT("/images/ects.png"),
    EMPTY("/images/empty.png"),
    EXIT("/images/exit.png"),
    GRASS("/images/grass.png"),
    ROCK("/images/rock.png"),
    PLAYER("/images/student.png"),
    SOLID("/images/solidWall.png"),

    SOUTHPLAYER("/images/studentSouth.png"),
    WESTPLAYER("/images/studentWest.png"),
    NORTHPLAYER("/images/studentNorth.png"),

    EXPLOSION("/images/explosion.png"),
    WALL("/images/wall.png"),
    EASTTUNNEL("/images/eastTunnel.png"),
    SOUTHTUNNEL("/images/southTunnel.png"),
    WESTTUNNEL("/images/westTunnel.png"),
    NORTHTUNNEL("/images/northTunnel.png");



    public Image image;

    ElementImage(String imagePath) {
        try {
            this.image = ImageIO.read(getClass().getResource(imagePath));
            if (this.image == null)
                System.out.println("ElementImage initialization is wrong");
        } catch (IOException ex) {
            throw new RuntimeException("Failed to load static resource");
        }
    }
}
