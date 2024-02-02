package GUI;
import javax.swing.JButton;

import Logical.Carta;

public class CardSelectionButton extends JButton{
	private int index;
	
	public CardSelectionButton(Carta c, int index) {
		super(c.toString());
		this.index = index;
	}
}
