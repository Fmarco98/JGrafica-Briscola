package GUI;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logical.Carta;
import Logical.Giocata;

public class GUIGiocata extends JPanel{
	
	private Giocata giocata;
	
	private JLabel[] icons = new JLabel[2];
	
	public GUIGiocata(Giocata g) {
		super();
		this.giocata = g;
		for(int i=0; i < icons.length; i++) icons[i] = new JLabel("");
		
		this.disegna();
		this.setLayout(new GridLayout(1, 2));
		for(int i=0; i < icons.length; i++) {
			this.add(icons[i]);
		}
	}
	
	private void disegna() {
		ImageIcon img = new ImageIcon("src/icon/CartaVoid.png");
		
		for(int i=0; i < this.giocata.getCarte().length; i++) {
			if(this.giocata.getCarte()[i] != null) {
				icons[i].setIcon(this.giocata.getCarte()[i].getFrontImage());
			} else {
				icons[i].setIcon(img);
			}
		}
		//this.repaint();
	}
	
	public void aggiorna() {
		for(int i=0; i < this.giocata.getCarte().length; i++) {
			System.out.println(this.giocata.getCarte()[i]);
		}
		this.disegna();
	}
}
