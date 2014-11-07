package javaAppletJessMonster;

import java.awt.Graphics;

public class ARest extends Attack {
	public ARest(Monster mon){
		super(mon);
		setDamage(0);
	}
	void attack( Leader defender) {
		mon.setEnergy(mon.getEnergy() + 20);
		mon.applet.textbox.getArray().add(new TextUnit(mon.nameToString() + " used Rest", mon.lead));
	}
	boolean isMet(Leader defender) {
		return true;
	}
	void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(mon.getURL(),"Rest.jpg"), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("             Rest" , x, y + 20);
		g.setFont(normalFont);
		g.drawImage(applet.getImage(mon.getURL(),"Energy.jpg"), x + 40,y + 25, applet);
		g.drawString("                      + 20" , x, y +40);
	}

}
