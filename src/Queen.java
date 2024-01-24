import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.abs;

public class Queen extends Piece {
    public Queen(int color) {
        super(color, "q", 4);
    }



    @Override
    public boolean isValidMove(Coordinate from, Coordinate to) {
        int rankDif = abs(from.getRank() - to.getRank());
        int fileDif = abs(from.getFile() - to.getFile());
        return rankDif == 0 || fileDif == 0 || rankDif == fileDif;
    }

    @Override
    public List<Coordinate> generateNextMoves() {
        Coordinate coord = this.getPosition();
        List<Coordinate> nextCoords = new ArrayList<>();
        for(int i=0; i<8; i++) {
            nextCoords.add(new Coordinate(coord.getRank(), i));
            nextCoords.add(new Coordinate(i, coord.getFile()));
        }
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
        // remove current field
        nextCoords.removeAll(Collections.singleton(coord));

        for (int i = 0; i < nextCoords.size(); i++) {
            System.out.println(nextCoords.get(i).getRank() + " " + nextCoords.get(i).getFile());
        }
        return nextCoords;
    }
}
