package javaAppletJessMonster;

import java.awt.Graphics;

public class AFireball extends Attack {
	public AFireball(Monster mon){
		super(mon);
		setHDamage(65);
		setEnergyCost(60);
	}
	public void attack( Leader defender) {
		hAttack(defender);
		toTextBox(mon.nameToString() + " used Fireball for " + calcHDamage()+ " DMG");
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.FireBall), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("           Fireball" , x, y + 20 );
		g.setFont(normalFont);
		g.drawImage(applet.getImage(Images.Energy), x + 35,y + 25, applet);
		g.drawString(getEnergyCost() +"            / "+getHDamage()+" DMG (" + calcHDamage() + ")" , x + 15, y + 40);
	}

}
