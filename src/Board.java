import java.util.List;

public class Board{
    private final Piece[][] board;
    private int player;

    public List<Coordinate> getNextMoves() {
        return nextMoves;
    }

    private List<Coordinate> nextMoves;
    private Bitboards bitboards;

    public Board() {
        this.board = new Piece[8][8];
        initializeBoard();
        this.bitboards = Bitboards.getInstance();
    }

    public void setPieceAt(Piece piece, Coordinate coordinate){
        this.board[coordinate.getRank()][coordinate.getFile()] = piece;
        if (piece != null) {
            piece.setPosition(coordinate);
        }
    }

    private void initializeBoard() {
        // Pawns
        for (int file = 0; file < 8; file++) {
            setPieceAt(new Pawn(0), new Coordinate(1, file)); // White pawns
            setPieceAt(new Pawn(1), new Coordinate(6, file)); // Black pawns
        }
        // Knights
        setPieceAt(new Knight(0), new Coordinate(0, 1)); // White knights
        setPieceAt(new Knight(0), new Coordinate(0, 6));

        setPieceAt(new Knight(1), new Coordinate(7, 1)); // Black knights
        setPieceAt(new Knight(1), new Coordinate(7, 6));

        // Rooks
        setPieceAt(new Rook(0), new Coordinate(0, 0)); // White rooks
        setPieceAt(new Rook(0), new Coordinate(0, 7));

        setPieceAt(new Rook(1), new Coordinate(7, 0)); // Black rooks
        setPieceAt(new Rook(1), new Coordinate(7, 7));

        // Bishops
        setPieceAt(new Bishop(0), new Coordinate(0, 2)); // White bishops
        setPieceAt(new Bishop(0), new Coordinate(0, 5));

        setPieceAt(new Bishop(1), new Coordinate(7, 2)); // Black bishops
        setPieceAt(new Bishop(1), new Coordinate(7, 5));

        // Queens
        setPieceAt(new Queen(0), new Coordinate(0, 3)); // White queen
        setPieceAt(new Queen(1), new Coordinate(7, 3)); // Black queen

        // Kings
        setPieceAt(new King(0), new Coordinate(0, 4)); // White king
        setPieceAt(new King(1), new Coordinate(7, 4)); // Black king
    }

    public void displayBoard() {
        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                if (this.getPieceAt(new Coordinate(rank, file)) != null) {
                    System.out.print(this.getPieceAt(new Coordinate(rank, file)).getFen() + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void movePiece(Coordinate from, Coordinate to) {
        System.out.println("Player " + this.player + " made the last turn.");
        Piece pieceToMove = this.getPieceAt(from);

        this.setPieceAt(pieceToMove, to);
        this.setPieceAt(null, from);
        this.bitboards.movePiece(pieceToMove, to);

        this.player = 1 + this.player * (-1);
    }

    public boolean isValidMove(Coordinate from, Coordinate to) {
        Piece pieceToMove = this.getPieceAt(from);
        if (pieceToMove == null || this.player != pieceToMove.getColor()) {
            return false;
        } else {
            return pieceToMove.isValidMove(from, to);
        }
    }

    public void generateMoves(Piece selectedPiece) {
        this.nextMoves = selectedPiece.generateNextMoves();
        Bitboards bitboards = Bitboards.getInstance();
        bitboards.printBitboard(bitboards.coordListToBitboard(this.nextMoves));
    }

    public Piece getPieceAt(Coordinate coordinate) {
        return this.board[coordinate.getRank()][coordinate.getFile()];
    }
}
