package javaAppletJessMonster;

import java.awt.Graphics;

public class StEnsnared extends Status{
	public StEnsnared(Monster mon, int value){
		super(mon, "DieRoll", value);
	}
	public void trigger(){
	}
	public void paint(Graphics g, int x, int y, int index, JessMonster applet) {
		g.drawImage(applet.getImage(getMon().getURL(),"Pictures/Die.jpg"), x + 10 + 20 * index,y + 175, applet);
		
	}
	void passive() {
		getMon().setCombat(getMon().getCombat() - getValue());
	}
}