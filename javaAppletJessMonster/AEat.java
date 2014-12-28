package javaAppletJessMonster;
import java.awt.Graphics;

public class AEat extends Attack {
	public AEat(Monster mon){
		super(mon);
	}
	public void attack( Leader defender) {
		mon.setHP(mon.getHP() + 30);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Eat");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).HDice >= 3){
				return true;
			} else if (mon.getEnergy() >= 50){
				mon.setEnergy(mon.getEnergy() - 50);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Blood), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Eat" , x + 90 , y + 15);
		g.setFont(normalFont);
		g.drawString("30          ADD ", x + 95, y + 30);
		g.drawImage(applet.getImage(Images.Health), x + 115 ,y + 20, applet);
		g.drawString("50" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 30 ,y + 5, applet);
		g.drawImage(applet.getImage(Images.Health), x ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Health), x + 20 ,y + 45, applet);
		g.drawImage(applet.getImage(Images.Health), x ,y + 45 , applet);
	}

}
