import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;  
    
public class BoxRecette extends JPanel{    
	    
	private TriDeContraintes tri;
	
	// constructeur  
	public BoxRecette(ArrayList<String> repas, ProfilUtilisateur profil, TriDeContraintes t){
		
		tri = t;
		
		this.setLayout(new GridLayout(repas.size(),1));
				
		//ajout du contenu de l'ArrayList passé en paramètre du constructeur dans le gridLayout sous la forme de checkBox
		for(int i=0;i<repas.size();i++){
			
			JCheckBox nomRecette = new JCheckBox(repas.get(i));
			
			nomRecette.addActionListener(new EcouteurRecette(this, profil, nomRecette, tri));
			
			//police de caractere
			nomRecette.setFont(new Font("Stencil", 0, 24));	
			
			//ajout de la CheckBox dans le panel
			this.add(nomRecette);
        }        
	}
}  
