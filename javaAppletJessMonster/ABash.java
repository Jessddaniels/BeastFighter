package javaAppletJessMonster;
import java.awt.Graphics;

public class ABash extends Attack {
	public ABash (Monster mon){
		super(mon);
		setHDamage(20);
		setExDamage(20);
	}
	public void attack( Leader defender) {
		hAttack(defender);
		exAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Bash for " + calcHDamage()+ " DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character") && ((Character) mon).CDice >= 2 && ((Character) mon).ExDice >= 1){
			return true;
		} else if (mon.getEnergy() >= 20){
			mon.setEnergy(mon.getEnergy() - 20);
			return true;
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Bash), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Bash" , x + 175 , y + 15);
		g.setFont(normalFont);
		g.drawString("20 DMG (" + calcHDamage() +")" , x + 150, y + 35);
		g.drawString("20          DMG (" + calcExDamage() +")" , x + 130, y + 55);
		g.drawImage(applet.getImage(Images.Combat), x + 150 ,y + 40, applet);
		g.drawString("20" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 30 ,y + 5, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Combat), x + 20 ,y + 45, applet);
		g.drawImage(applet.getImage(Images.Experience), x ,y + 45 , applet);
	}

}
