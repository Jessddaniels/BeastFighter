package javaAppletJessMonster;

import java.awt.Graphics;

public class AAmbush extends Attack {
	public AAmbush(Monster mon){
		super(mon);
		setHDamage(65);
	}
	void attack( Leader defender) {
		hAttack(defender);
		mon.setEnergy(mon.getEnergy() - 50);
		toTextBox(mon.nameToString() + " used Ambush for "+calcHDamage()+" DMG");
		
	}
	boolean isMet(Leader defender) {
		if (mon.getEnergy() < 50 || defender.getActiveMon().getHP() <= calcHDamage()){
			return false;
		}
		return true;
	}
	void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.TakeDown), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Ambush" , x + 20, y + 15);
		g.setFont(reqFont);
		g.drawString("opponent         >" + calcHDamage() , x + 10, y + 30);
		g.setFont(normalFont);
		g.drawString("50           / 65 DMG (" + calcHDamage() + ")" , x + 10, y + 50);
		g.drawImage(applet.getImage(Images.Health), x + 60,y + 18, applet);
		g.drawImage(applet.getImage(Images.Energy), x + 30,y + 35, applet);
	}

}
