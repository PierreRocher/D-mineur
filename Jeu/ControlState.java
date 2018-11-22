import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

/**
    *Controle l'etat de la fenetre, 
    *Sauvegarde l'etat de la partie en cas de fermeture
    *@author MANICOME_ROCHER
*/
public class ControlState implements WindowListener {
    private Game jeu;

    public ControlState(Game g) {
        this.jeu = g;
    }

    @Override
	public void windowClosing(WindowEvent evenement) {
        new Save(this.jeu);      
	}

    @Override
    public void windowActivated(WindowEvent evenement) {}

    @Override
    public void windowClosed(WindowEvent evenement){}

    @Override
    public void windowDeactivated(WindowEvent evenement){}

    @Override
    public void windowDeiconified(WindowEvent evenement){}

    @Override
    public void windowIconified(WindowEvent evenement){}

    @Override
    public void windowOpened(WindowEvent evenement){}

    
}