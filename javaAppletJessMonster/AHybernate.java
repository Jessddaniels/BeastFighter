package javaAppletJessMonster;

import java.awt.Graphics;

public class AHybernate extends Attack {
	public AHybernate(Monster mon){
		super(mon);
		setDamage(0);
	}
	public void attack( Leader defender) {
		mon.setEnergy(mon.getEnergy() + 10);
		mon.setHP(mon.getHP() + 10);
		toTextBox(mon.nameToString() + " used Hybernate");
		
	}
	public boolean isMet(Leader defender) {
		return true;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Hybernate.jpg"), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Hybernate" , x + 45, y + 15);
		g.setFont(normalFont);
		g.drawString("       + 10" , x + 60, y + 35);
		g.drawString("       + 10" , x + 60, y + 60);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Energy.jpg"), x + 60,y + 20, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Health.jpg"), x + 60,y + 45, applet);
	}

}
