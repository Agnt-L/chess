import javax.swing.*;
import java.awt.*;

public class CircleButtonMain {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle Button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new CircleButton();
        button.setText("Click me!");

        frame.add(button, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
