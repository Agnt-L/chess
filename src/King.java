import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class King extends Piece{
    public King(int color) {
        super(color, "k", 5);
    }

    @Override
    public boolean isValidMove(Coordinate from, Coordinate to) {
        int rankDif = abs(from.getRank() - to.getRank());
        int fileDif = abs(from.getFile() - to.getFile());
        return rankDif == 1 || fileDif == 1;
    }

    @Override
    public List<Coordinate> generateNextMoves() {
        Coordinate coord = this.getPosition();
        List<Coordinate> nextCoords = new ArrayList<>();
        int rank = coord.getRank();
        int file = coord.getFile();
        if (rank != 7) {
            if (file != 7) {
                nextCoords.add(new Coordinate(rank + 1, file + 1));
            }
            nextCoords.add(new Coordinate(rank + 1, file));
            if (file != 0) {
                nextCoords.add(new Coordinate(rank + 1, file - 1));
            }
        }
        if (rank != 0) {
            if (file != 7) {
                nextCoords.add(new Coordinate(rank - 1, file + 1));
            }
            nextCoords.add(new Coordinate(rank - 1, file));
            if (file != 0) {
                nextCoords.add(new Coordinate(rank - 1, file - 1));
            }

        }
        if (file != 7) {
            nextCoords.add(new Coordinate(rank, file + 1));
        }
        if (file != 0) {
            nextCoords.add(new Coordinate(rank, file - 1));
        }
        return nextCoords;
    }
}
