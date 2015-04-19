package javaAppletJessMonster;

import java.awt.Graphics;

public class LCHealthPack extends LeaderCard {
	public LCHealthPack(Leader l){
		super(l);
	}
	void activate() {
		Monster mon = player.getActiveMon();
		mon.setHP(mon.getHP() + 20);
		mon.setSpirit(mon.getSpirit() - 20);
		toTextBox("used Health Pack");
	}
	boolean isMet() {
		if (player.getActiveMon().getSpirit() >= 20){
			return true;
		}
		return false;
	}
	void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(player.getURL(),"Pictures/HealthPack.jpg"), x,y, applet);
		g.drawString(nameToString() , x, y + 15);
		g.drawString(" 20     -20" , x, y + 25);
		g.drawImage(applet.getImage(Images.Health), x,y + 30, applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 30,y + 30, applet);
	}
	String nameToString() {
		return "Health Pack";
	}
}
