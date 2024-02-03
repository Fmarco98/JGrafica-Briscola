package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Logical.Carta;
import Logical.Player;

public class CardSelectionButton extends JButton{
	private Player players;
	
	private int index;
	
	public CardSelectionButton(/*Carta c,*/ Player p, int index) {
		super(/*c.toString()*/);
		this.index = index;
		this.players = p;
		
		CardSelectionButton c = this;
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(c.getPlayer().getIndex() == c.getPlayer().getGame().getTurno().getIndexOfPlayingPlayer()) {
					Carta played = c.getPlayer().gioca(index);
					c.getPlayer().getGame().getGiocata().addGiocata(played, c.getPlayer());
					
					for(Player p: c.getPlayer().getGame().getPlayers()) {
						p.getGUI().aggiorna();
					}
					c.getPlayer().getGame().getTurno().nextTurno();
				}
				if(c.getPlayer().getGame().getTurno().isTurnoComplete()) {
					for(Player p: c.getPlayer().getGame().getPlayers()) {
						p.getMano().pesca();
						p.getGUI().aggiorna();
					}
					
					c.getPlayer().getGame().getGiocata().check();
					Player winner = c.getPlayer().getGame().getPlayers()[c.getPlayer().getGame().getTurno().getIndexOfPlayingPlayer()];
					winner.addPunti(c.getPlayer().getGame().getGiocata().getPunti());
					
					c.getPlayer().getGame().getLOG().addFeed(GUIActivityFeed.vintoGiocata(winner, c.getPlayer().getGame().getGiocata()));
					c.getPlayer().getGame().getGiocata().clear();
					
					for(Player p: c.getPlayer().getGame().getPlayers()) {
						p.getGUI().aggiorna();
					}				
				}
				Player players[] = c.getPlayer().getGame().getPlayers();
				if(players[0].getMano().getMano().size() == 0 && players[1].getMano().getMano().size() == 0) {
					if(players[0].getPunti() == players[1].getPunti()) {
						c.getPlayer().getGame().getLOG().addFeed("Pareggio");
					} else {						
						Player winner = players[0].getPunti() > players[1].getPunti() ? players[0] : players[1];
						c.getPlayer().getGame().getLOG().addFeed(GUIActivityFeed.vintoGame(winner));
					}
				}
			}
		});
	}
	
	public Player getPlayer() {
		return this.players;
	}
	public int getIndex() {
		return this.index;
	}
}
