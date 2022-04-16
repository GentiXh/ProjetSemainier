import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//classe ou les preferences de l'utilisateur sont enregistrees

public class ProfilUtilisateur{
	public boolean gluten;
	public boolean lactose;
	public boolean arachide;
	public boolean fodmap;
	public boolean oeuf;
	public int regime;
		
	// allergene true => utilisateur allergique, donc code qui cherche les allergies a exclure
	// allergene false => in contrarium
		
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
