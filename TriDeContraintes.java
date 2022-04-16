import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import java.util.*;

public class TriDeContraintes{
	
	// les choix de l'utilisateur
	private int regime; // 0 pour omnivore, 1 pour vegetarien et 2 pour vegan
	// pour tous les allergenes : false = ne contient pas l'allergene et donc l'utilisatuer allergique a cela peut en manger
	private boolean gluten; //1 => pas allergique au gluten		//0 => allergique au gluten
	private boolean oeuf;
	private boolean lactose;
	private boolean arachide;
	private boolean fodmap;
	
	//les strings des commandes sql qui changent selon les choix de l'utilisateur (voir a partir de ligne 44)
	private String Regime;   
	private String Gluten;
	private String Oeuf;
	private String Lactose;
	private String Arachide;
	private String Fodmap;
	
	private String type ; 
	
	public ArrayList<String> listeRecettePetitDej; //repas petit dej
	public ArrayList<String> listeRecetteFrancais; //repas francais
	public ArrayList<String> listeRecetteItalien; //repas italien
	public ArrayList<String> listeRecetteAsiatique; //repas asiatique
	public ArrayList<String> listeRecetteFastFood; //repas fast food
	public ArrayList<String> listeRecetteAutreCategorie;  //repas autre categorie
	
	//constructeur
	public TriDeContraintes(ProfilUtilisateur p){
		
		this.regime = p.regime;
		this.gluten = p.gluten;
		this.oeuf = p.oeuf;
		this.lactose = p.lactose;
		this.arachide = p.arachide;
		this.fodmap = p.fodmap; 
		
		Regime = "i.regime = "+regime;									//si vegan, cherche que les recettes veganes
		if (regime == 0){												//si omnivore
			 Regime = "("+Regime+" OR i.regime = 1 OR i.regime = 2)";	//inclut les recettes veganes et vege aussi
		}
		if (regime == 1){												//si vege
			 Regime = "("+Regime+" OR i.regime = 2)";					//inclut les recettes veganes aussi
		}
		
		Gluten = "i.gluten = "+gluten;					//si false, on est allergique au gluten, c-a-d qu'on cherche que les ingredients qui ont l'attribut de gluten comme false, donc qui n'ont pas de gluten
		if (gluten == true){ 							//si pas allergique au gluten...
			Gluten = "("+Gluten+" OR i.gluten = 0)";	//...prends en comptes les ingredients qui ont du gluten OU qui n'ont pas du gluten
		}

		Oeuf = "i.oeuf = "+oeuf;					
		if (oeuf == true){ 							
			Oeuf = "("+Oeuf+" OR i.oeuf = 0)";	
		}	
		
		Lactose = "i.lactose = "+lactose;					
		if (lactose == true){ 							
			Lactose = "("+Lactose+" OR i.lactose = 0)";	
		}	
		
		Arachide = "i.arachide = "+arachide;					
		if (arachide == true){ 							
			Arachide = "("+Arachide+" OR i.arachide = 0)";	
		}
		
		Fodmap = "i.fodmap = "+fodmap;					
		if (fodmap == true){ 							
			Fodmap = "("+Fodmap+" OR i.fodmap = 0)";	
		}			
		
	}
	
	public void Tri(){
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
				query = statement.executeQuery("select r.type, r.nomRecette, count(c.idIngredient) from recettes r, compositionrecette c, ingredients i where r.idRecette = c.idRecette and i.idIngredient = c.idIngredient and "+Regime+" and "+Gluten+" and "+Lactose+" and "+Oeuf+" and "+Fodmap+" and "+Arachide+" group by c.idRecette having count(c.idIngredient) in (select count(c.idIngredient) from recettes r, compositionrecette c, ingredients i where r.idRecette = c.idRecette and i.idIngredient = c.idIngredient group by c.idRecette)");
				//pour recettes diff de petits dejeuners
				while(query.next()){
					
					if (!listeRecettePetitDej.contains(query.getString("r.nomRecette")) && !listeRecetteFrancais.contains(query.getString("r.nomRecette")) && !listeRecetteItalien.contains(query.getString("r.nomRecette")) && !listeRecetteAsiatique.contains(query.getString("r.nomRecette")) && !listeRecetteFastFood.contains(query.getString("r.nomRecette")) && !listeRecetteAutreCategorie.contains(query.getString("r.nomRecette"))){  // pour eviter doublons
						
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
				
			/*	for (int i = 0; i<listeRecettePetitDej.size(); i++){ // affichage dans console des repas pour debug
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
			*/
				
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
		
		public void effacerContraintes(){ //vider les listes
			listeRecettePetitDej.clear();
			listeRecetteFrancais.clear();
			listeRecetteItalien.clear();
			listeRecetteAsiatique.clear();
			listeRecetteFastFood.clear();
			listeRecetteAutreCategorie.clear();
		}
		
		public ArrayList <String> getListePetitDej() {
			return listeRecettePetitDej;
		}
		
		public ArrayList <String> getListeItalien(){
			return listeRecetteItalien;
		}
		
		public ArrayList <String> getListeFrancais() {
			return listeRecetteFrancais;
		}
		
		public ArrayList <String> getListeAsiatique() {
			return listeRecetteAsiatique;
		}
		
		public ArrayList <String> getListeFastFood() {
			return listeRecetteFastFood;
		}
		public ArrayList <String> getListeAutreCategorie() {
			return listeRecetteAutreCategorie;
		}
}

