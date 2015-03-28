package javaAppletJessMonster;
import java.awt.Graphics;

public class AReflectionFade extends Attack {
	public AReflectionFade(Monster mon){
		super(mon);
		setExGain(10);
		setEnergyCost(10);
		setReqDice(new DieSet(0,0,0,0,0,2));
	}
	public void attack( Leader defender) {
		exGain();
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Reflection Fade");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Debira1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Reflection Fade" , x + 98 , y + 23);
		g.setFont(normalFont);
		g.drawString(getExGain() + "          ADD", x + 105, y + 45);
		g.drawImage(applet.getImage(Images.Experience), x + 125 ,y + 30, applet);
		//en cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy20), x + 40 ,y + 3, applet);
		//die cost
		y += 2;
		g.drawImage(applet.getImage(Images.Experience20), x ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Experience20), x ,y + 45 , applet);
	}

}
