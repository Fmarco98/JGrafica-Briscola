package GUI;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Logical.Carta;
import Logical.Player;

public class GUIPlayer extends JFrame{
	private static GUIActivityFeed activityFeed = new GUIActivityFeed();
	private JPanel gamePanel;
	
	private Player player;
	
	private GUIGiocata giocata;
	
	public GUIPlayer(Player p) {
		super("Briscola");
		//this.giocata = p.getGame().getGiocata().getGUI();
		this.giocata = p.getGame().getGiocata().getGUI();
		
		this.player = p;
		
		this.setBounds(300, 100, 900, 700);
		this.setMinimumSize(new Dimension(800, 700));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().add(this.desing());
		
		this.setVisible(true);
	}
	
	public void aggiorna() {
		//SwingUtilities.updateComponentTreeUI(this);
		gamePanel = this.desing();
		//this.repaint();
		//this.setContentPane(gamePanel);
		
		
		JFrame f = new JFrame();
		f.add(gamePanel);
		
		this.setContentPane(f.getContentPane());
		this.invalidate();
		this.validate();
		
	}
	
	private JPanel desing() {
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
			
			//JLabel ico = new JLabel();
			//ico.setIcon(this.player.getMano().getMano().get(i).getFrontImage());
			//carta.add(ico);
			
			CardSelectionButton button = new CardSelectionButton(/*this.player.getMano().getMano().get(i), */ this.player, i);
			button.setIcon(this.player.getMano().getMano().get(i).getFrontImage());
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
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout());
		//centerPanel.add(new Gap(), BorderLayout.WEST);
		centerPanel.add(giocata.getPanel());
		
		gamePanel.add(centerPanel);
		
		return gamePanel;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public static GUIActivityFeed getActivityFeed() {
		return activityFeed;
	}
}
