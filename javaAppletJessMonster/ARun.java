package javaAppletJessMonster;

import java.awt.Graphics;

public class ARun extends Attack {
	public ARun(Monster mon){
		super(mon);
		setHDamage(0);
		setEnergyCost(10);
	}
	public void attack( Leader defender) {
		mon.lead.tradeOK = true;
		mon.lead.myTurn = true;
		toTextBox(mon.nameToString() + " Ran");
	}
	public boolean isMet(Leader defender) {
		if (super.isMet(defender)){
			if (mon.lead.tradeOK == false){
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Run.jpg"), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("               Run" , x, y + 20);
		g.setFont(normalFont);
		g.drawImage(applet.getImage(Images.Energy), x + 35,y + 25, applet);
		g.drawString(getEnergyCost() + "           / Switch Active" , x + 18, y + 40);
	}

}
