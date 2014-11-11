package javaAppletJessMonster;

import java.awt.Graphics;

public class ABite extends Attack {
	public ABite(Monster mon){
		super(mon);
		setDamage(30);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - calcDamage());
		mon.setEnergy(mon.getEnergy() - 15);
		mon.applet.textbox.getArray().add(new TextUnit(mon.nameToString() + " used Bite for " +calcDamage()+ " dmg", mon.lead));
	}
	public boolean isMet(Leader defender) {
		if (mon.getEnergy() < 20){
			return false;
		}
		return true;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Bite.jpg"), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("             Bite" , x, y + 20);
		g.setFont(normalFont);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Energy.jpg"), x + 35,y + 25, applet);
		g.drawString("15          / 30 DMG (" + calcDamage() + ")" , x + 15, y + 40);
	}
}
