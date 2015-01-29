package javaAppletJessMonster;
import java.awt.Graphics;

public class APitch extends Attack {
	public APitch(Monster mon){
		super(mon);
		setCDamage(30);
	}
	public void attack( Leader defender) {
		hAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Pitch");
		
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
		g.drawImage(applet.getImage(Images.Debira3Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Pitch" , x + 110 , y + 25);
		g.setFont(normalFont);
		g.drawString("30              DMG (" + calcHDamage() +")" , x + 120, y + 40);
		g.drawImage(applet.getImage(Images.Combat), x+ 110 ,y + 40, applet);
		//en cost
		g.drawString("15" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Combat), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Combat), x + 20 ,y + 27, applet);
	}

}
