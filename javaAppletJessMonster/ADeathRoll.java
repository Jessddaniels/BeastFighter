package javaAppletJessMonster;

import java.awt.Graphics;

public class ADeathRoll extends Attack {
	public ADeathRoll(Monster mon){
		super(mon);
		setHDamage(40);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - applyDamage());
		mon.setEnergy(mon.getEnergy() - 10);
		toTextBox(mon.nameToString() + " used Death Roll for " + calcHDamage()+ " DMG");
	}
	public boolean isMet(Leader defender) {
		if (mon.getEnergy() < 10 || defender.getActiveMon().getEnergy() >= mon.getEnergy()){
			return false;
		}
		return true;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.DeathRoll), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("         Death Roll" , x, y + 20);
		g.setFont(reqFont);
		g.drawString("         own          > opp",x , y + 35);
		g.setFont(normalFont);
		g.drawString("     10         / 40 DMG (" + calcHDamage()+")" , x, y + 60);
		g.drawImage(applet.getImage(Images.Energy), x + 55,y + 25, applet);
		g.drawImage(applet.getImage(Images.Energy), x + 110,y + 25, applet);
		g.drawImage(applet.getImage(Images.Energy), x + 30,y + 45, applet);
	}

}
