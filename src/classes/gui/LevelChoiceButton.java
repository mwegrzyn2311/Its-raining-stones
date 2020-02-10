package classes.gui;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class LevelChoiceButton extends JButton {
    private JSONObject arguments;
    private Game game;

    public LevelChoiceButton(Game game, BufferedImage image, String name) {
        this.game = game;
        this.setText(name);
        constructButton();
        this.addActionListener(actionEvent -> {
            game.getContentPane().removeAll();
            LevelPanel levelPanel = new LevelPanel(image, game);
            game.add(levelPanel);
            game.setVisible(true);
            game.pack();
            levelPanel.requestFocusInWindow();
        });
    }


    public LevelChoiceButton(Game game, InputStream stream) throws IOException {
        this.game = game;
        String parameters = new String(stream.readAllBytes());
        this.arguments = new JSONObject(parameters);
        JSONArray map = this.arguments.getJSONArray("map");
        String name = (String) this.arguments.get("name");
        this.setText(name);
        constructButton();
        this.addActionListener(actionEvent -> {
            game.getContentPane().removeAll();
            LevelPanel levelPanel = new LevelPanel(map, game);
            game.add(levelPanel);
            game.pack();
            game.setVisible(true);
            levelPanel.requestFocusInWindow();
        });
    }


    private void constructButton() {
        this.setBackground(null);
        this.setPreferredSize(new Dimension(this.getText().length()*16,25));
        this.setFont(new Font("ROBOTO", Font.BOLD, 24));
        this.setForeground(new Color(255, 255, 255));
        this.setBorder(null);
        this.setFocusPainted(false);
    }

}
