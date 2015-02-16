package javaAppletJessMonster;

import java.awt.Graphics;

public class APackInstincts extends Attack {
	public APackInstincts(Monster mon){
		super(mon);
		setHDamage(0);
		setEnergyCost(15);
	}
	public void attack( Leader defender) {
		if (mon.getHP() >= 40) {
			mon.setEnergy(mon.getEnergy() - 15);
		}
		mon.lead.tradeOK = true;
		mon.lead.myTurn = true;
		toTextBox(mon.nameToString() + " Ran");
	}
	public boolean isMet(Leader defender) {
		if (mon.getHP() < 40){
			return true;
		}
		if (super.isMet(defender)){
			return true;
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.PackInstincts), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Pack Instincts" , x, y + 12);
		g.setFont(normalFont);
		g.drawImage(applet.getImage(Images.Energy), x + 17,y + 15, applet);
		g.drawImage(applet.getImage(Images.Energy), x + 12,y + 35, applet);
		g.drawImage(applet.getImage(Images.Health), x + 55,y + 35, applet);
		g.drawString(getEnergyCost() + "         / Switch Active" , x, y + 30);
		g.drawString("0           if           < 40" , x, y + 50);
	}

}
