package javaAppletJessMonster;
import java.awt.Graphics;

public class AScratch extends Attack {
	public AScratch(Monster mon){
		super(mon);
		setDamage(15);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - calcDamage());
		mon.applet.textbox.getArray().add(new TextUnit(mon.nameToString() + " used Scratch for " + calcDamage()+ " DMG", mon.lead));
		
	}
	public boolean isMet(Leader defender) {
		return true;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(mon.getURL(),"Scratch.jpg"), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Scratch" , x + 45 , y + 15);
		g.setFont(normalFont);
		g.drawString("15 DMG (" + calcDamage() +")" , x + 85, y + 25);
	}

}
