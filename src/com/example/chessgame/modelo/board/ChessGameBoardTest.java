package com.example.chessgame.modelo.board;

import com.example.chessgame.modelo.game.ChessGamePiece;
import com.example.chessgame.modelo.pieces.Knight;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ChessGameBoardTest {

    @Test
    void getCells() {
        ChessGameBoard board = new ChessGameBoard();
        BoardSquare[][] expectedCells = new BoardSquare[2][2];
        expectedCells[0][0] = new BoardSquare(0, 0, null);
        expectedCells[0][1] = new BoardSquare(0, 1, null);
        expectedCells[1][0] = new BoardSquare(1, 0, null);
        expectedCells[1][1] = new BoardSquare(1, 1, null);
        board.setChessCells(expectedCells);

        BoardSquare[][] actualCells = board.getCells();

        assertArrayEquals(expectedCells, actualCells);
    }

    @Test
    void validateCoordinates() {
        ChessGameBoard board = new ChessGameBoard();
        BoardSquare[][] expectedCells = new BoardSquare[2][2];
        board.setChessCells(expectedCells);
        assertTrue(board.validateCoordinates(0, 0));
        assertTrue(board.validateCoordinates(0, 1));
        assertTrue(board.validateCoordinates(1, 0));
        assertTrue(board.validateCoordinates(1, 1));
    }

    @Test
    void getCell() {
        ChessGameBoard board = new ChessGameBoard();
        BoardSquare[][] cells = new BoardSquare[2][2];
        cells[0][0] = new BoardSquare(0, 0, null);
        cells[0][1] = new BoardSquare(0, 1, null);
        cells[1][0] = new BoardSquare(1, 0, null);
        cells[1][1] = new BoardSquare(1, 1, null);
        board.setChessCells(cells);
        assertEquals(cells[0][0], board.getCell(0, 0));
        assertEquals(cells[0][1], board.getCell(0, 1));
        assertEquals(cells[1][0], board.getCell(1, 0));
        assertEquals(cells[1][1], board.getCell(1, 1));
    }


    @Test
    void getAllWhitePieces() {
        ChessGameBoard board = new ChessGameBoard();
        BoardSquare[][] cells = new BoardSquare[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = new BoardSquare(i, j, null);
            }
        }
        board.setChessCells(cells);
        Knight knight = new Knight(board, 0, 0, ChessGamePiece.WHITE);
        cells[0][0].setPieceOnSquare(knight);

        ArrayList<ChessGamePiece> whitePieces = board.getAllWhitePieces();

        assertEquals(1, whitePieces.size());
        assertTrue(whitePieces.contains(knight));
    }

    @Test
    void getAllBlackPieces() {
        ChessGameBoard board = new ChessGameBoard();
        BoardSquare[][] cells = new BoardSquare[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = new BoardSquare(i, j, null);
            }
        }
        board.setChessCells(cells);
        Knight knight = new Knight(board, 0, 0, ChessGamePiece.BLACK);
        cells[0][0].setPieceOnSquare(knight);

        ArrayList<ChessGamePiece> blackPieces = board.getAllBlackPieces();

        assertEquals(1, blackPieces.size());
        assertTrue(blackPieces.contains(knight));
    }
}