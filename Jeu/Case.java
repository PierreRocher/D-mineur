import java.awt.*;
import javax.swing.*;

/**
	*Definir les proprietes de la case
	*@author MANICOME ROCHER
*/
public class Case extends JLabel {
	boolean uncovered=false;
	private Game jeu;
	MouseController a;;
	int valeur, x, y, posx, posy, nb_bombe;
	Case[][] t;

	/**
	*Acces a partir d'une partie sauvegardee
	*/
	public Case(Game g, int i, int j) {
		super();
		this.jeu = g;
		a = new MouseController(g);

		t = this.jeu.terrain;
		x = t.length; //taille d'une ligne
		y = t[0].length; // taille d'une colonne

		valeur = this.jeu.grille[i][j];
		posx = i; /*position de la case*/
		posy = j; /*position de la case*/
		nb_bombe = this.jeu.nb_bombe;

		if (this.jeu.newgame) {
			
			addMouseListener(this.a);
			
			setText(null);
			setBackground(Color.GRAY);
		
		} else {
			
			if (this.jeu.uncovered_cases[i][j]==false) {
				setBackground(Color.GRAY);
				addMouseListener(this.a);
			
				if (this.jeu.text[i][j]=='*') {
					setText("\u2605");
				} else if(this.jeu.text[i][j]=='?') {
					setText("?");
				} else if (this.jeu.text[i][j]=='_') {
					setText(null);
				}
			} else {
				uncovered = true;
				setBackground(Color.LIGHT_GRAY);
				if (valeur!=0) {
					setText(Integer.toString(valeur));
				}
			}
		}

		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
		setOpaque(true);
		setFont(getFont().deriveFont(getFont().getStyle(), 20));		
	}

/**
	*Actions en reponse a un click gauche.
	*Actions:
	*	Decouvre la case;
	*	Lance affichage de fin.
*/
	public void OnLeftClick() {
		int nb_uncovered=0; 

		if (valeur==-1) {
			new EndGame(1, this);
		} else {
			Uncover();
		}

		for (int i=0 ; i<x; i++) {
			for (int j=0; j<y; j++) {
				if(t[i][j].uncovered) nb_uncovered++; 
			}
		}

		if (nb_bombe==(x*y)-nb_uncovered) {
			new EndGame(0, this);
		}
	}

/**
	*Decouvre la case.
	*Actions:
	*	Texte;
	*	Couleur de fond;
	*	Enlever ActionListener;
	*	Eventuel action récursive sur les cases environnantes;
*/
	public void Uncover() {

		removeMouseListener(this.a);
		
		if (this.valeur != 0)
			setText(Integer.toString(this.valeur));
		
		setBackground(Color.LIGHT_GRAY);
		this.uncovered=true;

		//Découvrir les cases environnant une case vide
		if (valeur==0) {
			if (posy!=0) {
				if(!this.t[posx][posy-1].uncovered)
					this.t[posx][posy-1].Uncover();

				if (posx!=x-1)
					if(!this.t[posx+1][posy-1].uncovered)
						this.t[posx+1][posy-1].Uncover();

				
				if (posx!=0)
					if(!this.t[posx-1][posy-1].uncovered)
						this.t[posx-1][posy-1].Uncover();
				
			}

			if (posy!=y-1) {
				if(!this.t[posx][posy+1].uncovered)
					this.t[posx][posy+1].Uncover();

				if (posx!=x-1)
					if(!this.t[posx+1][posy+1].uncovered)
						this.t[posx+1][posy+1].Uncover();

				if (posx!=0)
					if(!this.t[posx-1][posy+1].uncovered)
						this.t[posx-1][posy+1].Uncover();
			}			

			if (posx!=x-1)
				if(!this.t[posx+1][posy].uncovered)
					this.t[posx+1][posy].Uncover();

			if (posx!=0)
				if(!this.t[posx-1][posy].uncovered)
					this.t[posx-1][posy].Uncover();
		}
	}
}