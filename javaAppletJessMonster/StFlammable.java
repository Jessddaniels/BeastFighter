package javaAppletJessMonster;

import java.awt.Graphics;

public class StFlammable extends Status{
	public StFlammable(Monster mon, int value){
		super(mon, "StFlammable", value);
	}
	public void trigger(){
		getMon().setHP(getMon().getHP() - getValue());
	}
	public void paint(Graphics g, int x, int y, int index, JessMonster applet) {
		g.drawImage(applet.getImage(getMon().getURL(),"Pictures/Die.jpg"), x + 10 + 20 * index,y + 175, applet);
		
	}
}
