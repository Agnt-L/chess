import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
public class BitboardGame {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Bitboards bitboards = Bitboards.getInstance();
        for (int i = 0; i < bitboards.bitboards.length; i++) {
            bitboards.printBitboard(bitboards.bitboards[i]);
        }
        Rook rook = new Rook(0);
        bitboards.movePiece(rook, new Coordinate(0, 1));
    }
}
