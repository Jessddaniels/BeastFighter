package javaAppletJessMonster;
import java.awt.Graphics;

public class ASparkingStrike extends Attack {
	public ASparkingStrike(Monster mon){
		super(mon);
		setDamage(20);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - applyDamage());
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Sparking Strike for " + calcDamage()+ " DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).CDice >= 3){
				return true;
			} else if (mon.getEnergy() >= 15){
				mon.setEnergy(mon.getEnergy() - 15);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Debira2Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Sparking Strike" , x + 105 , y + 15);
		g.setFont(normalFont);
		g.drawString("20 DMG (" + calcDamage() +")" , x + 110, y + 35);
		//en cost
		g.drawString("15" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Combat), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Combat), x  ,y + 47, applet);
		g.drawImage(applet.getImage(Images.Combat), x + 20,y + 27 , applet);
	}

}