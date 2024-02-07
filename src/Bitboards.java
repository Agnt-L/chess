import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.List;

public class Bitboards {
    private static final Bitboards OBJ = new Bitboards();

    Long[] bitboards = new Long[] {
        0b11111111000000000000000000000000000000000000000000000000L, // white pawns
        0b0100001000000000000000000000000000000000000000000000000000000000L, // white knights
        0b0010010000000000000000000000000000000000000000000000000000000000L, // white bishops
        0b1000000100000000000000000000000000000000000000000000000000000000L, // white rooks
        0b0000100000000000000000000000000000000000000000000000000000000000L, // white queen
        0b1000000000000000000000000000000000000000000000000000000000000L, // white king
        0b0000000000000000000000000000000000000000000000001111111100000000L, // black pawns
        0b0000000000000000000000000000000000000000000000000000000001000010L, // black knights
        0b00100100L, // black bishops
        0b0000000000000000000000000000000000000000000000000000000010000001L, // black rooks
        0b00001000L, // black queen
        0b00010000L, // black king
        0b1111111111111111000000000000000000000000000000000000000000000000L, // white pieces
        0b1111111111111111L, // black pieces
    };

    private Bitboards() {
    }

    public static Bitboards getInstance() {
        return OBJ;
    }

    public BigInteger coordListToBitboard(List<Coordinate> coordList) {
        BigInteger combinedBitboard = new BigInteger("0", 2);
        for (Coordinate coord : coordList) {
            int rank = coord.getRank();
            int file = coord.getFile();
            int index = rank * 8 + file;
            combinedBitboard = combinedBitboard.setBit(index);
        }
        return combinedBitboard;
    }

    public static void printBitboard(Long bitboard) {
        int bitboardLen = Long.toBinaryString(bitboard).length();
        int zeroLines = (64 - bitboardLen) / 8;
        int zeros = (64 - bitboardLen) % 8;

        for (int i = 0; i < zeroLines; i++) {
            System.out.println("0 0 0 0 0 0 0 0");
        }

        for (int i = 0; i < zeros; i++) {
            System.out.print("0 ");
        }

        String bitString = Long.toBinaryString(bitboard);
        for (int i = 0; i < bitString.length(); i++) {
            if ((i+zeros) % 8 == 0 & i+zeros > 0) System.out.println();
            System.out.print(bitString.charAt(i) + " ");
        }
        System.out.println();
        System.out.println();
    }

    public static void printBitboard(BigInteger bitboard) {
        int bitboardLen = bitboard.bitLength();
        int zeroLines = (64 - bitboardLen) / 8;
        int zeros = (64 - bitboardLen) % 8;

        for (int i = 0; i < zeroLines; i++) {
            System.out.println("0 0 0 0 0 0 0 0");
        }

        for (int i = 0; i < zeros; i++) {
            System.out.print("0 ");
        }

        String bitString = bitboard.toString(2);
        for (int i = 0; i < bitString.length(); i++) {
            if (i % 8 == 0 & i > 0) System.out.println();
            System.out.print(bitString.charAt(i) + " ");
        }
        System.out.println();
        System.out.println();
    }
    public void movePiece(Piece piece, Coordinate to) {
        int bitboardIndex = piece.getIndex() * (piece.getColor() + 1);
        int fromIndex = piece.getPosition().getRank() * 8 + piece.getPosition().getFile();
        int toIndex = to.getRank() * 8 + to.getFile();
        int generalBitboardIndex = 12 + piece.getColor();

        // add 1 at new piece position in piece bitboard
        this.bitboards[bitboardIndex]  = this.bitboards[bitboardIndex] | (long) 1 << 64 - toIndex;
        printBitboard(this.bitboards[bitboardIndex]);
        // remove 1 at previous piece position in piece bitboard
        this.bitboards[bitboardIndex]  = this.bitboards[bitboardIndex] ^ (long) 1 << 64 - fromIndex;
        // add 1 at new piece position in player bitboard
        printBitboard(this.bitboards[bitboardIndex]);
        this.bitboards[generalBitboardIndex]  = this.bitboards[generalBitboardIndex] | (long) 1 << 64 - toIndex;
        printBitboard(this.bitboards[generalBitboardIndex]);
        // remove 1 at new piece position in player bitboard
        this.bitboards[generalBitboardIndex]  = this.bitboards[generalBitboardIndex] ^ (long) 1 << 64 - fromIndex;
        printBitboard(this.bitboards[generalBitboardIndex]);

        System.out.println("bitboards");
    }
}
