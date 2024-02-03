package Logical;

public class Gioco{
	
	private Mazzo mazzo;
	private Turno turno;
	private Giocata giocata;
	private Player[] players;
	
	public Gioco() {
		mazzo = new Mazzo();
		turno = new Turno();
		giocata = new Giocata();
		
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
}
