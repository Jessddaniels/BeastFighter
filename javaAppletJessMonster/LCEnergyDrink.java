package javaAppletJessMonster;

import java.awt.Graphics;

public class LCEnergyDrink extends LeaderCard {
	public LCEnergyDrink(Leader l){
		super(l);
	}
	void activate() {
		Monster mon = player.getActiveMon();
		mon.setEnergy(mon.getEnergy() + 20);
		mon.setSpirit(mon.getSpirit() - 20);
		toTextBox("used Energy Drink");
	}
	boolean isMet() {
		if (player.getActiveMon().getSpirit() >= 20){
			return true;
		}
		return false;
	}
	void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(player.getURL(),"Pictures/EnergyDrink.jpg"), x,y, applet);
		g.drawString(nameToString() , x, y + 15);
		g.drawString(" 20     -20" , x, y + 25);
		g.drawImage(applet.getImage(player.getURL(),"Pictures/Energy.jpg"), x,y + 30, applet);
		g.drawImage(applet.getImage(player.getURL(),"Pictures/Spirit.jpg"), x + 30,y + 30, applet);
	}
	String nameToString() {
		return "Energy Drink";
	}
}
