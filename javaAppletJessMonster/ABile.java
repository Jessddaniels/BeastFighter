package javaAppletJessMonster;
import java.awt.Graphics;

public class ABile extends Attack {
	public ABile(Monster mon){
		super(mon);
		setHDamage(20);
		setEnergyCost(20);
		setReqDice(new DieSet(0,0,2,2,0,0));
	}
	public void attack( Leader defender) {
		hAttack(defender);
		setDGain((int) (mon.getSpirit() / 10));
		dGain();
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Bile for " + calcHDamage()+ " DMG");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Adipedys3Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Bile" , x + 130 , y + 20);
		g.setFont(normalFont);
		g.drawString(getHDamage() + " DMG (" + calcHDamage() +")" , x + 110, y + 35);
		g.drawString("GAIN Spirit / 10" , x + 100, y + 55);
		g.drawImage(applet.getImage(Images.Damage), x + 175 ,y + 40, applet);
		//en cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Combat), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 47, applet);
		g.drawImage(applet.getImage(Images.Experience), x + 20,y + 27 , applet);
		g.drawImage(applet.getImage(Images.Experience), x + 20,y + 47 , applet);
	}

}
