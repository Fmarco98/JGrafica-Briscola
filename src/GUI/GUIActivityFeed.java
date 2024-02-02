package GUI;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

import Logical.Giocata;
import Logical.Player;

public class GUIActivityFeed extends JTextArea{
	
	public GUIActivityFeed() {
		super("");
		this.setEditable(false);
		//this.setMinimumSize(new Dimension(100, 300));
		
		this.setBorder(BorderFactory.createTitledBorder("LOG:"));
	}
	
	public void addFeed(String s) {
		super.append(s+"\n");
	}
	
	public static String vintoGiocata(Player p, Giocata g) {
		return p.getNome() +": +"+g.getPunti();
	}
	public static String vintoGame(Player p) {
		return p.getNome() +" ha vinto con "+p.getPunti()+" punti";
	}
}
