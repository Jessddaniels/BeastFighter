package javaAppletJessMonster;

import java.awt.Graphics;

public class ATakeDown extends Attack {
	public ATakeDown(Monster mon){
		super(mon);
		setDamage(50);
	}
	void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - 50);
		mon.setEnergy(mon.getEnergy() - 20);
		mon.applet.textbox.getArray().add(new TextUnit(mon.nameToString() + " used Take Down for 50 DMG",mon.lead));
		
	}
	boolean isMet(Leader defender) {
		if (mon.getEnergy() < 20 || defender.getActiveMon().getHP() > 50){
			return false;
		}
		return true;
	}
	void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/TakeDown.jpg"), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Take Down" , x + 20, y + 15);
		g.setFont(reqFont);
		g.drawString("opponent         <= 50" , x + 10, y + 30);
		g.setFont(normalFont);
		g.drawString("20           / 50 True DMG" , x + 10, y + 50);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Health.jpg"), x + 60,y + 18, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Energy.jpg"), x + 30,y + 35, applet);
	}

}
