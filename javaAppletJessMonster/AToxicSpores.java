package javaAppletJessMonster;
import java.awt.Graphics;

public class AToxicSpores extends Attack {
	public AToxicSpores(Monster mon){
		super(mon);
		setHDamage(15);
		setMaxHDamage(15);
		setEnergyCost(20);
		setReqDice(new DieSet(2,0,2,0,0,0));
	}
	public void attack( Leader defender) {
		hAttack(defender);
		maxHAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Toxic Spores for " + calcHDamage()+ " DMG");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Virgeo3Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Toxic Spores" , x + 115 , y + 20);
		g.setFont(normalFont);
		g.drawString(getHDamage() + " DMG (" + calcHDamage() +")" , x + 110, y + 35);
		g.drawString(getMaxHDamage() + " Max          DMG (" + calcMaxHDamage() +")" , x + 90, y + 55);
		g.drawImage(applet.getImage(Images.Health), x + 135 ,y + 40, applet);
		//en cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Health), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Health), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Energy), x + 20 ,y + 27 , applet);
		g.drawImage(applet.getImage(Images.Energy), x + 20 ,y + 47, applet);
	}

}
