package javaAppletJessMonster;
import java.awt.Graphics;

public class ASwordStrike extends Attack {
	public ASwordStrike(Monster mon){
		super(mon);
		setDamage(50);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - calcDamage());
		((Character) mon).CDice -= 3;
		((Character) mon).RollNum = 3;
		mon.applet.textbox.getArray().add(new TextUnit(mon.nameToString() + " used Scratch for " + calcDamage()+ " DMG", mon.lead));
		
	}
	public boolean isMet(Leader defender) {
		if (!mon.type.equals("character") || ((Character) mon).CDice < 3){
			return false;
		}
		return true;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Scratch.jpg"), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("SwordStrike" , x + 45 , y + 15);
		g.setFont(normalFont);
		g.drawString("50 DMG (" + calcDamage() +")" , x + 85, y + 25);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Combat.jpg"), x ,y , applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Combat.jpg"), x ,y + 20, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Combat.jpg"), x ,y + 40 , applet);
	}

}
