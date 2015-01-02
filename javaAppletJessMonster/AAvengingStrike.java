package javaAppletJessMonster;
import java.awt.Graphics;

public class AAvengingStrike extends Attack {
	public AAvengingStrike(Monster mon){
		super(mon);
		setDamage(20);
		setExDamage(20);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - applyDamage()- calcExDamage());
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Avenging Strike for " + (calcDamage() + calcExDamage())+" DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).CDice >= 2 && ((Character) mon).DDice >= 2){
				return true;
			} else if (mon.getEnergy() >= 60){
				mon.setEnergy(mon.getEnergy() - 60);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.SwordStrike), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Avenging Strike" , x + 105 , y + 15);
		g.setFont(normalFont);
		g.drawString("20 DMG (" + calcDamage() +")" , x + 110, y + 30);
		g.drawString("20 DMG (" + calcExDamage() +")" , x + 110, y + 45);
		g.drawString("60" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 30 ,y + 5, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Experience), x + 20 ,y + 45, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 45 , applet);
		g.drawImage(applet.getImage(Images.Experience), x + 20,y + 25 , applet);
	}

}
