package javaAppletJessMonster;

import java.awt.Graphics;

public class LCBeer extends LeaderCard {
	public LCBeer(Leader l){
		super(l);
	}
	void activate() {
		Monster mon = player.getActiveMon();
		mon.setSpirit(mon.getSpirit() + 5);
		mon.setExperience(mon.getExperience() + 50);//for testing
		toTextBox("used Beer");
	}
	boolean isMet() {
		return true;
	}
	void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.BeerCard), x,y, applet);
		g.drawString(nameToString() , x, y + 15);
		g.drawString(" 20" , x, y + 25);
		g.drawImage(applet.getImage(Images.Spirit), x,y + 30, applet);
	}
	public String nameToString() {
		return "Beer";
		
	}
}
