import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    public Pawn(int color) {
        super(color, "p", 0);
    }

    @Override
    public boolean isValidMove(Coordinate from, Coordinate to) {
        int rank = from.getRank();
        int rowDifference = to.getRank() - from.getRank();
        int colDifference = to.getFile() - from.getFile();

        if (colDifference == 0) {
            if (this.getColor() == 0) {
                return rowDifference == 1 | (rowDifference == 2 && rank == 1);
            } else {
                return rowDifference == -1 | (rowDifference == -2 && rank == 6);
            }
        }
        return false;
    }

    @Override
    public List<Coordinate> generateNextMoves() {
        List<Coordinate> nextCoords = new ArrayList<>();
        int rank = this.getPosition().getRank();
        int file = this.getPosition().getFile();
        if (this.getColor() == 0) {
            nextCoords.add(new Coordinate(rank + 1, file));
            if (rank == 1) {
                nextCoords.add(new Coordinate(rank + 2, file));
            }
        } else {
            nextCoords.add(new Coordinate(rank - 1, file));
            if (rank == 6) {
                nextCoords.add(new Coordinate(rank - 2, file));
            }
        }
        return nextCoords;
    }
}
