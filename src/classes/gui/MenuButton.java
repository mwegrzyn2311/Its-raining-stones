package classes.gui;

import javax.swing.*;
import java.awt.*;

public class MenuButton extends JButton {

    public MenuButton(String name){
        this.setBackground(null);
        this.setText(name);
        int width = name.length();
        this.setPreferredSize(new Dimension(width*16,40));
        this.setFont(new Font("ROBOTO", Font.BOLD, 24));
        this.setForeground(new Color(255, 255, 255));
        this.setBorder(null);
        this.setFocusPainted(false);
    }
}
