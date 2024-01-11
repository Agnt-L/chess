import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
       /* Board board = new Board();
        board.displayBoard();
        Rook rook = new Rook(0);
        rook.setPosition(new Coordinate(0, 0));
        rook.generateNextMoves();
        BigInteger test = new BigInteger("1000", 2);
        test = test.setBit(4);
        System.out.println(test.toString());*/
        Board board = new Board();
        board.displayBoard();
        Queen queen = new Queen(0);
        queen.setPosition(new Coordinate(3, 4));
        queen.generateNextMoves();
    }
}
