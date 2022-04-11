import java.awt.event.*;
import java.util.*;

public class EcouteurValiderAllergie implements ActionListener{
	
	private Allergie fenetre;

		
	//constructeur
	public EcouteurValiderAllergie(Allergie fen){
		fenetre=fen;
	}
	
	public void actionPerformed(ActionEvent evt) {
        Recette f = new Recette();
		f.setVisible(true);
			
		//pour cacher l'ancienne fenêtre
		fenetre.hide();
    }
	
	
    
		
		
}
