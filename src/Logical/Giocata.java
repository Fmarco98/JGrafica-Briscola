package Logical;

import GUI.GUIGiocata;

public class Giocata {
	private GUIGiocata gui; 
	
	private Player[] players = new Player[2];
	private Carta[] carte = new Carta[2];
	
	private int n;
	
	public Giocata() {
		n=0;
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
		for(Player p: players) p=null;
		for(Carta c: carte) c=null;
		n = 0;
	}
	
	public int getPunti() {
		return 0;
	}
	public GUIGiocata getGUI() {
		return this.gui;
	}
}
