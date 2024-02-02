package Logical;

public class Gioco{
	
	private Mazzo mazzo;
	private Turno turno;
	private Giocata giocata;
	
	public Gioco() {
		mazzo = new Mazzo();
		turno = new Turno();
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
	
}
