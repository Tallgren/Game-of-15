package FifteenGame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class logicFeatures extends JFrame {

    public ArrayList<JButton> buttonList() {
        ArrayList<JButton> buttonList = new ArrayList<>();
        for (int i = 1; i < 16; i++) {
            JButton b = new JButton();
            b.setText(String.valueOf(i)); //may need adjustments
            buttonList.add(b);
        }
        return buttonList;
    }

    public void scrambledButtonList(ArrayList<JButton> buttonList) {
        Collections.shuffle(buttonList);
    }
}
