package javaAppletJessMonster;
import java.awt.Graphics;

public class ALeechTrap extends Attack {
	public ALeechTrap(Monster mon){
		super(mon);
		setDamage(20);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - applyDamage());
		mon.setSpirit(mon.getSpirit() + 5 * mon.getCombat() / 20);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Leech Trap for " + calcDamage()+ " DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).DDice >= 2 && ((Character) mon).SDice >= 1 ){
				return true;
			} else if (mon.getEnergy() >= 50){
				mon.setEnergy(mon.getEnergy() - 50);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Calumbra3Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Leech Trap" , x + 110 , y + 18);
		g.setFont(normalFont);
		g.drawString("20 DMG (" + calcDamage() +")" , x + 110, y + 35);
		g.drawString("5          ADD (" + 5 * mon.getCombat() / 20 +")", x + 110, y + 55);
		g.drawImage(applet.getImage(Images.Spirit), x + 130 ,y + 40, applet);
		//en cost
		g.drawString("50" , x + 10, y + 20);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Energy.jpg"), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Damage), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Damage), x  ,y + 47, applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 20,y + 27 , applet);
	}

}
