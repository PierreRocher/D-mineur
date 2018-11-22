import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
	*MouseListener detectant l'action de la souris sur les cases
	*@author MANICOME_ROCHER
*/
public class MouseController implements MouseListener {
	Case bloc;
	Game jeu;

	public MouseController(Game g) {
		super();
		this.jeu = g;
	}
	/**
		*Change la couleur de la case lorsque la souris entre dans la case
	*/
	@Override
	public void mouseEntered(MouseEvent e) {
		this.bloc =(Case) e.getSource();
		this.bloc.setBackground(new Color(25, 25, 112));
	}

	/**
		*Rends a la case sa couleur initiale
	*/
	@Override
	public void mouseExited(MouseEvent e) {
		this.bloc =(Case) e.getSource();
		this.bloc.setBackground(Color.GRAY);
	}

	/**
		*Detecte si la case a ete clique, 
		*Deux boutons possibles
	*/
	@Override
	public void mouseClicked(MouseEvent e) {
		this.bloc =(Case) e.getSource();

		if (e.getButton()==MouseEvent.BUTTON1) {
			if (this.bloc.getText()==null) {
				this.bloc.OnLeftClick();
			}
		}

		if (e.getButton()==MouseEvent.BUTTON3) {
			String text;
			int x=0;
			
			if (this.bloc.getText()==null) {
				this.bloc.setText("\u2605");
			}
			else if (this.bloc.getText().equals("\u2605")) {
				this.bloc.setText("?");
			}
			else if (this.bloc.getText().equals("?")) {
				this.bloc.setText(null);
			}

			for (int i=0; i<this.jeu.nb_ligne; i++) {
				for (int j=0; j<this.jeu.nb_colonne; j++) {
					text = this.jeu.terrain[i][j].getText();
					if (text!=null) {
						if (text.equals("\u2605")) x++;	
					}								
				}				
			}

			x = this.jeu.nb_bombe-x;
			this.jeu.reste.setText("Reste: "+Integer.toString(x));		

			Fenêtre frame = (Fenêtre) SwingUtilities.getWindowAncestor(this.bloc);
			frame.revalidate();
			frame.repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}