package FifteenGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class graphicFeatures extends JFrame {

    logicFeatures lf = new logicFeatures();
    JPanel headPanel = new JPanel();
    JPanel gamePanel = buttonPanel(lf.buttonList());
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

    public JPanel buttonPanel(ArrayList<JButton> listToBeAdded){
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));
        for (JButton element: listToBeAdded) {
            buttonPanel.add(element);
        }
        buttonPanel.add(new JButton(""));
        return buttonPanel;
    }
}
