package javaAppletJessMonster;

import java.awt.Graphics;

public class APackInstincts extends Attack {
	public APackInstincts(Monster mon){
		super(mon);
		setDamage(0);
	}
	public void attack( Leader defender) {
		if (mon.getHP() >= 40) {
			mon.setEnergy(mon.getEnergy() - 15);
		}
		mon.lead.tradeOK = true;
		mon.lead.myTurn = true;
		mon.applet.textbox.getArray().add(new TextUnit(mon.nameToString() + " Ran", mon.lead));
	}
	public boolean isMet(Leader defender) {
		if (mon.getEnergy() >= 15 || mon.getHP() < 40){
			return true;
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(mon.getURL(),"PackInstincts.jpg"), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Pack Instincts" , x, y + 12);
		g.setFont(normalFont);
		g.drawImage(applet.getImage(mon.getURL(),"Energy.jpg"), x + 17,y + 15, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Energy.jpg"), x + 12,y + 35, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Health.jpg"), x + 55,y + 35, applet);
		g.drawString("15         / Switch Active" , x, y + 30);
		g.drawString("0           if           < 40" , x, y + 50);
	}

}
