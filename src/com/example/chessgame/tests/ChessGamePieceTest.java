package com.example.chessgame.tests;

import com.example.chessgame.modelo.board.ChessGameBoard;
import com.example.chessgame.modelo.game.ChessGamePiece;
import com.example.chessgame.modelo.pieces.Knight;

import java.util.ArrayList;

public class ChessGamePieceTest {

    public void testcalculatePossibleMoves(){
        ChessGameBoard board = new ChessGameBoard();
        Knight knight = new Knight(board, 3, 3, ChessGamePiece.WHITE);
        ArrayList<String> expectMoves = new ArrayList<>();
        expectMoves.add("5,2");
    }

    public void testcalculateNorthMoves(){
        ChessGameBoard board = new ChessGameBoard();
        Knight knight = new Knight(board, 7, 1, ChessGamePiece.BLACK);
        ArrayList<String> expectMoves = new ArrayList<>();
        expectMoves.add("5,0");
        expectMoves.add("5,2");
        expectMoves.add("6,3");

    }
}
