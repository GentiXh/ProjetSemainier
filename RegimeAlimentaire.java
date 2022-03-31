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
    
    //Constructeur
    public RegimeAlimentaire() {

        //on definit le nom de la fenetre
        super("Regime Alimentaire");

        //Dimensions de la fenetre graphique et fermeture
        this.setSize(700,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//création des différents éléments de la fenêtre
        fond = new JPanel(new BorderLayout());  
        fond2 = new JPanel(new GridBagLayout()); // permet de mettre au centre de la fenetre
        regimeAlimentaire = new JLabel("Regime Alimentaire",JLabel.CENTER);
        boutonOmnivore = new JButton("Omnivore");
        boutonVegetarian = new JButton("Vegetarian");
        boutonVegan = new JButton("Vegan");
	
      

        fond.setBackground(new Color(255, 204, 204));
        fond2.setBackground(new Color(255, 204, 204));

        regimeAlimentaire.setBackground(new Color(255, 204, 153));
        regimeAlimentaire.setFont(new Font("Stencil", 0, 48)); 
        regimeAlimentaire.setVerticalAlignment(javax.swing.SwingConstants.TOP); 
        

        boutonOmnivore.setBackground(new Color(0, 0, 0));
        boutonOmnivore.setFont(new Font("Stencil", 0, 36));
        boutonOmnivore.setForeground(new Color(255, 204, 204));
        
        //écouteur du bouton omnivore
		boutonOmnivore.addActionListener(new EcouteurRegime(this,0));
        
        boutonVegetarian.setBackground(new Color(0, 0, 0));
        boutonVegetarian.setFont(new Font("Stencil", 0, 36)); 
        boutonVegetarian.setForeground(new Color(255, 204, 204));
        
        //écouteur du bouton vegetarian
        boutonVegetarian.addActionListener(new EcouteurRegime(this, 1)); 

        boutonVegan.setBackground(new Color(0, 0, 0));
        boutonVegan.setFont(new Font("Stencil", 0, 36));
        boutonVegan.setForeground(new Color(255, 204, 204));
        boutonVegan.addActionListener(new EcouteurRegime(this, 2)); 
				
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
