import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AllergiePage2 extends JPanel{
	
	public boolean valide= false;
    public AllergiePage2() {
		JButton jButton1 = new JButton();
        JPanel contenu = new JPanel();
        JCheckBox glutenBox = new JCheckBox();
        JCheckBox lactoseBox = new JCheckBox();
        JCheckBox arachideBox = new JCheckBox();
        JCheckBox foodmapBox = new JCheckBox();
        JCheckBox oeufBox = new JCheckBox();
        JCheckBox autresBox = new JCheckBox();

        jButton1.setText("jButton1");

        setBackground(new Color(204, 204, 255));

        contenu.setBackground(new Color(204, 204, 255));

        glutenBox.setFont(new Font("Stencil", 0, 36)); 
        glutenBox.setText("Gluten");
        
        glutenBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                glutenBoxActionPerformed(evt);
            }
        });

        lactoseBox.setFont(new Font("Stencil", 0, 36)); 
        lactoseBox.setText("Lactose");
        lactoseBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lactoseBoxActionPerformed(evt);
            }
        });

        arachideBox.setFont(new Font("Stencil", 0, 36));
        arachideBox.setText("Arachide");

        foodmapBox.setFont(new Font("Stencil", 0, 36)); 
        foodmapBox.setText("Foodmap");
        foodmapBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodmapBoxActionPerformed(evt);
            }
        });

        oeufBox.setFont(new Font("Stencil", 0, 36));
        oeufBox.setText("Oeuf");
        oeufBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oeufBoxActionPerformed(evt);
            }
        });

        autresBox.setFont(new Font("Stencil", 0, 36)); 
        autresBox.setText("Autres");
		
	}
	
	 private void glutenBoxActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }   
    
    private void lactoseBoxActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void oeufBoxActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void foodmapBoxActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }           
    
	
}
