package javaAppletJessMonster;
import java.awt.Graphics;

public class AAvengingBlast extends Attack {
	public AAvengingBlast(Monster mon){
		super(mon);
		setHDamage(15);
	}
	public void attack( Leader defender) {
		exAttack(defender);
		hAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Avenging Blast for " + (calcHDamage() + calcExDamage())+" DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).CDice >= 2 && ((Character) mon).DDice >= 2){
				return true;
			} else if (mon.getEnergy() >= 20){
				mon.setEnergy(mon.getEnergy() - 20);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Debira2Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Avenging Blast" , x + 100 , y + 22);
		g.setFont(normalFont);
		g.drawString("15 DMG (" + calcHDamage() +")" , x + 110, y + 35);
		g.drawString("10           DMG (" + calcExDamage() +")" , x + 100, y + 55);
		g.drawImage(applet.getImage(Images.Experience), x + 120 ,y + 40, applet);
		//en cost
		g.drawString("20" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		y += 2;
		g.drawImage(applet.getImage(Images.Combat), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Experience), x + 20,y + 27 , applet);
		g.drawImage(applet.getImage(Images.Experience), x + 20 ,y + 47, applet);
	}

}
