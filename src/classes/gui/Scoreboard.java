package classes.gui;

import classes.elements.Player;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class Scoreboard extends JLabel {
    private LevelPanel levelPanel;
    public int totalPoints;

    public Scoreboard(LevelPanel levelPanel){
        this.levelPanel = levelPanel;
        this.totalPoints = levelPanel.map.totalPoints;
        // this.setBackground(new Color(49, 49, 49));
        this.setText("Pts: "+levelPanel.player.points+" / "+totalPoints);
        this.setFont(new Font("Serif", Font.BOLD, 18));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);
        Color borderColor = new Color(246, 162, 8);
        this.setBorder(BorderFactory.createLineBorder(borderColor, 5));

    }

    public void updateText(){
        this.setText("Pts: "+levelPanel.player.points+" / "+totalPoints);
    }
}
