package javaAppletJessMonster;

import java.awt.Graphics;

public class ATackle extends Attack {
	public ATackle(Monster mon){
		super(mon);
		setDamage(25);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - calcDamage());
		mon.setEnergy(mon.getEnergy() - 10);
		mon.applet.textbox.getArray().add(new TextUnit(mon.nameToString() + " used Tackle for " +calcDamage()+ " dmg", mon.lead));
	}
	public boolean isMet(Leader defender) {
		if (mon.getEnergy() < 10){
			return false;
		}
		return true;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/TakeDown.jpg"), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("         Tackle" , x, y + 15);
		g.setFont(normalFont);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Energy.jpg"), x + 33,y + 25, applet);
		g.drawString("10          / 25 DMG (" + calcDamage() + ")" , x + 13, y + 40);
	}
}
