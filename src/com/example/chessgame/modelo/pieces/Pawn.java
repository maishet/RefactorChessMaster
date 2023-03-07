package com.example.chessgame.modelo.pieces;
import com.example.chessgame.modelo.board.ChessGameBoard;
import com.example.chessgame.modelo.game.ChessGamePiece;

import javax.swing.ImageIcon;
import java.util.ArrayList;

public class Pawn extends ChessGamePiece{
    private boolean notMoved;
    // ----------------------------------------------------------
    /**
     * Create a new Pawn object.
     *
     * @param board
     *            the board to create the pawn on
     * @param row
     *            row of the pawn
     * @param col
     *            column of the pawn
     * @param color
     *            either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public Pawn(ChessGameBoard board, int row, int col, int color ){
        super( board, row, col, color, true );
        notMoved = true;
        possibleMoves = calculatePossibleMoves( board );
    }
    /**
     * Moves this pawn to a row and col
     *
     * @param board
     *            the board to move on
     * @param row
     *            the row to move to
     * @param col
     *            the col to move to
     * @return boolean true if the move was successful, false otherwise
     */
    @Override
    public boolean move( ChessGameBoard board, int row, int col ){
        if ( super.move( board, row, col ) ){
            notMoved = false;
            possibleMoves = calculatePossibleMoves( board );
            if ( ( getColorOfPiece() == ChessGamePiece.BLACK && row == 7 )
                    || ( getColorOfPiece() == ChessGamePiece.WHITE && row == 0 ) ){ // pawn has reached the end of the board, promote it to queen
                board.getCell( row, col ).setPieceOnSquare( new Queen(
                        board,
                        row,
                        col,
                        getColorOfPiece() ) );
            }
            return true;
        }
        return false;
    }
    /**
     * Calculates the possible moves for this piece. These are ALL the possible
     * moves, including illegal (but at the same time valid) moves.
     *
     * @param board
     *            the game board to calculate moves on
     * @return ArrayList<String> the moves
     */
    @Override
    protected ArrayList<String> calculatePossibleMoves( ChessGameBoard board ){
        ArrayList<String> moves = new ArrayList<>();
        if (isPieceOnScreen()) {
            int currRow = getColorOfPiece() == ChessGamePiece.WHITE ? (pieceRow - 1) : (pieceRow + 1);
            int maxIter = notMoved ? 2 : 1;

            // check for normal moves
            for (int i = 0; i < maxIter; i++) {
                if (isOnScreen(currRow, pieceColumn) && board.getCell(currRow, pieceColumn).getPieceOnSquare() == null) {
                    moves.add(currRow + "," + pieceColumn);
                } else {
                    break;
                }
                currRow += getColorOfPiece() == ChessGamePiece.WHITE ? -1 : 1;
            }

            // check for enemy capture points
            int enemyRow = getColorOfPiece() == ChessGamePiece.WHITE ? (pieceRow - 1) : (pieceRow + 1);
            int leftCol = pieceColumn - 1;
            int rightCol = pieceColumn + 1;
            if (isEnemy(board, enemyRow, leftCol)) {
                moves.add(enemyRow + "," + leftCol);
            }
            if (isEnemy(board, enemyRow, rightCol)) {
                moves.add(enemyRow + "," + rightCol);
            }
        }
        return moves;
    }
    /**
     * Creates an icon for this piece depending on the piece's color.
     *
     * @return ImageIcon the ImageIcon representation of this piece.
     */
    @Override
    public ImageIcon createImageByPieceType(){
        if ( getColorOfPiece() == ChessGamePiece.WHITE ){
            return new ImageIcon(
                    getClass().getResource("../../ChessImages/WhitePawn.gif")
            );
        }
        else if ( getColorOfPiece() == ChessGamePiece.BLACK ){
            return new ImageIcon(
                    getClass().getResource("../../ChessImages/BlackPawn.gif")
            );
        }
        else
        {
            return new ImageIcon(
                    getClass().getResource("../../ChessImages/default-Unassigned.gif")
            );
        }
    }
}
