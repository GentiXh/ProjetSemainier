import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class EcouteurRecette implements ActionListener{
	
	private BoxRecette pan;			//panel sur laquelle intervient cet ecouteur
	
	private ProfilUtilisateur profil;
	
	private TriDeContraintes t;
	
	private JCheckBox box;
	
	private int n = 2;   			//exactement la meme logique que le counter + le modulo d'EcouteurAllergie2
	
	//constructeur
	public EcouteurRecette(BoxRecette pan, ProfilUtilisateur p, JCheckBox box, TriDeContraintes t){
		this.pan = pan;
		profil = p;
		this.box=box;
		this.t = t;
	}
	
	public void actionPerformed(ActionEvent evt) {
		
		if (n % 2 == 0){
			if (t.getPetitDejList().contains(box.getText())){		//s'il s'agit d'un repas petit dej
				profil.ajouterRepasPetitDej(box.getText());			//setteur de petit dej
			}
			else{													//sinon
				profil.ajouterRepasNormaux(box.getText());			//setteur repas non petit dej
			}
			n++;
		}
		
		else{
			if (t.getPetitDejList().contains(box.getText())){
				profil.supprimerRepasPetitDej(box.getText());
			}
			else{
				profil.supprimerRepasNormaux(box.getText());
			}
			n++;
		}
			
	   System.out.println("Liste des repas non petit dej coches");
       for(int i=0; i<profil.getRepasNormaux().size();i++){
			System.out.println(profil.getRepasNormaux().get(i));
		}
	   System.out.println("Liste des repas petit dej coches");
       for(int i=0; i<profil.getRepasPetitDej().size();i++){
			System.out.println(profil.getRepasPetitDej().get(i));
		}		
    }
}
