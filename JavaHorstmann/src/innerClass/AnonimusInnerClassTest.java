package innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

/**
 * @autor mvl on 01.06.2017.
 */
public class AnonimusInnerClassTest {
    public static void main(String[] args) {
        TalkingClock2 clock = new TalkingClock2();
        clock.start(1000, true);

        JOptionPane.showMessageDialog(null, "Выход ?..");
        System.exit(0);
    }
}

class TalkingClock2{
    public void start(int interval, boolean beep){
        Timer t = new Timer(interval, e -> {
            System.out.println("At the tone, the time is " + new Date());
            if (beep) Toolkit.getDefaultToolkit().beep();
        });
        t.start();
    }
}
