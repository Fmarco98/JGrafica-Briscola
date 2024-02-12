package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Games.Gioco1v1;
import Logical.Player;

public class GUIPlayer extends JFrame{
	//proprietario
	private Player player;
	
	//parti grafiche
	private GUIActivityFeed activityFeed;
	private GUIGiocata giocata;
	private InfoPanel leftPanel;
	private CardPanel cardsSelectionPanel;
	private JLabel pointLabel;

	public GUIPlayer(Player p) {
		super("Briscola - "+p.getNome());
		this.setIconImage(Gioco1v1.ICO.getImage());
		this.giocata = p.getGame().getGiocata().getGUI();
		this.activityFeed = p.getGame().getLOG();
		
		this.player = p;

		this.setBounds(300, 100, 900, 700);
		this.setMinimumSize(new Dimension(870, 700));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.createFrame();

		this.setVisible(true);
	}

	public void refresh() {
		pointLabel.setText("Punti: "+ this.player.getPunti());
		
		cardsSelectionPanel.refresh();
		giocata.refresh();

		this.invalidate();
		this.validate();
	}
	

	private void createFrame() {
		leftPanel = new InfoPanel(this.getPlayer());
		cardsSelectionPanel = new CardPanel(this.getPlayer());
		pointLabel = new JLabel("Punti: "+ this.player.getPunti());
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(leftPanel, BorderLayout.WEST);
		this.getContentPane().add(gamePanel());
	}

	private JPanel gamePanel() {
		JPanel gamePanel = new JPanel();
		gamePanel.setLayout(new BorderLayout());

		//top panel
		JPanel pointPanel = new JPanel();
		pointPanel.setLayout(new FlowLayout());
		pointPanel.add(pointLabel);
		gamePanel.add(pointPanel, BorderLayout.NORTH);

		//bottom panel
		gamePanel.add(cardsSelectionPanel, BorderLayout.SOUTH);

		//center panel
		JPanel giocataPanel = new JPanel();
		giocataPanel.setLayout(new BorderLayout());

		JLabel briscola = new JLabel();
		briscola.setIcon(this.player.getGame().getBriscolaCard().getCardImage());

		gamePanel.add(briscola, BorderLayout.WEST);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout());
		centerPanel.add(giocata);

		gamePanel.add(centerPanel);

		return gamePanel;
	}

	public Player getPlayer() {
		return this.player;
	}
}
