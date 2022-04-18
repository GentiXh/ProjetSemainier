import java.awt.*;    
import javax.swing.*;    
    
public class Semainier extends JFrame{      
  
	// constructeur  
	public Semainier(ProfilUtilisateur p){     		 
		
		//récuperer la taille de l'écran + mettre fenetre au centre de l'ecran  + fermeture
		this.pack();
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		int height = tailleEcran.height;
		int width = tailleEcran.width;
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
        //création des différentes cases du planning
        Case jourLundi = new Case("LUNDI", new Color(255, 153, 153));
        Case jourMardi = new Case("MARDI", new Color(255, 204, 153));
        Case jourMercredi = new Case("MERCREDI", new Color(255, 255, 153));
        Case jourJeudi = new Case("JEUDI", new Color(204, 255, 153));
        Case jourVendredi = new Case("VENDREDI", new Color(153, 255, 153));
        Case jourSamedi = new Case("SAMEDI", new Color(153, 255, 204));
        Case jourDimanche = new Case("DIMANCHE", new Color(153, 255, 255));
        
        //création de la dernière case qui contiendra le logo d'happyfrigo
        JPanel case8 = new JPanel(new BorderLayout());    
		case8.setBackground(new Color(192, 192, 192));
		case8.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel logo = new JLabel("HAPPYFRIGO", JLabel.CENTER);
		logo.setFont(new Font("Stencil", 0, 48));
		case8.add(logo,BorderLayout.CENTER);
		
       //on set notre fenêtre en gridLayout pour avoir la disposition en forme de cases désirée     
		this.setLayout(new GridLayout(2,4));
		
		// ajout des cases à la fenêtre
		this.add(jourLundi); 
		this.add(jourMardi); 
		this.add(jourMercredi);  
		this.add(jourJeudi); 
		this.add(jourVendredi); 
		this.add(jourSamedi);  
		this.add(jourDimanche); 
		this.add(case8); 
		 
		//affichage de la fenetre 
		this.setVisible(true); 
	}
}  
