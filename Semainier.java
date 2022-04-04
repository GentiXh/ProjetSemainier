import java.awt.*;    
import javax.swing.*;    
    
public class Semainier{    
	JFrame frameObj;    
  
	// constructeur  
	public Semainier(){    
		frameObj = new JFrame();    		 

		JPanel case1 = new JPanel(new BorderLayout()); 
		JPanel case2 = new JPanel(new BorderLayout());   
		JPanel case3 = new JPanel(new BorderLayout());    
		JPanel case4 = new JPanel(new BorderLayout());     
		JPanel case5 = new JPanel(new BorderLayout());    
		JPanel case6 = new JPanel(new BorderLayout());    
		JPanel case7 = new JPanel(new BorderLayout());     
		JPanel case8 = new JPanel(new BorderLayout());    
		case8.setBackground(new Color(192, 192, 192));
		 
		case1.setBorder(BorderFactory.createLineBorder(Color.black));
		case2.setBorder(BorderFactory.createLineBorder(Color.black));
		case3.setBorder(BorderFactory.createLineBorder(Color.black));
		case4.setBorder(BorderFactory.createLineBorder(Color.black));
		case5.setBorder(BorderFactory.createLineBorder(Color.black));
		case6.setBorder(BorderFactory.createLineBorder(Color.black));
		case7.setBorder(BorderFactory.createLineBorder(Color.black));
		case8.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JPanel fondLundi = new JPanel();
		JPanel fondMardi = new JPanel();
		JPanel fondMercredi = new JPanel();
		JPanel fondJeudi = new JPanel();
		JPanel fondVendredi = new JPanel();
		JPanel fondSamedi = new JPanel();
		JPanel fondDimanche = new JPanel();
		 
		fondLundi.setBorder(BorderFactory.createLineBorder(Color.black));
		fondMardi.setBorder(BorderFactory.createLineBorder(Color.black));
		fondMercredi.setBorder(BorderFactory.createLineBorder(Color.black));
		fondJeudi.setBorder(BorderFactory.createLineBorder(Color.black));
		fondVendredi.setBorder(BorderFactory.createLineBorder(Color.black));
		fondSamedi.setBorder(BorderFactory.createLineBorder(Color.black));
		fondDimanche.setBorder(BorderFactory.createLineBorder(Color.black));

		fondLundi.setBackground(new Color(255, 153, 153));
		fondMardi.setBackground(new Color(255, 204, 153));
		fondMercredi.setBackground(new Color(255, 255, 153));
		fondJeudi.setBackground(new Color(204, 255, 153));
		fondVendredi.setBackground(new Color(153, 255, 153));
		fondSamedi.setBackground(new Color(153, 255, 204));
		fondDimanche.setBackground(new Color(153, 255, 255));
		
		JLabel lundi = new JLabel("LUNDI");
		JLabel mardi = new JLabel("MARDI");
		JLabel mercredi = new JLabel("MERCREDI");
		JLabel jeudi = new JLabel("JEUDI");
		JLabel vendredi = new JLabel("VENDREDI");
		JLabel samedi = new JLabel("SAMEDI");
		JLabel dimanche = new JLabel("DIMANCHE");
		JLabel logo = new JLabel("HAPPYFRIGO", JLabel.CENTER);
		 
		lundi.setFont(new Font("Stencil", 0, 24));
		mardi.setFont(new Font("Stencil", 0, 24));
		mercredi.setFont(new Font("Stencil", 0, 24));
		jeudi.setFont(new Font("Stencil", 0, 24));
		vendredi.setFont(new Font("Stencil", 0, 24));
		samedi.setFont(new Font("Stencil", 0, 24));
		dimanche.setFont(new Font("Stencil", 0, 24));
		logo.setFont(new Font("Stencil", 0, 48));
		
		fondLundi.add(lundi);
		fondMardi.add(mardi); 
		fondMercredi.add(mercredi);
		fondJeudi.add(jeudi);
		fondVendredi.add(vendredi);
		fondSamedi.add(samedi);
		fondDimanche.add(dimanche);
		
		case1.add(fondLundi,BorderLayout.NORTH);
		case2.add(fondMardi,BorderLayout.NORTH);
		case3.add(fondMercredi,BorderLayout.NORTH);
		case4.add(fondJeudi,BorderLayout.NORTH);
		case5.add(fondVendredi,BorderLayout.NORTH);
		case6.add(fondSamedi,BorderLayout.NORTH);
		case7.add(fondDimanche,BorderLayout.NORTH);
		case8.add(logo,BorderLayout.CENTER);


		frameObj.add(case1); 
		frameObj.add(case2); 
		frameObj.add(case3);  
		frameObj.add(case4); 
		frameObj.add(case5); 
		frameObj.add(case6);  
		frameObj.add(case7); 
		frameObj.add(case8); 
		  
		// setting the grid layout using the parameterless constructor    
		frameObj.setLayout(new GridLayout(2,4));    
		  
		  
		frameObj.setSize(700, 700);    
		frameObj.setVisible(true);    
	}
}  
