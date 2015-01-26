package javaAppletJessMonster;
import java.awt.Graphics;

public class APurgatory extends Attack {
	public APurgatory (Monster mon){
		super(mon);
		setHDamage(35);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - applyDamage());
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Purgatory for " + calcHDamage()+ " DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).DDice >= 2 && ((Character) mon).SDice >= 3 ){
				return true;
			} else if (mon.getEnergy() >= 25){
				mon.setEnergy(mon.getEnergy() - 25);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Calumbra3Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Purgatory" , x + 110 , y + 18);
		g.setFont(normalFont);
		g.drawString("35 DMG (" + calcHDamage() +")" , x + 110, y + 35);
		//en cost
		g.drawString("25" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Damage), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Damage), x  ,y + 47, applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 20,y + 27 , applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 20,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 40,y + 27 , applet);
	}

}
