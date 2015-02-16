package javaAppletJessMonster;
import java.awt.Graphics;

public class AToxicSpores extends Attack {
	public AToxicSpores(Monster mon){
		super(mon);
		setHDamage(20);
		setEnDamage(40);
		setEnergyCost(60);
		setReqDice(new DieSet(2,2,0,0,0,0));
	}
	public void attack( Leader defender) {
		hAttack(defender);
		enAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Toxic Spores for " + calcHDamage()+ " DMG");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Virgeo3Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Toxic Spores" , x + 115 , y + 20);
		g.setFont(normalFont);
		g.drawString(" DMG (" + calcHDamage() +")" , x + 110, y + 35);
		g.drawString(getEnDamage() + "          DMG (" + calcEnDamage() +")" , x + 90, y + 55);
		g.drawImage(applet.getImage(Images.Energy), x + 110 ,y + 40, applet);
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
