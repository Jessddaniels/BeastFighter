package javaAppletJessMonster;

import java.awt.Graphics;

public class ARest extends Attack {
	public ARest(Monster mon){
		super(mon);
		setHDamage(0);
		setEnergyCost(0);
	}
	void attack( Leader defender) {
		mon.setEnergy(mon.getEnergy() + 20);
		toTextBox(mon.nameToString() + " used Rest");
	}
	void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Rest), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("             Rest" , x, y + 20);
		g.setFont(normalFont);
		g.drawImage(applet.getImage(Images.Energy), x + 40,y + 25, applet);
		g.drawString("                      + 20" , x, y +40);
	}

}
