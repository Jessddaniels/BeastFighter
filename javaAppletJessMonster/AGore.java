package javaAppletJessMonster;

import java.awt.Graphics;

public class AGore extends Attack {
	public AGore(Monster mon){
		super(mon);
		setHDamage(40);
		setEnergyCost(30);
	}
	public void attack( Leader defender) {
		hAttack(defender);
		toTextBox(mon.nameToString() + " used Gore for " + calcDamage()+ " DMG");
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Gore), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Gore" , x + 45, y + 12);
		g.setFont(normalFont);
		g.drawString(getEnergyCost() + "            /" , x + 35, y + 30);
		g.drawString(getHDamage() + " DMG (" + calcDamage()  + ")", x + 35, y + 45);
		g.drawString("1.5 X DMG if           < 40", x + 10, y + 65);
		g.drawImage(applet.getImage(Images.Energy), x + 55,y + 15, applet);
		g.drawImage(applet.getImage(Images.Health), x + 80,y + 50, applet);
	}
	public int calcDamage(){
		if (mon.getHP() < 40){
			return (int) (super.calcHDamage() * 1.5);
		} else {
			return super.calcHDamage();
		}
	}
}
