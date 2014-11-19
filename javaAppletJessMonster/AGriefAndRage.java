package javaAppletJessMonster;
import java.awt.Graphics;

public class AGriefAndRage extends Attack {
	public AGriefAndRage(Monster mon){
		super(mon);
	}
	public void attack( Leader defender) {
		mon.setSpirit(mon.getSpirit() + 50);
		mon.setCombat(mon.getCombat() + 50);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Grief and Rage");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).CDice >= 2 && ((Character) mon).SDice >= 2){
				return true;
			} else if (mon.getEnergy() >= 100){
				mon.setEnergy(mon.getEnergy() - 100);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/SwordStrike.jpg"), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Grief and Rage" , x + 90 , y + 15);
		g.setFont(normalFont);
		g.drawString("50          ADD ", x + 95, y + 30);
		g.drawString("50          ADD", x + 95, y + 45);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Combat.jpg"), x + 115 ,y + 20, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Spirit.jpg"), x + 115 ,y + 30, applet);
		g.drawString("100" , x + 10, y + 20);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Energy.jpg"), x + 30 ,y + 5, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Spirit.jpg"), x ,y + 25, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Combat.jpg"), x + 20 ,y + 45, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Spirit.jpg"), x ,y + 45 , applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Combat.jpg"), x + 20,y + 25 , applet);
	}

}
