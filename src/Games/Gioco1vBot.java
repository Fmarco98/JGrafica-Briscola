package Games;

import GUI.GUIActivityFeed;
import Logical.Bot;
import Logical.Player;

public class Gioco1vBot extends Game{
	
	public Gioco1vBot(String name) {
		super(true);
		
		Player[] players = super.getPlayers();
		
		players[0] = new Player(name, this, 0);
		players[0].enableGUI();
		
		players[1] = new Bot(this, 1);
		
		super.getLOG().addFeed(GUIActivityFeed.inizioGame(players));
	}
	
}
