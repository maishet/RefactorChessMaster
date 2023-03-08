package com.example.chessgame.modelo.board;

import com.example.chessgame.modelo.game.ChessGamePiece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

class BoardSquareTest {
    private ChessGamePiece piece;
    @Test
    void getRow() {
        BoardSquare boardSquare = new BoardSquare(0,0,piece);
        assertEquals(0, boardSquare.getRow());
    }

    @Test
    void getColumn() {
        BoardSquare boardSquare = new BoardSquare(0,0,piece);
        assertEquals(0, boardSquare.getColumn());
    }

    @Test
    void getPieceOnSquare() {
        BoardSquare boardSquare = new BoardSquare(0,0,piece);
        assertNull(boardSquare.getPieceOnSquare());
        boardSquare.setPieceOnSquare(piece);
        assertEquals(piece, boardSquare.getPieceOnSquare());
    }

    @Test
    void setPieceOnSquare() {
        BoardSquare boardSquare = new BoardSquare(0,0,piece);
        assertNull(boardSquare.getPieceOnSquare());
        boardSquare.setPieceOnSquare(piece);
        assertEquals(piece, boardSquare.getPieceOnSquare());
    }

    @Test
    void clearSquare() {
        BoardSquare boardSquare = new BoardSquare(0,0,piece);
        assertNull(boardSquare.getPieceOnSquare());
        boardSquare.setPieceOnSquare(piece);
        boardSquare.clearSquare();
        assertNull(boardSquare.getPieceOnSquare());
    }
}