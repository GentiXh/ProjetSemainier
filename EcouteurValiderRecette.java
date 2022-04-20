import java.awt.event.*;
import java.util.*;

public class EcouteurValiderRecette implements ActionListener{
	
	private Recette fenetre;            //fenetre sur laquelle intervient cet ecouteur
	private ProfilUtilisateur profil;
		
	//constructeur
	public EcouteurValiderRecette(Recette fen, ProfilUtilisateur p){
		fenetre=fen;
		profil = p;
	}
	
	public void actionPerformed(ActionEvent evt) {
		if(!profil.getRepasNormaux().isEmpty() && !profil.getRepasPetitDej().isEmpty()){  //s'il y a au moins un repas normal et un repas petit dejeuner selectionnees
			//creation + affichage d'une nouvelle fenetre Semainier
			Semainier semainier = new Semainier(profil);
			semainier.setVisible(true);
			//pour cacher l'ancienne fenêtre (Recette)
			fenetre.dispose();
		}
	}
}

