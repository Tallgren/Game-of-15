package FifteenGame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class LogicFeatures extends JFrame {

    public ArrayList<JButton> buttonList() {
        ArrayList<JButton> buttonList = new ArrayList<>();
        for (int i = 1; i < 16; i++) {
            JButton b = new JButton();
            b.setText(String.valueOf(i));
            buttonList.add(b);
        }
        buttonList.add(new JButton(""));
        return buttonList;
    }

    public void demoList(ArrayList<JButton> buttonList) {
        buttonList.get(14).setText("");
        buttonList.get(15).setText("15");
    }

    public void scrambledButtonList(ArrayList<JButton> buttonList) {
        Collections.shuffle(buttonList);
    }
    public boolean isWin(ArrayList<JButton> orderOfButtons) {
        int controller = 1;
        for (int i = 0; i < orderOfButtons.size()-1; i++) {
            if (orderOfButtons.get(i).getText().equals("")) {
                break;
            } else if (controller == Integer.parseInt(orderOfButtons.get(i).getText())) {
                    controller++;
                }
            }
        if (controller == 16) {
            return true;
        } else {
            return false;
        }
    }
}