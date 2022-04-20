import java.awt.*;    
import javax.swing.*;    
    
public class Case extends JPanel{    
	
	
	// constructeur  
	public Case(ProfilUtilisateur p, String jour, Color couleur){
				
		super(new BorderLayout());
		
		//contour noir de la case
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		// JPanel NORTH et CENTER de chaque case
		JPanel fondJour = new JPanel();
		JPanel recette = new JPanel();
		
		//on nomme la case
		JLabel jourJ = new JLabel(jour);
		
		//police de caractere
		jourJ.setFont(new Font("Stencil", 0, 40));
		
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
		
		
		JLabel mangePD = new JLabel("- "+p.getRepasPetitDej().get((int)(Math.random()*( p.getRepasPetitDej().size()))), JLabel.CENTER);
		JLabel mangeDej = new JLabel("- "+p.getRepasNormaux().get((int)(Math.random()*( p.getRepasNormaux().size()))), JLabel.CENTER);
		JLabel mangeDiner = new JLabel("- "+p.getRepasNormaux().get((int)(Math.random()*( p.getRepasNormaux().size()))), JLabel.CENTER);
		
		//set d'une nouvelle police de caractère
		petitDej.setFont(new Font("Stencil", 0, 30));
		dejeuner.setFont(new Font("Stencil", 0, 30));
		diner.setFont(new Font("Stencil", 0, 30));
		
		mangePD.setFont(new Font("Stencil", 0, 18));
		mangeDej.setFont(new Font("Stencil", 0, 18));
		mangeDiner.setFont(new Font("Stencil", 0, 18));
		
		//ajout des labels à leurs panels respectifs
		casePetitDej.add(petitDej,BorderLayout.NORTH);
		caseDej.add(dejeuner,BorderLayout.NORTH);
		caseDiner.add(diner,BorderLayout.NORTH);
		
		
		casePetitDej.add(mangePD,BorderLayout.CENTER);
		caseDej.add(mangeDej,BorderLayout.CENTER);
		caseDiner.add(mangeDiner,BorderLayout.CENTER);
		
		
		//ajout des différents sous panels dans le grand panel recette
		recette.add(casePetitDej);
		recette.add(caseDej);
		recette.add(caseDiner);
		
		//ajout du panel recette dans ma case
		this.add(recette,BorderLayout.CENTER); 
	}
}  
