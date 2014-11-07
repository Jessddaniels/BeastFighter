package javaAppletJessMonster;

import java.awt.Graphics;

public class ADeathRoll extends Attack {
	public ADeathRoll(Monster mon){
		super(mon);
		setDamage(40);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - calcDamage());
		mon.setEnergy(mon.getEnergy() - 10);
		mon.applet.textbox.getArray().add(new TextUnit(mon.nameToString() + " used Death Roll for " + calcDamage()+ " DMG", mon.lead));
	}
	public boolean isMet(Leader defender) {
		if (mon.getEnergy() < 10 || defender.getActiveMon().getEnergy() >= mon.getEnergy()){
			return false;
		}
		return true;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(mon.getURL(),"DeathRoll.jpg"), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("         Death Roll" , x, y + 20);
		g.setFont(reqFont);
		g.drawString("         own          > opp",x , y + 35);
		g.setFont(normalFont);
		g.drawString("     10         / 40 DMG (" + calcDamage()+")" , x, y + 60);
		g.drawImage(applet.getImage(mon.getURL(),"Energy.jpg"), x + 55,y + 25, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Energy.jpg"), x + 110,y + 25, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Energy.jpg"), x + 30,y + 45, applet);
	}

}
