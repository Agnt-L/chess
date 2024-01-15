import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ChessBoardGUI extends JFrame {
    private static final int SQUARE_SIZE = 80;
    private static final int ICON_SIZE = (int) (0.85 * SQUARE_SIZE);
    private CircleButton[][] boardButtons;
    private final Board chessBoard;

    private Coordinate firstClickedCoord;
    private Piece selectedPiece;

    public ChessBoardGUI(Board chessBoard) {
        super("Chess Board");
        this.chessBoard = chessBoard;
        initializeGUI();
    }

    public CircleButton getButtonAt(Coordinate coordinate) {
        return this.boardButtons[coordinate.getRank()][coordinate.getFile()];
    }

    public void setButtonAt(Coordinate coordinate, CircleButton button) {
        this.boardButtons[coordinate.getRank()][coordinate.getFile()] = button;
    }

    private void initializeGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 8));
        boardButtons = new CircleButton[8][8];

        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                CircleButton button = new CircleButton();
                button.setPreferredSize(new Dimension(SQUARE_SIZE, SQUARE_SIZE));
                if ((file + rank) % 2 == 1) button.setBackground(Color.GRAY);
                button.addActionListener(new ChessButtonListener(rank, file));
                this.setButtonAt(new Coordinate(rank, file), button);
                add(button);
            }
        }

        updateBoardUI();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateBoardUI() {
        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                Coordinate coordinate = new Coordinate(rank, file);
                Piece piece = chessBoard.getPieceAt(coordinate);
                if (piece != null) {
                    this.getButtonAt(coordinate).setIcon(getPieceIcon(piece));
                } else {
                    this.getButtonAt(coordinate).setIcon(null);
                }
            }
        }
        chessBoard.displayBoard();
    }

    private ImageIcon getPieceIcon(Piece piece) {
        String pieceType = piece.getClass().getSimpleName().toLowerCase();
        String color = (piece.getColor() == 0) ? "white" : "black";
        String fileName = color + "_" + pieceType + ".png";

        String filePath = "images/" + fileName;
        System.out.println(filePath);

        Image img = new ImageIcon(getClass().getResource(filePath)).getImage();
        Image newImg = img.getScaledInstance(ICON_SIZE, ICON_SIZE, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newImg);

        return icon;
    }

    private class ChessButtonListener implements ActionListener {
        private int rank;
        private int file;

        public ChessButtonListener(int rank, int file) {
            this.rank = rank;
            this.file = file;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle button click event (e.g., move a piece)
            // You might want to implement additional logic here based on your game requirements
            // For simplicity, this example just prints the clicked coordinates
            System.out.println("Clicked: " + rank + ", " + file);
            Coordinate clickedCoord = new Coordinate(rank, file);
            if (chessBoard.getNextMoves() != null) {
                for (Coordinate coord: chessBoard.getNextMoves()) {
                    boardButtons[coord.getRank()][coord.getFile()].setClicked(false);
                }
            }
            if (chessBoard.getPieceAt(clickedCoord) != null) {
                firstClickedCoord = clickedCoord;
                selectedPiece = chessBoard.getPieceAt(clickedCoord);
                chessBoard.generateMoves(selectedPiece);
                List<Coordinate> nextCoords = chessBoard.getNextMoves();
                for (Coordinate coord: nextCoords) {
                    boardButtons[coord.getRank()][coord.getFile()].setClicked(true);
                }
            } else {
                chessBoard.movePiece(firstClickedCoord, clickedCoord);
                chessBoard.displayBoard();
                updateButton(getButtonAt(firstClickedCoord), null);
                updateButton(getButtonAt(clickedCoord), selectedPiece);
                //updateBoardUI();
            }



        }
    }
    public void updateButton(CircleButton button, Piece piece) {
        if (piece != null) {
            button.setIcon(getPieceIcon(piece));
        } else {
            button.setIcon(null);
        }
    }


    private class ChessBoardListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("ACTION!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Board chessBoard = new Board();  // You need to have a Board instance
            new ChessBoardGUI(chessBoard);
        });
    }
}
