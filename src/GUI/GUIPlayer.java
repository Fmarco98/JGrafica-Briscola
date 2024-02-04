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
	private JPanel gamePanel;

	private Player player;

	private GUIActivityFeed activityFeed;
	private GUIGiocata giocata;

	public GUIPlayer(Player p) {
		super("Briscola - "+p.getNome());
		this.setIconImage(Gioco1v1.ICO.getImage());
		this.giocata = p.getGame().getGiocata().getGUI();
		this.activityFeed = p.getGame().getLOG();
		
		this.player = p;

		this.setBounds(300, 100, 900, 700);
		this.setMinimumSize(new Dimension(870, 700));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().add(this.design());

		this.setVisible(true);
	}

	public void aggiorna() {
		//SwingUtilities.updateComponentTreeUI(this);
		gamePanel = this.design();
		//this.repaint();
		//this.setContentPane(gamePanel);


		JFrame f = new JFrame();
		f.add(gamePanel);

		this.setContentPane(f.getContentPane());
		this.invalidate();
		this.validate();

	}

	private JPanel design() {
		JPanel all = new JPanel();
		all.setLayout(new BorderLayout());
		all.add(leftPanel(), BorderLayout.WEST);
		all.add(gamePanel());

		return all;
		//this.repaint();
	}

	private JPanel leftPanel() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		//p.setMinimumSize(new Dimension(300, 700));
		p.setPreferredSize(new Dimension(200, 700));

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		JLabel plName = new JLabel(this.player.getNome());
		topPanel.add(plName);
		p.add(topPanel, BorderLayout.NORTH);

		JPanel acPanel = new JPanel();
		acPanel.setLayout(new GridLayout(1,1));
		acPanel.add(activityFeed.getThing());

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
			CardSelectionButton button = new CardSelectionButton(/*this.player.getMano().getMano().get(i), */ this.player, i);
			button.setIcon(this.player.getMano().getMano().get(i).getCardImage());

			selectionPanel.add(button);
		}
		gamePanel.add(selectionPanel, BorderLayout.SOUTH);

		//center panel
		JPanel giocataPanel = new JPanel();
		giocataPanel.setLayout(new BorderLayout());

		JPanel briscolaPanel = new JPanel();
		JLabel icon = new JLabel();
		icon.setIcon(this.player.getGame().getBriscolaCard().getCardImage());
		briscolaPanel.add(icon);

		gamePanel.add(briscolaPanel, BorderLayout.WEST);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout());
		centerPanel.add(giocata.getPanel());

		gamePanel.add(centerPanel);

		return gamePanel;
	}

	public Player getPlayer() {
		return this.player;
	}
}
