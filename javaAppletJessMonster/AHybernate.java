package javaAppletJessMonster;

import java.awt.Graphics;

public class AHybernate extends Attack {
	public AHybernate(Monster mon){
		super(mon);
		setHGain(10);
		setEnGain(10);
	}
	public void attack( Leader defender) {
		hGain();
		enGain();
		toTextBox(mon.nameToString() + " used Hybernate");
		
	}
	public boolean isMet(Leader defender) {
		return true;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Hybernate), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Hybernate" , x + 45, y + 15);
		g.setFont(normalFont);
		g.drawString("       + 10" , x + 60, y + 35);
		g.drawString("       + 10" , x + 60, y + 60);
		g.drawImage(applet.getImage(Images.Energy), x + 60,y + 20, applet);
		g.drawImage(applet.getImage(Images.Health), x + 60,y + 45, applet);
	}

}
