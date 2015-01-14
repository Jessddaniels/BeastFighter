package javaAppletJessMonster;
import java.awt.Graphics;

public class AFellingChop extends Attack {
	public AFellingChop (Monster mon){
		super(mon);
		setDamage(50);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - applyDamage());
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Timber for " + calcDamage()+ " DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character") && ((Character) mon).CDice >= 3 && ((Character) mon).ExDice >= 1){
			return true;
		} else if (mon.getEnergy() >= 60){
			mon.setEnergy(mon.getEnergy() - 60);
			return true;
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Virgeo1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Felling Chop" , x + 115 , y + 20);
		g.setFont(normalFont);
		g.drawString("50 DMG (" + calcDamage() +")" , x + 110, y + 35);
		g.drawString("80" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Combat), x + 20 ,y + 45, applet);
		g.drawImage(applet.getImage(Images.Experience), x ,y + 45 , applet);
		g.drawImage(applet.getImage(Images.Combat), x + 20 ,y + 25, applet);
	}

}
