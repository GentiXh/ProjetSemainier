import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Accueil extends JFrame{
	
	//attributs
	JButton boutonGO;
	JLabel titre;

    //Constructeur
    public Accueil() {

        //on definit le nom de la fenetre
        super("Happy frigo");

        //Dimensions de la fenetre graphique et fermeture
        this.setSize(700,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
		boutonGO = new JButton("GO!");
		boutonGO.setBackground(new Color(0, 0, 0));
        boutonGO.setFont(new Font("Stencil", 0, 48)); 
        boutonGO.setForeground(new Color(255, 255, 204));
        boutonGO.setText("GO!");
        
        /* public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGOActionPerformed(evt);
            }
        }); */
        
		titre = new JLabel("HAPPY FRIGO");
		
		titre.setFont(new Font("Stencil", 0, 48)); 
        titre.setText("HAPPY FRI");
        
		JPanel fond = new JPanel(new GridBagLayout());
		fond.setBackground( new Color(135,206,250));
		
		
		GridBagConstraints c= new GridBagConstraints();
		
		
		// branchement de l'écouteur
		//boutonGO.addActionListener(new EcouteurClic(this));

          
        //ajout du conteneur principal dans la fenetre
        this.add(fond);


        //Ajout des éléments graphiques au conteneur principal		
		
		fond.add(titre);
		fond.add(boutonGO);
		
		
        //Rendre la fenêtre visible
        this.setVisible(true);
    }
}

/*private void buttonGOActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        RegimeAlimentaire f = new RegimeAlimentaire();
        f.setVisible(true);
        
        //pour cacher l'ancienne fenêtre
        this.hide();
    }      
    * */
