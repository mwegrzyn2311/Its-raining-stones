package classes.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    public JPanel startingScreen;
    ButtonListener(JPanel screen){
        this.startingScreen = screen;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
