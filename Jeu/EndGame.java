import javax.swing.*;
import java.awt.*;

/**
	*Affichage de fin de partie
	*@author MANICOME_ROCHER
*/
public class EndGame {
	private Case[][] c;
	private Case a;
	private int x, y;

	/**
		*Redirige en fonction de l'issue de la partie
	*/
	public EndGame(int way, Case bloc) {
		this.c = bloc.t;
		this.a = bloc;
		this.x = this.c.length;
		this.y = this.c[0].length;

		Game g =(Game) this.a.getParent();
		Fenêtre f =(Fenêtre) SwingUtilities.getWindowAncestor(this.a);
		
		int sizex, sizey;
		sizex =(int) (f.getWidth()*0.8);
		sizey = f.getHeight();
		
		JButton b = new JButton("PlayAgain?");
		b.setPreferredSize(new Dimension(f.getWidth()-sizex,(int) (sizey*0.2)));
		b.addActionListener(new Reactif(f));
		g.panel.add(b);

		f.revalidate();
		f.repaint();

		if (way==1) {
			Lose();		
		}
		else {
			Win();
		}	
	}

	/**
		*Coloration specifique a chaque cas, 
		*Indication de la case ayant explose, 
		*Proposition d'une nouvelle partie
	*/
	public void Lose() {
		for (int i=0; i<x; i++) {
			for (int j=0; j<y; j++) {
				if (this.c[i][j].valeur==-1) {
					if (!this.c[i][j].uncovered) {
						//Aggrandir la taille de police des cases minées
						this.c[i][j].setFont(
							this.c[i][j].getFont().deriveFont(
								this.c[i][j].getFont().getStyle(), 40
							)
						);

						this.c[i][j].removeMouseListener(this.c[i][j].a);
						
						
						if (this.c[i][j].getText()!=null) {
							if (this.c[i][j].getText().equals("\u2605")) {
								this.c[i][j].setText("\u2620");
								this.c[i][j].setBackground(Color.GREEN);
							}
							if (this.c[i][j].getText().equals("?")) {
								this.c[i][j].setText("\u2620");
								this.c[i][j].setBackground(Color.ORANGE);
							}
						} else {
							this.c[i][j].setText("\u2620");
							this.c[i][j].setBackground(Color.RED);
						}
					}
				}
			}
		}
		this.a.setText("X");
	}

	/**
		*Affichage des bombes, 
		*Proposition d'une nouvelle partie
	*/
	public void Win() {
		for (int i=0; i<x; i++) {
			for (int j=0; j<y; j++) {
				if (!this.c[i][j].uncovered) {
					if (this.c[i][j].valeur==-1) {
						//Aggrandir la taille de police des cases minées
						this.c[i][j].setFont(
							this.c[i][j].getFont().deriveFont(
								this.c[i][j].getFont().getStyle(), 40
							)
						);

						this.c[i][j].removeMouseListener(this.c[i][j].a);
						this.c[i][j].setText("\u2620");
					} else {
						this.c[i][j].Uncover();
					}
				}
			}
		}
	}
}