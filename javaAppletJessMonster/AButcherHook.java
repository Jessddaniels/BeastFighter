package javaAppletJessMonster;
import java.awt.Graphics;

public class AButcherHook extends Attack {
	public AButcherHook(Monster mon){
		super(mon);
		setHDamage(25);
	}
	public void attack( Leader defender) {
		hAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Butcher Hook for " + calcHDamage()+ " DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).CDice >= 3 && ((Character) mon).ExDice >= 1 ){
				return true;
			} else if (mon.getEnergy() >= 20){
				mon.setEnergy(mon.getEnergy() - 20);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Calumbra2Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Butcher Hook" , x + 105 , y + 25);
		g.setFont(normalFont);
		g.drawString("25 DMG (" + calcHDamage() +")" , x + 110, y + 45);
		//en cost
		g.drawString("20" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Combat), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 47, applet);
		g.drawImage(applet.getImage(Images.Combat), x + 20,y + 27 , applet);
		g.drawImage(applet.getImage(Images.Experience), x + 20,y + 47 , applet);
	}

}
