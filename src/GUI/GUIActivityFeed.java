package GUI;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;

import Logical.Giocata;
import Logical.Gioco1v1;
import Logical.Player;

public class GUIActivityFeed{
	private Gioco1v1 game;
	
	private String txt;
	
	public GUIActivityFeed(Gioco1v1 g) {
		txt = "";
		this.game = g;
	}
	
	public JTextArea getThing() {
		JTextArea area = new JTextArea();
		area.setEditable(false);
		area.setBorder(BorderFactory.createTitledBorder("LOG:"));
		
		area.setText(txt);
		
		return area;
	}
	
	public void addFeed(String s) {
		txt += s+'\n';
		for(Player p: game.getPlayers()) p.getGUI().aggiorna();
	}
	
	public static String inizioGame(Player ...players) {
		return players[0].getNome() +" vs. "+ players[1].getNome();
	}
	public static String vintoGiocata(Player p, Giocata g) {
		return p.getNome() +": +"+g.getPunti();
	}
	public static String vintoGame(Player p) {
		return p.getNome() +" ha vinto con "+p.getPunti()+" punti";
	}
}
