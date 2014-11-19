package javaAppletJessMonster;
import java.awt.Graphics;

public class AHeadSlap extends Attack {
	public AHeadSlap (Monster mon){
		super(mon);
		setDamage(20);
		setKDamage(20);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - calcDamage());
		int currentK = defender.getActiveMon().getKnowledge();
		defender.getActiveMon().setKnowledge(currentK - calcKDamage());
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Head Slap for " + calcDamage()+ " DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (!mon.type.equals("character") || ((Character) mon).CDice < 2 || ((Character) mon).KDice < 1 || mon.getEnergy() < 30){
			return false;
		}
		return true;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Blood.jpg"), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Head Slap" , x + 175 , y + 15);
		g.setFont(normalFont);
		g.drawString("20 DMG (" + calcDamage() +")" , x + 150, y + 35);
		g.drawString("20          DMG (" + calcKDamage() +")" , x + 130, y + 55);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Knowledge.jpg"), x + 150 ,y + 40, applet);
		g.drawString("40" , x + 10, y + 20);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Energy.jpg"), x + 30 ,y + 5, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Combat.jpg"), x ,y + 25, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Combat.jpg"), x + 20 ,y + 45, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Knowledge.jpg"), x ,y + 45 , applet);
	}

}
