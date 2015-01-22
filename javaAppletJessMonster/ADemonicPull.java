package javaAppletJessMonster;
import java.awt.Graphics;

public class ADemonicPull extends Attack {
	public ADemonicPull(Monster mon){
		super(mon);
		setDamage(20);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - applyDamage());
		mon.setHP(mon.getHP() + 20);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Demonic Pull for " + calcDamage()+ " DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).EnDice >= 1 && ((Character) mon).SDice >= 1 ){
				return true;
			} else if (mon.getEnergy() >= 10){
				mon.setEnergy(mon.getEnergy() - 10);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Calumbra3Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Demonic Pull" , x + 105 , y + 20);
		g.setFont(normalFont);
		g.drawString("25          ADD", x + 105, y + 45);
		g.drawImage(applet.getImage(Images.Energy), x + 125 ,y + 35, applet);
		//en cost
		g.drawString("Null" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		// die cost
		g.drawImage(applet.getImage(Images.Energy), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Spirit), x ,y + 47, applet);
	}

}