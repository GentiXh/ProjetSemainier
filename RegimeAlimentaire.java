import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;


public class RegimeAlimentaire extends JFrame{
	
	//attributs
	JPanel fond;
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
        fond = new JPanel(new GridBagLayout());   // permet de mettre au centre de la fenetre
        regimeAlimentaire = new JLabel();
        boutonOmnivore = new JButton();
        boutonVegetarian = new JButton();
        boutonVegan = new JButton();
	
      

        fond.setBackground(new Color(255, 204, 204));

        regimeAlimentaire.setBackground(new Color(255, 204, 153));
        regimeAlimentaire.setFont(new Font("Stencil", 0, 48)); 
        regimeAlimentaire.setText("Régime Alimentaire");
        regimeAlimentaire.setVerticalAlignment(javax.swing.SwingConstants.TOP); 

        boutonOmnivore.setBackground(new Color(0, 0, 0));
        boutonOmnivore.setFont(new Font("Stencil", 0, 36));
        boutonOmnivore.setForeground(new Color(255, 204, 204));
        boutonOmnivore.setText("Omnivore");
        
        //écouteur du bouton omnivore
		boutonOmnivore.addActionListener(new EcouteurRegime(this,0));
        
        boutonVegetarian.setBackground(new Color(0, 0, 0));
        boutonVegetarian.setFont(new Font("Stencil", 0, 36)); 
        boutonVegetarian.setForeground(new Color(255, 204, 204));
        boutonVegetarian.setText("Vegetarian");
        
        //écouteur du bouton vegetarian
        boutonVegetarian.addActionListener(new EcouteurRegime(this, 1)); 

        boutonVegan.setBackground(new Color(0, 0, 0));
        boutonVegan.setFont(new Font("Stencil", 0, 36));
        boutonVegan.setForeground(new Color(255, 204, 204));
        boutonVegan.setText("Vegan");
        boutonVegan.addActionListener(new EcouteurRegime(this, 2)); 
				
		this.add(fond);
		fond.add(box);
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
