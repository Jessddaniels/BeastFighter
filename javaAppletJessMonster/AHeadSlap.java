package javaAppletJessMonster;
import java.awt.Graphics;

public class AHeadSlap extends Attack {
	public AHeadSlap (Monster mon){
		super(mon);
		setHDamage(10);
		setExDamage(10);
	}
	public void attack( Leader defender) {
		hAttack(defender);
		exAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Head Slap for " + calcHDamage()+ " DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character") && ((Character) mon).CDice >= 2 && ((Character) mon).ExDice >= 1){
			return true;
		} else if (mon.getEnergy() >= 15){
			mon.setEnergy(mon.getEnergy() - 15);
			return true;
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Adipedys2Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Head Slap" , x + 110 , y + 20);
		g.setFont(normalFont);
		g.drawString("10 DMG (" + calcHDamage() +")" , x + 105, y + 35);
		g.drawString("10          DMG (" + calcExDamage() +")" , x + 105, y + 55);
		g.drawImage(applet.getImage(Images.Experience), x + 120 ,y + 40, applet);
		//en cost
		g.drawString("15" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Combat), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Experience), x + 20 ,y + 27, applet);
	}

}
