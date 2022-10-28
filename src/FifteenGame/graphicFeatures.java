package FifteenGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class graphicFeatures extends JFrame {
    JPanel headPanel = new JPanel();
    JPanel gamePanel = buttonPanel();
    JButton newGame = new JButton("Nytt Spel");
    JButton demo = new JButton("Demo");
    graphicFeatures() {
        setLayout(new BorderLayout());
        add(headPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.SOUTH);

        headPanel.add(newGame);
        headPanel.add(demo);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JPanel buttonPanel(){
        logicFeatures lf = new logicFeatures();
        ArrayList <JButton> buttonList = lf.buttonList();
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));
        for (JButton element: buttonList) {
            buttonPanel.add(element);
        }
        return buttonPanel;
    }
}
