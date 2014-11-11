package javaAppletJessMonster;

import java.awt.Graphics;

public class ARestInPeace extends Attack {
	public ARestInPeace(Monster mon){
		super(mon);
		setDamage(0);
	}
	public void attack( Leader defender) {
		mon.setEnergy(mon.getEnergy() + 15);
		mon.setSpirit(mon.getSpirit() + 5);
		mon.applet.textbox.getArray().add(new TextUnit(mon.nameToString() + " used Rest In Peace", mon.lead));
		
	}
	public boolean isMet(Leader defender) {
		return true;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/RestInPeace.jpg"), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Rest in Peace" , x, y + 15);
		g.setFont(normalFont);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Energy.jpg"), x ,y + 25, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Spirit.jpg"), x + 55,y + 25, applet);
		g.drawString("       + 15" , x, y + 40);
		g.drawString("+ 5" , x + 80, y + 40);
	}

}
