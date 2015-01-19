package javaAppletJessMonster;
import java.awt.Graphics;

public class ABlightBolt extends Attack {
	public ABlightBolt(Monster mon){
		super(mon);
		setDamage(20);
		setEnDamage(40);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - applyDamage());
		int currentEn = defender.getActiveMon().getEnergy();
		defender.getActiveMon().setEnergy(currentEn - calcEnDamage());
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Blight Bolt for " + calcDamage()+ " DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character") && ((Character) mon).HDice >= 2 && ((Character) mon).EnDice >= 2){
			return true;
		} else if (mon.getEnergy() >= 60){
			mon.setEnergy(mon.getEnergy() - 60);
			return true;
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Virgeo3Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Blight Bolt" , x + 115 , y + 20);
		g.setFont(normalFont);
		g.drawString("20 DMG (" + calcDamage() +")" , x + 110, y + 35);
		g.drawString("40          DMG (" + calcEnDamage() +")" , x + 90, y + 55);
		g.drawImage(applet.getImage(Images.Energy), x + 110 ,y + 40, applet);
		g.drawString("60" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		g.drawImage(applet.getImage(Images.Energy), x ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Energy), x + 20 ,y + 45, applet);
		g.drawImage(applet.getImage(Images.Health), x ,y + 45 , applet);
		g.drawImage(applet.getImage(Images.Health), x + 20 ,y + 25 , applet);
	}

}
