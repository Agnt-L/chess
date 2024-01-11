import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.List;

public class ChessBoardGUI extends JFrame {
    private static final int SQUARE_SIZE = 80;
    private static final int ICON_SIZE = (int) (0.85 * SQUARE_SIZE);
    private CircleButton[][] boardButtons;
    private Board chessBoard;

    private Coordinate firstClickedCoord;

    public ChessBoardGUI(Board chessBoard) {
        super("Chess Board");
        this.chessBoard = chessBoard;
        initializeGUI();
    }

    private void initializeGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 8));
        boardButtons = new CircleButton[8][8];

        for (int file = 0; file < 8; file++) {
            for (int rank = 0; rank < 8; rank++) {
                CircleButton button = new CircleButton();
                button.setPreferredSize(new Dimension(SQUARE_SIZE, SQUARE_SIZE));
                if ((file + rank) % 2 == 1) button.setBackground(Color.gray);
                button.addActionListener(new ChessButtonListener(file, rank));
                boardButtons[rank][file] = button;
                add(button);
            }
        }

        updateBoardUI();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateBoardUI() {
        for (int file = 0; file < 8; file++) {
            for (int rank = 0; rank < 8; rank++) {
                Piece piece = chessBoard.getPieceAt(new Coordinate(file, rank));
                if (piece != null) {
                    boardButtons[file][rank].setIcon(getPieceIcon(piece));
                } else {
                    boardButtons[file][rank].setIcon(null);
                }
            }
        }
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

    public Coordinate getButtonCoordinate(JButton clickedButton) {
        return null;
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
            if (firstClickedCoord == null) {
                firstClickedCoord = new Coordinate(rank, file);
                Piece selectedPiece = chessBoard.getPieceAt(new Coordinate(rank, file));
                chessBoard.generateMoves(selectedPiece);
                List<Coordinate> nextCoords = chessBoard.getNextMoves();
                for (Coordinate coord: nextCoords) {
                    boardButtons[coord.getFile()][coord.getRank()].setClicked(true);
                }

            } else {
                chessBoard.movePiece(firstClickedCoord, new Coordinate(rank, file));
                chessBoard.displayBoard();
                updateBoardUI();
                firstClickedCoord = null;
            }

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Board chessBoard = new Board();  // You need to have a Board instance
            new ChessBoardGUI(chessBoard);
        });
    }
}
