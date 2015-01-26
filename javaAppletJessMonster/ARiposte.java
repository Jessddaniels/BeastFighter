package javaAppletJessMonster;
import java.awt.Graphics;

public class ARiposte extends Attack {
	public ARiposte(Monster mon){
		super(mon);
		setHDamage(15);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - applyDamage());
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Riposte for " + calcHDamage()+ " DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).CDice >= 2 && ((Character) mon).DDice >= 1 ){
				return true;
			} else if (mon.getEnergy() >= 15){
				mon.setEnergy(mon.getEnergy() - 15);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Debira1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Riposte" , x + 115 , y + 20);
		g.setFont(normalFont);
		g.drawString("15 DMG (" + calcHDamage() +")" , x + 110, y + 40);
		g.drawString("15" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Combat), x ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 45 , applet);
		g.drawImage(applet.getImage(Images.Damage), x + 20 ,y + 45, applet);
	}

}
