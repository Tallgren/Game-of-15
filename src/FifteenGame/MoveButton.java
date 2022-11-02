package FifteenGame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class MoveButton extends JFrame{

    public int buttonIndex = 0;
    public int emptyIndex = 0;


    public ArrayList<JButton> moveButton(ArrayList<JButton> currentOrderOfButtons, JButton button, JPanel gamePanel){

        buttonIndex = currentOrderOfButtons.indexOf(button);
        int row = buttonIndex / 4;
        int column = buttonIndex % 4;

        for (JButton element:currentOrderOfButtons) {
            if (element.getText().equals("")) {
                emptyIndex = currentOrderOfButtons.indexOf(element);
            }
        }
        int emptyIndexRow = emptyIndex / 4;
        int emptyIndexColumn = emptyIndex % 4;

        if (emptyIndexRow == row && (emptyIndexColumn == (column -1) || emptyIndexColumn == (column +1))) {
            Collections.swap(currentOrderOfButtons, buttonIndex, emptyIndex);
            SwapButtons(gamePanel, currentOrderOfButtons);
        }
        else if (emptyIndexColumn == column && (row == (emptyIndexRow -1) || row == (emptyIndexRow +1))){
            Collections.swap(currentOrderOfButtons, buttonIndex, emptyIndex);
            SwapButtons(gamePanel, currentOrderOfButtons);
        }

        return currentOrderOfButtons;
/*
        if (lf.isWin(currentOrderOfButtons)){
            headPanel.add(winnerLabel);
        }
 */
    }
    public void SwapButtons(JPanel gamePanel, ArrayList<JButton> currentOrderOfButtons) {
        JButton bEmpty = (JButton) gamePanel.getComponent(emptyIndex);
        JButton bSwap = (JButton) gamePanel.getComponent(buttonIndex);
        String emptyText = bEmpty.getText();
        String swapText = bSwap.getText();
        bEmpty.setText(swapText);
        bSwap.setText(emptyText);
        Collections.swap(currentOrderOfButtons, buttonIndex, emptyIndex);
    }
}