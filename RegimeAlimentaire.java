mport java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;


public class RegimeAlimentaire extends JFrame{
	
	//attributs
	JPanel fond;
	JLabel regimeAlimentaire;
	JButton buttonOmnivore;
	JButton buttonVegetarian;
	JButton buttonVegan;
    //Constructeur
    public RegimeAlimentaire() {

        //on definit le nom de la fenetre
        super("Regime Alimentaire");

        //Dimensions de la fenetre graphique et fermeture
        this.setSize(600,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//création des différents éléments de la fenêtre
        fond = new JPanel();
        regimeAlimentaire = new JLabel();
        buttonOmnivore = new JButton();
        buttonVegetarian = new JButton();
        buttonVegan = new JButton();

      

        fond.setBackground(new Color(255, 204, 204));

        regimeAlimentaire.setBackground(new Color(255, 204, 153));
        regimeAlimentaire.setFont(new Font("Stencil", 0, 48)); 
        regimeAlimentaire.setText("Régime Alimentaire");
        regimeAlimentaire.setVerticalAlignment(javax.swing.SwingConstants.TOP); //?

        buttonOmnivore.setBackground(new Color(0, 0, 0));
        buttonOmnivore.setFont(new Font("Stencil", 0, 36));
        buttonOmnivore.setForeground(new Color(255, 204, 204));
        buttonOmnivore.setText("Omnivore");
        
        //écouteur du bouton omnivore
        buttonOmnivore.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOmnivoreActionPerformed(evt);
            }
        });

        buttonVegetarian.setBackground(new Color(0, 0, 0));
        buttonVegetarian.setFont(new Font("Stencil", 0, 36)); 
        buttonVegetarian.setForeground(new Color(255, 204, 204));
        buttonVegetarian.setText("Végétarian");
        
        //écouteur du bouton vegetarian
        buttonVegetarian.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonVegetarianActionPerformed(evt);
            }
        });

        buttonVegan.setBackground(new Color(0, 0, 0));
        buttonVegan.setFont(new Font("Stencil", 0, 36));
        buttonVegan.setForeground(new Color(255, 204, 204));
        buttonVegan.setText("Végan");
        buttonVegan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonVeganActionPerformed(evt);
            }
		});
		
		
		
       
       
        //Rendre la fenêtre visible
        this.setVisible(true);
    }
}
