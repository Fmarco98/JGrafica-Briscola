package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Logical.Carta;
import Logical.Giocata;
import Logical.Player;
import Logical.Turno;

public class SelectionCardButton extends JButton{
	private Player player;
	
	private int index;
	
	public SelectionCardButton(/*Carta c,*/ Player p, int index) {
		super(/*c.toString()*/);
		this.index = index;
		this.player = p;
		
		SelectionCardButton c = this;
		this.addActionListener(new ActionListener() {
			private Player players[] = c.getPlayer().getGame().getPlayers();
			private Giocata giocata = c.getPlayer().getGame().getGiocata();
			private Turno turno = c.getPlayer().getGame().getTurno();

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(c.getPlayer().getIndex() == turno.getIndexOfPlayingPlayer()) {
					Carta played = c.getPlayer().gioca(index);
					giocata.addGiocata(played, c.getPlayer());
					
					refresh(players);
					turno.nextTurno();
				}
				
				do {					
					if(c.getPlayer().getGame().isThereBot() && !turno.isTurnoComplete()) {
						if(turno.getIndexOfPlayingPlayer() == 1) {
							Carta cc = players[1].gioca(-1);
							giocata.addGiocata(cc, players[1]);
						}
						refresh(players);
						turno.nextTurno();
						//Game.pause();
					}
					
					if(turno.isTurnoComplete()) {
						turno.reset();
						
						giocata.check();
						Player winner = players[turno.getIndexOfPlayingPlayer()];
						Player loser = players[turno.getIndexOfNotPlayingPlayer()];
						winner.addPunti(giocata.getPunti());
						
						winner.getMano().pesca();
						loser.getMano().pesca();
						
						c.getPlayer().getGame().getLOG().addFeed(GUIActivityFeed.vintoGiocata(winner, c.getPlayer().getGame().getGiocata()));
						giocata.clear();
						
						refresh(players);			
					}
				} while(c.getPlayer().getGame().isThereBot() && turno.getIndexOfPlayingPlayer() == 1);
				
				endCheck();
			}
			
			public void endCheck() {
				if(players[0].getMano().getMano().size() == 0 && players[1].getMano().getMano().size() == 0) {
					if(players[0].getPunti() == players[1].getPunti()) {
						c.getPlayer().getGame().getLOG().addFeed("Pareggio");
					} else {						
						Player winner = players[0].getPunti() > players[1].getPunti() ? players[0] : players[1];
						c.getPlayer().getGame().getLOG().addFeed(GUIActivityFeed.vintoGame(winner));
					}
					//Game.pause();
					//c.getPlayer().getGame().end();
				}				
			}
			
			public void refresh(Player[] players) {
				for(Player p: players) {
					if(p.getGUI() != null) p.getGUI().refresh();
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
