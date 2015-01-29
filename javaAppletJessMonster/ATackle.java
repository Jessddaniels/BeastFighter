package javaAppletJessMonster;

import java.awt.Graphics;

public class ATackle extends Attack {
	public ATackle(Monster mon){
		super(mon);
		setHDamage(25);
	}
	public void attack( Leader defender) {
		hAttack(defender);
		mon.setEnergy(mon.getEnergy() - 10);
		toTextBox(mon.nameToString() + " used Tackle for " +calcHDamage()+ " dmg");
	}
	public boolean isMet(Leader defender) {
		if (mon.getEnergy() < 10){
			return false;
		}
		return true;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.TakeDown), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("         Tackle" , x, y + 15);
		g.setFont(normalFont);
		g.drawImage(applet.getImage(Images.Energy), x + 33,y + 25, applet);
		g.drawString("10          / 25 DMG (" + calcHDamage() + ")" , x + 13, y + 40);
	}
}
