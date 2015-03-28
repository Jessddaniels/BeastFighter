package javaAppletJessMonster;
import java.awt.Graphics;

public class ABash extends Attack {
	public ABash (Monster mon){
		super(mon);
		setHDamage(20);
		setExDamage(20);
		setEnergyCost(20);
		setReqDice(new DieSet(0,0,2,0,0,1));
	}
	public void attack( Leader defender) {
		hAttack(defender);
		exAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Bash for " + calcHDamage()+ " DMG");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Bash), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Bash" , x + 175 , y + 15);
		g.setFont(normalFont);
		g.drawString(getHDamage() + " DMG (" + calcHDamage() +")" , x + 150, y + 35);
		g.drawString(getExDamage() + "          DMG (" + calcExDamage() +")" , x + 130, y + 55);
		g.drawImage(applet.getImage(Images.Combat), x + 150 ,y + 40, applet);
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy20), x + 30 ,y + 5, applet);
		g.drawImage(applet.getImage(Images.Combat20), x ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Combat20), x + 20 ,y + 45, applet);
		g.drawImage(applet.getImage(Images.Experience20), x ,y + 45 , applet);
	}

}
