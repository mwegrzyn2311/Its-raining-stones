package classes.gui;

import org.json.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LevelChoicePanel extends JPanel {

    public LevelChoicePanel(Game game) throws IOException {
        this.setPreferredSize(new Dimension(16*50, 10*50));

        this.setBorder(null);
        int i;
        String base = "Level";
        this.setLayout(new GridLayout(7,1));
        for(i = 1; i <= 7; i++) {
            InputStream stream = getClass().getResourceAsStream("/levels/" + base + i + ".json");
            if(stream == null)
                continue;
            JSONObject jsonInfo = new JSONObject(new String(stream.readAllBytes()));
            String name = (String) jsonInfo.get("name");
            int index = 0;
            if(jsonInfo.has("playerIndex"))
                index = (int) jsonInfo.get("playerIndex");
            BufferedImage image = ImageIO.read(getClass().getResource("/levelPatterns/" + base + i + ".png"));
            this.add(new LevelChoiceButton(game, image, name, index));
        }

        this.setBackground(new Color(86, 86, 86));
    }
}
