package classes;

import classes.board.RectangularMap;
import classes.gui.Game;
import org.json.JSONObject;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    //TODO: Add switching between the players
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            try {
                Game game = new Game();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
