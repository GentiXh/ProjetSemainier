import java.awt.event.*;
import java.util.*;

public class EcouteurAllergie2 implements ActionListener{
	
	private Allergie fenetre;
	int allergene;
		
	//constructeur
	public EcouteurAllergie2(Allergie fen, int val){
		fenetre=fen;
		allergene = val;
	}
	
	public void actionPerformed(ActionEvent evt) {
        if (allergene == 1){
			fenetre.gluten=true;
		}
		if (allergene == 2){
			fenetre.lactose=true;
		}
		if (allergene == 3){
			fenetre.arachide=true;
		}
		if (allergene == 4){
			fenetre.fodmap=true;
		}
		if (allergene == 5){
			fenetre.oeuf=true;
		}
		
		
		
		
    }
  
    
		
		
}
