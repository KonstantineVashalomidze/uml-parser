import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.HashSet;
import java.util.Set;

public class MovableCircle
    extends DraggableComponent
{
    MovableCircle self = this;
    Set<Point> circlesCoordinates = new HashSet<>();
    private Point startPoint;

    public MovableCircle()
    {
        this.setBounds(0, 0, 10_000, 10_000);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (e.getButton() == MouseEvent.BUTTON1)
                {
                    startPoint = e.getPoint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                startPoint = null;
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if (startPoint != null) {
                    circlesCoordinates.add(new Point(e.getX(), e.getY()));

                    repaint();
                }

            }
        });
    }

    @Override
    public void paintComponent(Graphics g)
    {
        var g2 = (Graphics2D) g;

        g2.drawRect(0, 0, 10_000, 10_000);
        g2.fillRect(0, 0, 10_000, 10_000);

        circlesCoordinates.forEach((point) -> {
            g2.setPaint(Color.red);
            g2.drawOval((int) point.getX(), (int) point.getY(), 5, 5);
            g2.fillOval((int) point.getX(), (int) point.getY(), 5, 5);
        });

    }



}
