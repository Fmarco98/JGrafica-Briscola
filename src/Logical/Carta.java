package Logical;
import javax.swing.ImageIcon;

public class Carta {
	
	private int index;
	private String seme;
	private int value;
	private ImageIcon frontIcon;
	private ImageIcon backIcon=null;
	
	public Carta(Carta c) {
		this.index = c.index;
		this.seme = c.seme;
		this.value = c.value;
		this.frontIcon = c.frontIcon;
		this.backIcon = c.backIcon;
	}
	
	public Carta(int index, String seme) {
		int value = switch(index) {
			case 1 -> 11;
			case 3 -> 10;
			case 8 -> 2;
			case 9 -> 3;
			case 10 -> 4;
			default -> 0;
		};
		
		
		this.frontIcon = new ImageIcon("src/icon/carte/"+ seme+index +".png");
		//this.backIcon = new ImageIcon("src/icon/cartaBackIcon.png");
		
		this.value = value;
		this.index = index;
		this.seme = seme;
		
		
	}
	
	public int getValue() {
		return value;
	}
	public String getSeme() {
		return seme;
	}
	public int getIndex() {
		return index;
	}
	public ImageIcon getFrontImage() {
		return frontIcon;
	}
	public ImageIcon getBackImage() {
		return backIcon;
	}
	
	@Override
	public String toString() {
		String index = "";
		switch(this.index) {
			case 1:
				index = "Asso";
				break;
			case 8:
				index = "Fante";
				break;
			case 9:
				index = "Cavallo";
				break;
			case 10:
				index = "Re";
				break;
			default:
				index = this.index+"";
		}
		
		return index+" di "+this.seme/*+" | Valore: "+ this.value*/;
	}
}