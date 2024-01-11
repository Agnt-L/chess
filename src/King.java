import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class King extends Piece{
    public King(int color) {
        super(color, "k");
    }

    @Override
    public boolean isValidMove(Coordinate from, Coordinate to) {
        int rankDif = abs(from.getRank() - to.getRank());
        int fileDif = abs(from.getFile() - to.getFile());
        return rankDif == 1 || fileDif == 1;
    }

    @Override
    public List<Coordinate> generateNextMoves() {
        List<Coordinate> nextCoords = new ArrayList<>();
        return nextCoords;
    }
}
