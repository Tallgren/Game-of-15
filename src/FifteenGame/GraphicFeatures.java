package FifteenGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GraphicFeatures extends JFrame implements ActionListener {
    LogicFeatures lf = new LogicFeatures();

    JPanel headPanel = new JPanel();
    JLabel winnerLabel = new JLabel("Grattis, du VANN!!!");
    JPanel gamePanel = buttonPanel(lf.buttonList());
    ArrayList<JButton> currentOrderOfButtons = lf.buttonList();
    JButton newGame = new JButton("Nytt Spel");
    JButton demo = new JButton("Demo");
    GraphicFeatures() {
        setLayout(new BorderLayout());
        add(headPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.SOUTH);

        headPanel.add(newGame);
        headPanel.add(demo);
        newGame.addActionListener(this);

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
    @Override
    public void actionPerformed(ActionEvent e) {
        //lf.moveButton(currentOrderOfButtons, (JButton) e.getSource());

        if (e.getSource() == newGame) {
            ArrayList<JButton> buttonList = lf.buttonList();
            lf.scrambledButtonList(buttonList);
            currentOrderOfButtons = buttonList;
            for (JButton element : buttonList) {
                JButton b = (JButton) gamePanel.getComponent(buttonList.indexOf(element));
                b.setText(element.getText());
            }
        }
    }
}
