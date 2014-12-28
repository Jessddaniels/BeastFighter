package javaAppletJessMonster;
import java.awt.Graphics;

public class ASwordStrike extends Attack {
	public ASwordStrike(Monster mon){
		super(mon);
		setDamage(30);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - calcDamage());
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Sword Strike for " + calcDamage()+ " DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).CDice >= 3){
				return true;
			} else if (mon.getEnergy() >= 50){
				mon.setEnergy(mon.getEnergy() - 50);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.SwordStrike), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Sword Strike" , x + 105 , y + 15);
		g.setFont(normalFont);
		g.drawString("30 DMG (" + calcDamage() +")" , x + 110, y + 35);
		g.drawString("50" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 30 ,y + 5, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Combat), x + 20 ,y + 45, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 45 , applet);
	}

}
