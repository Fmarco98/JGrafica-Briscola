package GUI;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logical.Carta;
import Logical.Giocata;

public class GUIGiocata{
	
	private Giocata giocata;
	
	public GUIGiocata(Giocata g) {
		this.giocata = g;
	}
	
	public JPanel getPanel() {
		JPanel giocataPanel = new JPanel();
		giocataPanel.setLayout(new GridLayout(1, 2));
		ImageIcon img = new ImageIcon("src/icon/CartaVoid.png");
		
		for(int i=0; i < this.giocata.getCarte().length; i++) {
			JLabel icon = new JLabel();
			if(this.giocata.getCarte()[i] != null) {
				icon.setIcon(this.giocata.getCarte()[i].getCardImage());
			} else {
				icon.setIcon(img);
			}
			giocataPanel.add(icon);
		}
		
		return giocataPanel;
	}
}
