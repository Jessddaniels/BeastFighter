package javaAppletJessMonster;
import java.awt.Graphics;

public class ABearHug extends Attack {
	public ABearHug(Monster mon){
		super(mon);
		setHDamage(10);
		setEnDamage(10);
	}
	public void attack( Leader defender) {
		hAttack(defender);
		enAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Bear Hug for " + calcHDamage()+ " DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character") && ((Character) mon).HDice >= 2 && ((Character) mon).EnDice >= 2){
			return true;
		} else if (mon.getEnergy() >= 20){
			mon.setEnergy(mon.getEnergy() - 20);
			return true;
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Virgeo1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Bear Hug" , x + 115 , y + 20);
		g.setFont(normalFont);
		g.drawString("10 DMG (" + calcHDamage() +")" , x + 110, y + 35);
		g.drawString("10          DMG (" + calcEnDamage() +")" , x + 95, y + 55);
		g.drawImage(applet.getImage(Images.Energy), x + 115 ,y + 40, applet);
		//en cost
		g.drawString("20" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Health), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Health), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Energy), x + 20 ,y + 27 , applet);
		g.drawImage(applet.getImage(Images.Energy), x + 20 ,y + 47, applet);
	}

}
