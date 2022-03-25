import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Allergie extends JFrame{
	
		public JPanel panelChoix;
		public JButton	validerButton;
		public AllergiePage2 p2;
		
	public Allergie(){
		
		super("allergies");
		
		//pour le depart
		JLabel titre = new JLabel("ALLERGIES",JLabel.CENTER);
		JLabel allergieTexte = new JLabel("Allergie :");
		JButton yesButton = new JButton("Oui");
		JButton noButton = new JButton("Non");
		validerButton = new JButton();
		JPanel fond = new JPanel(new BorderLayout());
		JPanel centre = new JPanel(new GridBagLayout());
		JPanel panelChoix = new JPanel();
	
		this.setSize(700,700);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		fond.setBackground(new Color(204, 204, 255));
		this.add(fond);
		
		fond.add(centre, BorderLayout.CENTER);
		centre.setBackground(new Color(204, 204, 255));
		
		titre.setFont(new Font("Stencil", 0, 48));
		titre.setBackground(new Color(204, 204, 255));
		fond.add(titre, BorderLayout.NORTH);
		
		allergieTexte.setFont(new java.awt.Font("Stencil", 0, 24));
		allergieTexte.setBackground(new Color(204, 204, 255));
		centre.add(allergieTexte);
		
		yesButton.setBackground(new Color(0, 0, 0));
		yesButton.setFont(new Font("Stencil", 0, 24));
		yesButton.setForeground(new Color(204, 204, 255));
		yesButton.addActionListener(new EcouteurAllergie(this,true));
		centre.add(yesButton);

		noButton.setBackground(new java.awt.Color(0, 0, 0));
		noButton.setFont(new java.awt.Font("Stencil", 0, 24));
		noButton.setForeground(new java.awt.Color(204, 204, 255));
		noButton.addActionListener(new EcouteurAllergie(this, false));
		centre.add(noButton);

		
		
		//panelChoix.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		panelChoix.setBackground(new Color(204, 204, 255));
		fond.add(panelChoix, BorderLayout.SOUTH);
		
		// deuxieme partie
		p2 = new AllergiePage2();
		p2.setSize(700, 700);
		p2.setLocation(0,0);
		p2.setVisible(false);
		panelChoix.add(p2);

		this.setVisible(true);
    }
        
    
