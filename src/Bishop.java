import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Bishop extends Piece{
    public Bishop(int color) {
        super(color, "b");
    }

    @Override
    public boolean isValidMove(Coordinate from, Coordinate to) {
        int rankDif = abs(from.getRank() - to.getRank());
        int fileDif = abs(from.getFile() - to.getFile());
        return rankDif == fileDif;
    }

    @Override
    public List<Coordinate> generateNextMoves() {
        Coordinate coord = this.getPosition();
        List<Coordinate> nextCoords = new ArrayList<>();

        int rank = coord.getRank();
        int file = coord.getFile();

        while (rank != 8 && file != 8) {
            nextCoords.add(new Coordinate(rank, file));
            rank++;
            file++;
        }
        rank = coord.getRank();
        file = coord.getFile();
        while (rank != 8 && file != -1) {
            nextCoords.add(new Coordinate(rank, file));
            rank++;
            file--;
        }

        rank = coord.getRank();
        file = coord.getFile();
        while (rank != -1 && file != 8) {
            nextCoords.add(new Coordinate(rank, file));
            rank--;
            file++;
        }

        rank = coord.getRank();
        file = coord.getFile();
        while (rank != -1 && file != -1) {
            nextCoords.add(new Coordinate(rank, file));
            rank--;
            file--;

        }
        return nextCoords;
    }
}
