import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Allergie extends JFrame{
	
	//attributs
	public JButton validerButton;
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
		
	//constructeur	
	public Allergie(ProfilUtilisateur profil){
		
		super("Allergies");
		
		//on initialise tous les elements graphiques (boutons, labels, checkbox etc)
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
        
		//récuperer la taille de l'écran + mettre fenetre au centre de l'ecran  + fermeture
		this.pack();
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		int height = tailleEcran.height;
		int width = tailleEcran.width;
		this.setSize(width/2, height/2);
		this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//par defaut l'utilisateur n'a pas d'allergie donc les boolean allergenes sont tous 'false'
		//ces valeurs sont gardees telles quelles si l'utilisateur appuie sur "Non" a "Allergie: "
		profil.setGluten(false);
		profil.setLactose(false);
		profil.setArachide(false);
		profil.setFodmap(false);
		profil.setOeuf(false);
		
		//mise en couleur du fond
		fond.setBackground(new Color(204, 204, 255));
		this.add(fond);
		
		//mise en forme + affichage + ajout des elements graphiques de base
		fond.add(centre, BorderLayout.CENTER);
		centre.setBackground(new Color(204, 204, 255));
		
		titre.setFont(new Font("Stencil", 0, 48));
		titre.setBackground(new Color(204, 204, 255));
		fond.add(titre, BorderLayout.NORTH);
		
		allergieTexte.setFont(new java.awt.Font("Stencil", 0, 24));
		allergieTexte.setBackground(new Color(204, 204, 255));
		centre.add(allergieTexte);
		
		//creation des boutons 'oui' et 'non' d'allergies + mise en forme + ajout +affichage + lien avec leur ecouteur
		yesButton.setBackground(new Color(0, 0, 0));
		yesButton.setFont(new Font("Stencil", 0, 24));
		yesButton.setForeground(new Color(204, 204, 255));
		yesButton.addActionListener(new EcouteurAllergie(this,true, profil));
		centre.add(yesButton);

		noButton.setBackground(new java.awt.Color(0, 0, 0));
		noButton.setFont(new java.awt.Font("Stencil", 0, 24));
		noButton.setForeground(new java.awt.Color(204, 204, 255));
		noButton.addActionListener(new EcouteurAllergie(this, false, profil));
		centre.add(noButton);
		
		//creation + mise en forme + ajout  bouton pour valider choix allergies qui n'est pas affiche au depart
		validerButton.setBackground(new Color(0, 0, 0));
		validerButton.setFont(new Font("Stencil", 0, 24));
		validerButton.setForeground(new Color(204, 204, 255));
		fond.add(validerButton, BorderLayout.SOUTH);
		validerButton.addActionListener(new EcouteurValiderAllergie(this,profil));
		validerButton.setVisible(false); 
			
		// ajout + mise en forme des checkbox qui ne sont pas affichees au depart			
		centre.add(glutenBox);
		centre.add(lactoseBox);
		centre.add(arachideBox);
		centre.add(fodmapBox);
		centre.add(oeufBox);
	
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
	
		glutenBox.setVisible(false);
		lactoseBox.setVisible(false);
		arachideBox.setVisible(false);
		fodmapBox.setVisible(false);
		oeufBox.setVisible(false);
		
		//lien entre les checkbox et l'ecouteur pour choix d'allergene
		/* les numeros permettent de distinguer quelle case est cochee dans l'ecouteur*/
		glutenBox.addActionListener(new EcouteurAllergie2(this, 1, profil));
		lactoseBox.addActionListener(new EcouteurAllergie2(this, 2, profil));
		arachideBox.addActionListener(new EcouteurAllergie2(this, 3, profil));
		fodmapBox.addActionListener(new EcouteurAllergie2(this, 4, profil));
		oeufBox.addActionListener(new EcouteurAllergie2(this, 5, profil));
		
		//affichage de la fenetre
		this.setVisible(true);
    }
}
