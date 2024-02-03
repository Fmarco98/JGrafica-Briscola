package Logical;

import javax.swing.ImageIcon;

import GUI.GUIActivityFeed;

public class Gioco1v1{
	public static final ImageIcon ICO = new ImageIcon("src/icon/ProgIcon.png");
	
	private Mazzo mazzo;
	private Turno turno;
	private Giocata giocata;
	private Player[] players;
	private Carta briscola;
	private GUIActivityFeed log;
	
	public Gioco1v1(String ...names) {
		mazzo = new Mazzo();
		turno = new Turno();
		giocata = new Giocata(this);
		briscola = new Carta(mazzo.getBriscola());
		log = new GUIActivityFeed(this);
		
		players = new Player[2];
		for(int i=0; i < this.players.length; i++) {
			this.players[i] = new Player(names[i], this, i);
		}
		log.addFeed(GUIActivityFeed.inizioGame(players));
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
}
