package javaAppletJessMonster;

import java.awt.Graphics;

public class AHeadbutt extends Attack {
	public AHeadbutt(Monster mon){
		super(mon);
		setDamage(40);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - calcDamage());
		mon.setHP(mon.getHP() - 10);
		mon.setEnergy(mon.getEnergy() - 15);
		toTextBox( mon.nameToString() + " used Headbutt for " + calcDamage()+ " DMG");
	}
	public boolean isMet(Leader defender) {
		if(mon.getEnergy() < 15) {
			return false;
		}
		return true;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Headbutt), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Headbutt" , x + 35, y + 12);
		g.setFont(normalFont);
		g.drawString("15            /" , x + 35, y + 30);
		g.drawString("40 DMG (" + calcDamage()  + ")", x + 35, y + 45);
		g.drawString("-10 (" + calcDamage()+ ")" , x + 35, y + 65);
		g.drawImage(applet.getImage(Images.Energy), x + 55,y + 15, applet);
		g.drawImage(applet.getImage(Images.Health), x + 85,y + 50, applet);
	}

}
