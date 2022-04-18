import java.awt.event.*;
import java.util.*;

public class EcouteurValiderSemainier implements ActionListener{
	
	private Semainier fenetre;            //fenetre sur laquelle intervient cet ecouteur
	private ProfilUtilisateur profil;
		
	//constructeur
	public EcouteurValiderSemainier(Semainier fen, ProfilUtilisateur p){
		fenetre=fen;
		profil = p;
	}
	
	public void actionPerformed(ActionEvent evt) {
        //creation + affichage d'une nouvelle fenetre Courses
        Courses courses = new Courses(profil);
		courses.setVisible(true);
		//pour cacher l'ancienne fenêtre (Semainier)
		fenetre.dispose();
    }
}

