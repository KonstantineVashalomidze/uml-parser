import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Main {

    public static void main(String[] args) {
        JFrame f = new JFrame("Swing Hello World");
        f.setLayout(null);
        // by doing this, we prevent Swing from resizing
        // our nice component
        f.setBounds(new Rectangle(0, 0, 800, 800));

        MovableCircle movableCircle = new MovableCircle();



        f.add(movableCircle);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
    }

}