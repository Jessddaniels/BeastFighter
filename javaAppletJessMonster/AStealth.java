package javaAppletJessMonster;

import java.awt.Graphics;

public class AStealth extends Attack {
	public AStealth(Monster mon){
		super(mon);
		setCGain(25);
		setEnergyCost(40);
	}
	public void attack( Leader defender) {
		mon.setCombat(mon.getCombat() + getCGain());
		mon.lead.tradeOK = true;
		mon.lead.myTurn = true;
		toTextBox(mon.nameToString() + " used Stealth");
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.DeathRoll), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("             Stealth" , x, y + 20);
		g.setFont(normalFont);
		g.drawString("                + " + getCGain(),x , y + 35);
		g.drawString(getEnergyCost() + "         / Switch Active" , x + 15, y + 60);
		g.drawImage(applet.getImage(Images.Combat), x + 75,y + 25, applet);
		g.drawImage(applet.getImage(Images.Energy), x + 30,y + 45, applet);
	}

}
