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
					JFrame f = new JFrame();
					f.setVisible(true);
					f.setSize(400, 500);
					f.getContentPane().add(c.getPlayer().getGame().getGiocata().getGUI().getPanel());
					
					c.getPlayer().getGame().getTurno().nextTurno();
				}
				if(c.getPlayer().getGame().getTurno().isTurnoComplete()) {
					
					
					
					c.getPlayer().getGame().getGiocata().clear();
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
