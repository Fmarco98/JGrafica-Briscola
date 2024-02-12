package Logical;

import Games.Game;

public class Bot extends Player{
	
	public Bot(Game game, int index) {
		super("Bot", game, index);
	}
	
	@Override
	public Carta gioca(int i) {
		if(super.getMano().getMano().size() != 0) {
			for(Carta c : super.getMano().getMano()) {
				if(c.getSeme() == super.getGame().getBriscolaCard().getSeme()) {
					return super.gioca(super.getMano().getMano().indexOf(c));
				}
			}
			return super.gioca((int)(Math.random()*super.getMano().getMano().size()));			
		}
		return null;
	}
	
	@Override
	public void enableGUI() {}
}
