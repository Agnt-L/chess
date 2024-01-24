import java.util.List;

public abstract class Piece {
    private int color;

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    private Coordinate position;

    private final String fenLetter;

    private final int index;

    public Piece(int color, String fenLetter, int index) {
        this.color = color;
        this.fenLetter = fenLetter;
        this.index = index;
    }

    public String getFen() {
        if (this.color == 0) {
            return fenLetter.toUpperCase();
        } else {
            return fenLetter;
        }
    }

    public int getIndex() {
        return index;
    }

    public abstract boolean isValidMove(Coordinate from, Coordinate to);

    public abstract List<Coordinate> generateNextMoves();

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
