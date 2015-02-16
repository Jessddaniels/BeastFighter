package javaAppletJessMonster;

import java.awt.Graphics;

public class ARecover extends Attack {
	public ARecover(Monster mon){
		super(mon);
		setHDamage(0);
		setEnergyCost(999999);
		setReqDice(new DieSet(0,0,3,0,0,0));
	}
	void attack( Leader defender) {
		mon.setEnergy(mon.getEnergy() + 50);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Recover");
	}
	void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Rest), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("          Recover" , x, y + 20);
		g.setFont(normalFont);
		g.drawImage(applet.getImage(Images.Energy), x + 40,y + 25, applet);
		g.drawString("                      + 50" , x, y +40);
		g.drawImage(applet.getImage(Images.Energy), x ,y , applet);
		g.drawImage(applet.getImage(Images.Energy), x ,y + 20, applet);
		g.drawImage(applet.getImage(Images.Energy), x ,y + 40 , applet);
	}

}
