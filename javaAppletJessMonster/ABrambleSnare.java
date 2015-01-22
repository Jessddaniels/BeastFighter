package javaAppletJessMonster;
import java.awt.Graphics;

public class ABrambleSnare extends Attack {
	public ABrambleSnare(Monster mon){
		super(mon);
		setCDamage(10);
		setEnDamage(10);
	}
	public void attack( Leader defender) {
		int currentC = defender.getActiveMon().getCombat();
		defender.getActiveMon().setCombat(currentC - calcCDamage());
		int currentEn = defender.getActiveMon().getEnergy();
		defender.getActiveMon().setEnergy(currentEn - calcEnDamage());
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Bramble Snare");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character") && ((Character) mon).ExDice >= 2){
			return true;
		} else if (mon.getEnergy() >= 15){
			mon.setEnergy(mon.getEnergy() - 15);
			return true;
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Virgeo2Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Bramble Snare" , x + 110 , y + 20);
		g.setFont(normalFont);
		g.drawString("10          DMG (" + calcCDamage() +")", x + 90, y + 35);
		g.drawImage(applet.getImage(Images.Combat), x + 110 ,y + 25, applet);
		g.drawString("10          DMG (" + calcEnDamage() +")" , x + 90, y + 55);
		g.drawImage(applet.getImage(Images.Energy), x + 110 ,y + 45, applet);
		//en cost
		g.drawString("15" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Experience), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Experience), x ,y + 47 , applet);
	}

}
