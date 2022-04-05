import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Accueil extends JFrame{
	
	//attributs
	JButton boutonGO;
	JLabel titre;

    //Constructeur
    public Accueil() {

        //on definit le nom de la fenetre
        super("Happy frigo");

        //récuperer la taille de l'écran + mettre fenetre au centre de l'ecran  + fermeture
	this.pack();
	Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
	int height = tailleEcran.height;
	int width = tailleEcran.width;
	this.setSize(width/2, height/2);
	this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	boutonGO = new JButton("GO!");
	boutonGO.setBackground(new Color(0, 0, 0));
        boutonGO.setFont(new Font("Stencil", 0, 48)); 
        boutonGO.setForeground(new Color(255, 255, 204));
        boutonGO.setText("GO!");
             
	titre = new JLabel("HAPPY FRIGO");
		
	titre.setFont(new Font("Stencil", 0, 48)); 
        titre.setText("HAPPY FRI");
        
	JPanel fond = new JPanel(new GridBagLayout());
	fond.setBackground( new Color(135,206,250));
		
		
	GridBagConstraints c= new GridBagConstraints();
		
		
	// branchement de l'écouteur
	boutonGO.addActionListener(new EcouteurAccueil(this));

          
        //ajout du conteneur principal dans la fenetre
        this.add(fond);


        //Ajout des éléments graphiques au conteneur principal		
		
	fond.add(titre);
	fond.add(boutonGO);
		
		
        //Rendre la fenêtre visible
        this.setVisible(true);
    }
}
