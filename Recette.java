import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Recette extends JFrame {
		
	
	public Recette(ProfilUtilisateur profil){ //constructeur
		
		System.out.println("on passe par recette");
		
		ProfilUtilisateur p = profil;

		//récuperer la taille de l'écran + mettre fenetre au centre de l'ecran  + fermeture
		this.pack();
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		int height = tailleEcran.height;
		int width = tailleEcran.width;
		this.setSize(width/2, height/2);
		this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //mettre en attributs
        JPanel fond = new JPanel(new BorderLayout());
        JLabel titre = new JLabel("RECETTES",JLabel.CENTER);
        JTabbedPane jTabbedPane1 = new JTabbedPane();
        
        
		//creation + appel d'une instance de tri qui permet de choisir les recettes correspondantes aux choix de l'utilisateur.
        //l'instance profil du ProfilUtilisateur passee en parametre a travers toute la chaine sequentielle des classes depuis RegimeAlimentaires jusqu'a ici, et puis finallement a TriDeContraintes
		TriDeContraintes t = new TriDeContraintes(p); 
		t.Tri();					  //appel la methode qui fait le tri selon les choix de l'utilisateur pour tout "type" de recette
        
        //création des ArrayLists selon les types de repas
        ArrayList<String> listeFr = t.getFrancaisList();
		ArrayList<String> listeIt = t.getItalienList();
		ArrayList<String> listeAs = t.getAsiatiqueList();
		ArrayList<String> listeFF = t.getFastFoodList();
		ArrayList<String> listeDej = t.getPetitDejList();
		ArrayList<String> listeAutre = t.getAutreCategorieList();
		
		//création des ArrayLists finales apres les choix de l'utilisateur
		ArrayList<String> listeFinaleRepasNormaux = new ArrayList<String>();		//repas pas petit dejeuner
		ArrayList<String> listeFinaleRepasPetitDej = new ArrayList<String>();		//repas petit dejeuner
		
        //les BoxRecette sont des JPanel
        BoxRecette francais = new BoxRecette(listeFr);
        BoxRecette italien = new BoxRecette(listeIt);
        BoxRecette asiatique = new BoxRecette(listeAs);
        BoxRecette fastFood = new BoxRecette(listeFF);
        BoxRecette petitDej = new BoxRecette(listeDej);
        BoxRecette autreCategorie = new BoxRecette(listeAutre);     
        
        fond.setBackground(new Color(204, 255, 204));
		this.add(fond);

        titre.setBackground(new Color(255, 255, 255));
        titre.setFont(new Font("Stencil", 0, 48)); 
    
		fond.add(titre, BorderLayout.NORTH);
		
        jTabbedPane1.setBackground(new Color(255, 255, 255));
        fond.add(jTabbedPane1, BorderLayout.CENTER);

        jTabbedPane1.addTab("Francais", francais);
        jTabbedPane1.addTab("Italien", italien);     
        jTabbedPane1.addTab("Asiatique", asiatique);
        jTabbedPane1.addTab("Fast-food", fastFood);
        jTabbedPane1.addTab("Petit dejeuner", petitDej);
        jTabbedPane1.addTab("Autres", autreCategorie);
        
        setVisible(true);
	}
}
