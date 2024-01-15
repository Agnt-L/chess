import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rook extends Piece{
    public Rook(int color) {
        super(color, "r");
    }

    @Override
    public boolean isValidMove(Coordinate from, Coordinate to) {
        return from.getRank() == to.getRank() || from.getFile() == to.getFile();
    }

    @Override
    public List<Coordinate> generateNextMoves() {
        Coordinate coord = this.getPosition();
        List<Coordinate> nextCoords = new ArrayList<>();
        for(int i=0; i<8; i++) {
            nextCoords.add(new Coordinate(coord.getRank(), i));
            nextCoords.add(new Coordinate(i, coord.getFile()));
            System.out.println(coord.getRank());
        }
        // remove current field
        nextCoords.removeAll(Collections.singleton(coord));

        for (int i = 0; i < nextCoords.size(); i++) {
            System.out.println(nextCoords.get(i).getRank() + " " + nextCoords.get(i).getFile());
        }

        return nextCoords;
    }


}
