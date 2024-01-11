import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CircleButton extends JButton {

    private final int circleRadius = 20;

    public void setClicked(boolean clicked) {
        isClicked = clicked;
        repaint();
    }

    private boolean isClicked = false;

    public CircleButton() {
        setBorderPainted(false);
        setOpaque(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isClicked = true;
                //enable buttons that correspond to generated moves
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (isClicked) {
            g2d.setColor(Color.red);
            g2d.fillOval(getWidth() / 2 - circleRadius, getHeight() / 2 - circleRadius, circleRadius * 2, circleRadius * 2);
        }
    }

}
