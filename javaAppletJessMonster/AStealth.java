package javaAppletJessMonster;

import java.awt.Graphics;

public class AStealth extends Attack {
	public AStealth(Monster mon){
		super(mon);
	}
	public void attack( Leader defender) {
		mon.setEnergy(mon.getEnergy() - 40);
		mon.setPower(mon.getPower() + 25);
		mon.lead.tradeOK = true;
		mon.lead.myTurn = true;
		mon.applet.textbox.getArray().add(new TextUnit(mon.nameToString() + " used Stealth", mon.lead));
	}
	public boolean isMet(Leader defender) {
		if (mon.getEnergy() < 40){
			return false;
		}
		return true;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/DeathRoll.jpg"), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("             Stealth" , x, y + 20);
		g.setFont(normalFont);
		g.drawString("                + 25",x , y + 35);
		g.drawString("     40         / Switch Active" , x, y + 60);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Combat.jpg"), x + 75,y + 25, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Energy.jpg"), x + 30,y + 45, applet);
	}

}
