package javaAppletJessMonster;

import java.awt.Graphics;

public class ABodySlam extends Attack {
	public ABodySlam(Monster mon){
		super(mon);
		setDamage(mon.getHP() / 3);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		setDamage(mon.getHP() / 3);
		defender.getActiveMon().setHP(currentHP - calcDamage());
		mon.setEnergy(mon.getEnergy() - 20);
		toTextBox(mon.nameToString() + " used Body Slam for " + calcDamage() + " dmg");
	}
	public boolean isMet(Leader defender) {
		if (mon.getEnergy() < 20 || mon.getHP() < 0){
			return false;
		}
		return true;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.BodySlam), x,y, applet);
		g.drawImage(applet.getImage(Images.Energy), x + 105,y + 15, applet);
		g.drawImage(applet.getImage(Images.Health), x + 135,y + 45, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Body Slam" , x + 70, y + 13);
		g.setFont(normalFont);
		g.drawString("20         /", x + 85, y + 30);
		g.drawString("DMG " + mon.getHP() / 3 + " (" +calcDamage() + ")", x + 65, y + 45);
		setDamage(mon.getHP() / 3);
		g.drawString("DMG = 1/3 own", x + 50, y + 60);	
	}

}
