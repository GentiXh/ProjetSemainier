import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RecetteV1 extends JFrame {
	
	public RecetteV1(){
		JPanel fond = new JPanel(new BorderLayout());
        JLabel titre = new JLabel("RECETTES",JLabel.CENTER);
        JTabbedPane jTabbedPane1 = new JTabbedPane();
        JPanel francais = new JPanel();
        JPanel italien = new JPanel();
        JPanel asiatique = new JPanel();
        JPanel fastfood = new JPanel();
        JPanel petitdej = new JPanel();
        
        fond.setBackground(new Color(204, 255, 204));
		this.add(fond);

        titre.setBackground(new Color(255, 255, 255));
        titre.setFont(new Font("Stencil", 0, 48)); 
    
		fond.add(titre, BorderLayout.NORTH);
		
        jTabbedPane1.setBackground(new Color(255, 255, 255));
        fond.add(jTabbedPane1, BorderLayout.CENTER);

     
        jTabbedPane1.addTab("Français", francais);
        
        jTabbedPane1.addTab("Italien", italien);
              
        jTabbedPane1.addTab("Asiatique", asiatique);
        
        jTabbedPane1.addTab("Fast-food", fastfood);
        
        jTabbedPane1.addTab("Petit dejeuner", petitdej);
        
        this.setSize(700,700);
		setPreferredSize(new java.awt.Dimension(700, 700));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
	}
	
	
}
