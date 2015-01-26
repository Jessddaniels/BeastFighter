package javaAppletJessMonster;

import java.awt.Graphics;

public class ARun extends Attack {
	public ARun(Monster mon){
		super(mon);
		setHDamage(0);
	}
	public void attack( Leader defender) {
		mon.setEnergy(mon.getEnergy() - 10);
		mon.lead.tradeOK = true;
		mon.lead.myTurn = true;
		toTextBox(mon.nameToString() + " Ran");
	}
	public boolean isMet(Leader defender) {
		if (mon.getEnergy() < 10 || mon.lead.tradeOK == true){
			return false;
		}
		return true;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Run.jpg"), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("               Run" , x, y + 20);
		g.setFont(normalFont);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Energy.jpg"), x + 35,y + 25, applet);
		g.drawString("10           / Switch Active" , x + 18, y + 40);
	}

}
