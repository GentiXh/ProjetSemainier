import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Recette extends JFrame {
	
	public Recette(){
		JPanel fond = new JPanel(new BorderLayout());
        JLabel titre = new JLabel();
        JTabbedPane jTabbedPane1 = new JTabbedPane();
        JPanel francais = new JPanel();
        JPanel italien = new JPanel();
        JPanel asiatique = new JPanel();
        JPanel fastfood = new JPanel();
        JPanel petitdej = new JPanel();
        
       
        //récuperer la taille de l'écran + mettre fenetre au centre de l'ecran  + fermeture
	this.pack();
	Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
	int height = tailleEcran.height;
	int width = tailleEcran.width;
	this.setSize(width/2, height/2);
	this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        fond.setBackground(new Color(204, 255, 204));
		this.add(fond);

        titre.setBackground(new Color(255, 255, 255));
        titre.setFont(new Font("Stencil", 0, 48)); 
        titre.setText("RECETTES");
		fond.add(titre, BorderLayout.NORTH);
		
        jTabbedPane1.setBackground(new Color(255, 255, 255));
        fond.add(jTabbedPane1, BorderLayout.CENTER);

        francais.setBackground(new Color(255, 255, 255));
        
        jTabbedPane1.addTab("Français", francais);
         
        italien.setBackground(new Color(255, 255, 255));
        
        jTabbedPane1.addTab("Italien", italien);
        
        jTabbedPane1.addTab("Asiatique", asiatique);
        
        jTabbedPane1.addTab("Fast-food", fastfood);
        
        jTabbedPane1.addTab("Petit déjeuner", petitdej);
        
         
	}
	
	
}
