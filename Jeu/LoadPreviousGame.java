import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

/**
	*Charge une ancienne partie
	*Classe modificatrice de la classe Game 
	*@author MANICOME_ROCHER
*/
public class LoadPreviousGame{
	private Game jeu;

	public LoadPreviousGame(Game g) {
		super();
		this.jeu = g;
		this.jeu.newgame = false;
		Loading();
	}

	/**
		*Charge les donnees sauvegardees
	*/
	public void Loading() {
		try {
			FileInputStream file = new FileInputStream("Sauvegarde.bin");
	        DataInputStream flux = new DataInputStream(file);
			
			try {
				this.jeu.nb_ligne = flux.readInt();
				this.jeu.nb_colonne = flux.readInt();
				this.jeu.nb_bombe = flux.readInt();

				this.jeu.uncovered_cases = new boolean[this.jeu.nb_ligne][this.jeu.nb_colonne];
				this.jeu.text = new char[this.jeu.nb_ligne][this.jeu.nb_colonne];
				this.jeu.grille = new int[this.jeu.nb_ligne][this.jeu.nb_colonne];

				for (int i=0; i<this.jeu.nb_ligne; i++) {
					for (int j=0; j<this.jeu.nb_colonne; j++) {
						this.jeu.uncovered_cases[i][j] = flux.readBoolean();
						this.jeu.text[i][j] =(char) flux.readChar();
						this.jeu.grille[i][j] =(int) flux.readInt();
					}
				}
				
			} catch(IOException e) {
				System.err.println("Read Error");
			}

			try {
				flux.close();
			} catch(IOException e) {
				System.err.println("Close Error");
			}

		} catch(FileNotFoundException f) {
			System.err.println("FileNotFound");
		}

		this.jeu.reste.setText("Reste: "+Integer.toString(this.jeu.nb_bombe));
		GridLayout gestionnaire = new GridLayout(this.jeu.nb_ligne, this.jeu.nb_colonne);
		this.jeu.setLayout(gestionnaire);

		Creer_Terrain(this.jeu.nb_ligne, this.jeu.nb_colonne);
	}


	/**
		*Cree le terrain de jeu avec les composants Cases
	*/
	public void Creer_Terrain(int nb_ligne, int nb_colonne) {
		int u=0, v=0;
		this.jeu.terrain = new Case[this.jeu.nb_ligne][this.jeu.nb_colonne];
		for(int i=0;i<this.jeu.nb_ligne;i++){
			for(int j=0;j<this.jeu.nb_colonne;j++){		
				this.jeu.terrain[i][j] = new Case(this.jeu, i, j);
				this.jeu.add(this.jeu.terrain[i][j]);
			}
		}
	}
}