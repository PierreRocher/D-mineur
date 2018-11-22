import java.awt.*;
import javax.swing.*;


/**
	*Creer une nouvelle partie
	*Classe modificatrice de la classe Game 
	*@author MANICOME_ROCHER
*/
public class NewGame{
	private Game jeu;

	public NewGame(Game g) {
		super();
		this.jeu = g;
		this.jeu.newgame = true;

		Selection s = new Selection(this.jeu, this);
		s.setVisible(true);
	}

	/**
		*Creer le plateau de jeu
	*/
	public void Creer_Jeu() {

		this.jeu.grille = new int[this.jeu.nb_ligne][this.jeu.nb_colonne];
		this.jeu.reste.setText("Reste: "+Integer.toString(this.jeu.nb_bombe));
		GridLayout gestionnaire = new GridLayout(this.jeu.nb_ligne, this.jeu.nb_colonne);
		this.jeu.setLayout(gestionnaire);

		Poser_Bombe();
		Detect_Bombe();
		Creer_Terrain();
	}

	/**
		*Pose les bombes aleatoirement dans la grille
	*/
	public void Poser_Bombe() {
		int x, y;
		boolean b;
		String[] tab = new String[this.jeu.nb_bombe];

		for (int i=0; i<this.jeu.nb_bombe; i++) {
			do {
				b = false;
				x = (int) ((Math.random())*100+1)%this.jeu.nb_ligne;
				y = (int) ((Math.random())*100+1)%this.jeu.nb_colonne;
				tab[i] = x+"-"+y;
				for (int j=0; j<i; j++) {
					if (tab[i].equals(tab[j]))
						b = true;
				}
			} while(b);
			this.jeu.grille[x][y] = -1;
		}
	}

	/**
		*Attribue aux cases adjacent les bombes la quantite de bombe qui les entoure 
	*/
	public void Detect_Bombe() {
		for(int i=0;i<this.jeu.nb_ligne;i++){
			for(int j=0;j<this.jeu.nb_colonne;j++){
				if(this.jeu.grille[i][j]!=-1){

					if (j!=0) {
						if(this.jeu.grille[i][j-1]==-1)
							this.jeu.grille[i][j]++;

						if (i!=this.jeu.nb_ligne-1) {
							if(this.jeu.grille[i+1][j-1]==-1)
								this.jeu.grille[i][j]++;
						}

						if (i!=0) {
							if(this.jeu.grille[i-1][j-1]==-1)
								this.jeu.grille[i][j]++;
						}
						
					}

					if (j!=this.jeu.nb_colonne-1) {
						if(this.jeu.grille[i][j+1]==-1)
							this.jeu.grille[i][j]++;

						if (i!=this.jeu.nb_ligne-1) {
							if(this.jeu.grille[i+1][j+1]==-1)
								this.jeu.grille[i][j]++;
						}

						if (i!=0) {
							if(this.jeu.grille[i-1][j+1]==-1)
								this.jeu.grille[i][j]++;
						}
					}			

					if (i!=this.jeu.nb_ligne-1) {
						if(this.jeu.grille[i+1][j]==-1)
							this.jeu.grille[i][j]++;
					}

					if (i!=0) {
						if(this.jeu.grille[i-1][j]==-1)
							this.jeu.grille[i][j]++;
					}
				}
			}
		}
	}

	/**
		*Cree le terrain de jeu avec les composants Cases
	*/
	public void Creer_Terrain() {
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