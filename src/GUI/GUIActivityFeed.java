package GUI;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;

import Games.Game;
import Logical.Giocata;
import Logical.Player;

public class GUIActivityFeed extends JTextArea{
	private Game game;
	
	private String txt;
	
	public GUIActivityFeed(Game g) {
		txt = "";
		this.game = g;
		
		this.createTxtArea();
	}
	
	private void createTxtArea() {
		this.setEditable(false);
		this.setBorder(BorderFactory.createTitledBorder("LOG:"));
		
		this.setText(txt);
	}
	
	/*public JTextArea getThing() {
		JTextArea area = new JTextArea();
		area.setEditable(false);
		area.setBorder(BorderFactory.createTitledBorder("LOG:"));
		
		area.setText(txt);
		
		return area;
	}*/
	
	public void addFeed(String s) {
		txt += s+'\n';
		this.append(s+'\n');
		/*for(Player p: game.getPlayers()) {
			if(p.getGUI() != null) p.getGUI().aggiorna();
		}*/
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
