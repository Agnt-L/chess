public class Pawn extends Piece {
    public Pawn(int color) {
        super(color, "p");
    }

    @Override
    public boolean isValidMove(Coordinate from, Coordinate to) {
        int rowDifference = Math.abs(to.getRank() - from.getRank());
        int colDifference = Math.abs(to.getFile() - from.getFile());

        return (rowDifference == 1 && colDifference == 0);
    }

    @Override
    public void generateNextMoves() {

    }
}
