import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Recette extends JFrame {
	
	//Panneaux d'affichages selon le type du plat
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
        
        //creation + appel d'une instance de tri qui permet de choisir les recettes correspondantes aux choix de l'utilisateur.
        //l'instance profil du ProfilUtilisateur passee en parametre a travers toute la chaine sequentielle des classes depuis RegimeAlimentaires jusqu'a ici, et puis finallement a TriDeContraintes
		TriDeContraintes t = new TriDeContraintes(profil); 
		t.Tri();					  //appel la methode qui fait le tri selon les choix de l'utilisateur pour tout "type" de recette
		
		//codes qui affichent le regime et la valeur du gluten sur la console depuis cette classe. A utiliser si besoin de debug
		/**System.out.println(" gluten recette "+profil.gluten);*/
		/**System.out.println(" regime recette "+profil.regime);*/

        System.out.print("\nRecettes Petit dejeuner: ");
		for (int i = 0; i<t.getPetitDejList().size(); i++){ // affichage dans console des repas pour debug
			if (i==t.getPetitDejList().size()-1){
				System.out.print(t.getPetitDejList().get(i));
			}
			else{
				System.out.print(t.getPetitDejList().get(i)+", ");
			}
		}
		
		System.out.print("\nRecettes Francaises: ");
		for (int i = 0; i<t.getFrancaisList().size(); i++){ // affichage dans console des repas pour debug
			if (i==t.getFrancaisList().size()-1){
				System.out.print(t.getFrancaisList().get(i));
			}
			else{
				System.out.print(t.getFrancaisList().get(i)+", ");
			}
		}
		
		System.out.print("\nRecettes Italiennes: ");
		for (int i = 0; i<t.getItalienList().size(); i++){ // affichage dans console des repas pour debug
			if (i==t.getItalienList().size()-1){
				System.out.print(t.getItalienList().get(i));
			}
			else{
				System.out.print(t.getItalienList().get(i)+", ");
			}
		}
		
		System.out.print("\nRecettes Asiatiques: ");
		for (int i = 0; i<t.getAsiatiqueList().size(); i++){ // affichage dans console des repas pour debug
			if (i==t.getAsiatiqueList().size()-1){
				System.out.print(t.getAsiatiqueList().get(i));
			}
			else{
				System.out.print(t.getAsiatiqueList().get(i)+", ");
			}
		}
		
		System.out.print("\nRecettes Fast-Food: ");
		for (int i = 0; i<t.getFastFoodList().size(); i++){ // affichage dans console des repas pour debug
			if (i==t.getFastFoodList().size()-1){
				System.out.print(t.getFastFoodList().get(i));
			}
			else{
				System.out.print(t.getFastFoodList().get(i)+", ");
			}
		}
		
		System.out.print("\nRecettes Autres categories: ");
		for (int i = 0; i<t.getAutreCategorieList().size(); i++){ // affichage dans console des repas pour debug
			if (i==t.getAutreCategorieList().size()-1){
				System.out.print(t.getAutreCategorieList().get(i));
			}
			else{
				System.out.print(t.getAutreCategorieList().get(i)+", ");
			}
		}
	}
}
