package javaAppletJessMonster;
import java.awt.Graphics;

public class AReflectionFade extends Attack {
	public AReflectionFade(Monster mon){
		super(mon);
	}
	public void attack( Leader defender) {
		mon.setExperience(mon.getExperience() + 10);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Reflection Fade");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).ExDice >= 2){
				return true;
			} else if (mon.getEnergy() >= 10){
				mon.setEnergy(mon.getEnergy() - 10);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Debira1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Reflection Fade" , x + 98 , y + 23);
		g.setFont(normalFont);
		g.drawString("10          ADD", x + 105, y + 45);
		g.drawImage(applet.getImage(Images.Experience), x + 125 ,y + 30, applet);
		//en cost
		g.drawString("10" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		y += 2;
		g.drawImage(applet.getImage(Images.Experience), x ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Experience), x ,y + 45 , applet);
	}

}
