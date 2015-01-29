package javaAppletJessMonster;
import java.awt.Graphics;

public class AFuguToxin extends Attack {
	public AFuguToxin(Monster mon){
		super(mon);
	}
	public void attack( Leader defender) {
		setHDamage(defender.getActiveMon().getHP() / 10);
		hAttack(defender);
		setEnDamage(defender.getActiveMon().getEnergy() / 10);
		enAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Fugu Toxin for " + calcHDamage()+ " DMG");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).ExDice >= 2 && ((Character) mon).DDice >= 2 ){
				return true;
			} else if (mon.getEnergy() >= 20){
				mon.setEnergy(mon.getEnergy() - 20);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Calumbra2Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Fugu Toxin" , x + 105 , y + 25);
		g.setFont(normalFont);
		g.drawString("Enemy Loses 1/10" , x + 90, y + 40);
		g.drawString("        &       " , x + 120, y + 60);
		g.drawImage(applet.getImage(Images.Health), x + 120 ,y + 45, applet);
		g.drawImage(applet.getImage(Images.Energy), x + 155 ,y + 45, applet);
		//en cost
		g.drawString("20" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		// die cost
		g.drawImage(applet.getImage(Images.Damage), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Damage), x ,y + 47, applet);
		g.drawImage(applet.getImage(Images.Experience), x + 20,y + 27 , applet);
		g.drawImage(applet.getImage(Images.Experience), x +20 ,y + 47 , applet);
	}

}
