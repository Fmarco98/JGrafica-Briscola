package Logical;

public class Turno {
	private boolean turno;
	
	public Turno() {
		this.turno = false;
	}
	
	public void nextTurno() {
		this.turno = !this.turno;
	}
	
	public boolean isTurnoComplete() {
		return this.turno != true;
	}
	
	public int getIndexOfPlayingPlayer() {
		if(this.turno) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public int getIndexOfNotPlayingPlayer() {
		if(this.turno) {
			return 0;
		} else {
			return 1;
		}
	}
}
