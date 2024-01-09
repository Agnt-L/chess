public class Board {
    private Piece[][] board;

    public Board() {
        this.board = new Piece[8][8];
        initializeBoard();
    }

    public void addPiece(Piece piece, Coordinate coordinate){
        this.board[coordinate.getRank()][coordinate.getFile()] = piece;
        piece.setPosition(coordinate);
    }

    private void initializeBoard() {
        // Pawns
        for (int file = 0; file < 8; file++) {
            addPiece(new Pawn(0), new Coordinate(1, file));
            addPiece(new Pawn(1), new Coordinate(6, file));
            //board[1][file] = new Pawn(0); // White pawns
            //board[6][file] = new Pawn(1); // Black pawns
        }
        // Knights
        addPiece(new Knight(0), new Coordinate(0, 1)); // White knights
        addPiece(new Knight(0), new Coordinate(0, 6));

        addPiece(new Knight(1), new Coordinate(7, 1)); // Black knights
        addPiece(new Knight(1), new Coordinate(7, 6));

        // Rooks
        addPiece(new Rook(0), new Coordinate(0, 0)); // White rooks
        addPiece(new Rook(0), new Coordinate(0, 7));

        addPiece(new Rook(1), new Coordinate(7, 0)); // Black rooks
        addPiece(new Rook(1), new Coordinate(7, 7));
/*
        // Bishops
        addPiece(new Bishop(0), new Coordinate(0, 2)); // White bishops
        addPiece(new Bishop(0), new Coordinate(0, 5));

        addPiece(new Bishop(1), new Coordinate(7, 2)); // Black bishops
        addPiece(new Bishop(1), new Coordinate(7, 5));

        // Queens
        addPiece(new Queen(0), new Coordinate(0, 3)); // White queen
        addPiece(new Queen(1), new Coordinate(7, 3)); // Black queen

        // Kings
        addPiece(new King(0), new Coordinate(0, 4)); // White king
        addPiece(new King(1), new Coordinate(7, 4)); // Black king
 */
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
        for (int file = 0; file < 8; file++) {
            for (int rank = 0; rank < 8; rank++) {
                if (board[file][rank] != null) {
                    System.out.print(board[file][rank].getFen() + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void movePiece(Coordinate from, Coordinate to) {
        Piece pieceToMove = board[from.getRank()][from.getFile()];

        if (pieceToMove == null) {
            System.out.println("No piece to move at the specified position.");
            return;
        }

        if (!pieceToMove.isValidMove(from, to)) {
            System.out.println("Invalid move for the selected piece.");
            return;
        }

        board[to.getRank()][to.getFile()] = pieceToMove;
        board[from.getRank()][from.getFile()] = null;

        System.out.println("Piece moved successfully.");
    }

    public Piece getPieceAt(Coordinate coordinate) {
        return this.board[coordinate.getFile()][coordinate.getRank()];
    }
}
