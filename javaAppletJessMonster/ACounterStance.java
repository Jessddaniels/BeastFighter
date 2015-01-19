package javaAppletJessMonster;
import java.awt.Graphics;

public class ACounterStance extends Attack {
	public ACounterStance(Monster mon){
		super(mon);
		setExDamage(20);
	}
	public void attack( Leader defender) {
		int currentC = defender.getActiveMon().getCombat();
		defender.getActiveMon().setCombat(currentC - calcExDamage());
		mon.setCombat(mon.getCombat() + 20);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Counter Stance");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).DDice >= 2 && ((Character) mon).CDice >= 1){
				return true;
			} else if (mon.getEnergy() >= 60){
				mon.setEnergy(mon.getEnergy() - 60);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Debira1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Counter Stance" , x + 90 , y + 15);
		g.setFont(normalFont);
		g.drawString("20          DMG (" + calcExDamage() +")" , x + 95, y + 30);
		g.drawString("20          ADD (" + calcExDamage() +")" , x + 95, y + 45);
		g.drawImage(applet.getImage(Images.Combat), x + 115 ,y + 20, applet);
		g.drawImage(applet.getImage(Images.Combat), x + 115 ,y + 30, applet);
		g.drawString("60" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 30 ,y + 5, applet);
		g.drawImage(applet.getImage(Images.Damage), x ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Combat), x + 20 ,y + 45, applet);
		g.drawImage(applet.getImage(Images.Damage), x ,y + 45 , applet);
	}

}
