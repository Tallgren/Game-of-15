package FifteenGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GraphicFeatures extends JFrame implements ActionListener {

    LogicFeatures lf = new LogicFeatures();
    MoveButton mb = new MoveButton();
    JPanel headPanel = new JPanel();
    JPanel panelForButtons = new JPanel();

    ArrayList<JButton> currentOrderOfButtons = lf.buttonList();
    JPanel gamePanel = buttonPanel(panelForButtons, currentOrderOfButtons);
    JButton newGame = new JButton("Nytt Spel");
    JButton demo = new JButton("Demo");

    GraphicFeatures() {
        setLayout(new BorderLayout());
        add(headPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.SOUTH);
        panelForButtons.setLayout(new GridLayout(4, 4));

        headPanel.add(newGame);
        headPanel.add(demo);
        newGame.addActionListener(e -> {
            ArrayList<JButton> buttonList = lf.buttonList();
            lf.scrambledButtonList(buttonList);
            for (JButton element : buttonList) {
                JButton b = (JButton) gamePanel.getComponent(buttonList.indexOf(element));
                b.setText(element.getText());
            }
        });
        demo.addActionListener(l -> {
            ArrayList<JButton> buttonList = lf.buttonList();
            lf.demoList(buttonList);
            for (JButton element : buttonList) {
                JButton b = (JButton) gamePanel.getComponent(buttonList.indexOf(element));
                b.setText(element.getText());
            }
        });
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mb.moveButton(currentOrderOfButtons, (JButton) e.getSource(), gamePanel);

        revalidate();
        repaint();
    }

    public JPanel buttonPanel(JPanel buttonPanel, ArrayList<JButton> listToBeAdded) {
        for (JButton element : listToBeAdded) {
            element.addActionListener(this);
            buttonPanel.add(element);
        }
        return buttonPanel;
    }
}