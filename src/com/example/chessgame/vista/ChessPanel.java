package com.example.chessgame.vista;
import com.example.chessgame.controlador.ChessGameLog;
import com.example.chessgame.modelo.board.ChessGameBoard;
import com.example.chessgame.modelo.game.ChessGameEngine;
import com.example.chessgame.modelo.game.ChessGraveyard;

import java.awt.*;
import javax.swing.*;

public class ChessPanel extends JPanel{
    private ChessMenuBar    menuBar;
    private ChessGameBoard gameBoard;
    private ChessGameLog gameLog;
    private ChessGraveyard playerOneGraveyard;
    private ChessGraveyard  playerTwoGraveyard;
    private ChessGameEngine gameEngine;
    // ----------------------------------------------------------
    /**
     * Create a new ChessPanel object.
     */
    public ChessPanel(){
        this.setLayout( new BorderLayout() );
        menuBar = new ChessMenuBar();
        gameBoard = new ChessGameBoard();
        gameLog = new ChessGameLog();
        playerOneGraveyard = new ChessGraveyard( "Player 1's graveyard" );
        playerTwoGraveyard = new ChessGraveyard( "Player 2's graveyard" );
        this.add( menuBar, BorderLayout.NORTH );
        this.add( gameBoard, BorderLayout.CENTER );
        this.add( gameLog, BorderLayout.SOUTH );
        this.add( playerOneGraveyard, BorderLayout.WEST );
        this.add( playerTwoGraveyard, BorderLayout.EAST );
        this.setPreferredSize( new Dimension( 800, 600 ) );
        gameEngine = new ChessGameEngine( gameBoard ); // start the game
    }
    // ----------------------------------------------------------
    /**
     * Gets the logger object for use in other classes.
     *
     * @return Pieces.ChessGameLog the Pieces.ChessGameLog object
     */
    public ChessGameLog getGameLog(){
        return gameLog;
    }
    // ----------------------------------------------------------
    /**
     * Gets the board object for use in other classes.
     *
     * @return ChessGameBoard the ChessGameBoard object
     */
    public ChessGameBoard getGameBoard(){
        return gameBoard;
    }
    // ----------------------------------------------------------
    /**
     * Gets the game engine object for use in other classes
     *
     * @return ChessGameEngine the ChessGameEngine object
     */
    public ChessGameEngine getGameEngine(){
        return gameEngine;
    }
    // ----------------------------------------------------------
    /**
     * Gets the appropriate graveyard object for use in other classes.
     *
     * @param whichPlayer
     *            the number of the player (1 or 2)
     * @return ChessGraveyard the graveyard requested
     */
    public ChessGraveyard getGraveyard( int whichPlayer ){
        if ( whichPlayer == 1 ){
            return playerOneGraveyard;
        }
        else if ( whichPlayer == 2 ){
            return playerTwoGraveyard;
        }
        else
        {
            return null;
        }
    }
}