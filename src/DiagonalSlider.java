import java.util.List;

public class DiagonalSlider {
    List<Coordinate> diagonalMoveList;
    public void generateDiagonalMoves(Coordinate coord) {
        int rank = coord.getRank();
        int file = coord.getFile();
        while (rank != 8 && file != 8) {
            diagonalMoveList.add(new Coordinate(rank, file));
            rank++;
            file++;
        }
        rank = coord.getRank();
        file = coord.getFile();
        while (rank != 8 && file != -1) {
            diagonalMoveList.add(new Coordinate(rank, file));
            rank++;
            file--;
        }

        rank = coord.getRank();
        file = coord.getFile();
        while (rank != -1 && file != 8) {
            diagonalMoveList.add(new Coordinate(rank, file));
            rank--;
            file++;
        }

        rank = coord.getRank();
        file = coord.getFile();
        while (rank != -1 && file != -1) {
            diagonalMoveList.add(new Coordinate(rank, file));
            rank--;
            file--;
        }
    }
}
