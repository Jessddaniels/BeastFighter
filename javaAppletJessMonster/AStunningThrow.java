package javaAppletJessMonster;
import java.awt.Graphics;

public class AStunningThrow extends Attack {
	public AStunningThrow (Monster mon){
		super(mon);
		setCDamage(20);
	}
	public void attack( Leader defender) {
		cAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Stunning Throw");
		
	}
	public boolean isMet(Leader defender) {
		if (mon.type.equals("character")){
			if (((Character) mon).HDice >= 2 && ((Character) mon).SDice >= 2){
				return true;
			} else if (mon.getEnergy() >= 20){
				mon.setEnergy(mon.getEnergy() - 20);
				return true;
			}
		}
		return false;
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Adipedys1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Stunning Throw " , x + 100 , y + 25);
		g.setFont(normalFont);
		g.drawString("20          DMG (" + calcCDamage() +")" , x + 90, y + 45);
		g.drawImage(applet.getImage(Images.Combat), x + 110 ,y + 30, applet);
		//en cost
		g.drawString("20" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 40 ,y + 3, applet);
		//die cost
		y += 2;
		g.drawImage(applet.getImage(Images.Health), x ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Health), x ,y + 45 , applet);
		g.drawImage(applet.getImage(Images.Spirit), x + 20, y + 25, applet);
		g.drawImage(applet.getImage(Images.Spirit), x +20, y + 45 , applet);
	}

}
