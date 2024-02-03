package Logical;

public class Gioco1v1{
	
	private Mazzo mazzo;
	private Turno turno;
	private Giocata giocata;
	private Player[] players;
	private Carta briscola;
	
	public Gioco1v1() {
		mazzo = new Mazzo();
		turno = new Turno();
		giocata = new Giocata(this);
		briscola = new Carta(mazzo.getBriscola());
		
		players = new Player[2];
		for(int i=0; i < this.players.length; i++) {
			this.players[i] = new Player("Gino"+i, this, i);
		}
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
}
