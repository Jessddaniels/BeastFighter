package javaAppletJessMonster;
import java.awt.Graphics;

public class ASwordStrike extends Attack {
	public ASwordStrike(Monster mon){
		super(mon);
		setHDamage(30);
		setEnergyCost(50);
		setReqDice(new DieSet(0,0,3,0,0,0));
	}
	public void attack( Leader defender) {
		hAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Sword Strike for " + calcHDamage()+ " DMG");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.SwordStrike), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Sword Strike" , x + 105 , y + 15);
		g.setFont(normalFont);
		g.drawString(getHDamage() + " DMG (" + calcHDamage() +")" , x + 110, y + 35);
		g.drawString(getEnergyCost() +"" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy), x + 30 ,y + 5, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 25, applet);
		g.drawImage(applet.getImage(Images.Combat), x + 20 ,y + 45, applet);
		g.drawImage(applet.getImage(Images.Combat), x ,y + 45 , applet);
	}

}
