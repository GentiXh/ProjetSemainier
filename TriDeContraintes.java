import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import java.util.*;

public class TriDeContraintes{
	
	// les choix de l'utilisateur:
	
	private int regime; 			// 0 pour omnivore, 1 pour vegetarien et 2 pour vegan
	
	// pour tous les allergenes : true => l'utilisateur est allergique a l'allergene en question => le code va cherche a exclure les ingredients qui contiennent cet allergene
	private boolean gluten;
	private boolean oeuf;
	private boolean lactose;
	private boolean arachide;
	private boolean fodmap;
	
	//les strings des commandes sql qui changent selon les choix de l'utilisateur (voir a partir de ligne 47)
	private String Regime;   
	private String Gluten;
	private String Oeuf;
	private String Lactose;
	private String Arachide;
	private String Fodmap;
	
	//listes (qui seront remplies sur cette classe) selon les types des plats proposees par le query de tri
	
	private ArrayList<String> listeRecettePetitDej; 			//repas petit dej
	private ArrayList<String> listeRecetteFrancais; 			//repas francais
	private ArrayList<String> listeRecetteItalien; 				//repas italien
	private ArrayList<String> listeRecetteAsiatique;			//repas asiatique
	private ArrayList<String> listeRecetteFastFood; 			//repas fast food
	private ArrayList<String> listeRecetteAutreCategorie;    		//repas autre categorie
	
	//constructeur
	public TriDeContraintes(ProfilUtilisateur p){
		
		//association des valeurs enregistrees aux variables de cette classe
		this.regime = p.getRegime();
		this.gluten = p.getGluten();
		this.oeuf = p.getOeuf();
		this.lactose = p.getLactose();
		this.arachide = p.getArachide();
		this.fodmap = p.getFodmap(); 
		
		//dans les commentaires suivants, le terme "exclut" sera utilisee car la query contient un NOT IN afin d'exclure les "compopsitions" recette+ingredient qui ne marche pas pour faire le tri selon les donnees de ProfilUtilisateur
								
		if (regime == 0){										//si omnivore :
			 Regime = " and ((i.regime = 3)";					/*exclut les ingredients de regime 3. regime 3 n'est associee a rien, donc n'exclut rien (puisque omnivore comprend tout les regime)*/
		}														/*On a du faire cela et ne pas dire Regime = "" car sinon la requete query ne marche pas dans certain cas: des and/or et parantheses en plus ou moins que necessaires ce qui cree des erreurs de syntaxe ou resultats incoherents*/
	
		if (regime == 1){										//si vegetarien :
			 Regime = " and ((i.regime = 0) ";					/*exclut les recettes omnivores*/
		}
		if (regime == 2){										//si vegan :
			Regime = " and ((i.regime = 1 or i.regime = 0) ";	/*exclut les recettes omnivores et vegetariennes*/
		}
		
		Gluten = " or i.gluten = "+gluten;						//si true, on est allergique au gluten, query va chercher a exclure les ingredients qui contient du gluten
		if (gluten == false){ 									//si pas allergique au gluten :
			Gluten = "";										/*n'exclut rien en se basant sur l'existence ou non du gluten dans l'ingredient en question*/
		}

		Oeuf = " or i.oeuf = "+oeuf;							//idem			
		if (oeuf == false){ 							
			Oeuf = "";	
		}	
		
		Lactose = " or i.lactose = "+lactose;					//idem	
		if (lactose == false){ 							
			Lactose = "";	
		}	
		
		Arachide = " or i.arachide = "+arachide;				//idem		
		if (arachide == false){ 							
			Arachide = "";	
		}
		
		Fodmap = " or i.fodmap = "+fodmap;						//idem	
		if (fodmap == false){ 							
			Fodmap = "";	
		}			
	}
	
	public void Tri(){
		
		//connection a la base de donnees
		Connection conDB = null; 
		Statement statement = null;
		ResultSet query = null;
		
		// initialise recette 
		listeRecettePetitDej = new ArrayList<String>(); 
		listeRecetteFrancais = new ArrayList<String>();
		listeRecetteItalien = new ArrayList<String>();
		listeRecetteAsiatique = new ArrayList<String>();
		listeRecetteFastFood = new ArrayList<String>();
		listeRecetteAutreCategorie = new ArrayList<String>();

		
		try{
			Class.forName("org.mariadb.jdbc.Driver"); // on connecte au driver de la MariaBD
            System.out.println("Driver trouve...");
			conDB = DriverManager.getConnection("jdbc:mariadb://localhost:3306/ProjetSemainier", "root", "root"); // on connecte a la BD
				statement = conDB.createStatement();
				
				//requetes SQL
				query = statement.executeQuery("select distinct r.`type`, r.nomRecette from recettes r, compositionrecette c, ingredients i where r.idRecette=c.idRecette and i.idIngredient=c.idIngredient and c.idRecette not in (select c.idRecette from ingredients i, recettes r, compositionrecette c where r.idRecette=c.idRecette and i.idIngredient=c.idIngredient"+Regime+Gluten+Lactose+Fodmap+Oeuf+Arachide+"))");
				
				while(query.next()){
											
					switch(query.getString("r.type")){		//ajoute les recettes triees dans les listes de types de plats correspondants
							
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
		
		public void effacerContraintes(){ 				//vider les listes si besoin/debug
			listeRecettePetitDej.clear();
			listeRecetteFrancais.clear();
			listeRecetteItalien.clear();
			listeRecetteAsiatique.clear();
			listeRecetteFastFood.clear();
			listeRecetteAutreCategorie.clear();
		}
		
		//getteurs des listes de recettes selon les types
		
		public ArrayList <String> getItalienList(){
			return new ArrayList<String>(listeRecetteItalien);
		}
		
		public ArrayList <String> getFrancaisList(){
			return new ArrayList<String>(listeRecetteFrancais);
		}
		
		public ArrayList <String> getAsiatiqueList(){
			return new ArrayList<String>(listeRecetteAsiatique);
		}
		
		public ArrayList <String> getFastFoodList(){
			return new ArrayList<String>(listeRecetteFastFood);
		}
		
		public ArrayList <String> getAutreCategorieList(){
			return new ArrayList<String>(listeRecetteAutreCategorie);
		}
		
		public ArrayList <String> getPetitDejList(){
			return new ArrayList<String>(listeRecettePetitDej);
		}
}
