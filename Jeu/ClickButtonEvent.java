import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClickButtonEvent implements ActionListener {
	private Selection bouton;
	private JTextField label;
	private String c,u;
	
	public ClickButtonEvent(Selection b, JTextField l, String c,String u){
		this.bouton = b;
		this.label= l;
		this.u = u;
		this.c = c;
	}

	public void actionPerformed(ActionEvent e) {
		
		if(this.c.equals("ligne")){
				try{
				if(Integer.parseInt(this.label.getText()) <=30 && Integer.parseInt(this.label.getText()) >=4)
					this.bouton.nb_ligne = Integer.parseInt(this.label.getText());
				else
					this.bouton.nb_ligne = 30;
				}catch(NumberFormatException error){
					FenetreErreur erreur = new FenetreErreur("Erreur!",true);
					erreur.setVisible(true);
					this.label.setText(Integer.toString(this.bouton.nb_ligne));
				}

				if(this.u.equals("+")) {
					if(this.bouton.nb_ligne <30){
						this.bouton.nb_ligne++;
					}
				}
				else{
					if(this.bouton.nb_ligne >4){
						this.bouton.nb_ligne--;
					}
				}
				this.label.setText(Integer.toString(this.bouton.nb_ligne));
		}

		else if (this.c.equals("colonne")){
			try{
				if(Integer.parseInt(this.label.getText()) <=30 && Integer.parseInt(this.label.getText()) >=4)
					this.bouton.nb_colonne = Integer.parseInt(this.label.getText());
				else
					this.bouton.nb_colonne = 30;
			}catch(NumberFormatException error){
				FenetreErreur erreur = new FenetreErreur("Erreur!",true);
				erreur.setVisible(true);
				this.label.setText(Integer.toString(this.bouton.nb_colonne));
			}

			if(this.u.equals("+")) {
				if(this.bouton.nb_colonne <30){
					this.bouton.nb_colonne++;
				}
			}
			else{
				if(this.bouton.nb_colonne >4){
					this.bouton.nb_colonne--;
				}
			}
			this.label.setText(Integer.toString(this.bouton.nb_colonne));
		}
		else if(this.c.equals("bombe")){
			try{
				if(Integer.parseInt(this.label.getText()) <=(this.bouton.nb_colonne*this.bouton.nb_ligne) && Integer.parseInt(this.label.getText()) >=1)
					this.bouton.nb_bombe = Integer.parseInt(this.label.getText());
			}catch(NumberFormatException error){
				FenetreErreur erreur = new FenetreErreur("Erreur bombes", false);
				erreur.setVisible(true);
			}

			if(this.u.equals("+")) {
				this.bouton.nb_ligne = Integer.parseInt(this.bouton.textLigne.getText());
				this.bouton.nb_colonne = Integer.parseInt(this.bouton.textColonne.getText());
				if(this.bouton.nb_bombe <(this.bouton.nb_colonne*this.bouton.nb_ligne)){
					System.out.println(this.bouton.nb_colonne);System.out.println(this.bouton.nb_ligne);
					this.bouton.nb_bombe++;
				}
			}
			else{
				if(this.bouton.nb_bombe >1){
					this.bouton.nb_bombe--;
				}
			}
			this.label.setText(Integer.toString(this.bouton.nb_bombe));
		}

		this.bouton.revalidate();
		this.bouton.repaint();
	}	
}
