import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FenetreErreur extends JFrame {
	private boolean b;
	public FenetreErreur(String nom, boolean b) {		
		super(nom);
		this.b = b;
		this.setSize(1500,300);
		this.setLocation(200,220);
		
		if(b){
			JLabel erreur1 = new JLabel("Remplissez les cases des lignes et des colonnes avec des entiers compris entre 4 et 30 uniquement");
			erreur1.setFont(new Font("Arial",Font.PLAIN,20));
			erreur1.setHorizontalAlignment(JLabel.CENTER);
			this.add(erreur1);
		}else{
			JLabel erreur2 = new JLabel("Remplissez la cases des bombes avec des entiers compris entre 1 et le maximum de cases uniquement");
			erreur2.setFont(new Font("Arial",Font.PLAIN,20));
			erreur2.setHorizontalAlignment(JLabel.CENTER);
			this.add(erreur2);
		}
	}
}
