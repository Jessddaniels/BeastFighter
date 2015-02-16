package javaAppletJessMonster;
import java.awt.Graphics;

public class AVileGenesis extends Attack {
	public AVileGenesis(Monster mon){
		super(mon);
		setHDamage(15);
		setSDamage(20);
		setEnergyCost(20);
		setReqDice(new DieSet(2,0,0,3,0,0));
	}
	public void attack( Leader defender) {
		hAttack(defender);
		sAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Vile Genesis for " + calcHDamage()+ " DMG");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Adipedys3Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Vile Genesis" , x + 110 , y + 20);
		g.setFont(normalFont);
		g.drawString(getHDamage() + " DMG (" + calcHDamage() +")" , x + 110, y + 35);
		g.drawString(getSDamage() + "          DMG (" + calcSDamage() +")" , x + 100, y + 55);
		g.drawImage(applet.getImage(Images.Spirit), x + 120 ,y + 40, applet);
		//en Cost
		g.drawString(getEnergyCost()  + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//dice
		g.drawImage(applet.getImage(Images.Health), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Health), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 20 ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 20 ,y + 47, applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 40 ,y + 27 , applet);
	}

}
