package javaAppletJessMonster;
import java.awt.Graphics;

public class AVengeance extends Attack {
	public AVengeance(Monster mon){
		super(mon);
		setDamage(40);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - calcDamage());
		mon.setSpirit(mon.getSpirit() + 40);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Vengeance for " + calcDamage()+" DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).CDice >= 4 && ((Character) mon).SDice >= 2){
				return true;
			} else if (mon.getEnergy() >= 100){
				mon.setEnergy(mon.getEnergy() - 100);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/SwordStrike.jpg"), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Vengeance" , x + 105 , y + 15);
		g.setFont(normalFont);
		g.drawString("40 DMG (" + calcDamage() +")" , x + 110, y + 30);
		g.drawString("100" , x + 10, y + 20);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Energy.jpg"), x + 30 ,y + 5, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Combat.jpg"), x ,y + 25, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Combat.jpg"), x + 20 ,y + 45, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Combat.jpg"), x ,y + 45 , applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Combat.jpg"), x + 20,y + 25 , applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Spirit.jpg"), x + 40,y + 25 , applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Spirit.jpg"), x + 40,y + 45 , applet);
	}

}
