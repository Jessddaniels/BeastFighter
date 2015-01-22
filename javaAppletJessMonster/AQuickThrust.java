package javaAppletJessMonster;
import java.awt.Graphics;

public class AQuickThrust extends Attack {
	public AQuickThrust (Monster mon){
		super(mon);
		setDamage(10);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - applyDamage());
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Quick Thrust for " + calcDamage()+ " DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).EnDice >= 2){
				return true;
			} else if (mon.getEnergy() >= 10){
				mon.setEnergy(mon.getEnergy() - 10);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Adipedys1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Quick Thrust " , x + 100 , y + 25);
		g.setFont(normalFont);
		g.drawString("10 DMG (" + calcDamage() +")" , x + 110, y + 40);
		//en Cost
		g.drawString("10" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Energy), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Energy), x ,y + 47 , applet);
	}

}
