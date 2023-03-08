package com.example.chessgame.modelo.game;

import com.example.chessgame.modelo.board.ChessGameBoard;
import com.example.chessgame.modelo.pieces.Knight;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ChessGamePieceTest {

    @Test
    void calculatePossibleMoves() {
        ChessGameBoard board = new ChessGameBoard();
        Knight knight = new Knight(board, 5, 2, ChessGamePiece.WHITE);
        ArrayList<String> expectMoves = new ArrayList<>();
        expectMoves.add("3,3");
        expectMoves.add("3,1");
        expectMoves.add("4,4");
        expectMoves.add("4,0");
        assertEquals(expectMoves, knight.calculatePossibleMoves(board));
    }

    @Test
    void calculateSouthMoves() {
        ChessGameBoard board = new ChessGameBoard();
        Knight knight = new Knight(board, 3, 2, ChessGamePiece.BLACK);
        ArrayList<String> expectMoves = new ArrayList<>();
        expectMoves.add("4,4");
        expectMoves.add("4,0");
        expectMoves.add("2,4");
        expectMoves.add("2,0");
        assertEquals(expectMoves, knight.calculateSouthMoves(board));
    }

    @Test
    void calculateNorthMoves() {
        ChessGameBoard board = new ChessGameBoard();
        Knight knight = new Knight(board, 7, 1, ChessGamePiece.WHITE);
        ArrayList<String> expectMoves = new ArrayList<>();
        expectMoves.add("5,2");
        expectMoves.add("5,0");
        assertEquals(expectMoves, knight.calculateNorthMoves(board));
    }

    @Test
    void calculateEastMoves() {
        ChessGameBoard board = new ChessGameBoard();
        Knight knight = new Knight(board, 8, 1, ChessGamePiece.BLACK);
        ArrayList<String> expectMoves = new ArrayList<>();
        assertEquals(expectMoves, knight.calculateEastMoves(board,3));
    }

    @Test
    void calculateWestMoves() {
        ChessGameBoard board = new ChessGameBoard();
        Knight knight = new Knight(board, 7, 1, ChessGamePiece.WHITE);
        ArrayList<String> expectMoves = new ArrayList<>();
        assertEquals(expectMoves, knight.calculateWestMoves(board,2));
    }

    @Test
    void calculateNorthWestMoves() {
        ChessGameBoard board = new ChessGameBoard();
        Knight knight = new Knight(board, 7, 1, ChessGamePiece.BLACK);
        ArrayList<String> expectMoves = new ArrayList<>();
        expectMoves.add("6,0");
        assertEquals(expectMoves, knight.calculateNorthWestMoves(board,3));
    }

    @Test
    void calculateNorthEastMoves() {
        ChessGameBoard board = new ChessGameBoard();
        Knight knight = new Knight(board, 7, 1, ChessGamePiece.WHITE);
        ArrayList<String> expectMoves = new ArrayList<>();
        assertEquals(expectMoves, knight.calculateNorthEastMoves(board,2));
    }

    @Test
    void calculateSouthWestMoves() {
        ChessGameBoard board = new ChessGameBoard();
        Knight knight = new Knight(board, 7, 1, ChessGamePiece.BLACK);
        ArrayList<String> expectMoves = new ArrayList<>();
        assertEquals(expectMoves, knight.calculateSouthWestMoves(board,3));
    }

    @Test
    void calculateSouthEastMoves() {
        ChessGameBoard board = new ChessGameBoard();
        Knight knight = new Knight(board, 7, 1, ChessGamePiece.WHITE);
        ArrayList<String> expectMoves = new ArrayList<>();
        assertEquals(expectMoves, knight.calculateSouthEastMoves(board,2));
    }
}