package classes.gui;

import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Game extends JFrame {
    public Game() throws IOException {
        super("Kamienie na ryj");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.add(new StartingScreen(this));
        // this.add(new LevelChoicePanel(this));

        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
