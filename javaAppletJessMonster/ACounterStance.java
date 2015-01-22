package javaAppletJessMonster;
import java.awt.Graphics;

public class ACounterStance extends Attack {
	public ACounterStance(Monster mon){
		super(mon);
		setCDamage(10);
	}
	public void attack( Leader defender) {
		int currentC = defender.getActiveMon().getCombat();
		defender.getActiveMon().setCombat(currentC - calcCDamage());
		mon.setCombat(mon.getCombat() + 10);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Counter Stance");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).ExDice >= 2 && ((Character) mon).CDice >= 2){
				return true;
			} else if (mon.getEnergy() >= 20){
				mon.setEnergy(mon.getEnergy() - 20);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Debira1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Counter Stance" , x + 102 , y + 22);
		g.setFont(normalFont);
		g.drawString("10          DMG (" + calcCDamage() +")" , x + 95, y + 35);
		g.drawImage(applet.getImage(Images.Combat), x + 115 ,y + 25, applet);
		g.drawString("10          ADD (" + calcCDamage() +")" , x + 95, y + 55);
		g.drawImage(applet.getImage(Images.Combat), x + 115 ,y + 45, applet);
		//en cost
		g.drawString("20" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		y += 2;
		g.drawImage(applet.getImage(Images.Combat), x ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 45 , applet);
		g.drawImage(applet.getImage(Images.Experience), x + 20 ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Experience), x + 20 ,y + 45 , applet);
	}

}
