package javaAppletJessMonster;
import java.awt.Graphics;

public class AStampede extends Attack {
	public AStampede (Monster mon){
		super(mon);
		setHDamage(20);
		setEnergyCost(25);
		setReqDice(new DieSet(2,2,0,0,0,0));
	}
	public void attack( Leader defender) {
		setHDamage(20 + 10 * (mon.lead.monsterList.size() - 1));
		hAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Stampede for " + calcHDamage()+ " DMG");
		setHDamage(20);
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Virgeo2Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Stampede " , x + 115 , y + 20);
		g.setFont(normalFont);
		g.drawString("10 DMG per Ally +" , x + 100, y + 35);
		g.drawString(getHDamage() + " DMG (" + calcHDamage() + ")" , x + 110, y + 55);
		//en cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy20), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Health20), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Health20), x ,y + 47, applet);
		g.drawImage(applet.getImage(Images.Energy20), x + 20,y + 27 , applet);
		g.drawImage(applet.getImage(Images.Energy20), x + 20 ,y + 47 , applet);
	}

}
