package javaAppletJessMonster;
import java.awt.Graphics;

public class ACounterStance extends Attack {
	public ACounterStance(Monster mon){
		super(mon);
		setCDamage(10);
		setCGain(10);
		setEnergyCost(20);
		setReqDice(new DieSet(0,0,2,0,0,2));
	}
	public void attack( Leader defender) {
		cAttack(defender);
		cGain();
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Counter Stance");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Debira1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Counter Stance" , x + 102 , y + 22);
		g.setFont(normalFont);
		g.drawString(getCDamage() + "          DMG (" + calcCDamage() +")" , x + 100, y + 37);
		g.drawImage(applet.getImage(Images.Combat), x + 120 ,y + 25, applet);
		g.drawString(getCDamage() + "          ADD (" + calcCDamage() +")" , x + 100, y + 57);
		g.drawImage(applet.getImage(Images.Combat), x + 120 ,y + 45, applet);
		//en cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		y += 2;
		g.drawImage(applet.getImage(Images.Combat), x ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 45 , applet);
		g.drawImage(applet.getImage(Images.Experience), x + 20 ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Experience), x + 20 ,y + 45 , applet);
	}

}
