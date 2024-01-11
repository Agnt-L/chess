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
        List<Coordinate> nextCoords = new ArrayList<>();
        return nextCoords;
    }
}
