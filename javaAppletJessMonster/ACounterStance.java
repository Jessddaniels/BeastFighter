package javaAppletJessMonster;
import java.awt.Graphics;

public class ACounterStance extends Attack {
	public ACounterStance(Monster mon){
		super(mon);
		setKDamage(20);
	}
	public void attack( Leader defender) {
		int currentC = defender.getActiveMon().getCombat();
		defender.getActiveMon().setCombat(currentC - calcKDamage());
		mon.setCombat(mon.getCombat() + 20);
		((Character) mon).RollNum = 3;
		mon.applet.textbox.getArray().add(new TextUnit(mon.nameToString() + " used Counter Stance", mon.lead));
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).KDice >= 2 && ((Character) mon).CDice >= 1){
				return true;
			} else if (mon.getEnergy() >= 60){
				mon.setEnergy(mon.getEnergy() - 60);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/SwordStrike.jpg"), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Counter Stance" , x + 90 , y + 15);
		g.setFont(normalFont);
		g.drawString("20          DMG (" + calcKDamage() +")" , x + 95, y + 30);
		g.drawString("20          ADD (" + calcKDamage() +")" , x + 95, y + 45);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Combat.jpg"), x + 115 ,y + 20, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Combat.jpg"), x + 115 ,y + 30, applet);
		g.drawString("60" , x + 10, y + 20);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Energy.jpg"), x + 30 ,y + 5, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Knowledge.jpg"), x ,y + 25, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Combat.jpg"), x + 20 ,y + 45, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Knowledge.jpg"), x ,y + 45 , applet);
	}

}
