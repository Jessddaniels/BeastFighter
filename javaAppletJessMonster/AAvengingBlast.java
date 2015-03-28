package javaAppletJessMonster;
import java.awt.Graphics;

public class AAvengingBlast extends Attack {
	public AAvengingBlast(Monster mon){
		super(mon);
		setHDamage(15);
		setMaxHDamage(10);
		setEnergyCost(20);
		setReqDice(new DieSet(0,0,0,0,2,2));
	}
	public void attack( Leader defender) {
		maxHAttack(defender);
		hAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Avenging Blast for " + (calcHDamage() + calcExDamage())+" DMG");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Debira2Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Avenging Blast" , x + 100 , y + 22);
		g.setFont(normalFont);
		g.drawString("15 DMG (" + calcHDamage() +")" , x + 110, y + 35);
		g.drawString("10 Max        DMG (" + calcMaxHDamage() +")" , x + 90, y + 55);
		g.drawImage(applet.getImage(Images.Health), x + 130 ,y + 40, applet);
		//en cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy20), x + 40 ,y + 3, applet);
		//die cost
		y += 2;
		g.drawImage(applet.getImage(Images.Damage20), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Damage20), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Experience20), x + 20,y + 27 , applet);
		g.drawImage(applet.getImage(Images.Experience20), x + 20 ,y + 47, applet);
	}

}
