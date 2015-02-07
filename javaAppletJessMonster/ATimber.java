package javaAppletJessMonster;
import java.awt.Graphics;

public class ATimber extends Attack {
	public ATimber(Monster mon){
		super(mon);
		setCDamage(15);
	}
	public void attack( Leader defender) {
		cAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Timber");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).EnDice >= 1 && ((Character) mon).ExDice >= 2){
				return true;
			} else if (mon.getEnergy() >= 15){
				mon.setEnergy(mon.getEnergy() - 15);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Virgeo1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Timber" , x + 115 , y + 20);
		g.setFont(normalFont);
		g.drawString("15          DMG (" + calcCDamage() +")" , x + 90, y + 45);
		g.drawImage(applet.getImage(Images.Combat), x + 110 ,y + 30, applet);
		//en Cost
		g.drawString("15" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Energy), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Experience), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Experience), x + 20 ,y + 27, applet);
	}

}
