package javaAppletJessMonster;
import java.awt.Graphics;

public class AMomentum extends Attack {
	public AMomentum (Monster mon){
		super(mon);
		setHDamage(15);
		setEnergyCost(30);
		setReqDice(new DieSet(0,2,2,0,0,0));
	}
	public void attack( Leader defender) {
		hAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Momentum for " + calcHDamage()+ " DMG");
		setHDamage(getHDamage() + 5);
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Adipedys2Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Momentum" , x + 105 , y + 20);
		g.setFont(normalFont);
		g.drawString(getHDamage() + "  DMG (" + calcHDamage() +")" , x + 105, y + 35);
		g.setFont(smallFont);
		g.drawString(" Momentum Base Damage + 5" , x + 75, y + 45);
		g.setFont(normalFont);
		//en Cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//dice
		g.drawImage(applet.getImage(Images.Combat), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Energy), x + 20 ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Energy), x + 20 ,y + 47 , applet);
	}

}
