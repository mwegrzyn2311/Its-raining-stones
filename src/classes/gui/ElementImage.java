package classes.gui;

import classes.elements.Explosion;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public enum ElementImage {
    DISC("disc.png"),
    POINT("point.png"),
    EMPTY("empty.png"),
    EXIT("exit.png"),
    GRASS("grass.png"),
    ROCK("rock.png"),
    SOLID("solidWall.png"),

    PLAYER("player.png"),
    SOUTHPLAYER("playerSouth.png"),
    WESTPLAYER("playerWest.png"),
    NORTHPLAYER("playerNorth.png"),

    EXPLOSION("explosion.png"),
    WALL("wall.png"),
    EASTTUNNEL("eastTunnel.png"),
    SOUTHTUNNEL("southTunnel.png"),
    WESTTUNNEL("westTunnel.png"),
    NORTHTUNNEL("northTunnel.png");



    public Image image;

    ElementImage(String imagePath) {
        try {
            this.image = ImageIO.read(getClass().getResource("/images/" + imagePath));
            if (this.image == null)
                System.out.println("ElementImage initialization is wrong");
        } catch (IOException ex) {
            throw new RuntimeException("Failed to load static resource");
        }
    }
}
