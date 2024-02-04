package Logical;

import GUI.GUIGiocata;
import Games.Game;

public class Giocata {
	private Game game;
	
	private GUIGiocata gui; 
	
	private Player[] players = new Player[2];
	private Carta[] carte = new Carta[2];
	
	private int n;
	
	public Giocata(Game g) {
		n=0;
		this.game = g;
		for(Player p: players) p=null;
		for(Carta c: carte) c=null;	
		
		gui = new GUIGiocata(this);
	}
	
	public void addGiocata(Carta c, Player p) {
		this.players[n] = p;
		this.carte[n] = c;
		
		n++;
	}
	
	public Carta[] getCarte() {
		return this.carte;
	}
	
	public void clear() {
		for(int i=0; i < this.players.length; i++) this.players[i]=null;
		for(int i=0; i < this.carte.length; i++) this.carte[i]=null;
		n = 0;
	}
	
	public void check() {
		if(carte[0].getSeme().equals(carte[1].getSeme())) {		
			if(carte[0].getValue() >= carte[1].getValue()) {
				this.game.getTurno().setTurno(this.game.getTurno().getTurno());
			} else {
				this.game.getTurno().setTurno(!this.game.getTurno().getTurno());
			}
		} else {
			if(carte[0].getSeme().equals(this.game.getBriscolaCard().getSeme())) {
				this.game.getTurno().setTurno(this.game.getTurno().getTurno());
			} else if(carte[1].getSeme().equals(this.game.getBriscolaCard().getSeme())) {
				this.game.getTurno().setTurno(!this.game.getTurno().getTurno());
			} else {
				this.game.getTurno().setTurno(this.game.getTurno().getTurno());
			}
		}
	}
	
	public int getPunti() {
		int punti=0;
		for(Carta c: carte) {
			punti += c.getValue();
		}
		return punti;
	}
	public GUIGiocata getGUI() {
		return this.gui;
	}
}
