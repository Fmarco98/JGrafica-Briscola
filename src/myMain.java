

import java.util.Scanner;

import javax.swing.JFrame;

import Games.Game;
import Games.Gioco1v1;
import Games.Gioco1vBot;

public class myMain {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Gioco 1 o 2: ");
		int gioco = in.nextInt();
		
		Game g=null;
		if(gioco == 1) {
			g = new Gioco1v1("Gino", "Mario");
		} else if (gioco == 2) {
			g = new Gioco1vBot("Gino");			
		} else {
			System.err.println("Coglione non sai leggere");
		}
		
		
		/*JFrame f = new JFrame();
		f.setSize(500, 700);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setVisible(true);
		f.getContentPane().add(g.getLOG());*/
	}
}