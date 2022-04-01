import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Planning extends JFrame {

		public Planning(){
			//définit le nom de la fenetre
			super("Happy frigo");
			
			//Dimensions de la fenetre graphique et fermeture
			this.setSize(700,700);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			JPanel fond = new JPanel(new BorderLayout());
			JTable jt1;
			String[][] d1 = {
			{ "",""  ," " },
			
			};
			// Names of the column
			String[] cn1 = { "LUNDI", "MARDI", "MERCREDI" };
			// JTable initialization
			jt1 = new JTable(d1, cn1);
			//set bounds for JTable
			jt1.setBounds(30, 40, 200, 300);
			// add it to the JScrollPane
			JScrollPane jsp1 = new JScrollPane(jt1);
			fond.add(jsp1, BorderLayout.NORTH);
			
			
			JTable jt2;
			String[][] d2 = {
			{ "", "" ,"" },
			};
			// Names of the column
			String[] cn2 = { "JEUDI", "VENDREDI", "SAMEDI" };
			// JTable initialization
			jt2 = new JTable(d2, cn2);
			//set bounds for JTable
			jt2.setBounds(30, 40, 200, 300);
			// add it to the JScrollPane
			JScrollPane jsp2 = new JScrollPane(jt2);
			fond.add(jsp2, BorderLayout.SOUTH);
			
			this.add(fond);
			/*
			JPanel fond = new JPanel();
			JScrollPane jScrollPane2 = new JScrollPane();
			JTextArea mardi = new JTextArea();
			JScrollPane jScrollPane3 = new JScrollPane();
			JTextArea jeudi = new JTextArea();
			JScrollPane jScrollPane4 = new JScrollPane();
			JTextArea vendredi = new JTextArea();
			JScrollPane jScrollPane5 = new JScrollPane();
			JTextArea lundi = new JTextArea();
			JScrollPane jScrollPane6 = new JScrollPane();
			JTextArea mercredi = new JTextArea();
			JScrollPane jScrollPane7 = new JScrollPane();
			JTextArea dimanche = new JTextArea();
			JScrollPane jScrollPane8 = new JScrollPane();
			JTextArea samedi = new JTextArea();

			fond.setBackground(new Color(255, 255, 204));

		    mardi.setColumns(20);
			mardi.setFont(new Font("Stencil", 0, 18)); 
		    mardi.setRows(5);
			mardi.setText("MARDI");
			jScrollPane2.setViewportView(mardi);

		    jeudi.setColumns(20);
			jeudi.setFont(new Font("Stencil", 0, 18)); 
			jeudi.setRows(5);
			jeudi.setText("JEUDI");
			jScrollPane3.setViewportView(jeudi);

		    vendredi.setColumns(20);
			vendredi.setFont(new Font("Stencil", 0, 18)); 
			vendredi.setRows(5);
			vendredi.setText("VENDREDI");
			jScrollPane4.setViewportView(vendredi);

		    lundi.setColumns(20);
			lundi.setFont(new Font("Stencil", 0, 18));
		    lundi.setRows(5);
			lundi.setText("LUNDI");
			jScrollPane5.setViewportView(lundi);

			mercredi.setColumns(20);
			mercredi.setFont(new Font("Stencil", 0, 18)); 
		    mercredi.setRows(5);
			mercredi.setText("MERCREDI");
			jScrollPane6.setViewportView(mercredi);

		    dimanche.setColumns(20);
			dimanche.setFont(new Font("Stencil", 0, 18)); 
		    dimanche.setRows(5);
			dimanche.setText("DIMANCHE");
			jScrollPane7.setViewportView(dimanche);

			samedi.setColumns(20);
			samedi.setFont(new Font("Stencil", 0, 18)); 
		    samedi.setRows(5);
			samedi.setText("SAMEDI");
			jScrollPane8.setViewportView(samedi);

			javax.swing.GroupLayout fondLayout = new GroupLayout(fond);
			* */
			this.setVisible(true);
			
	}             
}
