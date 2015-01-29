package javaAppletJessMonster;
import java.awt.Graphics;

public class AVidensManus extends Attack {
	public AVidensManus(Monster mon){
		super(mon);
		setCGain(25);
	}
	public void attack( Leader defender) {
		cGain();
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Videns Manus");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).SDice >= 2 && ((Character) mon).ExDice >= 2){
				return true;
			} else if (mon.getEnergy() >= 20){
				mon.setEnergy(mon.getEnergy() - 20);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Debira2Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Videns Manus" , x + 105 , y + 25);
		g.setFont(normalFont);
		g.drawString("25          ADD ", x + 110, y + 45);
		g.drawImage(applet.getImage(Images.Combat), x + 130 ,y + 30, applet);
		//en cost
		g.drawString("20" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Spirit), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Spirit), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Experience), x + 20,y + 27 , applet);
		g.drawImage(applet.getImage(Images.Experience), x + 20,y + 47 , applet);
	}

}
