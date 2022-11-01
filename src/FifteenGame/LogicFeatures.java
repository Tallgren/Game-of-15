package FifteenGame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class LogicFeatures extends JFrame {

    public ArrayList<JButton> buttonList() {
        ArrayList<JButton> buttonList = new ArrayList<>();
        for (int i = 1; i < 16; i++) {
            JButton b = new JButton();
            b.setText(String.valueOf(i)); //may need adjustments
            buttonList.add(b);
        }
        return buttonList;
    }

    public void demoList(ArrayList<JButton> buttonList) {
        buttonList.get(15).setText("");
        buttonList.get(16).setText("15");
    }

    public void scrambledButtonList(ArrayList<JButton> buttonList) {
        Collections.shuffle(buttonList);
    }

    public ArrayList <JButton> moveButton(ArrayList <JButton> currentOrderOfButtons, JButton button){
        int buttonIndex = currentOrderOfButtons.indexOf(button);
        int row = buttonIndex / 4;
        int column = buttonIndex % 4;
        int emptyIndex = currentOrderOfButtons.indexOf("");
        if (emptyIndex == row -1 || emptyIndex == row +1 || emptyIndex == column -1 || emptyIndex == column +1){
            Collections.swap(currentOrderOfButtons, buttonIndex, emptyIndex);
        }
        return currentOrderOfButtons;
        /*
        if (isWin(currentOrderOfButtons)){
            gf.headPanel.add(gf.winnerLabel);
        }
        */
    }

    public boolean isWin(ArrayList<JButton> orderOfButtons) {
        int controller = 1;
        for (JButton element : orderOfButtons) {
            if (controller == Integer.parseInt(element.getText())) {
                controller++;
            }
        }
        if (controller == 15) {
            return true;
        } else {
            return false;
        }
    }
}
