package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Logical.Player;

public class InfoPanel extends JPanel{

	private Player player;

	private String name;
	private GUIActivityFeed af;

	private JPanel topPanel;
	private JLabel nameLabel;

	public InfoPanel(Player p) {
		super();
		this.player = p;
		this.name = p.getNome();
		this.af = p.getGame().getLOG();

		this.topPanel = new JPanel();
		this.nameLabel = new JLabel(name);

		this.createPanel();
	}

	private void createPanel() {
		this.setLayout(new BorderLayout());
		//this.setMinimumSize(new Dimension(300, 700));
		this.setPreferredSize(new Dimension(200, 700));

		topPanel.setLayout(new FlowLayout());
		topPanel.add(nameLabel);
		
		this.add(topPanel, BorderLayout.NORTH);
		this.add(af);
	}
}
