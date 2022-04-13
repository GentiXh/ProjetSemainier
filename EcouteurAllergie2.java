import java.awt.event.*;
import java.util.*;

public class EcouteurAllergie2 implements ActionListener{
	
	private Allergie fenetre;
	private int n1=2;
	private int n2=2;
	private int n3=2;
	private int n4=2;
	private int n5=2;
	
	int allergene;
		
	//constructeur
	public EcouteurAllergie2(Allergie fen, int val){
		fenetre=fen;
		allergene = val;
	}
	
	public void actionPerformed(ActionEvent evt) {
        if (allergene == 1){
			
			if (n1%2==0){
				fenetre.setGluten(false);
			}
			else {
				fenetre.setGluten(true);
			}
			n1++;
		}
		if (allergene == 2){
			if (n2%2==0){
				fenetre.setLactose(false);
			}
			else {
				fenetre.setLactose(true);
			}
			n2++;
		}
		if (allergene == 3){
			if (n3%2==0){
				fenetre.setArachide(false);
			}
			else {
				fenetre.setArachide(true);
			}			
			n3++;

		}
			
		if (allergene == 4){
			if (n4%2==0){
				fenetre.setFodmap(false);
			}
			else {
				fenetre.setFodmap(true);
			}			
			n4++;
		}
		
		if (allergene == 5){
			if (n5%2==0){
				fenetre.setOeuf(false);
			}
			else {
				fenetre.setOeuf(true);
			}			
			n5++;
		}
		
		
		
    }
  
    
		
		
}
