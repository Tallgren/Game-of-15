package FifteenGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class graphicFeatures extends JFrame {

    public JPanel buttonPanel(ArrayList <JButton> buttonList){
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));
        for (JButton element: buttonList) {
            buttonPanel.add(element);
        }
        return buttonPanel;
    }
}
