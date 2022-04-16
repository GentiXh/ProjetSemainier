import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;


public class RegimeAlimentaire extends JFrame{
	
	//attributs
	JPanel fond;
	JPanel fond2;
	JLabel regimeAlimentaire;
	JButton boutonOmnivore;
	JButton boutonVegetarian;
	JButton boutonVegan;
	int regime;
	Box box = Box.createVerticalBox(); // permet d'aligner verticalement les jpanel
    public ProfilUtilisateur profil;
    
    
    
    //Constructeur
    public RegimeAlimentaire() {

        //on definit le nom de la fenetre
        super("Regime Alimentaire");

        System.out.println("on passe par regime allimentaire");

		//récuperer la taille de l'écran + mettre fenetre au centre de l'ecran  + fermeture
		this.pack();
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		int height = tailleEcran.height;
		int width = tailleEcran.width;
		this.setSize(width/2, height/2);
		this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//création des différents éléments de la fenêtre
        fond = new JPanel(new BorderLayout());  
        fond2 = new JPanel(new GridBagLayout()); // permet de mettre au centre de la fenetre
        regimeAlimentaire = new JLabel("Regime Alimentaire",JLabel.CENTER);
        boutonOmnivore = new JButton("Omnivore");
        boutonVegetarian = new JButton("Vegetarian");
        boutonVegan = new JButton("Vegan");
		
		profil = new ProfilUtilisateur();
      

        fond.setBackground(new Color(255, 204, 204));
        fond2.setBackground(new Color(255, 204, 204));

        regimeAlimentaire.setBackground(new Color(255, 204, 153));
        regimeAlimentaire.setFont(new Font("Stencil", 0, 48)); 
        regimeAlimentaire.setVerticalAlignment(javax.swing.SwingConstants.TOP); 
        

        boutonOmnivore.setBackground(new Color(0, 0, 0));
        boutonOmnivore.setFont(new Font("Stencil", 0, 36));
        boutonOmnivore.setForeground(new Color(255, 204, 204));
        boutonOmnivore.addActionListener(new EcouteurRegime(this,0, profil));
        
        boutonVegetarian.setBackground(new Color(0, 0, 0));
        boutonVegetarian.setFont(new Font("Stencil", 0, 36)); 
        boutonVegetarian.setForeground(new Color(255, 204, 204));
        boutonVegetarian.addActionListener(new EcouteurRegime(this, 1,profil)); 

        boutonVegan.setBackground(new Color(0, 0, 0));
        boutonVegan.setFont(new Font("Stencil", 0, 36));
        boutonVegan.setForeground(new Color(255, 204, 204));
        boutonVegan.addActionListener(new EcouteurRegime(this, 2,profil)); 
				
		this.add(fond);
		fond.add(fond2, BorderLayout.CENTER);
		fond2.add(box);
		fond.add(regimeAlimentaire, BorderLayout.NORTH);
		box.add(boutonOmnivore);
		box.add(boutonVegetarian);
		box.add(boutonVegan);
       
       //Rendre la fenêtre visible
        this.setVisible(true);

	}
    // met à jour le regime
    public void setRegime(int val){
		regime=val;
	}
}
