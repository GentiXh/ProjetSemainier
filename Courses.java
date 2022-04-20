import java.awt.*;    
import javax.swing.*;    
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import java.util.*;

public class Courses extends JFrame{      
  
	private ProfilUtilisateur profil;
	private ArrayList<String> listeCourses; //liste des courses des ingredients pour les recettes choisies
	
	// constructeur  
	public Courses(ProfilUtilisateur p){     		 
		super("Liste de Courses");
		
		profil = p;
		listeCourses = new ArrayList<String>();
		
		//récuperer la taille de l'écran + mettre fenetre au centre de l'ecran  + fermeture
		this.pack();
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		int height = tailleEcran.height;
		int width = tailleEcran.width;
		this.setSize(width/2, height/2);
		this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
        
        JPanel fond = new JPanel(new BorderLayout());
        JPanel milieu = new JPanel();
        milieu.setLayout(new GridLayout(listeCourses.size(),1));
        
        JLabel titre = new JLabel("Liste de courses :",JLabel.CENTER);
        
        
        fond.setBackground(new Color(252, 178, 178));
        milieu.setBackground(new Color(252, 178, 178));
        titre.setFont(new java.awt.Font("Stencil", 0, 36)); 

		creerListeCourses();   //appelle la methode au dessous qui trouve les ingredients de recette selectionnees et gardees par ProfilUtilisateur
		
		for(int i=0;i<listeCourses.size();i++){
			
			JLabel ingredient = new JLabel("- "+listeCourses.get(i));
						
			ingredient.setFont(new Font("Stencil", 0, 24));	
			
			milieu.add(ingredient);
                
        }  
		
		//ajout des éléments dans la fenetre
        fond.add(titre, BorderLayout.NORTH);
        fond.add(milieu, BorderLayout.CENTER);
		this.add(fond);
		
		
		//affichage de la fenetre 
		this.setVisible(true); 
	}
	
	public void creerListeCourses(){
		Connection conDB = null; 
		Statement statement = null;
		ResultSet query = null;
		try{
			Class.forName("org.mariadb.jdbc.Driver"); // on connecte au driver de la MariaBD
            System.out.println("Driver trouve...");
			conDB = DriverManager.getConnection("jdbc:mariadb://localhost:3306/ProjetSemainier", "root", "root"); // on connecte a la BD
				statement = conDB.createStatement();
				
				for (int i = 0; i<profil.getRepas().size(); i++){			//parcours de toutes les recettes choisis
					String s = profil.getRepas().get(i);
					//requetes SQL
					query = statement.executeQuery("select distinct i.nomIngredient from recettes r, compositionrecette c, ingredients i where r.idRecette=c.idRecette and i.idIngredient=c.idIngredient and r.nomRecette = '"+s+"'");					
					while(query.next()){
						if(!listeCourses.contains(query.getString("i.nomIngredient"))){ //ici le "distinct" ne suffit par car on va parcourir la bd plusieurs fois avec le for
						listeCourses.add(query.getString("i.nomIngredient"));
						}
					}
				}
				
			} catch (Exception ex) {ex.printStackTrace();}  // pour retrouver sources des erreurs eventuelles
			finally{
				try{query.close();}
				catch (Exception e){
					e.printStackTrace();
				}
				try {statement.close();}
				catch(Exception e){
					e.printStackTrace();
				}
				try{conDB.close();}
				catch(Exception e){
					e.printStackTrace();
				}
			}	
	}
}  
