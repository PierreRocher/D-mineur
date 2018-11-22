import java.awt.*;
import javax.swing.*;

/**
	*Componant de base neutre qui sera modifie par la suite.
	*Centre d'informations concernant la partie en cours.
	*@author MANICOME_ROCHER
*/
public class Game extends JComponent {
	int nb_colonne;
	int nb_ligne;
	int nb_bombe;
	boolean initialized = false;
	boolean newgame;
	boolean[][] uncovered_cases;
	char[][] text;
	int[][] grille; 
	Case[][] terrain;
	JPanel panel = new JPanel();
	JLabel reste;

	/**
		*Division de la fenetre en deux parties: 
		*Plateau de jeu / 
		*Barre d'etat
	*/
	public Game(Fenêtre frame) {

		int sizex, sizey;
		sizex =(int) (frame.getWidth()*0.8);
		sizey = frame.getHeight();
		this.setPreferredSize(new Dimension(sizex, sizey));

		panel.setPreferredSize(new Dimension(frame.getWidth()-sizex, sizey));
		panel.setBackground(new Color(51, 51, 200));

    	frame.add(this, BorderLayout.CENTER);
    	frame.add(panel, BorderLayout.EAST);

    	reste = new JLabel();
    	reste.setPreferredSize(new Dimension(frame.getWidth()-sizex,(int) (sizey*0.2)));
    	reste.setHorizontalAlignment(JLabel.CENTER);
    	reste.setOpaque(true);
    	reste.setBackground(Color.CYAN);

    	panel.add(reste);

    	JButton button = new JButton("Save&Quit");
    	button.setPreferredSize(new Dimension(frame.getWidth()-sizex,(int) (sizey*0.2)));
    	button.addActionListener(new Reactif(this));
    	panel.add(button);
	}
}