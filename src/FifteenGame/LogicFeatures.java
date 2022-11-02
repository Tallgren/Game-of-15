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

    public ArrayList<JButton> demoList(ArrayList<JButton> buttonList) {
        buttonList.get(15).setText("");
        buttonList.get(16).setText("15");
        return buttonList;
    }

    public void scrambledButtonList(ArrayList<JButton> buttonList) {
        Collections.shuffle(buttonList);
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