import java.awt.event.*;
import java.util.*;

public class EcouteurValiderRecette implements ActionListener{
	
	private Recette fenetre;            //fenetre sur laquelle intervient cet ecouteur
	private ProfilUtilisateur profil;
		
	//constructeur
	public EcouteurValiderRecette(Recette fen, ProfilUtilisateur p){
		fenetre=fen;
		profil = p;
	}
	
	public void actionPerformed(ActionEvent evt) {
        //creation + affichage d'une nouvelle fenetre Semainier
        Semainier semainier = new Semainier(profil);
		semainier.setVisible(true);
		//pour cacher l'ancienne fenêtre (Recette)
		fenetre.dispose();
    }
}

