import java.awt.event.*;
import java.util.*;

public class EcouteurRegime implements ActionListener{
	
	private RegimeAlimentaire fenetreRegime;
	private int reg;
	public ProfilUtilisateur profil;
	
	//constructeur
	public EcouteurRegime(RegimeAlimentaire fen, int val, ProfilUtilisateur p){
		fenetreRegime=fen;
		reg=val;
		profil = p;
	}

	 public void actionPerformed(ActionEvent evt) {                                         
       
       //on set la valeur de regime dans ProfilUtilisateur
		profil.setReg(reg);
        
		// ouvre une nouvelle fenetre allergie:
        Allergie fenetreAllergie = new Allergie(this.profil);
        fenetreAllergie.setVisible(true);
        
        //pour cacher l'ancienne fenêtre
        
		System.out.println("on est passe par ecouteur regime");		
		fenetreRegime.dispose();
		System.out.println("regime alimentaire se ferme");
    }
}
