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
        /*
        Stream<Path> pngFiles = Files.list(Paths.get("src/levelPatterns"));
        int pngCount = (int)pngFiles.count();
        Stream<Path> files = Files.list(Paths.get("src/levels"));
        int levelsCount = (int)files.count();
        this.setLayout(new GridLayout(levelsCount+pngCount+1,1));
        this.setBackground(new Color(86, 86, 86));
        files = Files.list(Paths.get("src/levels"));
        files.forEach(file -> {
            try {
                // this.levels.add(new LevelChoiceButton(game, file));
                this.add(new LevelChoiceButton(game, file));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        pngFiles = Files.list(Paths.get("src/levelPatterns"));
        pngFiles.forEach(file -> {
            try {
                String path = String.valueOf(file);
                BufferedImage image = ImageIO.read(new File(path));
                String name = path.substring(18, path.length()-4);
                this.add(new LevelChoiceButton(game, image, name));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        */
        int i;
        String base = "Level";
        for(i = 1; i <= 3; i++) {
            InputStream stream = getClass().getResourceAsStream("/levels/" + base + i + ".json");
            this.add(new LevelChoiceButton(game, stream));
        }

        for(i = i; i <= 4; i++) {
            InputStream stream = getClass().getResourceAsStream("/levels/" + base + i + ".json");
            String name = (String) new JSONObject(new String(stream.readAllBytes())).get("name");
            BufferedImage image = ImageIO.read(getClass().getResource("/levelPatterns/" + base + i + ".png"));
            this.add(new LevelChoiceButton(game, image, name));
        }

        this.setLayout(new GridLayout(i-1,1));
        this.setBackground(new Color(86, 86, 86));
    }
}
