package javaAppletJessMonster;

import java.awt.Graphics;

public class StEnsnared extends Status{
	public StEnsnared(Monster mon, int value){
		super(mon, "StEnsnared", value);
		setSavingsRoll(new DieSet(0,0,3,0,0,0));
	}
	public void trigger(){
		getMon().setCombat(getMon().getCombat() - getValue());
	}
	public void paint(Graphics g, int x, int y, int index, JessMonster applet) {
		g.drawImage(applet.getImage(getMon().getURL(),"Pictures/Die.jpg"), x + 10 + 20 * index,y + 175, applet);
		
	}
	public void passive() {
	}
}