import java.awt.event.*;
import java.util.*;

public class EcouteurAccueil implements ActionListener{
	
	private Accueil fenetre; //fenetre sur laquelle intervient cet ecouteur
	
	//constructeur
	public EcouteurAccueil(Accueil fen){ 
		fenetre=fen;
	}
	
	public void actionPerformed(ActionEvent evt) {                                         
        /**System.out.println("on passe par ecouteur go");*/
		
		//une nouvelle fenetre regime apparait quand on clique sur go
        RegimeAlimentaire f = new RegimeAlimentaire();
        f.setVisible(true);

        //pour cacher l'ancienne fenêtre (accueil)
        fenetre.hide();
    }	
}
