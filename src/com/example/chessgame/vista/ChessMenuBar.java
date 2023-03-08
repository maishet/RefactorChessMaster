package com.example.chessgame.vista;
import java.awt.Component;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class ChessMenuBar extends JMenuBar {
    private List<MenuObserver> observers = new ArrayList<>();

    public ChessMenuBar() {
        String[] menuCategories = { "File", "Options", "Help" };
        String[] menuItemLists = { "New game/restart,Exit", "Toggle graveyard,Toggle game log", "About" };
        for (int i = 0; i < menuCategories.length; i++) {
            JMenu currMenu = new JMenu(menuCategories[i]);
            String[] currMenuItemList = menuItemLists[i].split(",");
            for (int j = 0; j < currMenuItemList.length; j++) {
                JMenuItem currItem = new JMenuItem(currMenuItemList[j]);
                currItem.addActionListener(event -> notifyObservers(currItem.getText()));
                currMenu.add(currItem);
            }
            this.add(currMenu);
        }
    }

    public void addObserver(MenuObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(MenuObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String buttonName) {
        for (MenuObserver observer : observers) {
            observer.menuItemClicked(buttonName);
        }
    }

    public interface MenuObserver {
        void menuItemClicked(String buttonName);
    }

    public class ChessMenuHandler implements MenuObserver {

        @Override
        public void menuItemClicked(String buttonName) {
            if (buttonName.equals("About")) {
                aboutHandler();
            } else if (buttonName.equals("New game/restart")) {
                restartHandler();
            } else if (buttonName.equals("Toggle game log")) {
                toggleGameLogHandler();
            } else if (buttonName.equals("Exit")) {
                exitHandler();
            } else {
                toggleGraveyardHandler();
            }
        }

    }
    public void aboutHandler(){
        JOptionPane.showMessageDialog(
                this.getParent(),
                "YetAnotherChessGame v1.0 by:\nBen Katz\nMyles David\n"
                        + "Danielle Bushrow\n\nFinal Project for CS2114 @ VT" );
    }
    public void restartHandler(){
        ( (ChessPanel)this.getParent() ).getGameEngine().reset();
    }
    public void exitHandler(){
        JOptionPane.showMessageDialog( this.getParent(), "Thanks for leaving"
                + ", quitter! >:(" );
        Component possibleFrame = this;
        while ( possibleFrame != null && !( possibleFrame instanceof JFrame ) ){
            possibleFrame = possibleFrame.getParent();
        }
        JFrame frame = (JFrame)possibleFrame;
        assert frame != null;
        frame.setVisible( false );
        frame.dispose();
    }
    public void toggleGraveyardHandler(){
        ( (ChessPanel)this.getParent() ).getGraveyard( 1 ).setVisible(
                !( (ChessPanel)this.getParent() ).getGraveyard( 1 ).isVisible() );
        ( (ChessPanel)this.getParent() ).getGraveyard( 2 ).setVisible(
                !( (ChessPanel)this.getParent() ).getGraveyard( 2 ).isVisible() );
    }
    /**
     * Takes an appropriate action if the toggle game log button is clicked.
     */
    public void toggleGameLogHandler(){
        ( (ChessPanel)this.getParent() ).getGameLog().setVisible(
                !( (ChessPanel)this.getParent() ).getGameLog().isVisible() );
        ( (ChessPanel)this.getParent() ).revalidate();
    }
}

