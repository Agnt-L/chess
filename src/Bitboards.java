import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.List;

public class Bitboards {
    private static final Bitboards OBJ = new Bitboards();

    private long black_pawn = 0b0000000000000000000000000000000000000000000000001111111100000000L;
    private long black_rook = 0b0000000000000000000000000000000000000000000000000000000010000001L;
    private long black_knight = 0b0000000000000000000000000000000000000000000000000000000001000010L;

    public long getBlack_pawn() {
        return black_pawn;
    }

    public void setBlack_pawn(long black_pawn) {
        this.black_pawn = black_pawn;
    }

    public long getBlack_rook() {
        return black_rook;
    }

    public void setBlack_rook(long black_rook) {
        this.black_rook = black_rook;
    }

    public long getBlack_knight() {
        return black_knight;
    }

    public void setBlack_knight(long black_knight) {
        this.black_knight = black_knight;
    }

    public long getBlack_bishop() {
        return black_bishop;
    }

    public void setBlack_bishop(long black_bishop) {
        this.black_bishop = black_bishop;
    }

    public long getBlack_queen() {
        return black_queen;
    }

    public void setBlack_queen(long black_queen) {
        this.black_queen = black_queen;
    }

    public long getBlack_king() {
        return black_king;
    }

    public void setBlack_king(long black_king) {
        this.black_king = black_king;
    }

    public long getWhite_pawn() {
        return white_pawn;
    }

    public void setWhite_pawn(long white_pawn) {
        this.white_pawn = white_pawn;
    }

    public long getWhite_rook() {
        return white_rook;
    }

    public void setWhite_rook(long white_rook) {
        this.white_rook = white_rook;
    }

    public long getWhite_knight() {
        return white_knight;
    }

    public void setWhite_knight(long white_knight) {
        this.white_knight = white_knight;
    }

    public long getWhite_bishop() {
        return white_bishop;
    }

    public void setWhite_bishop(long white_bishop) {
        this.white_bishop = white_bishop;
    }

    public long getWhite_queen() {
        return white_queen;
    }

    public void setWhite_queen(long white_queen) {
        this.white_queen = white_queen;
    }

    public long getWhite_king() {
        return white_king;
    }

    public void setWhite_king(long white_king) {
        this.white_king = white_king;
    }

    private long black_bishop = 0b00100100L;
    private long black_queen = 0b00001000L;
    private long black_king = 0b00010000L;

    private long white_pawn = 0b11111111000000000000000000000000000000000000000000000000L;
    private long white_rook = 0b1000000100000000000000000000000000000000000000000000000000000000L;
    private long white_knight = 0b0100001000000000000000000000000000000000000000000000000000000000L;
    private long white_bishop = 0b0010010000000000000000000000000000000000000000000000000000000000L;
    private long white_queen = 0b0000100000000000000000000000000000000000000000000000000000000000L;
    private long white_king = 0b1000000000000000000000000000000000000000000000000000000000000L;


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
}
