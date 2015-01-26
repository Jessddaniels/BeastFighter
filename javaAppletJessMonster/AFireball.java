package javaAppletJessMonster;

import java.awt.Graphics;

public class AFireball extends Attack {
	public AFireball(Monster mon){
		super(mon);
		setHDamage(65);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - applyDamage());
		mon.setEnergy(mon.getEnergy() - 60);
		toTextBox(mon.nameToString() + " used Fireball for " + calcHDamage()+ " DMG");
	}
	public boolean isMet(Leader defender) {
		if (mon.getEnergy() < 60){
			return false;
		}
		return true;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.FireBall), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("           Fireball" , x, y + 20 );
		g.setFont(normalFont);
		g.drawImage(applet.getImage(Images.Energy), x + 35,y + 25, applet);
		g.drawString("60            / 65 DMG (" + calcHDamage() + ")" , x + 15, y + 40);
	}

}
