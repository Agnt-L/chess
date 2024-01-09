public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Board board = new Board();
        board.displayBoard();
        Rook rook = new Rook(0);
        rook.setPosition(new Coordinate(0, 0));
        rook.generateNextMoves();
    }
}
