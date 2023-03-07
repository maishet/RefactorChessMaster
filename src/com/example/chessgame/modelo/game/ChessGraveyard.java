package com.example.chessgame.modelo.game;
import java.awt.GridLayout;
import javax.swing.*;

public class ChessGraveyard extends JPanel{
    private String title;
    // ----------------------------------------------------------
    /**
     * Create a new ChessGraveyard object.
     *
     * @param title
     *            the title of the graveyard
     */
    public ChessGraveyard( String title ){
        this.title = title;
        this.add( new JLabel( title ) );
        this.setLayout( new GridLayout( 8, 0 ) );
    }
    // ----------------------------------------------------------
    /**
     * Adds a piece to the graveyard.
     *
     * @param piece
     *            the GamePiece to add
     */
    public void addPiece( ChessGamePiece piece ){
        piece.setPieceLocation( -1, -1 );
        JLabel pieceLabel = new JLabel();
        pieceLabel.setIcon( piece.getImage() );
        this.add( pieceLabel );
    }
    // ----------------------------------------------------------
    /**
     * Removes all pieces from the graveyard.
     */
    public void clearGraveyard(){
        this.removeAll();
        this.add( new JLabel( title ) );
    }
}

