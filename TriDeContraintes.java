import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import java.util.*;

public class TriDeContraintes{
	
	private int regime; // 0 pour omnivore, 1 pour vegetarien et 2 pour vegan
	// pour tous les allergenes : false = ne contient pas l'allergene et donc l'utilisatuer allergique a cela peut en manger
	private boolean gluten;
	private boolean oeuf;
	private boolean lactose;
	private boolean arachide;
	private boolean fodmap;
	
	private String type ; 
	
	protected ArrayList<String> listeRecettePetitDej; //repas petit dej
	protected ArrayList<String> listeRecetteFrancais; //repas francais
	protected ArrayList<String> listeRecetteItalien; //repas italien
	protected ArrayList<String> listeRecetteAsiatique; //repas asiatique
	protected ArrayList<String> listeRecetteFastFood; //repas fast food
	protected ArrayList<String> listeRecetteAutreCategorie;  //repas autre categorie
	
	//constructeur
	public TriDeContraintes(int regime, boolean gluten, boolean oeuf, boolean lactose, boolean arachide, boolean fodmap, String type){
		this.regime = regime;
		this.gluten = gluten;
		this.oeuf = oeuf;
		this.lactose = lactose;
		this.arachide = arachide;
		this.fodmap = fodmap;
		this.type = type; 
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
				query = statement.executeQuery("Select r.nomRecette from recettes r, ingredients i, compo c where r.idRecette = c.idRecette AND i.idIngredient = c.idIngredient AND i.regime="+regime+" AND i.gluten="+gluten+" AND i.oeuf="+oeuf+" AND i.lactose="+lactose+" AND i.arachide="+arachide+" AND i.fodmap="+fodmap+" AND r.type='"+type+"' AND r.matin=false");
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
