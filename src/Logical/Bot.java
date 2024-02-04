package Logical;

import Games.Game;

public class Bot extends Player{
	
	public Bot(Game game, int index) {
		super("Bot", game, index);
	}
	
	public Carta gioca(int i) {
		
		for(Carta c : super.getMano().getMano()) {
			if(c.getSeme() == super.getGame().getBriscolaCard().getSeme()) {
				return super.gioca(super.getMano().getMano().indexOf(c));
			}
		}
		return super.gioca((int)(Math.random()*super.getMano().getMano().size()));
	}
	
	public void enableGUI() {}
}
