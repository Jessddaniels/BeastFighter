package javaAppletJessMonster;
import java.awt.Graphics;

public class AHeadSlap extends Attack {
	public AHeadSlap (Monster mon){
		super(mon);
		setHDamage(10);
		setExDamage(5);
		setEnergyCost(15);
		setReqDice(new DieSet(0,0,2,0,0,0));
	}
	public void attack( Leader defender) {
		hAttack(defender);
		exAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Head Slap for " + calcHDamage()+ " DMG");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Adipedys2Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Head Slap" , x + 110 , y + 20);
		g.setFont(normalFont);
		g.drawString(getHDamage() + " DMG (" + calcHDamage() +")" , x + 105, y + 35);
		g.drawString(getExDamage() + "          DMG (" + calcExDamage() +")" , x + 105, y + 55);
		g.drawImage(applet.getImage(Images.Experience), x + 120 ,y + 40, applet);
		//en cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy20), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Combat20), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Combat20), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Experience20), x + 20 ,y + 27, applet);
	}

}
