package javaAppletJessMonster;

import java.awt.Graphics;

public class ABodySlam extends Attack {
	public ABodySlam(Monster mon){
		super(mon);
		setEnergyCost(20);
	}
	public void attack( Leader defender) {
		setHDamage(mon.getHP() / 3);
		hAttack(defender);
		toTextBox(mon.nameToString() + " used Body Slam for " + calcHDamage() + " dmg");
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.BodySlam), x,y, applet);
		g.drawImage(applet.getImage(Images.Energy), x + 105,y + 15, applet);
		g.drawImage(applet.getImage(Images.Health), x + 135,y + 45, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Body Slam" , x + 70, y + 13);
		g.setFont(normalFont);
		g.drawString(getEnergyCost() + "         /", x + 85, y + 30);
		g.drawString("DMG " + mon.getHP() / 3 + " (" +calcHDamage() + ")", x + 65, y + 45);
		setHDamage(mon.getHP() / 3);
		g.drawString("DMG = 1/3 own", x + 50, y + 60);	
	}

}
