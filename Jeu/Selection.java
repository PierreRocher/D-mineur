import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Selection extends JFrame {
	int nb_ligne = 15, nb_colonne = 15, nb_bombe = 1;	

	JTextField textLigne = new JTextField(Integer.toString(nb_ligne));
	JTextField textColonne = new JTextField(Integer.toString(nb_colonne));
	JTextField textBombe = new JTextField(Integer.toString(nb_bombe));

	public Selection(Game g, NewGame n) {
		super("Selection");
		this.setDefaultLookAndFeelDecorated(false);
		this.setSize(900,400);
		this.setLocation(500,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridLayout grille = new GridLayout(6,3);
		this.setLayout(grille);

		JLabel ligne = new JLabel("Nombres de lignes:");
		JLabel colonne = new JLabel("Nombres de colonnes:");
		JLabel bombe = new JLabel("Nombres de bombes:");
		JLabel ligne2 = new JLabel("entre 4 et 30");
		JLabel colonne2 = new JLabel("entre 4 et 30");
		JLabel bombe2 = new JLabel("entre 1 et le nombres de cases max");
		JButton lignePlus = new JButton("+");
		JButton colonnePlus = new JButton("+");
		JButton bombePlus = new JButton("+");

		JButton ligneMoins = new JButton("-");
		JButton colonneMoins = new JButton("-");
		JButton bombeMoins = new JButton("-");
		JLabel trou = new JLabel();
		JButton valider = new JButton("Valider");

		ligne.setHorizontalAlignment(JLabel.CENTER);
		colonne.setHorizontalAlignment(JLabel.CENTER);
		bombe.setHorizontalAlignment(JLabel.CENTER);
		ligne2.setHorizontalAlignment(JLabel.CENTER);
		colonne2.setHorizontalAlignment(JLabel.CENTER);
		bombe2.setHorizontalAlignment(JLabel.CENTER);
		textLigne.setHorizontalAlignment(JTextField.CENTER);
		textColonne.setHorizontalAlignment(JTextField.CENTER);
		textBombe.setHorizontalAlignment(JLabel.CENTER);

		textLigne.setFont(new Font("Arial",Font.PLAIN,35));
		textColonne.setFont(new Font("Arial",Font.PLAIN,35));
		textBombe.setFont(new Font("Arial",Font.PLAIN,35));
		lignePlus.setFont(new Font("Arial",Font.PLAIN,35));
		ligneMoins.setFont(new Font("Arial",Font.PLAIN,35));
		bombeMoins.setFont(new Font("Arial",Font.PLAIN,35));
		colonnePlus.setFont(new Font("Arial",Font.PLAIN,35));
		colonneMoins.setFont(new Font("Arial",Font.PLAIN,35));
		bombePlus.setFont(new Font("Arial",Font.PLAIN,35));


		this.add(ligne);
		this.add(colonne);
		this.add(bombe);
		this.add(ligne2);
		this.add(colonne2);
		this.add(bombe2);
		this.add(lignePlus);
		this.add(colonnePlus);
		this.add(bombePlus);
		this.add(textLigne);
		this.add(textColonne);
		this.add(textBombe);
		this.add(ligneMoins);
		this.add(colonneMoins);
		this.add(bombeMoins);
		this.add(trou);
		this.add(valider);

		lignePlus.addActionListener(new ClickButtonEvent(this, textLigne, "ligne", "+"));
		ligneMoins.addActionListener(new ClickButtonEvent(this, textLigne, "ligne", "-"));
		colonnePlus.addActionListener(new ClickButtonEvent(this, textColonne, "colonne", "+"));
		colonneMoins.addActionListener(new ClickButtonEvent(this, textColonne, "colonne", "-"));
		bombePlus.addActionListener(new ClickButtonEvent(this, textBombe,"bombe", "+"));
		bombeMoins.addActionListener(new ClickButtonEvent(this, textBombe,"bombe", "-"));
		textLigne.addActionListener(new ClickButtonEvent(this,textLigne,"ligne", "t"));
		textColonne.addActionListener(new ClickButtonEvent(this,textColonne,"colonne", "t"));
		textBombe.addActionListener(new ClickButtonEvent(this,textBombe,"bombe", "t"));

		valider.addActionListener(new ClickButtonEventValider(textLigne, textColonne, textBombe, g, n));

	}
}
