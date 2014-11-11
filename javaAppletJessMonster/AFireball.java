package javaAppletJessMonster;

import java.awt.Graphics;

public class AFireball extends Attack {
	public AFireball(Monster mon){
		super(mon);
		setDamage(65);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - calcDamage());
		mon.setEnergy(mon.getEnergy() - 60);
		mon.applet.textbox.getArray().add(new TextUnit(mon.nameToString() + " used Fireball for " + calcDamage()+ " DMG",mon.lead));
	}
	public boolean isMet(Leader defender) {
		if (mon.getEnergy() < 60){
			return false;
		}
		return true;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Fireball.jpg"), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("           Fireball" , x, y + 20 );
		g.setFont(normalFont);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Energy.jpg"), x + 35,y + 25, applet);
		g.drawString("60            / 65 DMG (" + calcDamage() + ")" , x + 15, y + 40);
	}

}
