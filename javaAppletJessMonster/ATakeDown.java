package javaAppletJessMonster;

import java.awt.Graphics;

public class ATakeDown extends Attack {
	public ATakeDown(Monster mon){
		super(mon);
		setHDamage(50);
		setEnergyCost(20);
	}
	void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - 50);
		toTextBox(mon.nameToString() + " used Take Down for 50 DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (super.isMet(defender)){
			if (defender.getActiveMon().getHP() <= 50){
				return true;
			}
		}
		return false;
	}
	void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.TakeDown), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Take Down" , x + 20, y + 15);
		g.setFont(reqFont);
		g.drawString("opponent         <= 50" , x + 10, y + 30);
		g.setFont(normalFont);
		g.drawString("20           / 50 True DMG" , x + 10, y + 50);
		g.drawImage(applet.getImage(Images.Health), x + 60,y + 18, applet);
		g.drawImage(applet.getImage(Images.Energy), x + 30,y + 35, applet);
	}

}
