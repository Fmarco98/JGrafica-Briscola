package Logical;

public class Turno {
	private boolean turno;
	
	public Turno() {
		this.turno = true;
	}
	
	public void nextTurno() {
		this.turno = !this.turno;
	}
	
	public int getIndexOfPlayingPlayer() {
		if(this.turno) {
			return 0;
		} else {
			return 1;
		}
	}
	
	public int getIndexOfNotPlayingPlayer() {
		if(this.turno) {
			return 1;
		} else {
			return 2;
		}
	}
}
