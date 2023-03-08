package com.example.chessgame.vista;
import javax.swing.*;

public class ChessMain{
    public static void main( String[] args ){
        JFrame frame = new JFrame( "YetAnotherChessGame 1.0" );
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE );
        frame.getContentPane().add( ChessPanel.getInstance() );
        frame.pack();
        frame.setVisible( true );
    }
}
