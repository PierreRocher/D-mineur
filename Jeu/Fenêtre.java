import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

/**
	*Création de la fenetre principale
	*@author MANICOME_ROCHER
*/
public class Fenêtre extends JFrame {
	JPanel panel = new JPanel();
	JButton nouveau = new JButton("NewGame");
	JButton last = new JButton("LastGame");
	JButton quit = new JButton("Quit");

	/**
		*Menu: NewGame; LastGame; Quit.
	*/
	public Fenêtre() {
		super("Démineur");
		setSize(1000,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setBackground(Color.GRAY);
    	add(panel);

		try{
            FileInputStream file = new FileInputStream("Sauvegarde.bin");
            DataInputStream flux = new DataInputStream(file);
            try {
            	flux.close();
            } catch(IOException e) {
            	System.err.println("Close error");
            }

            nouveau.addActionListener(new Reactif(this));
	    	nouveau.setPreferredSize(new Dimension(getWidth()/2, getHeight()/3));
	    	panel.add(nouveau, BorderLayout.NORTH);

	    	last.addActionListener(new Reactif(this));
	    	last.setPreferredSize(new Dimension(getWidth()/2, getHeight()/3));
	    	panel.add(last, BorderLayout.CENTER);

	    	quit.addActionListener(new Reactif(this));
	    	quit.setPreferredSize(new Dimension(getWidth()/2, getHeight()/3));
	    	panel.add(quit, BorderLayout.SOUTH);

        } catch(FileNotFoundException e) {
	   		nouveau.addActionListener(new Reactif(this));
	    	nouveau.setPreferredSize(new Dimension(getWidth()/2, getHeight()/3));
	    	panel.add(nouveau, BorderLayout.NORTH);

	    	quit.addActionListener(new Reactif(this));
	    	quit.setPreferredSize(new Dimension(getWidth()/2, getHeight()/3));
	    	panel.add(quit, BorderLayout.SOUTH);
        }
	}

	/**
		*Vider la fenetre et lancer une nouvelle partie
	*/
	public void LaunchNewGame() {

		remove(panel);
		Game g = new Game(this);

		NewGame ng = new NewGame(g);
		addWindowListener(new ControlState(g));
		revalidate();
		repaint();

	}

	/**
		*Vider la fenetre et lancer une partie sauvegardee
	*/
	public void LaunchPreviousGame() {

		remove(panel);
		Game g = new Game(this);

		LoadPreviousGame pg = new LoadPreviousGame(g);
		addWindowListener(new ControlState(g));

		revalidate();
		repaint();
	}
}