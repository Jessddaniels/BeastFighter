package javaAppletJessMonster;
import java.awt.Graphics;

public class AHeadSlap extends Attack {
	public AHeadSlap (Monster mon){
		super(mon);
		setDamage(20);
		setExDamage(20);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - calcDamage());
		int currentEx = defender.getActiveMon().getDamage();
		defender.getActiveMon().setExperience(currentEx - calcExDamage());
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Head Slap for " + calcDamage()+ " DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (!mon.type.equals("character") || ((Character) mon).CDice < 2 || ((Character) mon).ExDice < 1 || mon.getEnergy() < 30){
			return false;
		}
		return true;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.HeadSlap), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Head Slap" , x + 70 , y + 15);
		g.setFont(normalFont);
		g.drawString("20 DMG (" + calcDamage() +")" , x + 70, y + 35);
		g.drawString("20          DMG (" + calcExDamage() +")" , x + 70, y + 55);
		g.drawImage(applet.getImage(Images.Experience), x + 90 ,y + 40, applet);
		g.drawString("40" , x + 10, y + 20);
		//dice
		g.drawImage(applet.getImage(Images.Energy), x + 30 ,y + 5, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Combat), x + 20 ,y + 45, applet);
		g.drawImage(applet.getImage(Images.Experience), x ,y + 45 , applet);
	}

}
