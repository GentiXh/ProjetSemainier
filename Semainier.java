import java.awt.*;    
import javax.swing.*;    
    
public class Semainier extends JFrame{      
  
	private ProfilUtilisateur profil;
	
	// constructeur  
	public Semainier(ProfilUtilisateur p){ 
		    		 
		super("Planning de la semaine");
		
		profil = p;
		
		//récuperer la taille de l'écran + mettre fenetre au centre de l'ecran  + fermeture
		this.pack();
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		int height = tailleEcran.height;
		int width = tailleEcran.width;
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
        //création des différentes cases du planning
        Case jourLundi = new Case(profil, "LUNDI", new Color(255, 153, 153));
        Case jourMardi = new Case(profil,"MARDI", new Color(255, 204, 153));
        Case jourMercredi = new Case(profil,"MERCREDI", new Color(255, 255, 153));
        Case jourJeudi = new Case(profil,"JEUDI", new Color(204, 255, 153));
        Case jourVendredi = new Case(profil,"VENDREDI", new Color(153, 255, 153));
        Case jourSamedi = new Case(profil,"SAMEDI", new Color(153, 255, 204));
        Case jourDimanche = new Case(profil,"DIMANCHE", new Color(153, 255, 255));
            
        //création de la dernière case qui contiendra le logo d'happyfrigo
        JPanel case8 = new JPanel(new BorderLayout());  
        JPanel milieu = new JPanel();  
        //milieu.setLayout(new GridLayout(2,1));  
		case8.setBackground(new Color(192, 192, 192));
		milieu.setBackground(new Color(192, 192, 192));
		case8.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel question = new JLabel("Une liste de courses ?", JLabel.CENTER);
		question.setFont(new Font("Stencil", 0, 40));
		case8.add(question,BorderLayout.NORTH);
		
		JLabel logo = new JLabel("HAPPYFRIGO " , JLabel.CENTER);
		logo.setFont(new Font("Stencil", 0, 48));
		case8.add(logo,BorderLayout.SOUTH);
		
		JButton btnCourses = new JButton("C'est par ici !");
		btnCourses.setBackground(new Color(51, 51, 51));
		btnCourses.setFont(new Font("Stencil", 0, 40));
		btnCourses.setForeground(new Color(204, 204, 255));
		btnCourses.addActionListener(new EcouteurValiderSemainier(this,profil));

		milieu.add(btnCourses);
		
		case8.add(milieu,BorderLayout.CENTER);
		
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
