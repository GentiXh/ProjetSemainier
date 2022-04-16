import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//classe ou les preferences de l'utilisateur sont enregistrees

public class ProfilUtilisateur{
	private boolean gluten;
	private boolean lactose;
	private boolean arachide;
	private boolean fodmap;
	private boolean oeuf;
	private int regime;
		
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
}
