package javaAppletJessMonster;
import java.awt.Graphics;

public class AEat extends Attack {
	public AEat(Monster mon){
		super(mon);
		setHGain(15);
	}
	public void attack( Leader defender) {
		hGain();
		((Character) mon).RollNum = 2;
		toTextBox(mon.nameToString() + " used Eat");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).HDice >= 2){
				return true;
			} else if (mon.getEnergy() >= 10){
				mon.setEnergy(mon.getEnergy() - 10);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Adipedys2Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Eat" , x + 125 , y + 20);
		g.setFont(normalFont);
		g.drawString("15          ADD ", x + 110, y + 40);
		g.drawImage(applet.getImage(Images.Health), x + 125 ,y + 25, applet);
		//en cost
		g.drawString("10" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Health), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Health), x ,y + 47 , applet);
	}

}
