package javaAppletJessMonster;

import java.awt.Graphics;

public class LCSteroids extends LeaderCard {
	public LCSteroids(Leader l){
		super(l);
	}
	void activate() {
		Monster mon = player.getActiveMon();
		mon.setHP(mon.getHP() - 15);
		mon.setPower(mon.getPower() + 20);
		mon.setSpirit(mon.getSpirit() - 20);
		player.getApplet().textbox.getArray().add(new TextUnit("used Steroids", player));
	}
	boolean isMet() {
		if (player.getActiveMon().getSpirit() >= 20){
			return true;
		}
		return false;
	}
	void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(player.getURL(),"Steroids.jpg"), x,y, applet);
		g.drawString(nameToString() , x, y + 15);
		g.drawString(" 20    -20   -15" , x, y + 25);
		g.drawImage(applet.getImage(player.getURL(),"Combat.jpg"), x,y + 30, applet);
		g.drawImage(applet.getImage(player.getURL(),"Spirit.jpg"), x + 30,y + 30, applet);
		g.drawImage(applet.getImage(player.getURL(),"Health.jpg"), x + 60,y + 30, applet);
	}
	@Override
	String nameToString() {
		// TODO Auto-generated method stub
		return "Steroids";
	}
}
