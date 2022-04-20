import java.awt.event.*;
import java.util.*;

public class EcouteurValiderAllergie implements ActionListener{
	
	private Allergie fenetre;            //fenetre sur laquelle intervient cet ecouteur
	private ProfilUtilisateur profil;
		
	//constructeur
	public EcouteurValiderAllergie(Allergie fen, ProfilUtilisateur p){
		fenetre=fen;
		profil = p;
	}
	
	public void actionPerformed(ActionEvent evt) {
        //creation + affichage d'une nouvelle fenetre recette
        Recette recette = new Recette(profil);
		recette.setVisible(true);
		//pour cacher l'ancienne fenêtre(allergie)
		fenetre.dispose();
    }
}

