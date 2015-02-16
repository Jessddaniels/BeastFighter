package javaAppletJessMonster;

import java.awt.Graphics;

public class ASpiritSink extends Attack {
	public ASpiritSink(Monster mon){
		super(mon);
		setHDamage(20);
		setSDamage(20);
		setEnergyCost(25);
	}
	public void attack( Leader defender) {
		hAttack(defender);
		sAttack(defender);
		toTextBox( mon.nameToString() + " used Spirit Sink");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.SpiritSink), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Spirit Sink" , x, y + 15);
		g.setFont(normalFont);
		g.drawString(getEnergyCost() + "           /           -20" , x, y + 35);
		g.drawString(getHDamage() + " DMG ( " + calcHDamage()+ ")" , x, y + 50);
		g.drawImage(applet.getImage(Images.Energy), x + 22,y + 18, applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 57,y + 18, applet);
	}
}
