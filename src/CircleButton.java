import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Flow;

public class CircleButton extends JButton implements Flow.Subscriber<Piece> {

    private final int circleRadius = 20;

    private static final int SQUARE_SIZE = 80;
    private static final int ICON_SIZE = (int) (0.85 * SQUARE_SIZE);
    private Flow.Subscription subscription;

    public void setClicked(boolean clicked) {
        isClicked = clicked;
        repaint();
    }

    private boolean isClicked = false;

    public CircleButton() {
        setBorderPainted(false);
        setOpaque(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //isClicked = true;
                //enable buttons that correspond to generated moves
                //repaint();
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

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Piece piece) {
        ImageIcon icon = getPieceIcon(piece);
        this.setIcon(icon);
        System.out.println("NEXT!!!");
        subscription.request(1);
    }

    private ImageIcon getPieceIcon(Piece piece) {
        String pieceType = piece.getClass().getSimpleName().toLowerCase();
        String color = (piece.getColor() == 0) ? "white" : "black";
        String fileName = color + "_" + pieceType + ".png";

        String filePath = "images/" + fileName;
        System.out.println(filePath);

        Image img = new ImageIcon(getClass().getResource(filePath)).getImage();
        Image newImg = img.getScaledInstance(ICON_SIZE, ICON_SIZE, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newImg);

        return icon;
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Done");
    }
}
