public class Knight extends Piece {

    public Knight(int color) {
        super(color, "n");
    }

    @Override
    public boolean isValidMove(Coordinate from, Coordinate to) {
        int rowDifference = Math.abs(to.getRank() - from.getRank());
        int colDifference = Math.abs(to.getFile() - from.getFile());

        return (rowDifference == 2 && colDifference == 1 || rowDifference == 1 && colDifference == 2);
    }

    @Override
    public void generateNextMoves() {
    }
}
