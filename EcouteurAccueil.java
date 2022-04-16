import java.awt.event.*;
import java.util.*;

public class EcouteurAccueil implements ActionListener{
	
	private Accueil fenetre;
	
	//constructeur
	public EcouteurAccueil(Accueil fen){
		fenetre=fen;
	}
	
	private void buttonGOActionPerformed(ActionEvent evt) {                                         
        System.out.println("on passe par ecouteur go");

        RegimeAlimentaire f = new RegimeAlimentaire();
        f.setVisible(true);

        //pour cacher l'ancienne fenêtre
        fenetre.hide();
    }
    
	public void actionPerformed(ActionEvent e){
		buttonGOActionPerformed(e);
    }

		
		
}
