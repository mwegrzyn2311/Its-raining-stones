package classes.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StartingScreen extends JPanel {
    private JButton choose;
    private JButton options;
    private JButton quit;

    public StartingScreen(Game game){
        // this.setBackground(new Color(155, 61, 5));
        this.setBackground(new Color(86, 86, 86));
        this.setPreferredSize(new Dimension(16*50, 10*50));
        this.setLayout(new GridLayout(3,1));
        this.setBorder(null);

        choose = new MenuButton("Choose level");
        choose.addActionListener(new ButtonListener(this){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    game.add(new LevelChoicePanel(game));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                game.remove(this.startingScreen);
                game.pack();
                game.setVisible(true);
            }
        });
        options = new MenuButton("Options");
        options.addActionListener(new ButtonListener(this){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //TODO: Change it to option panel
                System.out.println("I hope I will implement it soon");
            }
        });
        quit = new MenuButton("Quit");
        quit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        this.add(choose);
        this.add(options);
        this.add(quit);
    }
}
