import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AllergiePage2 extends JPanel{
	
	public boolean valide= false;
	
    public AllergiePage2() {
			
		JButton jButton1 = new JButton();
        JPanel contenu = new JPanel(new GridBagLayout());
        JCheckBox glutenBox = new JCheckBox();
        JCheckBox lactoseBox = new JCheckBox();
        JCheckBox arachideBox = new JCheckBox();
        JCheckBox fodmapBox = new JCheckBox();
        JCheckBox oeufBox = new JCheckBox();
        JCheckBox autresBox = new JCheckBox();

		this.setSize(700,700);


        jButton1.setText("jButton1");

        setBackground(new Color(204, 204, 255));
		
        contenu.setBackground(new Color(204, 204, 255));
        this.add(contenu);

        glutenBox.setFont(new Font("Stencil", 0, 36)); 
        glutenBox.setText("Gluten");
        glutenBox.setBackground(new Color(204, 204, 255));
        contenu.add(glutenBox);
        
        glutenBox.addActionListener(new EcouteurAllergie2());

        lactoseBox.setFont(new Font("Stencil", 0, 36)); 
        lactoseBox.setText("Lactose");
        contenu.add(lactoseBox);
        lactoseBox.setBackground(new Color(204, 204, 255));
        lactoseBox.addActionListener(new EcouteurAllergie2());
       

        arachideBox.setFont(new Font("Stencil", 0, 36));
        arachideBox.setText("Arachide");
        contenu.add(arachideBox);
        arachideBox.setBackground(new Color(204, 204, 255));

        fodmapBox.setFont(new Font("Stencil", 0, 36)); 
        fodmapBox.setText("Fodmap");
        contenu.add(fodmapBox);
		fodmapBox.setBackground(new Color(204, 204, 255));
		
		fodmapBox.addActionListener(new EcouteurAllergie2());

        oeufBox.setFont(new Font("Stencil", 0, 36));
        oeufBox.setText("Oeuf");
        contenu.add(oeufBox);
        oeufBox.setBackground(new Color(204, 204, 255));
        
		oeufBox.addActionListener(new EcouteurAllergie2());    

        autresBox.setFont(new Font("Stencil", 0, 36)); 
        autresBox.setText("Autres");
        contenu.add(autresBox);
        autresBox.setBackground(new Color(204, 204, 255));

		
		
	}
	
	
	/* private void glutenBoxActionPerformed(ActionEvent evt) {                                          
        // TODO add your handling code here:
    }   
    
    private void lactoseBoxActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void oeufBoxActionPerformed(ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void foodmapBoxActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
    }   */        
    
	
}

