import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Recette extends JFrame {
	
	public Recette(){
		JPanel fond = new JPanel();
        JLabel titre = new JLabel();
        JTabbedPane jTabbedPane1 = new JTabbedPane();
        JPanel francais = new JPanel();
        JPanel italien = new JPanel();
        JPanel asiatique = new JPanel();
        JPanel fastfood = new JPanel();
        JPanel petitdej = new JPanel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 700));
        
        fond.setBackground(new Color(204, 255, 204));

        titre.setBackground(new Color(255, 255, 255));
        titre.setFont(new Font("Stencil", 0, 48)); 
        titre.setText("RECETTES");

        jTabbedPane1.setBackground(new Color(255, 255, 255));

        francais.setBackground(new Color(255, 255, 255));
        
        jTabbedPane1.addTab("Français", francais);
         
        italien.setBackground(new Color(255, 255, 255));
        
        jTabbedPane1.addTab("Italien", italien);
        
        jTabbedPane1.addTab("Asiatique", asiatique);
        
        jTabbedPane1.addTab("Fast-food", fastfood);
        
        jTabbedPane1.addTab("Petit déjeuner", petitdej);
        
         
	}
	
	
}
