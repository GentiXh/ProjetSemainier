import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import java.util.*;

public class TriDeContraintes{
	
	private int regime;
	private boolean gluten;
	private boolean oeuf;
	private boolean lactose;
	private boolean arachide;
	private boolean fodmap;
	
	private String nationalite;
	
	protected ArrayList<String> listeRecette1; //repas normaux
	protected ArrayList<String> listeRecette2; //repas petit dej
	
	public TriDeContraintes(int regime, boolean gluten, boolean oeuf, boolean lactose, boolean arachide, boolean fodmap, String nationalite){
		this.regime = regime;
		this.gluten = gluten;
		this.oeuf = oeuf;
		this.lactose = lactose;
		this.arachide = arachide;
		this.fodmap = fodmap;
		this.nationalite = nationalite;
	}
	
	public TriDeContraintes(int regime, boolean gluten, boolean oeuf, boolean lactose, boolean arachide, boolean fodmap){
		this.regime = regime;
		this.gluten = gluten;
		this.oeuf = oeuf;
		this.lactose = lactose;
		this.arachide = arachide;
		this.fodmap = fodmap;
		this.nationalite = nationalite;
	}
	
	public void Tri(){
		Connection conDB = null;
		Statement statement = null;
		ResultSet query1 = null;
		ResultSet query2 = null;
		listeRecette1 = new ArrayList<String>();
		listeRecette1 = new ArrayList<String>();		
		
		try{
			Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Driver trouve...");
			conDB = DriverManager.getConnection(
				"jdbc:mariadb://localhost:3306/ProjetSemainier", "root", "root");
				statement = conDB.createStatement();
				
				query1 = statement.executeQuery("Select r.nomRecette from recettes r, ingredients i, compo c where r.idRecette = c.idRecette AND i.idIngredient = c.idIngredient AND i.regime="+regime+" AND i.gluten="+gluten+" AND i.oeuf="+oeuf+" AND i.lactose="+lactose+" AND i.arachide="+arachide+" AND i.fodmap="+fodmap+" AND r.nationalite='"+nationalite+"' AND r.matin=false");
				while(query1.next()){
					
					if (!listeRecette1.contains(query1.getString("r.nomRecette"))){
						listeRecette1.add(query1.getString("r.nomRecette"));
					}
				}

				query2 = statement.executeQuery("Select r.nomRecette from recettes r, ingredients i, compo c where r.idRecette = c.idRecette AND i.idIngredient = c.idIngredient AND i.regime="+regime+" AND i.gluten="+gluten+" AND i.oeuf="+oeuf+" AND i.lactose="+lactose+" AND i.arachide="+arachide+" AND i.fodmap="+fodmap+" AND r.matin=true");
				while(query2.next()){
					
					if (!listeRecette2.contains(query2.getString("r.nomRecette"))){
						listeRecette2.add(query2.getString("r.nomRecette"));
					}
				}
				
				System.out.println("Repas normaux");
				
				for (int i = 0; i<listeRecette1.size(); i++){
					System.out.println(listeRecette1.get(i));
				}
				
				System.out.println("Repas petit dej");
				
				for (int i = 0; i<listeRecette2.size(); i++){
					System.out.println(listeRecette2.get(i));
				}
				
			} catch (Exception ex) {ex.printStackTrace();}
			finally{
				try{query1.close();}
				catch (Exception e){
					e.printStackTrace();
				}
				try{query2.close();}
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
		public void effacerContraintes(){
			listeRecette1.clear();
			listeRecette2.clear();
		}
		public ArrayList <String> getListe1() {
			return listeRecette1;
		}
		
		public ArrayList <String> getListe2(){
			return listeRecette2;
		}
}

