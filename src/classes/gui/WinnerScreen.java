package classes.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class WinnerScreen extends JPanel {

    public WinnerScreen(Game game, int score, int max) {
        this.setPreferredSize(new Dimension(16*50, 10*50));
        myLabel("Congratulations!");
        myLabel("You've completed the level");
        myLabel("with " + score + " points out of " + max + " possible");
        this.setBackground(new Color(86,86,86));
        //TODO: Add buttons
        MenuButton choose = new MenuButton("Choose level");
        choose.addActionListener(new ButtonListener(this){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                game.getContentPane().removeAll();
                try {
                    LevelChoicePanel panel = new LevelChoicePanel(game);
                    game.add(panel);
                    game.pack();
                    game.setVisible(true);
                    panel.requestFocusInWindow();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        choose.setBorder(BorderFactory.createLineBorder(new Color(255, 190,0), 3));
        this.add(choose);
    }

    public void myLabel(String text) {
        JLabel txt = new JLabel(text, SwingConstants.CENTER);
        txt.setFont(new Font("ROBOTO", Font.BOLD, 42));
        txt.setForeground(new Color(255,255,255));
        this.add(txt);
    }
}