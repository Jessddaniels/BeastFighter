package javaAppletJessMonster;
import java.awt.Graphics;

public class AScratch extends Attack {
	public AScratch(Monster mon){
		super(mon);
		setHDamage(15);
	}
	public void attack( Leader defender) {
		hAttack(defender);
		toTextBox(mon.nameToString() + " used Scratch for " + calcHDamage()+ " DMG");
		
	}
	public boolean isMet(Leader defender) {
		return true;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Scratch.jpg"), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Scratch" , x + 45 , y + 15);
		g.setFont(normalFont);
		g.drawString("15 DMG (" + calcHDamage() +")" , x + 85, y + 25);
	}

}
