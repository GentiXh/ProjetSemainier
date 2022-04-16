import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProfilUtilisateur{
	public boolean gluten;
	public boolean lactose;
	public boolean arachide;
	public boolean fodmap;
	public boolean oeuf;
	public int regime;
		
	// allergene true => pas d'allergique, donc peut en manger
	// allergene false => allergique, doit manger seulement recettes qui n'en contiennent PAS
		
		
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

}
