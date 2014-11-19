package javaAppletJessMonster;

import java.awt.Graphics;

public class LCProtein extends LeaderCard {
	public LCProtein(Leader l){
		super(l);
	}
	void activate() {
		Monster mon = player.getActiveMon();
		mon.setCombat(mon.getCombat() + 10);
		mon.setSpirit(mon.getSpirit() - 20);
		toTextBox("used Protein");
	}
	boolean isMet() {
		if (player.getActiveMon().getSpirit() >= 20){
			return true;
		}
		return false;
	}
	void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(player.getURL(),"Pictures/Protein.jpg"), x,y, applet);
		g.drawString(nameToString() , x, y + 15);
		g.drawString(" 10     -20" , x, y + 25);
		g.drawImage(applet.getImage(player.getURL(),"Pictures/Combat.jpg"), x,y + 30, applet);
		g.drawImage(applet.getImage(player.getURL(),"Pictures/Spirit.jpg"), x + 30,y + 30, applet);
	}
	@Override
	String nameToString() {
		// TODO Auto-generated method stub
		return "Protein";
	}
}
