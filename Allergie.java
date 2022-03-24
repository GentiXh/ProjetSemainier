import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Allergie extends JFrame{
	
	public Allergie(){
		JPanel panelAllergie = new JPanel();
		JLabel titre = new JLabel();
		JLabel allergieTexte = new JLabel();
		JButton yesButton = new JButton();
		JButton noButton = new JButton();
		JPanel panelChoix = new JPanel();
		JButton	validerButton = new JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		panelAllergie.setBackground(new Color(204, 204, 255));

		titre.setFont(new Font("Stencil", 0, 48));
		titre.setText("ALLERGIES");

		allergieTexte.setFont(new java.awt.Font("Stencil", 0, 24));
		allergieTexte.setText("Allergie :");

		yesButton.setBackground(new Color(0, 0, 0));
		yesButton.setFont(new Font("Stencil", 0, 24));
		yesButton.setForeground(new Color(204, 204, 255));
		yesButton.setText("Oui");
		yesButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					yesButtonActionPerformed(evt);
				}
			});

		noButton.setBackground(new java.awt.Color(0, 0, 0));
		noButton.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
		noButton.setForeground(new java.awt.Color(204, 204, 255));
		noButton.setText("Non");
		noButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					noButtonActionPerformed(evt);
				}
			});

		panelChoix.setBackground(new Color(204, 204, 255));
			
		validerButton.setBackground(new Color(0, 0, 0));
		validerButton.setFont(new Font("Stencil", 0, 36));
		validerButton.setForeground(new Color(204, 204, 255));
		validerButton.setText("Valider");
	}
        
    private void yesButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        AllergiePage2 p2 = new AllergiePage2();
        p2.setSize(700, 270);
        p2.setLocation(0,0);
        panelChoix.removeAll();
        panelChoix.add(p2, BorderLayout.CENTER);
        panelChoix.add(p2); 
        panelChoix.revalidate();
        panelChoix.repaint(); 
        validerButton.hide();
      
    }    
    
    private void noButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Recette f = new Recette();
        f.setVisible(true);
        
        //pour cacher l'ancienne fenêtre
        this.hide();
    }      
        
}
