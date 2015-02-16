package javaAppletJessMonster;

import java.awt.Graphics;

public class AHeadbutt extends Attack {
	public AHeadbutt(Monster mon){
		super(mon);
		setHDamage(40);
		setEnergyCost(15);
	}
	public void attack( Leader defender) {
		hAttack(defender);
		mon.setHP(mon.getHP() - 10);
		toTextBox( mon.nameToString() + " used Headbutt for " + calcHDamage()+ " DMG");
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Headbutt), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Headbutt" , x + 35, y + 12);
		g.setFont(normalFont);
		g.drawString(getEnergyCost() + "            /" , x + 35, y + 30);
		g.drawString(getHDamage() + " DMG (" + calcHDamage()  + ")", x + 35, y + 45);
		g.drawString("-10 (" + calcHDamage()+ ")" , x + 35, y + 65);
		g.drawImage(applet.getImage(Images.Energy), x + 55,y + 15, applet);
		g.drawImage(applet.getImage(Images.Health), x + 85,y + 50, applet);
	}

}
