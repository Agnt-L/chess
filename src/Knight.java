import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    public Knight(int color) {
        super(color, "n", 1);
    }

    @Override
    public boolean isValidMove(Coordinate from, Coordinate to) {
        int rowDifference = Math.abs(to.getRank() - from.getRank());
        int colDifference = Math.abs(to.getFile() - from.getFile());

        return (rowDifference == 2 && colDifference == 1 || rowDifference == 1 && colDifference == 2);
    }

    @Override
    public List<Coordinate> generateNextMoves() {
        Coordinate coord = this.getPosition();
        List<Coordinate> nextCoords = new ArrayList<>();
        int rank = coord.getRank();
        int file = coord.getFile();

        // Check possible moves up-left
        if (rank < 6 && file > 0) {
            nextCoords.add(new Coordinate(rank + 2, file - 1));
        }

        // Check possible moves up-right
        if (rank < 6 && file < 7) {
            nextCoords.add(new Coordinate(rank + 2, file + 1));
        }

        // Check possible moves down-left
        if (rank > 1 && file > 0) {
            nextCoords.add(new Coordinate(rank - 2, file - 1));
        }

        // Check possible moves down-right
        if (rank > 1 && file < 7) {
            nextCoords.add(new Coordinate(rank - 2, file + 1));
        }

        // Check possible moves up-2 left
        if (rank < 7 && file > 1) {
            nextCoords.add(new Coordinate(rank + 1, file - 2));
        }

        // Check possible moves up-2 right
        if (rank < 7 && file < 6) {
            nextCoords.add(new Coordinate(rank + 1, file + 2));
        }

        // Check possible moves down-2 left
        if (rank > 0 && file > 1) {
            nextCoords.add(new Coordinate(rank - 1, file - 2));
        }

        // Check possible moves down-2 right
        if (rank > 0 && file < 6) {
            nextCoords.add(new Coordinate(rank - 1, file + 2));
        }

        return nextCoords;
    }
}
