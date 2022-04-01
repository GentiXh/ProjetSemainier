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
	private boolean matin;
	
	protected Arraylist<String> listeRecette;
	
	public class TriDeContraintes(int regime, boolean gluten, boolean oeuf, boolean lactose, boolean arachide, boolean fodmap, String nationalite, boolean matin){
		this.regime = regime;
		this.gluten = gluten;
		this.oeuf = oeuf;
		this.lactose = lactose;
		this.arachide = arachide;
		this.fodmap = fodmap;
		this.nationalite = nationalite;
		this.matin = matin;
	}
	
	public void Tri(){
		Connection conDB = null;
		Statement statement = null;
		ResultSet query = null;
		listeRecette = new ArrayList<String>();	
		
		try{
			Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Driver trouve...");
			conDB = DriverManager.getConnection(
				"jdbc:mariadb://localhost:3306/ProjetSemainier", "root", "root");
				statement = conDB.createStatement();
				query = statement.executeQuery("Select r.nomRecette from recettes r, ingredients i, compo c where r.idRecette = c.idRecette AND i.idIngredient = c.idIngredient AND i.regime="+regime+" AND i.gluten="+gluten+" AND i.oeuf="+oeuf+" AND i.lactose="+lactose+" AND i.arachide="+arachide+" AND i.fodmap="+fodmap+" AND r.nationalite='"+nationalite+"' AND r.matin="+matin);
				while(query.next()){
					
					listeRecette.add(query.getString("nomRecette"));
				}
				
				Set<String> listeSansDoublons = new LinkedHashSet<String>(listeRecette);
				listeRecette.clear();
				listeRecette.addAll(listeSansDoublons);
				
				for (int i = 0; i<output.size(); i++){
					System.out.println(listeRecette.get(i));
				}
			} catch (Exception ex) {ex.printStackTrace();}
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
		public void effacerContraintes(){
			listeRecette.clear();
		}
		public listeRecette <String> getList() {
			return listeRecette;
		}
			
}
