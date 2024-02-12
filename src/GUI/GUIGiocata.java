package GUI;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logical.Carta;
import Logical.Giocata;

public class GUIGiocata extends JPanel{
	public static final ImageIcon VOID_CARD = new ImageIcon("src/icon/CartaVoid.png");
	
	private Giocata giocata;
	
	public GUIGiocata(Giocata g) {
		this.giocata = g;
		
		this.setLayout(new GridLayout(1, 2));
		
		this.loadCards(this.giocata.getCarte());
	}
	
	private void loadCards(Carta[] carte) {
		for(int i=0; i < carte.length; i++) {
			JLabel icon = new JLabel();
			if(this.giocata.getCarte()[i] != null) {
				icon.setIcon(this.giocata.getCarte()[i].getCardImage());
			} else {
				icon.setIcon(VOID_CARD);
			}
			this.add(icon);
		}
	}
	
	public void refresh() {
		this.removeAll();
		
		this.loadCards(this.giocata.getCarte());
	}
}
