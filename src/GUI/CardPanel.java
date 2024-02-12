package GUI;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JPanel;

import Logical.Carta;
import Logical.Player;

public class CardPanel extends JPanel{
	
	private Player player;
	
	public CardPanel(Player p) {
		this.player = p;
		
		this.setLayout(new FlowLayout());
		
		this.createPanel(this.player.getMano().getMano());
	}
	
	private void createPanel(List<Carta> cards) {
		for(int i=0; i < cards.size(); i++) {
			SelectionCardButton button = new SelectionCardButton(/*this.player.getMano().getMano().get(i), */ this.player, i);
			button.setIcon(cards.get(i).getCardImage());

			this.add(button);
		}
	}
	
	public void refresh() {
		this.removeAll();
		
		this.createPanel(this.player.getMano().getMano());
	}
	
}
