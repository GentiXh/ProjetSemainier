import java.awt.event.*;
import java.util.*;

public class EcouteurAllergie implements ActionListener{
	
	private Allergie fenetre; 			//fenetre sur laquelle intervient cet ecouteur
	private boolean resultat;			//permet de distinguer sur quel bouton l'utilisateur a clique
	private ProfilUtilisateur profil;	
		
	//constructeur
	public EcouteurAllergie(Allergie fen, boolean res, ProfilUtilisateur p){
		fenetre=fen;
		resultat=res;
		profil= p;
	}
	
	public void actionPerformed(ActionEvent evt){
		if(resultat==false){ 							 //on a clique sur 'non'
			Recette recette = new Recette(profil);       /*appel la classe recette en passant l'instance de ProfilUtilisateur*/
			
			//on affiche recette
			recette.setVisible(true);					
			
			//pour cacher l'ancienne fenêtre
			fenetre.dispose(); 			
			//Explication: les valeurs d'allergies ont ete mises a false par defaut dans la classe Allergie, donc pas besoin de faire appel aux setteurs de ProfilUtilisateur pour mettre tout en false		
				
		}else if (resultat==true){						 //on a clique sur 'oui'
			
			//on refait la fenetre allergie
			/*on enleve les boutons 'oui' et 'non' et le label*/
			fenetre.centre.remove(fenetre.yesButton);
			fenetre.centre.remove(fenetre.noButton);
			fenetre.centre.remove(fenetre.allergieTexte);
			/*on affiche les checkbox et le bouton valider*/
			fenetre.glutenBox.setVisible(true);
			fenetre.lactoseBox.setVisible(true);
			fenetre.arachideBox.setVisible(true);
			fenetre.fodmapBox.setVisible(true);
			fenetre.oeufBox.setVisible(true);
			fenetre.validerButton.setVisible(true);
			
			fenetre.revalidate();
			fenetre.repaint();
		}		
		/**System.out.println("on est passe par ecouteur allergie");*/
	}		
}
