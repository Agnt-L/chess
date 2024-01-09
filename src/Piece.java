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

    public Piece(int color, String fenLetter) {
        this.color = color;
        this.fenLetter = fenLetter;
    }

    public String getFen() {
        if (this.color == 0) {
            return fenLetter.toUpperCase();
        } else {
            return fenLetter;
        }
    }

    public abstract boolean isValidMove(Coordinate from, Coordinate to);

    public abstract void generateNextMoves();

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
