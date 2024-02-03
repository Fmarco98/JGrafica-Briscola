package Logical;

public class Turno {
	private boolean turno;
	private int n;
	
	public Turno() {
		this.turno = false;
		n = 0;
	}
	
	public void nextTurno() {
		this.turno = !this.turno;
		n++;
	}
	public void setTurno(boolean b) {
		this.turno = b;
	}
	public boolean getTurno() {
		return this.turno;
	}
	
	public boolean isTurnoComplete() {
		boolean b = n == 2;
		if(b) {
			n = 0;
		}
		return b;
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
