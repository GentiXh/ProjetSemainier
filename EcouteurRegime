import java.awt.event.*;
import java.util.*;

public class EcouteurRegime implements ActionListener{
	
	private RegimeAlimentaire fenetre;
	private int reg;
	//constructeur
	public EcouteurRegime(RegimeAlimentaire fen, int val){
		fenetre=fen;
		reg=val;
	}

	 public void actionPerformed(ActionEvent evt) {                                         
        // ouvre une nouvelle fenetre allergie:
        Allergie f = new Allergie();
        f.setVisible(true);
        
        //pour cacher l'ancienne fenêtre
        fenetre.hide();
        
        //instancie le regime :
        fenetre.setRegime(reg);
    }
    
   
}

