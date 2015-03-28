package javaAppletJessMonster;
import java.awt.Graphics;

public class ATimber extends Attack {
	public ATimber(Monster mon){
		super(mon);
		setCDamage(15);
		setEnergyCost(15);
		setReqDice(new DieSet(0,1,0,0,0,2));
	}
	public void attack( Leader defender) {
		cAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Timber");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Virgeo1Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Timber" , x + 115 , y + 20);
		g.setFont(normalFont);
		g.drawString(getCDamage() + "          DMG (" + calcCDamage() +")" , x + 90, y + 45);
		g.drawImage(applet.getImage(Images.Combat), x + 110 ,y + 30, applet);
		//en Cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy20), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Energy20), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Experience20), x ,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Experience20), x + 20 ,y + 27, applet);
	}

}
