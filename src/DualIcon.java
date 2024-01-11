import javax.swing.Icon;
import java.awt.*;

public class DualIcon implements Icon {

    private Icon icon1;
    private Icon icon2;

    public DualIcon(Icon icon1, Icon icon2) {
        this.icon1 = icon1;
        this.icon2 = icon2;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        icon1.paintIcon(c, g, x, y);
        icon2.paintIcon(c, g, x + (icon1.getIconWidth() - icon2.getIconWidth()) / 2, y + (icon1.getIconHeight() - icon2.getIconHeight()) / 2);
    }

    @Override
    public int getIconWidth() {
        return icon1.getIconWidth() + icon2.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return icon1.getIconHeight();
    }
}
