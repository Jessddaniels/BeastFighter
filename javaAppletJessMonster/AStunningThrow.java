package javaAppletJessMonster;
import java.awt.Graphics;

public class AStunningThrow extends Attack {
	public AStunningThrow (Monster mon){
		super(mon);
		setCDamage(20);
		setEnergyCost(20);
		setReqDice(new DieSet(2,2,0,0,0,0));
	}
	public void attack( Leader defender) {
		cAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Stunning Throw");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Adipedys1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Stunning Throw " , x + 100 , y + 25);
		g.setFont(normalFont);
		g.drawString(getCDamage() + "          DMG (" + calcCDamage() +")" , x + 90, y + 45);
		g.drawImage(applet.getImage(Images.Combat), x + 110 ,y + 30, applet);
		//en cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy20), x + 40 ,y + 3, applet);
		//die cost
		y += 2;
		g.drawImage(applet.getImage(Images.Health20), x ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Health20), x ,y + 45 , applet);
		g.drawImage(applet.getImage(Images.Energy20), x + 20, y + 25, applet);
		g.drawImage(applet.getImage(Images.Energy20), x +20, y + 45 , applet);
	}

}
