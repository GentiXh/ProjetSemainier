import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Recette extends JFrame {
	
	public Allergie fenAllergie;
	public RegimeAlimentaire fenRegime;
	private ArrayList<String> listeRecetteFrancais;
	private ArrayList<String> listeRecettePetitDej;
	private ArrayList<String> listeRecetteItalien;	
	private ArrayList<String> listeRecetteAsiatique;
	private ArrayList<String> listeRecetteFastFood;
	private ArrayList<String> listeRecetteAutreCategorie;
	public String type;
	private JPanel francais;
	private JPanel italien;
	private JPanel asiatique;
	private JPanel fastFood;
	private JPanel petitDej;
	private JPanel autreCategorie;
	
	
	
	public Recette(ProfilUtilisateur profil){ //constructeur
		
		System.out.println("on passe par recette");

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
        francais = new JPanel();
		italien = new JPanel();
        asiatique = new JPanel();
        fastFood = new JPanel();
        petitDej = new JPanel();
        autreCategorie = new JPanel();
        //fenAllergie= new Allergie();
        fenRegime = new RegimeAlimentaire();
        
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
        // lien avec BD
        listeRecetteFastFood = new ArrayList<String>();
        listeRecetteFrancais = new ArrayList<String>();
        listeRecetteItalien = new ArrayList<String>();
        listeRecetteAsiatique = new ArrayList<String>();
        listeRecetteFastFood = new ArrayList<String>();
        listeRecetteAutreCategorie = new ArrayList<String>();
        listeRecettePetitDej = new ArrayList<String>(); 
		TriDeContraintes t = new TriDeContraintes(profil); 
		t.Tri();
		listeRecetteFrancais = t.getListeFrancais();
		listeRecettePetitDej = t.getListePetitDej();
		listeRecetteItalien= t.listeRecetteItalien;
		listeRecetteAsiatique = t.getListeAsiatique();
		listeRecetteFastFood = t.getListeFastFood();
		listeRecetteAutreCategorie = t.getListeAutreCategorie();
		System.out.println(" gluten recette "+profil.gluten);
		System.out.println(" regime recette "+profil.regime);

        
       	for (int i = 0; i<listeRecetteItalien.size(); i++){ // affichage dans console des repas pour debug
			System.out.println(listeRecetteItalien.get(i));
		}
        
        // faire les checkbox dans chaque "sous fenetre" (cad type)
        //fenRegime.regime, fenAllergie.gluten, fenAllergie.oeuf, fenAllergie.lactose, fenAllergie.arachide, fenAllergie.fodmap

	
	
	}
	
	
}

