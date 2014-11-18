package javaAppletJessMonster;

import java.awt.Graphics;

public class ARecover extends Attack {
	public ARecover(Monster mon){
		super(mon);
		setDamage(0);
	}
	void attack( Leader defender) {
		mon.setEnergy(mon.getEnergy() + 50);
		((Character) mon).EnDice -= 3;
		((Character) mon).RollNum = 3;
		mon.applet.textbox.getArray().add(new TextUnit(mon.nameToString() + " used Recover", mon.lead));
	}
	boolean isMet(Leader defender) {
		if (!mon.type.equals("character") || ((Character) mon).EnDice < 3){
			return false;
		}
		return true;
	}
	void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Rest.jpg"), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("          Recover" , x, y + 20);
		g.setFont(normalFont);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Energy.jpg"), x + 40,y + 25, applet);
		g.drawString("                      + 50" , x, y +40);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Energy.jpg"), x ,y , applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Energy.jpg"), x ,y + 20, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Energy.jpg"), x ,y + 40 , applet);
	}

}