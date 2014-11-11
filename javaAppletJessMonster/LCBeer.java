package javaAppletJessMonster;

import java.awt.Graphics;

public class LCBeer extends LeaderCard {
	public LCBeer(Leader l){
		super(l);
	}
	void activate() {
		Monster mon = player.getActiveMon();
		mon.setSpirit(mon.getSpirit() + 20);
		player.getApplet().textbox.getArray().add(new TextUnit("used Beer", player));
	}
	boolean isMet() {
		return true;
	}
	void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(player.getURL(),"Beer.jpg"), x,y, applet);
		g.drawString(nameToString() , x, y + 15);
		g.drawString(" 20" , x, y + 25);
		g.drawImage(applet.getImage(player.getURL(),"Spirit.jpg"), x,y + 30, applet);
	}
	@Override
	public String nameToString() {
		return "Beer";
		
	}
}
