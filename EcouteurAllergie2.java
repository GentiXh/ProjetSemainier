import java.awt.event.*;
import java.util.*;

public class EcouteurAllergie2 implements ActionListener{
	
	private Allergie fenetre;			//fenetre sur laquelle intervient cet ecouteur
	
	private int n1=2;					//pour permettre de savoir quand la checkbox est cochee ou non :
	private int n2=2;					/*si nx modulo 2 vaut zero alors la case est cochee => l'utilisateur est allergique => boolean allergene = true*/
	private int n3=2;					/*si nx modulo 2 vaut un alors la case n'est pas cochee => l'utilisateur n'est pas allergique => boolean allergene = false*/
	private int n4=2;					/*chaque fois que l'on coche une meme checkbox nx augmente et la valeur de l'allergene change*/
	private int n5=2;

	int allergene;
	private ProfilUtilisateur profil;
	
	//constructeur
	public EcouteurAllergie2(Allergie fen, int val, ProfilUtilisateur p){
		fenetre = fen;
		allergene = val;
		profil = p;
	}
	
	public void actionPerformed(ActionEvent evt) {
        if (allergene == 1){				//gluten
			if (n1%2==0){
				profil.setGluten(true);
			}
			else {
				profil.setGluten(false);
			}
			/**System.out.println(" gluten ecouteur "+profil.gluten);*/  //pour debug si besoin
			n1++;
		}
		if (allergene == 2){				//lactose
			if (n2%2==0){
				profil.setLactose(true);
			}
			else {
				profil.setLactose(false);
			}
			n2++;
		}
		if (allergene == 3){				//arachide
			if (n3%2==0){
				profil.setArachide(true);
			}
			else {
				profil.setArachide(false);
			}			
			n3++;

		}
			
		if (allergene == 4){				//fodmap
			if (n4%2==0){
				profil.setFodmap(true);
			}
			else {
				profil.setFodmap(false);
			}			
			n4++;
		}
		
		if (allergene == 5){				//oeuf
			if (n5%2==0){
				profil.setOeuf(true);
			}
			else {
				profil.setOeuf(false);
			}			
			n5++;
		}
    }
}
