import java.awt.event.*;
import java.util.*;

public class EcouteurAllergie implements ActionListener{
	
	private Allergie fenetre;
	private boolean resultat;
		
	//constructeur
	public EcouteurAllergie(Allergie fen, boolean res){
		fenetre=fen;
		resultat=res;
	}
	
	public void actionPerformed(ActionEvent evt){
		
		if(resultat==false){ //on a clique sur 'oui'
			Recette f = new Recette();
			
			f.setVisible(true);
			
			//pour cacher l'ancienne fenêtre
			fenetre.hide();
			
			
		}else if (resultat==true){ // on a clique sur 'non'
			fenetre.centre.remove(fenetre.yesButton);
			fenetre.centre.remove(fenetre.noButton);
			fenetre.centre.remove(fenetre.allergieTexte);
			fenetre.glutenBox.setVisible(true);
			fenetre.lactoseBox.setVisible(true);
			fenetre.arachideBox.setVisible(true);
			fenetre.fodmapBox.setVisible(true);
			fenetre.oeufBox.setVisible(true);
			fenetre.autresBox.setVisible(true);
			
			fenetre.revalidate();
			fenetre.repaint(); 
			fenetre.validerButton.setVisible(true);
		}	
	}	
}
