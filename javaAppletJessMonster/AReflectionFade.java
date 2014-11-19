package javaAppletJessMonster;
import java.awt.Graphics;

public class AReflectionFade extends Attack {
	public AReflectionFade(Monster mon){
		super(mon);
	}
	public void attack( Leader defender) {
		mon.setKnowledge(mon.getKnowledge() + 30);
		mon.setExperience(mon.getExperience() + 30);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Reflection Fade");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).KDice >= 2 && ((Character) mon).ExDice >= 2){
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
		g.drawString("Reflection Fade" , x + 90 , y + 15);
		g.setFont(normalFont);
		g.drawString("30          ADD ", x + 95, y + 30);
		g.drawString("30          ADD", x + 95, y + 45);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Knowledge.jpg"), x + 115 ,y + 20, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Experience.jpg"), x + 115 ,y + 30, applet);
		g.drawString("100" , x + 10, y + 20);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Energy.jpg"), x + 30 ,y + 5, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Experience.jpg"), x ,y + 25, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Knowledge.jpg"), x + 20 ,y + 45, applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Experience.jpg"), x ,y + 45 , applet);
		g.drawImage(applet.getImage(mon.getURL(),"Pictures/Knowledge.jpg"), x + 20,y + 25 , applet);
	}

}
