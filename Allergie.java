import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Allergie extends JFrame{
	
		public JButton	validerButton;
		public JPanel centre;
		public JButton noButton;
		public JButton yesButton;
		public JCheckBox glutenBox;
		public JCheckBox lactoseBox;
		public JCheckBox arachideBox;
		public JCheckBox fodmapBox;
		public JCheckBox oeufBox;
		public JCheckBox autresBox;
		public JLabel allergieTexte;
		public boolean gluten;
		public boolean lactose;
		public boolean arachide;
		public boolean fodmap;
		public boolean oeuf;
		public boolean autres;

		
		
		
	public Allergie(){
		
		super("allergies");
		
		//pour le depart
		JLabel titre = new JLabel("ALLERGIES",JLabel.CENTER);
		allergieTexte = new JLabel("Allergie :");
		yesButton = new JButton("Oui");
		noButton = new JButton("Non");
		validerButton = new JButton("Valider");
		JPanel fond = new JPanel(new BorderLayout()); 
		centre = new JPanel(new GridBagLayout()); 
		glutenBox = new JCheckBox("Gluten");
        lactoseBox = new JCheckBox("Lactose");
        arachideBox = new JCheckBox("Arachide");
        fodmapBox = new JCheckBox("Fodmap");
        oeufBox = new JCheckBox("Oeuf");
        autresBox = new JCheckBox("Autres");
        
		//récuperer la taille de l'écran + mettre fenetre au centre de l'ecran  + fermeture
		this.pack();
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		int height = tailleEcran.height;
		int width = tailleEcran.width;
		this.setSize(width/2, height/2);
		this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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

		validerButton.setBackground(new Color(0, 0, 0));
		validerButton.setFont(new Font("Stencil", 0, 24));
		validerButton.setForeground(new Color(204, 204, 255));
		fond.add(validerButton, BorderLayout.SOUTH);
		validerButton.addActionListener(new EcouteurValiderAllergie(this));
		validerButton.setVisible(false); 
		
				
		// deuxieme partie
				
		centre.add(glutenBox);
		centre.add(lactoseBox);
		centre.add(arachideBox);
		centre.add(fodmapBox);
		centre.add(oeufBox);
		centre.add(autresBox);
	
		glutenBox.setFont(new java.awt.Font("Stencil", 0, 20));
		glutenBox.setBackground(new Color(204, 204, 255));
		arachideBox.setFont(new java.awt.Font("Stencil", 0, 20));
		arachideBox.setBackground(new Color(204, 204, 255));
		lactoseBox.setFont(new java.awt.Font("Stencil", 0, 20));
		lactoseBox.setBackground(new Color(204, 204, 255));
		oeufBox.setFont(new java.awt.Font("Stencil", 0, 20));
		oeufBox.setBackground(new Color(204, 204, 255));
		fodmapBox.setFont(new java.awt.Font("Stencil", 0, 20));
		fodmapBox.setBackground(new Color(204, 204, 255));
		autresBox.setFont(new java.awt.Font("Stencil", 0, 20));
		autresBox.setBackground(new Color(204, 204, 255));
	
		
		glutenBox.setVisible(false);
		lactoseBox.setVisible(false);
		arachideBox.setVisible(false);
		fodmapBox.setVisible(false);
		oeufBox.setVisible(false);
		autresBox.setVisible(false);
		
		glutenBox.addActionListener(new EcouteurAllergie2(this,1));
		lactoseBox.addActionListener(new EcouteurAllergie2(this,2));
		arachideBox.addActionListener(new EcouteurAllergie2(this,3));
		fodmapBox.addActionListener(new EcouteurAllergie2(this,4));
		oeufBox.addActionListener(new EcouteurAllergie2(this,5));
		autresBox.addActionListener(new EcouteurAllergie2(this,6));


		// par defaut l'utilisateur n'a pas d'allergies (boolean =false)
		gluten = false;
		lactose = false;
		arachide = false;
		fodmap = false;
		oeuf = false;
		autres = false;
		
		
		this.setVisible(true);
    }
   }