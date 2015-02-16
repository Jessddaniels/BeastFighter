package javaAppletJessMonster;
import java.awt.Graphics;

public class AVidensManus extends Attack {
	public AVidensManus(Monster mon){
		super(mon);
		setCGain(25);
		setEnergyCost(20);
		setReqDice(new DieSet(0,0,2,0,0,2));
	}
	public void attack( Leader defender) {
		cGain();
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Videns Manus");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Debira2Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Videns Manus" , x + 105 , y + 25);
		g.setFont(normalFont);
		g.drawString(getCGain() + "         ADD ", x + 110, y + 45);
		g.drawImage(applet.getImage(Images.Combat), x + 130 ,y + 30, applet);
		//en cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Combat), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Experience), x + 20,y + 27 , applet);
		g.drawImage(applet.getImage(Images.Experience), x + 20,y + 47 , applet);
	}

}
