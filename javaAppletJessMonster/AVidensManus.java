package javaAppletJessMonster;
import java.awt.Graphics;

public class AVidensManus extends Attack {
	public AVidensManus(Monster mon){
		super(mon);
	}
	public void attack( Leader defender) {
		mon.setExperience(mon.getExperience() + 30);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Videns Manus");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).DDice >= 2 && ((Character) mon).ExDice >= 2){
				return true;
			} else if (mon.getEnergy() >= 100){
				mon.setEnergy(mon.getEnergy() - 100);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Debira2Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("VidensManus" , x + 90 , y + 15);
		g.setFont(normalFont);
		g.drawString("30          ADD ", x + 95, y + 30);
		g.drawImage(applet.getImage(Images.Experience), x + 115 ,y + 20, applet);
		g.drawString("100" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 30 ,y + 5, applet);
		g.drawImage(applet.getImage(Images.Experience), x ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Experience), x ,y + 45 , applet);
		g.drawImage(applet.getImage(Images.Damage), x + 20,y + 25 , applet);
	}

}
