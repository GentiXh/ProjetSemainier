import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//classe ou les preferences de l'utilisateur sont enregistrees

public class ProfilUtilisateur{
	
	//Preference du regime alimentaire et allergenes de l'utilisateur qui seront remplis depuis les ecouteur d'Allergie et RegimeAlimentaire
	private boolean gluten;
	private boolean lactose;
	private boolean arachide;
	private boolean fodmap;
	private boolean oeuf;
	private int regime;
	
	//Listes des repas petit dejeuner et repas "normaux" qui seront remplies depuis les choix de l'utilisateur sur l'ecouteur de Recette
	private ArrayList<String> repasNormauxChoisis;
	private ArrayList<String> repasPetitDejChoisis;
		
	// allergene true => utilisateur allergique, donc code qui cherche les allergies a exclure
	// allergene false => in contrarium
		
	//setteurs:
	
	public void setGluten(boolean g){
		gluten = g;
	}
	public void setLactose(boolean l){
		lactose = l;
	}
	public void setOeuf(boolean o){
		oeuf = o;
	}
	public void setArachide(boolean a){
		arachide = a;
	}
	public void setFodmap(boolean f){
		fodmap = f;
	}
	public void setReg (int r){
		regime = r;
	}
	public void setRepasNormaux(String s){  			//appel du setteurs depuis ecouteurRegime avec le repas "checkee"
		if(!repasNormauxChoisis.contains(s)){			//si la liste ne contient pas le repas...
			repasNormauxChoisis.add(s);					//ajoute le dans la liste
		}
		else if (repasNormauxChoisis.contains(s)){		//sinon...
			repasNormauxChoisis.remove(s);				//supprime le de la liste
		}
	}
	public void setRepasPetitDej(String s){				//idem mais pour les repas de petit dejeuner
		if(!repasPetitDejChoisis.contains(s)){
			repasPetitDejChoisis.add(s);
		}
		else if (repasNormauxChoisis.contains(s)){
			repasPetitDejChoisis.remove(s);
		}
	}
	
	//Getteurs:
	
	public boolean getGluten(){
		return gluten;
	}

	public boolean getLactose(){
		return lactose;
	}

	public boolean getOeuf(){
		return oeuf;
	}

	public boolean getArachide(){
		return arachide;
	}

	public boolean getFodmap(){
		return fodmap;
	}
	
	public int getRegime(){
		return regime;
	}
	
	public ArrayList <String> getRepasNormaux(){
		return new ArrayList<String>(repasNormauxChoisis);
	}

	public ArrayList <String> getRepasPetitDej(){
		return new ArrayList<String>(repasPetitDejChoisis);
	}	
}
