package javaAppletJessMonster;
import java.awt.Graphics;

public class ABloodSplatter extends Attack {
	public ABloodSplatter(Monster mon){
		super(mon);
		setCDamage(10);
	}
	public void attack( Leader defender) {
		int currentC = defender.getActiveMon().getCombat();
		defender.getActiveMon().setCombat(currentC - calcCDamage());
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Blood Splatter");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).DDice >= 1 && ((Character) mon).ExDice >= 1 ){
				return true;
			} else if (mon.getEnergy() >= 10){
				mon.setEnergy(mon.getEnergy() - 10);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Calumbra1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Blood Splatter" , x + 105 , y + 20);
		g.setFont(normalFont);
		g.drawString("10          DMG (" + calcCDamage() +")" , x + 90, y + 45);
		g.drawImage(applet.getImage(Images.Combat), x + 110 ,y + 30, applet);
		g.drawString("10" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Damage), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Experience), x ,y + 47 , applet);
	}

}
