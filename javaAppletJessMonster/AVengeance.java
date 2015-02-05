package javaAppletJessMonster;
import java.awt.Graphics;

public class AVengeance extends Attack {
	public AVengeance(Monster mon){
		super(mon);
		setHDamage(5);
		setDGain(30);
	}
	public void attack( Leader defender) {
		hAttack(defender);
		dGain();
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Vengeance for " + calcHDamage()+" DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).CDice >= 2 && ((Character) mon).EnDice >= 2){
				return true;
			} else if (mon.getEnergy() >= 20){
				mon.setEnergy(mon.getEnergy() - 20);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Debira3Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Vengeance" , x + 110 , y + 20);
		g.setFont(normalFont);
		g.drawString("5 DMG (" + calcHDamage() +")" , x + 120, y + 35);
		g.drawString("30          GAIN (" + adj4Combat(getDGain()) +")" , x + 105, y + 55);
		g.drawImage(applet.getImage(Images.Damage), x + 125 ,y + 40, applet);
		//en cost
		g.drawString("20" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Combat), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Energy), x + 20,y + 27 , applet);
		g.drawImage(applet.getImage(Images.Energy), x + 20 ,y + 47, applet);
	}

}
