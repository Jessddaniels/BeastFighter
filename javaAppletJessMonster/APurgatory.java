package javaAppletJessMonster;
import java.awt.Graphics;

public class APurgatory extends Attack {
	public APurgatory (Monster mon){
		super(mon);
		setHDamage(35);
		setEnergyCost(25);
		setReqDice(new DieSet(0,0,0,3,2,0));
	}
	public void attack( Leader defender) {
		hAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Purgatory for " + calcHDamage()+ " DMG");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Calumbra3Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Purgatory" , x + 110 , y + 18);
		g.setFont(normalFont);
		g.drawString(getHDamage() + " DMG (" + calcHDamage() +")" , x + 110, y + 35);
		//en cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy20), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Damage20), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Damage20), x  ,y + 47, applet);
		g.drawImage(applet.getImage(Images.Spirit20), x + 20,y + 27 , applet);
		g.drawImage(applet.getImage(Images.Spirit20), x + 20,y + 47 , applet);
		g.drawImage(applet.getImage(Images.Spirit20), x + 40,y + 27 , applet);
	}

}
