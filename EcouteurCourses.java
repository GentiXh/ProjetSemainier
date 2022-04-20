import java.awt.event.*;
import java.util.*;

public class EcouteurCourses implements ActionListener{
	
	private Courses fenetre;            //fenetre sur laquelle intervient cet ecouteur
	private ProfilUtilisateur profil;
		
	//constructeur
	public EcouteurCourses(Courses fen, ProfilUtilisateur p){
		fenetre=fen;
		profil = p;
	}
	
	public void actionPerformed(ActionEvent evt) {
        //creation + affichage d'une nouvelle fenetre Courses
        Semainier s = new Semainier(profil);
		s.setVisible(true);
		//pour cacher l'ancienne fenêtre (Courses)
		fenetre.dispose();
    }
}

