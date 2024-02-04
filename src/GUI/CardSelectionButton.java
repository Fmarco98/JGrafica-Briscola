package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Games.Game;
import Logical.Carta;
import Logical.Giocata;
import Logical.Player;

public class CardSelectionButton extends JButton{
	private Player player;
	
	private int index;
	
	public CardSelectionButton(/*Carta c,*/ Player p, int index) {
		super(/*c.toString()*/);
		this.index = index;
		this.player = p;
		
		CardSelectionButton c = this;
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Player players[] = c.getPlayer().getGame().getPlayers();
				Giocata giocata = c.getPlayer().getGame().getGiocata();
				
				if(c.getPlayer().getIndex() == c.getPlayer().getGame().getTurno().getIndexOfPlayingPlayer()) {
					Carta played = c.getPlayer().gioca(index);
					giocata.addGiocata(played, c.getPlayer());
					
					refresh(players);
					c.getPlayer().getGame().getTurno().nextTurno();
				}
				
				do {					
					if(c.getPlayer().getGame().isThereBot() && !c.getPlayer().getGame().getTurno().isTurnoComplete()) {
						if(c.getPlayer().getGame().getTurno().getIndexOfPlayingPlayer() == 1) {
							Carta cc = players[1].gioca(-1);
							giocata.addGiocata(cc, players[1]);
						}
						refresh(players);
						c.getPlayer().getGame().getTurno().nextTurno();
						//Game.pause();
					}
					
					if(c.getPlayer().getGame().getTurno().isTurnoComplete()) {
						c.getPlayer().getGame().getTurno().reset();
						for(Player p: c.getPlayer().getGame().getPlayers()) {
							p.getMano().pesca();
						}
						
						giocata.check();
						Player winner = players[c.getPlayer().getGame().getTurno().getIndexOfPlayingPlayer()];
						winner.addPunti(c.getPlayer().getGame().getGiocata().getPunti());
						
						c.getPlayer().getGame().getLOG().addFeed(GUIActivityFeed.vintoGiocata(winner, c.getPlayer().getGame().getGiocata()));
						giocata.clear();
						
						refresh(players);			
					}
					if(players[0].getMano().getMano().size() == 0 && players[1].getMano().getMano().size() == 0) {
						if(players[0].getPunti() == players[1].getPunti()) {
							c.getPlayer().getGame().getLOG().addFeed("Pareggio");
						} else {						
							Player winner = players[0].getPunti() > players[1].getPunti() ? players[0] : players[1];
							c.getPlayer().getGame().getLOG().addFeed(GUIActivityFeed.vintoGame(winner));
						}
					}
					
					
				} while(c.getPlayer().getGame().isThereBot() && c.getPlayer().getGame().getTurno().getIndexOfPlayingPlayer() == 1);
			}
			
			public void refresh(Player[] players) {
				for(Player p: players) {
					if(p.getGUI() != null) p.getGUI().aggiorna();
				}
			}
		});
	}
	
	public Player getPlayer() {
		return this.player;
	}
	public int getIndex() {
		return this.index;
	}
}
