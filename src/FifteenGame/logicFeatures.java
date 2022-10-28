package FifteenGame;

import javax.swing.*;
import java.util.ArrayList;

public class logicFeatures extends JFrame {

    public ArrayList<JButton> buttonList() {
        ArrayList<JButton> buttonList = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            JButton b = new JButton();
            b.setText(String.valueOf(i)); //may need adjustments
            buttonList.add(b);
        }
        return buttonList;
    }
}
