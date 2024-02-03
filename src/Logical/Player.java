package Logical;

import GUI.GUIPlayer;

public class Player{
	private Gioco game;
	
	private int index;
	private int punti;
	private String nome;
	private Mano mano;
	
	private GUIPlayer gui;
	
	public Player(String nome, Gioco game, int i) {
		this.index = i;
		this.game = game;
		this.punti = 0;
		this.nome = nome;
		this.mano = new Mano(this.game.getMazzo());
		
		gui = new GUIPlayer(this);
	}
	
	public String getNome() {
		return nome;
	}
	public Mano getMano() {
		return mano;
	}
	public int getPunti() {
		return punti;
	}
	
	public Carta gioca(int index) {
		Carta c = this.mano.getMano().get(index);
		this.mano.getMano().remove(c);
		return c;
	}
	
	public void fineTurno() {		
		this.mano.pesca();
	}
	public void vintoGiocata(int punti) {
		this.punti += punti;
	}
	public boolean isInGame() {
		if(this.mano.getMano().size() != 0) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return this.mano.toString();
	}
	public Gioco getGame() {
		return this.game;
	}
	public int getIndex() {
		return this.index;
	}
	public GUIPlayer getGUI() {
		return this.gui;
	}
}
