import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import java.util.*;

public class TriDeContraintesTest{
	
	//constructeur
	public static void main (String[] args){
	
			int regime = 1; // 0 pour omnivore, 1 pour vegetarien et 2 pour vegan
	// pour tous les allergenes : false = ne contient pas l'allergene et donc l'utilisatuer allergique a cela peut en manger
	
			boolean gluten = false;
			boolean oeuf =true;
			boolean lactose=true;
			boolean arachide=true;
			boolean fodmap=true;
	
	
		String Regime = "i.regime = "+regime;							//si vegan, cherche que les recettes veganes
		if (regime == 0){												//si omnivore
			 Regime = "("+Regime+" OR i.regime = 1 OR i.regime = 2)";	//inclut les recettes veganes et vege aussi
		}
		if (regime == 1){												//si vege
			 Regime = "("+Regime+" OR i.regime = 2)";					//inclut les recettes veganes aussi
		}
		
		String Gluten = "i.gluten = "+gluten;					//si false, on est allergique au gluten, c-a-d qu'on cherche que les ingredients qui ont l'attribut de gluten comme false, donc qui n'ont pas de gluten
		if (gluten == true){ 							//si pas allergique au gluten...
			Gluten = "("+Gluten+" OR i.gluten = 0)";	//...prends en comptes les ingredients qui ont du gluten OU qui n'ont pas du gluten
		}

		String Oeuf = "i.oeuf = "+oeuf;					
		if (oeuf == true){ 							
			Oeuf = "("+Oeuf+" OR i.oeuf = 0)";	
		}	
		
		String Lactose = "i.lactose = "+lactose;					
		if (lactose == true){ 							
			Lactose = "("+Lactose+" OR i.lactose = 0)";	
		}	
		
		String Arachide = "i.arachide = "+arachide;					
		if (arachide == true){ 							
			Arachide = "("+Arachide+" OR i.arachide = 0)";	
		}
		
		String Fodmap = "i.fodmap = "+fodmap;					
		if (fodmap == true){ 							
			Fodmap = "("+Fodmap+" OR i.fodmap = 0)";	
		}
		Connection conDB = null; 
		Statement statement = null;
		ResultSet query = null;
		// initialise recette 
	    ArrayList<String> listeRecettePetitDej = new ArrayList<String>(); 
		ArrayList<String> listeRecetteFrancais = new ArrayList<String>();
		ArrayList<String> listeRecetteItalien = new ArrayList<String>();
		ArrayList<String> listeRecetteAsiatique = new ArrayList<String>();
		ArrayList<String> listeRecetteFastFood = new ArrayList<String>();
		ArrayList<String> listeRecetteAutreCategorie = new ArrayList<String>();

		
		try{
			Class.forName("org.mariadb.jdbc.Driver"); // on connecte au driver de la MariaBD
            System.out.println("Driver trouve...");
			conDB = DriverManager.getConnection("jdbc:mariadb://localhost:3306/ProjetSemainier", "root", "root"); // on connecte a la BD
				statement = conDB.createStatement();
				
				//requetes SQL
				query = statement.executeQuery("Select r.nomRecette, r.type from recettes r, ingredients i, compo c where r.idRecette = c.idRecette AND i.idIngredient = c.idIngredient AND "+Regime+" AND "+Gluten+" AND "+Oeuf+" AND "+Lactose+" AND "+Arachide+" AND "+Fodmap);
				//pour recettes diff de petits dejeuners
				
				while(query.next()){

					if (!listeRecettePetitDej.contains(query.getString("r.nomRecette")) && !listeRecetteFrancais.contains(query.getString("r.nomRecette")) && !listeRecetteItalien.contains(query.getString("r.nomRecette")) && !listeRecetteAsiatique.contains(query.getString("r.nomRecette")) && !listeRecetteFastFood.contains(query.getString("r.nomRecette")) && !listeRecetteAutreCategorie.contains(query.getString("r.nomRecette"))){  // pour ne pas inclure les doublons
						
						switch(query.getString("r.type")){
							
							case "petitDej":
								listeRecettePetitDej.add(query.getString("r.nomRecette"));
								break;
								
							case "francais":
								listeRecetteFrancais.add(query.getString("r.nomRecette"));
								break;
								
							case "italien":
								listeRecetteItalien.add(query.getString("r.nomRecette"));
								break;
								
							case "asiatique":
								listeRecetteAsiatique.add(query.getString("r.nomRecette"));
								break;
								
							case "fastFood":
								listeRecetteFastFood.add(query.getString("r.nomRecette"));
								break;
								
							case "autreCategorie":
								listeRecetteAutreCategorie.add(query.getString("r.nomRecette"));
								break;
							
						}	
					}
				}
				
				for (int i = 0; i<listeRecettePetitDej.size(); i++){ // affichage dans console des repas pour debug
					System.out.println(listeRecettePetitDej.get(i));
				}
				for (int i = 0; i<listeRecetteFrancais.size(); i++){ // affichage dans console des repas pour debug
					System.out.println(listeRecetteFrancais.get(i));
				}
				for (int i = 0; i<listeRecetteItalien.size(); i++){ // affichage dans console des repas pour debug
					System.out.println(listeRecetteItalien.get(i));
				}
				for (int i = 0; i<listeRecetteAsiatique.size(); i++){ // affichage dans console des repas pour debug
					System.out.println(listeRecetteAsiatique.get(i));
				}
				for (int i = 0; i<listeRecetteFastFood.size(); i++){ // affichage dans console des repas pour debug
					System.out.println(listeRecetteAsiatique.get(i));
				}
				for (int i = 0; i<listeRecetteAutreCategorie.size(); i++){ // affichage dans console des repas pour debug
					System.out.println(listeRecetteAutreCategorie.get(i));
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
