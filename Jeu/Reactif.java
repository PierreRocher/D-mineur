import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
	*ActionListener repondant a l'utilisation de chacun des boutons
	*@author MANICOME_ROCHER
*/
public class Reactif implements ActionListener {
	private Fenêtre frame;
	private Game jeu;

	/**
		*Parametre Fenetre
	*/
	public Reactif(Fenêtre fenetre) {
		super();
		this.frame = fenetre;
	}

	/**
		*Parametre Game
	*/
	public Reactif(Game g) {
		super();
		this.jeu = g;
	}

	/**
		*Detecte le bouton clique et reagit en consequance
	*/
	public void actionPerformed(ActionEvent e) {
		JButton b =(JButton) e.getSource();

		if (b.getActionCommand().equals("NewGame")) {
			this.frame.LaunchNewGame();

		} else if (b.getActionCommand().equals("LastGame")) {
			this.frame.LaunchPreviousGame();

		} else if (b.getActionCommand().equals("Save&Quit")) {
			new Save(this.jeu);

		} else if (b.getActionCommand().equals("PlayAgain?")) {
			String[] args=null;
			Main m = new Main();
			m.main(args);
			this.frame.dispose();
		} else {
			System.exit(0);
		}	
	}
}