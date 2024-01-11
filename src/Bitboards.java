import java.math.BigInteger;
import java.util.List;

public class Bitboards {
    private static final Bitboards OBJ = new Bitboards();


    private Bitboards() {
    }

    public static Bitboards getInstance() {
        return OBJ;
    }

    public BigInteger coordListToBitboard(List<Coordinate> coordList) {
        BigInteger combinedBitboard = new BigInteger("0", 2);
        for (Coordinate coord: coordList) {
            int rank = coord.getRank();
            int file = coord.getFile();
            int index = rank * 8 + 8 - file;
            combinedBitboard = combinedBitboard.setBit(index);
        }
        return combinedBitboard;
    }
}
