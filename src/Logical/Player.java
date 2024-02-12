package Logical;

import GUI.GUIPlayer;
import Games.Game;
import Games.Gioco1v1;

public class Player{
	private Game game;
	
	private int index;
	private int punti;
	private String nome;
	private Mano mano;
	
	private GUIPlayer gui=null;
	
	public Player(String nome, Game game, int i) {
		this.index = i;
		this.game = game;
		this.punti = 0;
		this.nome = nome;
		this.mano = new Mano(this.game.getMazzo());
	}
	
	public void enableGUI() {
		if(gui == null) {
			gui = new GUIPlayer(this);
		}
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
	public void addPunti(int p) {
		this.punti += p;
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
		return "Index: "+this.index+": "+this.mano.toString();
	}
	public Game getGame() {
		return this.game;
	}
	public int getIndex() {
		return this.index;
	}
	public GUIPlayer getGUI() {
		return this.gui;
	}
}
