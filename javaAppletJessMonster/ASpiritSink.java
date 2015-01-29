package javaAppletJessMonster;

import java.awt.Graphics;

public class ASpiritSink extends Attack {
	public ASpiritSink(Monster mon){
		super(mon);
		setHDamage(20);
		setSDamage(20);
	}
	public void attack( Leader defender) {
		mon.setEnergy(mon.getEnergy() - 25);
		hAttack(defender);
		sAttack(defender);
		toTextBox( mon.nameToString() + " used Spirit Sink");
		
	}
	public boolean isMet(Leader defender) {
		if(mon.getEnergy() < 25) {
			return false;
		}
		return true;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.SpiritSink), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Spirit Sink" , x, y + 15);
		g.setFont(normalFont);
		g.drawString("25           /           -20" , x, y + 35);
		g.drawString("20 DMG ( " + calcHDamage()+ ")" , x, y + 50);
		g.drawImage(applet.getImage(Images.Energy), x + 22,y + 18, applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 57,y + 18, applet);
	}
}
