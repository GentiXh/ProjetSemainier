import java.awt.event.*;
import java.util.*;

public class EcouteurAllergie implements ActionListener{
	
	private Allergie fenetre;
	private boolean resultat;
	private ProfilUtilisateur profil;
		
	//constructeur
	public EcouteurAllergie(Allergie fen, boolean res, ProfilUtilisateur p){
		fenetre=fen;
		resultat=res;
		profil= p;
	}
	
	public void actionPerformed(ActionEvent evt){
		if(resultat==false){ 						//on a clique sur 'non'
			Recette recette = new Recette(profil);
			
			//les allergens peuvent etre manges par l'utilisateur
			profil.setGluten(true);
			profil.setFodmap(true);
			profil.setArachide(true);
			profil.setLactose(true);
			profil.setOeuf(true);
			
			//on affiche recette
			recette.setVisible(true);
			
			//pour cacher l'ancienne fenêtre
			fenetre.dispose(); 					
				
		}else if (resultat==true){					 //on a clique sur 'oui'
			
			//on refait la fenetre allergie
			fenetre.centre.remove(fenetre.yesButton);
			fenetre.centre.remove(fenetre.noButton);
			fenetre.centre.remove(fenetre.allergieTexte);
			fenetre.glutenBox.setVisible(true);
			fenetre.lactoseBox.setVisible(true);
			fenetre.arachideBox.setVisible(true);
			fenetre.fodmapBox.setVisible(true);
			fenetre.oeufBox.setVisible(true);
			fenetre.revalidate();
			fenetre.repaint();
			fenetre.validerButton.setVisible(true);
		}		
		System.out.println("on est passe par ecouteur allergie");

	}		
}
