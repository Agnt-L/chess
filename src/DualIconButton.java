import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DualIconButton {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dual Icon Button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon1 = new ImageIcon(DualIconButton.class.getResource("images/white_king.png"));
        Image img1_scaled = icon1.getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon1_scaled = new ImageIcon(img1_scaled);
        ImageIcon icon2 = new ImageIcon(DualIconButton.class.getResource("images/black_pawn.png"));

        //
        int circleRadius = 10;
        BufferedImage image = new BufferedImage(circleRadius * 2, circleRadius * 2, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color transpGray = new Color(128, 128, 128, 220);
        g2d.setColor(transpGray);
        g2d.fillOval(0, 0, circleRadius * 2, circleRadius * 2);
        g2d.setColor(transpGray);
        g2d.drawOval(0, 0, circleRadius * 2, circleRadius * 2);

        // Create an icon from the image
        ImageIcon icon = new ImageIcon(image);

        DualIcon dualIcon = new DualIcon(icon1_scaled, icon);

        JButton button = new JButton();
        button.setIcon(dualIcon);

        frame.add(button, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
