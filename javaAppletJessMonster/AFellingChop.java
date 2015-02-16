package javaAppletJessMonster;
import java.awt.Graphics;

public class AFellingChop extends Attack {
	public AFellingChop (Monster mon){
		super(mon);
		setHDamage(25);
		setEnergyCost(25);
		setReqDice(new DieSet(0,0,0,0,3,2));
	}
	public void attack( Leader defender) {
		hAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Felling Chop for " + calcHDamage()+ " DMG");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Virgeo1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Felling Chop" , x + 115 , y + 20);
		g.setFont(normalFont);
		g.drawString(getHDamage() + " DMG (" + calcHDamage() +")" , x + 115, y + 45);
		//en cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Damage), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Damage), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Damage), x + 20 ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Experience), x + 20 ,y + 47, applet);
		g.drawImage(applet.getImage(Images.Experience), x + 40 ,y + 27 , applet);
	}

}
