import java.math.BigInteger;
public class BitboardGame {
    public static void main(String[] args) {
        Bitboards rookBitboard = Bitboards.getInstance();
        System.out.println("here");
        System.out.println(Double.toHexString(Math.pow(2,64)));
        BigInteger two = new BigInteger("2");
        BigInteger univSet = two.pow(64).subtract(BigInteger.valueOf(1));
        System.out.println(two.pow(64).subtract(BigInteger.valueOf(1)).bitLength());
        System.out.println(univSet.toString(2));
        printBitboard(univSet);
    }

    public static void printBitboard(Long bitboard) {
        int bitboardLen = Long.toBinaryString(bitboard).length();
        int zeroLines = (64-bitboardLen) / 8;
        int zeros = (64-bitboardLen) % 8;

        for (int i = 0; i < zeroLines; i++) {
            System.out.println("0 0 0 0 0 0 0 0");
        }

        for (int i = 0; i < zeros; i++) {
            System.out.print("0 ");
        }

        String bitString = Long.toBinaryString(bitboard);
        for (int i = 0; i < bitString.length(); i++) {
            if (i % 8 == 0 & i>0) System.out.println();
            System.out.print(bitString.charAt(i) + " ");
        }
        System.out.println();
        System.out.println();
    }

    public static void printBitboard(BigInteger bitboard) {
        int bitboardLen = bitboard.bitLength();
        int zeroLines = (64-bitboardLen) / 8;
        int zeros = (64-bitboardLen) % 8;

        for (int i = 0; i < zeroLines; i++) {
            System.out.println("0 0 0 0 0 0 0 0");
        }

        for (int i = 0; i < zeros; i++) {
            System.out.print("0 ");
        }

        String bitString = bitboard.toString(2);
        for (int i = 0; i < bitString.length(); i++) {
            if (i % 8 == 0 & i>0) System.out.println();
            System.out.print(bitString.charAt(i) + " ");
        }
        System.out.println();
        System.out.println();
    }
}
