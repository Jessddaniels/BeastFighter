package javaAppletJessMonster;

import java.awt.Graphics;

public class ASpiritSink extends Attack {
	public ASpiritSink(Monster mon){
		super(mon);
		setDamage(20);
	}
	public void attack( Leader defender) {
		mon.setEnergy(mon.getEnergy() - 25);
		defender.getActiveMon().setHP(defender.getActiveMon().getHP() - calcDamage());
		defender.getActiveMon().setSpirit(defender.getActiveMon().getSpirit() - 20);
		mon.applet.textbox.getArray().add(new TextUnit( mon.nameToString() + " used Spirit Sink", mon.lead));
		
	}
	public boolean isMet(Leader defender) {
		if(mon.getEnergy() < 25) {
			return false;
		}
		return true;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/SpiritSink.jpg"), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Spirit Sink" , x, y + 15);
		g.setFont(normalFont);
		g.drawString("25           /           -20" , x, y + 35);
		g.drawString("20 DMG ( " + calcDamage()+ ")" , x, y + 50);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Energy.jpg"), x + 22,y + 18, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Spirit.jpg"), x + 57,y + 18, applet);
	}
}
