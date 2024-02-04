package Games;

import javax.swing.ImageIcon;

import GUI.GUIActivityFeed;
import Logical.Carta;
import Logical.Giocata;
import Logical.Mazzo;
import Logical.Player;
import Logical.Turno;

public abstract class Game {
	public static final String PATH = System.getProperty("user.dir");
	public static final ImageIcon ICO = new ImageIcon(PATH+"\\src\\icon\\ProgIcon.png");
	
	private boolean thereIsBot;
	
	private Mazzo mazzo;
	private Turno turno;
	private Giocata giocata;
	private Player[] players;
	private Carta briscola;
	private GUIActivityFeed log;
	
	public Game(boolean bot) {
		mazzo = new Mazzo();
		turno = new Turno();
		giocata = new Giocata(this);
		briscola = new Carta(mazzo.getBriscola());
		log = new GUIActivityFeed(this);
		thereIsBot = bot;
		
		players = new Player[2];
	}
	
	public boolean isThereBot() {
		return thereIsBot;
	}
	public Mazzo getMazzo() {
		return mazzo;
	}
	public Turno getTurno() {
		return turno;
	}
	public Giocata getGiocata() {
		return giocata;
	}
	public Player[] getPlayers() {
		return this.players;
	}
	public Carta getBriscolaCard() {
		return this.briscola;
	}
	public GUIActivityFeed getLOG() {
		return log;
	}
	
	public static void pause() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
