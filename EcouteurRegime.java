import java.awt.event.*;
import java.util.*;

public class EcouteurRegime implements ActionListener{
	
	//attributs
	private RegimeAlimentaire fenetreRegime; //fenetre sur laquelle intervient cet ecouteur
	private int reg;						 // cet ecuteur a pour but d'instancier la valeur de regime en tant que 'reg'
	public ProfilUtilisateur profil;		
	
	//constructeur
	public EcouteurRegime(RegimeAlimentaire fen, int val, ProfilUtilisateur p){ // mettre le profil en parametre permet de conserver les informations de l'utilisateur 
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
		fenetreRegime.dispose();
    }
}
