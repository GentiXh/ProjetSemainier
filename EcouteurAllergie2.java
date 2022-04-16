import java.awt.event.*;
import java.util.*;

public class EcouteurAllergie2 implements ActionListener{
	
	private Allergie fenetre;
	private int n1=2;
	private int n2=2;
	private int n3=2;
	private int n4=2;
	private int n5=2;
	/**private boolean g;
	private boolean l;
	private boolean a;
	private boolean f;
	private boolean o;*/
	int allergene;
	private ProfilUtilisateur profil;
	
	
	//constructeur
	public EcouteurAllergie2(Allergie fen, int val, ProfilUtilisateur p){
		fenetre=fen;
		allergene = val;
		profil =p;
	}
	
	public void actionPerformed(ActionEvent evt) {
        if (allergene == 1){				//gluten
			if (n1%2==0){
				profil.setGluten(false);
			}
			else {
				profil.setGluten(true);
			}
			System.out.println(" gluten ecouteur "+profil.gluten);
			n1++;
		}
		if (allergene == 2){				//lactose
			if (n2%2==0){
				profil.setLactose(false);
			}
			else {
				profil.setLactose(true);
			}
			n2++;
		}
		if (allergene == 3){				//arachide
			if (n3%2==0){
				profil.setArachide(false);
			}
			else {
				profil.setArachide(true);
			}			
			n3++;

		}
			
		if (allergene == 4){				//fodmap
			if (n4%2==0){
				profil.setFodmap(false);
			}
			else {
				profil.setFodmap(true);
			}			
			n4++;
		}
		
		if (allergene == 5){				//oeuf
			if (n5%2==0){
				profil.setOeuf(false);
			}
			else {
				profil.setOeuf(true);
			}			
			n5++;
		}
		System.out.println("on est passe par ecouteur allergie2");
		
		if (allergene ==-1){
		Recette recette = new Recette(profil);
		recette.setVisible(true);
		//pour cacher l'ancienne fenêtre
		fenetre.dispose();
		}
		System.out.println("on est passe par ecouteur valider");
    }
}
