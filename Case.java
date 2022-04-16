import java.awt.*;    
import javax.swing.*;    
    
public class Case extends JPanel{    
	    
	// constructeur  
	public Case(String jour, Color couleur){
				
		super(new BorderLayout());
		
		//contour noir de la case
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		// JPanel NORTH et CENTER de chaque case
		JPanel fondJour = new JPanel();
		JPanel recette = new JPanel();
		
		//on nomme la case
		JLabel jourJ = new JLabel(jour);
		
		//police de caractere
		jourJ.setFont(new Font("Stencil", 0, 24));
		
		//contour noir de chaque JPanel nom
		fondJour.setBorder(BorderFactory.createLineBorder(Color.black));
		
		//mise en couleur du fondJour avec la couleur passée dans le constructeur
		fondJour.setBackground(couleur); 
		
		//ajout du JLabel (nom du jour) à son fond (JPanel)
		fondJour.add(jourJ);
		
		//ajout de fondJour dans la case
		this.add(fondJour,BorderLayout.NORTH);
		
		recette.setLayout(new GridLayout(3,1));
		
		//création des différents sous panels qui iront dans le panel recette
		JPanel casePetitDej = new JPanel(new BorderLayout()); 
		JPanel caseDej = new JPanel(new BorderLayout());   
		JPanel caseDiner = new JPanel(new BorderLayout()); 
		
		//création des différents labels soulignés qui iront dans les sous panels du panel recette
		JLabel petitDej = new JLabel("<HTML><U>PETIT-DEJEUNER</U></HTML>",JLabel.CENTER);
		JLabel dejeuner = new JLabel("<HTML><U>DEJEUNER</U></HTML>",JLabel.CENTER);
		JLabel diner = new JLabel("<HTML><U>DINER</U></HTML>",JLabel.CENTER);
		
		//set d'une nouvelle police de caractère
		petitDej.setFont(new Font("Stencil", 0, 18));
		dejeuner.setFont(new Font("Stencil", 0, 18));
		diner.setFont(new Font("Stencil", 0, 18));
		
		//ajout des labels à leurs panels respectifs
		casePetitDej.add(petitDej,BorderLayout.NORTH);
		caseDej.add(dejeuner,BorderLayout.NORTH);
		caseDiner.add(diner,BorderLayout.NORTH);
		
		//ajout des différents sous panels dans le grand panel recette
		recette.add(casePetitDej);
		recette.add(caseDej);
		recette.add(caseDiner);
		
		//ajout du panel recette dans ma case
		this.add(recette,BorderLayout.CENTER); 
	}
}  
