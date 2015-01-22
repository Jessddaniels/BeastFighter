package javaAppletJessMonster;
import java.awt.Graphics;

public class AVileGenesis extends Attack {
	public AVileGenesis(Monster mon){
		super(mon);
		setDamage(15);
		setSDamage(20);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - applyDamage());
		int currentS = defender.getActiveMon().getSpirit();
		defender.getActiveMon().setSpirit(currentS - calcSDamage());
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Vile Genesis for " + calcDamage()+ " DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character") && ((Character) mon).HDice >= 2 && ((Character) mon).SDice >= 3){
			return true;
		} else if (mon.getEnergy() >= 20){
			mon.setEnergy(mon.getEnergy() - 20);
			return true;
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Adipedys3Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Vile Genesis" , x + 110 , y + 20);
		g.setFont(normalFont);
		g.drawString("15 DMG (" + calcDamage() +")" , x + 110, y + 35);
		g.drawString("20          DMG (" + calcSDamage() +")" , x + 100, y + 55);
		g.drawImage(applet.getImage(Images.Spirit), x + 120 ,y + 40, applet);
		//en Cost
		g.drawString("25" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//dice
		g.drawImage(applet.getImage(Images.Health), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Health), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 20 ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 20 ,y + 47, applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 40 ,y + 27 , applet);
	}

}
