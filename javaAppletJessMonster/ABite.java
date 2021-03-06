package javaAppletJessMonster;

import java.awt.Graphics;

public class ABite extends Attack {
	public ABite(Monster mon){
		super(mon);
		setHDamage(30);
		setEnergyCost(20);
	}
	public void attack( Leader defender) {
		hAttack(defender);
		toTextBox(mon.nameToString() + " used Bite for " +calcHDamage()+ " dmg");
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Bite), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("             Bite" , x, y + 20);
		g.setFont(normalFont);
		g.drawImage(applet.getImage(Images.Energy), x + 35,y + 25, applet);
		g.drawString(getEnergyCost() + "          / "+getHDamage()+" DMG (" + calcHDamage() + ")" , x + 15, y + 40);
	}
}
