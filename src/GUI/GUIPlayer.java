package GUI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logical.Carta;
import Logical.Player;

public class GUIPlayer extends JFrame{
	private static GUIActivityFeed activityFeed = new GUIActivityFeed();
	
	private Player player;
	
	
	
	public GUIPlayer(Player p) {
		super("Briscola");
		
		this.player = p;
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.desing();
		this.setVisible(true);
	}
	
	public void desing() {
		this.setBounds(300, 100, 900, 700);
		this.setMinimumSize(new Dimension(500, 300));
		
		this.getContentPane().setLayout(new BorderLayout());
		this.add(leftPanel(), BorderLayout.WEST);
		this.add(gamePanel());
	}
	
	private JPanel leftPanel() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		JLabel plName = new JLabel("                   "+this.player.getNome()+"                   ");
		topPanel.add(plName);
		p.add(topPanel, BorderLayout.NORTH);
		
		JPanel acPanel = new JPanel();
		acPanel.setLayout(new GridLayout(1,1));
		acPanel.add(activityFeed);
		
		p.add(acPanel);
		
		return p;
	}
	
	private JPanel gamePanel() {
		JPanel gamePanel = new JPanel();
		gamePanel.setLayout(new BorderLayout());
		
		//top panel
		JPanel pointPanel = new JPanel();
		pointPanel.setLayout(new FlowLayout());
		JLabel pointJL = new JLabel("Punti: "+ this.player.getPunti());
		pointPanel.add(pointJL);
		gamePanel.add(pointPanel, BorderLayout.NORTH);
		
		//bottom panel
		JPanel selectionPanel = new JPanel();
		selectionPanel.setLayout(new FlowLayout());
		for(int i=0; i < this.player.getMano().getMano().size(); i++) {
			JPanel carta = new JPanel();
			carta.setLayout(new BorderLayout());
			
			JLabel ico = new JLabel();
			ico.setIcon(this.player.getMano().getMano().get(i).getFrontImage());
			carta.add(ico);
			
			CardSelectionButton button = new CardSelectionButton(this.player.getMano().getMano().get(i), i);
			carta.add(button, BorderLayout.SOUTH);
			
			selectionPanel.add(carta);
		}
		gamePanel.add(selectionPanel, BorderLayout.SOUTH);
		
		//center panel
		JPanel giocataPanel = new JPanel();
		giocataPanel.setLayout(new BorderLayout());
		
		JPanel briscolaPanel = new JPanel();
		JLabel icon = new JLabel();
		Carta briscola = new Carta(this.player.getGame().getMazzo().getBriscola());
		icon.setIcon(briscola.getFrontImage());
		briscolaPanel.add(icon);
		
		gamePanel.add(briscolaPanel, BorderLayout.WEST);
		
		return gamePanel;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public static GUIActivityFeed getActivityFeed() {
		return activityFeed;
	}
}
