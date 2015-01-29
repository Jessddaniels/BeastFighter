package javaAppletJessMonster;
import java.awt.Graphics;

public class AFellingChop extends Attack {
	public AFellingChop (Monster mon){
		super(mon);
		setHDamage(25);
	}
	public void attack( Leader defender) {
		hAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Felling Chop for " + calcHDamage()+ " DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character") && ((Character) mon).DDice >= 3 && ((Character) mon).ExDice >= 2){
			return true;
		} else if (mon.getEnergy() >= 25){
			mon.setEnergy(mon.getEnergy() - 25);
			return true;
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Virgeo1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Felling Chop" , x + 115 , y + 20);
		g.setFont(normalFont);
		g.drawString("25 DMG (" + calcHDamage() +")" , x + 115, y + 45);
		g.drawString("25" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		g.drawImage(applet.getImage(Images.Damage), x ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Experience), x + 20 ,y + 45, applet);
		g.drawImage(applet.getImage(Images.Damage), x ,y + 45 , applet);
		g.drawImage(applet.getImage(Images.Damage), x + 20 ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Experience), x + 40 ,y + 25 , applet);
	}

}
