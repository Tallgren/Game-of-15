package FifteenGame;

import javax.swing.*;
import java.util.ArrayList;

public class logicFeatures {

    public ArrayList<JButton> buttonList() {
        ArrayList<JButton> buttonList = new ArrayList<>();
        for(int i = 1; i <17; i++) {
            JButton b = new JButton();
            buttonList.add(b);
        }
        return buttonList;
    }
}
