import java.awt.event.*;
import java.util.*;

public class EcouteurValiderAllergie implements ActionListener{
	
	private Allergie fenetre;
	private ProfilUtilisateur profil;
		
	//constructeur
	public EcouteurValiderAllergie(Allergie fen, ProfilUtilisateur p){
		fenetre=fen;
		profil = p;
	}
	
	public void actionPerformed(ActionEvent evt) {
        Recette recette = new Recette(profil);
		recette.setVisible(true);
		//pour cacher l'ancienne fenêtre
		fenetre.dispose();
		System.out.println("on est passe par ecouteur valider");
    }
}
//// INUTILE
