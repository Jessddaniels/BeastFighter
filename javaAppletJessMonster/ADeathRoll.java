package javaAppletJessMonster;

import java.awt.Graphics;

public class ADeathRoll extends Attack {
	public ADeathRoll(Monster mon){
		super(mon);
		setHDamage(40);
		setEnergyCost(10);
	}
	public void attack( Leader defender) {
		hAttack(defender);
		toTextBox(mon.nameToString() + " used Death Roll for " + calcHDamage()+ " DMG");
	}
	public boolean isMet(Leader defender) {
		if (super.isMet(defender)){
			if (defender.getActiveMon().getEnergy() < mon.getEnergy()){
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.DeathRoll), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("         Death Roll" , x, y + 20);
		g.setFont(reqFont);
		g.drawString("         own          > opp",x , y + 35);
		g.setFont(normalFont);
		g.drawString(getEnergyCost() + "         / 40 DMG (" + calcHDamage()+")" , x + 10, y + 60);
		g.drawImage(applet.getImage(Images.Energy20), x + 55,y + 25, applet);
		g.drawImage(applet.getImage(Images.Energy20), x + 110,y + 25, applet);
		g.drawImage(applet.getImage(Images.Energy20), x + 30,y + 45, applet);
	}

}
