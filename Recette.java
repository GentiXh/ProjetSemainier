import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Recette extends JFrame {
		
	
	public Recette(ProfilUtilisateur profil){ //constructeur
		
		super("Recettes");
		
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
        JPanel bas = new JPanel();
        
        JLabel titre = new JLabel("RECETTES",JLabel.CENTER);
        JButton btnValider = new JButton("Valider mes choix");
        
        
        btnValider.setBackground(new Color(0, 0, 0));
		btnValider.setFont(new Font("Stencil", 0, 24));
		btnValider.setForeground(new Color(204, 255, 204));
		btnValider.addActionListener(new EcouteurValiderRecette(this, profil));
        
        JTabbedPane jTabbedPane1 = new JTabbedPane();
        
        //création des ArrayLists
		TriDeContraintes t = new TriDeContraintes(profil); 
		t.Tri();					 //appel la methode qui fait le tri selon les choix de l'utilisateur pour tout type de recette
        
        //les BoxRecette sont des JPanel
        BoxRecette francais = new BoxRecette(t.getFrancaisList(), profil, t);
        BoxRecette italien = new BoxRecette(t.getItalienList(), profil, t);
        BoxRecette asiatique = new BoxRecette(t.getAsiatiqueList(), profil, t);
        BoxRecette fastFood = new BoxRecette(t.getFastFoodList(), profil, t);
        BoxRecette petitDej = new BoxRecette(t.getPetitDejList(), profil, t);
        BoxRecette autreCategorie = new BoxRecette(t.getAutreCategorieList(), profil, t);
        
        fond.setBackground(new Color(204, 255, 204));
        bas.setBackground(new Color(204, 255, 204));
        
		this.add(fond);

        titre.setBackground(new Color(255, 255, 255));
        titre.setFont(new Font("Stencil", 0, 48)); 
    
		
		fond.add(titre, BorderLayout.NORTH);
		bas.add(btnValider);
		fond.add(bas, BorderLayout.SOUTH);
		
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
