package Games;

import GUI.GUIActivityFeed;
import Logical.Player;

public class Gioco1v1 extends Game {
	
	public Gioco1v1(String ...names) {
		super(false);
		Player[] players = super.getPlayers();
		
		for(int i=0; i < players.length; i++) {
			players[i] = new Player(names[i], this, i);
			players[i].enableGUI();
		}
		super.getLOG().addFeed(GUIActivityFeed.inizioGame(players));
	}

}
