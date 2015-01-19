package javaAppletJessMonster;
import java.awt.Graphics;

public class ABackToNature extends Attack {
	public ABackToNature(Monster mon){
		super(mon);
		setSDamage(15);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - applyDamage());
		int currentC= defender.getActiveMon().getCombat();
		defender.getActiveMon().setCombat(currentC - calcCDamage());
		mon.setSpirit(mon.getSpirit() + 10);
		((Character) mon).RollNum = 3;
		//toTextBox(mon.nameToString() + " used Back To Nature for " + calcDamage()+ " DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character") && ((Character) mon).SDice >= 3){
			return true;
		} else if (mon.getEnergy() >= 15){
			mon.setEnergy(mon.getEnergy() - 15);
			return true;
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Virgeo2Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Back To Nature" , x + 115 , y + 20);
		g.setFont(normalFont);
		g.drawString("10          Add (" + calcDamage() +")" , x + 90, y + 35);
		g.drawImage(applet.getImage(Images.Spirit), x + 110 ,y + 20, applet);
		g.drawString("15          DMG (" + calcCDamage() +")" , x + 90, y + 55);
		g.drawImage(applet.getImage(Images.Combat), x + 110 ,y + 40, applet);
		g.drawString("60" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		g.drawImage(applet.getImage(Images.Spirit), x ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 20 ,y + 45, applet);
		g.drawImage(applet.getImage(Images.Spirit), x ,y + 45 , applet);
	}

}
