package javaAppletJessMonster;
import java.awt.Graphics;

public class ARiposte extends Attack {
	public ARiposte(Monster mon){
		super(mon);
		setDamage(20);
	}
	public void attack( Leader defender) {
		int currentHP = defender.getActiveMon().getHP();
		defender.getActiveMon().setHP(currentHP - calcDamage());
		mon.setHP(mon.getHP() + 20);
		((Character) mon).RollNum = 3;
		mon.applet.textbox.getArray().add(new TextUnit(mon.nameToString() + " used Riposte for " + calcDamage()+ " DMG", mon.lead));
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).CDice >= 2 && ((Character) mon).HDice >= 1 ){
				return true;
			} else if (mon.getEnergy() >= 50){
				mon.setEnergy(mon.getEnergy() - 50);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/SwordStrike.jpg"), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Riposte" , x + 105 , y + 15);
		g.setFont(normalFont);
		g.drawString("20 DMG (" + calcDamage() +")" , x + 110, y + 30);
		g.drawString("20          ADD", x + 95, y + 45);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Health.jpg"), x + 115 ,y + 35, applet);
		g.drawString("50" , x + 10, y + 20);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Energy.jpg"), x + 30 ,y + 5, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Combat.jpg"), x ,y + 25, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Combat.jpg"), x + 20 ,y + 45, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Health.jpg"), x ,y + 45 , applet);
	}

}