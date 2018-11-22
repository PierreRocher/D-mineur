import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class ClickButtonEventValider implements ActionListener {
		private JTextField a,b,c;
		private Game jeu;
		private NewGame ng;

	public ClickButtonEventValider(JTextField textLigne, JTextField textColonne, JTextField textBombe, Game g, NewGame n){
		this.a = textLigne;
		this.b = textColonne;
		this.c = textBombe;
		this.jeu = g;
		this.ng = n;
	}

	public void actionPerformed(ActionEvent e) {
			boolean test = true;

			try{
				int g = Integer.parseInt(this.a.getText());
				if(g <=30 && g >=4){
					this.jeu.nb_ligne = g;
					this.a.setBackground(Color.WHITE);
				}else{
					test = false;
					this.a.setBackground(Color.RED);
				}
			}catch(NumberFormatException error){
				FenetreErreur erreur = new FenetreErreur("Erreur!",true);
				erreur.setVisible(true);
				test = false;
				this.a.setBackground(Color.RED);
			}

			try{
				int h = Integer.parseInt(this.b.getText());
				if(h <=30 && h >=4){
					this.jeu.nb_colonne = h;
					this.b.setBackground(Color.WHITE);
				}else{
					test = false;
					this.b.setBackground(Color.RED);
				}
			}catch(NumberFormatException error){
				FenetreErreur erreur = new FenetreErreur("Erreur!",true);
				erreur.setVisible(true);
				test = false;
				this.b.setBackground(Color.RED);
			}

			try{
				int i = Integer.parseInt(this.c.getText());	
				if(i <=(Integer.parseInt(this.a.getText())*Integer.parseInt(this.b.getText())) && i >=1){
					this.jeu.nb_bombe = i;
					this.c.setBackground(Color.WHITE);
				}else{
					test = false;
					this.c.setBackground(Color.RED);
				}
			}catch(NumberFormatException error){
				FenetreErreur erreur = new FenetreErreur("Erreur!",false);
				erreur.setVisible(true);
				test = false;
				this.c.setBackground(Color.RED);

			}
			
			if(test == true){
				this.ng.Creer_Jeu();
				Selection s =(Selection) SwingUtilities.getWindowAncestor(((JButton) e.getSource()));
				s.dispose();
			}
	}
}