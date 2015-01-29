package javaAppletJessMonster;
import java.awt.Graphics;

public class AStampede extends Attack {
	public AStampede (Monster mon){
		super(mon);
		setHDamage(30);
	}
	public void attack( Leader defender) {
		hAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Stampede for " + calcHDamage()+ " DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character") && ((Character) mon).HDice >= 2 && ((Character) mon).EnDice >= 2){
			return true;
		} else if (mon.getEnergy() >= 25){
			mon.setEnergy(mon.getEnergy() - 25);
			return true;
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Virgeo2Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Stampede " , x + 115 , y + 20);
		g.setFont(normalFont);
		g.drawString("30 DMG (" + calcHDamage() +")" , x + 110, y + 35);
		//en cost
		g.drawString("25" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Health), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Health), x ,y + 47, applet);
		g.drawImage(applet.getImage(Images.Energy), x + 20,y + 27 , applet);
		g.drawImage(applet.getImage(Images.Energy), x + 20 ,y + 47 , applet);
	}

}
