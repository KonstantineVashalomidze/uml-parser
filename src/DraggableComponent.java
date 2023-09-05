import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DraggableComponent
        extends JComponent {

    private volatile int screenX = 0;
    private volatile int screenY = 0;
    private volatile int myX = 0;
    private volatile int myY = 0;
    private Point startPoint;

    public DraggableComponent() {

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) { // Check for right mouse button
                    startPoint = e.getPoint();
                    screenX = e.getXOnScreen();
                    screenY = e.getYOnScreen();

                    myX = getX();
                    myY = getY();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                startPoint = null;
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });
        addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {

                if (startPoint != null) {
                    int deltaX = e.getXOnScreen() - screenX;
                    int deltaY = e.getYOnScreen() - screenY;

                    setLocation(myX + deltaX, myY + deltaY);

                }

            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }

        });
    }

}
