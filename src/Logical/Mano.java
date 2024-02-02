package Logical;
import java.util.ArrayList;
import java.util.List;

public class Mano {
	private Mazzo mazzo;
	
	private List<Carta> mano = new ArrayList<>();
		
	public Mano(Mazzo m) {
		this.mazzo = m;
		
		for(int i=0; i < 3; i++) {
			this.mano.add(mazzo.pesca());
		}
	}

	public List<Carta> getMano() {
		return mano;
	}
	public void setMano(List<Carta> mano) {
		this.mano = mano;
	}
	
	public void pesca() {
		this.mano.add(mazzo.pesca());
	}
	
	@Override
	public String toString() {
		String s="";
		
		for(Carta c : this.mano) {
			s += c.toString()+"\n";
		}
		
		return s;
	}
}
