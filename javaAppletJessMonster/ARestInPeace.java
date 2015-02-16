package javaAppletJessMonster;

import java.awt.Graphics;

public class ARestInPeace extends Attack {
	public ARestInPeace(Monster mon){
		super(mon);
		setEnGain(15);
		setSGain(5);
		setEnergyCost(0);
	}
	public void attack( Leader defender) {
		enGain();
		sGain();
		toTextBox(mon.nameToString() + " used Rest In Peace");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/RestInPeace.jpg"), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Rest in Peace" , x, y + 15);
		g.setFont(normalFont);
		g.drawImage(applet.getImage(Images.Energy), x ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 55,y + 25, applet);
		g.drawString("       + " + getEnGain() , x, y + 40);
		g.drawString("+ " + getSGain() , x + 80, y + 40);
	}

}
