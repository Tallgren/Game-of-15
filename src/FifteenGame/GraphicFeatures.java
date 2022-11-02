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

    JLabel winnerLabel = new JLabel("Grattis, du VANN!!!");
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

        System.out.print("first ");
        currentOrderOfButtons.forEach(a -> System.out.print(a.getText()+" "));
        System.out.println();

        mb.moveButton(currentOrderOfButtons, (JButton) e.getSource(), gamePanel);

        System.out.print("middle ");
        currentOrderOfButtons.forEach(a -> System.out.print(a.getText()+" "));
        System.out.println();

        /*
        JButton bEmpty = (JButton) gamePanel.getComponent(mb.emptyIndex);
        JButton bSwap = (JButton) gamePanel.getComponent(mb.buttonIndex);
        String emptyText = bEmpty.getText();
        String swapText = bSwap.getText();
        bEmpty.setText(swapText);
        bSwap.setText(emptyText);
        //Collections.swap(currentOrderOfButtons, mb.buttonIndex, mb.emptyIndex);
         */

        revalidate();
        repaint();

        System.out.print("last ");
        currentOrderOfButtons.forEach(a -> System.out.print(a.getText()+" "));
        System.out.println();

    }

    public JPanel buttonPanel(JPanel buttonPanel, ArrayList<JButton> listToBeAdded){
        for (JButton element: listToBeAdded) {
            element.addActionListener(this);
            buttonPanel.add(element);
        }
        return buttonPanel;
    }
}