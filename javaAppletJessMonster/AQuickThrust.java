package javaAppletJessMonster;
import java.awt.Graphics;

public class AQuickThrust extends Attack {
	public AQuickThrust (Monster mon){
		super(mon);
		setHDamage(10);
		setEnergyCost(10);
		setReqDice(new DieSet(0,0,0,0,0,2));
	}
	public void attack( Leader defender) {
		hAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Quick Thrust for " + calcHDamage()+ " DMG");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Adipedys1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Quick Thrust " , x + 100 , y + 25);
		g.setFont(normalFont);
		g.drawString(getHDamage() + " DMG (" + calcHDamage() +")" , x + 110, y + 40);
		//en Cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Energy), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Energy), x ,y + 47 , applet);
	}

}
