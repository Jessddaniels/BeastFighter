package javaAppletJessMonster;
import java.awt.Graphics;

public class ATimber extends Attack {
	public ATimber(Monster mon){
		super(mon);
		setDamage(20);
		setCDamage(20);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - applyDamage());
		int currentC = defender.getActiveMon().getCombat();
		defender.getActiveMon().setCombat(currentC - calcCDamage());
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Timber for " + calcDamage()+ " DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character") && ((Character) mon).CDice >= 2 && ((Character) mon).EnDice >= 1){
			return true;
		} else if (mon.getEnergy() >= 40){
			mon.setEnergy(mon.getEnergy() - 40);
			return true;
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Virgeo1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Timber" , x + 115 , y + 20);
		g.setFont(normalFont);
		g.drawString("20 DMG (" + calcDamage() +")" , x + 110, y + 35);
		g.drawString("20          DMG (" + calcCDamage() +")" , x + 90, y + 55);
		g.drawImage(applet.getImage(Images.Combat), x + 110 ,y + 40, applet);
		g.drawString("40" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Combat), x + 20 ,y + 45, applet);
		g.drawImage(applet.getImage(Images.Energy), x ,y + 45 , applet);
	}

}
