import java.util.List;

public class Board {
    private Piece[][] board;

    public List<Coordinate> getNextMoves() {
        return nextMoves;
    }

    private List<Coordinate> nextMoves;

    public Board() {
        this.board = new Piece[8][8];
        initializeBoard();
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
            setPieceAt(new Pawn(0), new Coordinate(1, file));
            setPieceAt(new Pawn(1), new Coordinate(6, file));
            //board[1][file] = new Pawn(0); // White pawns
            //board[6][file] = new Pawn(1); // Black pawns
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

        /*
        // Knights
        board[0][1] = new Knight(0); // White knights
        board[0][6] = new Knight(0);

        board[7][1] = new Knight(1); // Black knights
        board[7][6] = new Knight(1);

        // Rooks
        board[0][0] = new Rook(0); // White rooks
        board[0][7] = new Rook(0);

        board[7][0] = new Rook(1); // Black rooks
        board[7][7] = new Rook(1);

        // Bishops
        board[0][2] = new Bishop(0); // White bishops
        board[0][5] = new Bishop(0);

        board[7][2] = new Bishop(1); // Black bishops
        board[7][5] = new Bishop(1);

        // Queens
        board[0][3] = new Queen(0); // White queen
        board[7][3] = new Queen(1); // Black queen

        // Kings
        board[0][4] = new King(0); // White king
        board[7][4] = new King(1); // Black king
         */
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
        Piece pieceToMove = this.getPieceAt(from);

        if (pieceToMove == null) {
            System.out.println("No piece to move at the specified position.");
            return;
        }

        if (!pieceToMove.isValidMove(from, to)) {
            System.out.println("Invalid move for the selected piece.");
            return;
        }
        this.setPieceAt(pieceToMove, to);
        this.setPieceAt(null, from);

        System.out.println("Piece moved successfully.");
    }

    public void generateMoves(Piece selectedPiece) {
        this.nextMoves = selectedPiece.generateNextMoves();
        Bitboards bitboards = Bitboards.getInstance();
        BitboardGame.printBitboard(bitboards.coordListToBitboard(this.nextMoves));
    }

    public Piece getPieceAt(Coordinate coordinate) {
        Piece piece = this.board[coordinate.getRank()][coordinate.getFile()];
        return piece;
    }
}
