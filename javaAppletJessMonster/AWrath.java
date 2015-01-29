package javaAppletJessMonster;
import java.awt.Graphics;

public class AWrath extends Attack {
	public AWrath(Monster mon){
		super(mon);
		setHDamage(15);
	}
	public void attack( Leader defender) {
		setHDamage(getHDamage() + mon.getDamage());
		hAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Wrath for " + calcHDamage()+ " DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).CDice >= 2 && ((Character) mon).SDice >= 2 && ((Character) mon).DDice >= 2){
				return true;
			} else if (mon.getEnergy() >= 30){
				mon.setEnergy(mon.getEnergy() - 30);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Debira3Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Wrath" , x + 125 , y + 20);
		g.setFont(normalFont);
		g.drawString("15 DMG (" + calcHDamage() +")" , x + 115, y + 35);
		g.drawString("2x Damage from" , x + 85, y + 50);
		g.drawImage(applet.getImage(Images.Damage), x + 180,y + 40 , applet);
		//en cost
		g.drawString("30" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Combat), x ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 45 , applet);
		g.drawImage(applet.getImage(Images.Damage), x + 20,y + 25 , applet);
		g.drawImage(applet.getImage(Images.Damage), x + 20 ,y + 45, applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 40,y + 25 , applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 40,y + 45 , applet);
	}

}
