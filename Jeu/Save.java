import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;


/**
	*Sauvegarde l'etat de la partie sous forme simplifiee
	*@author MANICOME_ROCHER
*/
public class Save {
	public Save(Game g) {
		try {
			FileOutputStream file = new FileOutputStream("Sauvegarde.bin");
			DataOutputStream flux = new DataOutputStream(file);

			try {
				flux.writeInt(g.nb_ligne);
				flux.writeInt(g.nb_colonne);
				flux.writeInt(g.nb_bombe);

				for (int i=0; i<g.nb_ligne; i++) {
					for (int j=0; j<g.nb_colonne; j++) {
						flux.writeBoolean(g.terrain[i][j].uncovered);

						if (g.terrain[i][j].getText()==null) {
							flux.writeChar('_');
						} else if (g.terrain[i][j].getText().equals("\u2605")) {
							flux.writeChar('*');
						} else {
							flux.writeChar('?');
						}

						flux.writeInt(g.grille[i][j]);	
					}
				}
			} catch(IOException e) {
				System.err.println("Write Error");
			}

			try {
				flux.close();
			} catch(IOException e) {
				System.err.println("Close Error");
			}
		} catch(FileNotFoundException f) {
			System.err.println("FileNotFound");
		}

		System.exit(0);		
	}
}