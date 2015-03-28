package javaAppletJessMonster;
import java.awt.Graphics;

public class AButcherHook extends Attack {
	public AButcherHook(Monster mon){
		super(mon);
		setHDamage(25);
		setEnergyCost(20);
		setReqDice(new DieSet(0,0,3,0,0,1));
	}
	public void attack( Leader defender) {
		hAttack(defender);
		((Character) mon).RollNum = 3;
		toTextBox(mon.nameToString() + " used Butcher Hook for " + calcHDamage()+ " DMG");
		
	}
	public void paint(Graphics g, int x, int y, JessMonster applet) {
		g.drawImage(applet.getImage(Images.Calumbra2Attack), x,y, applet);
		x = x + 5;
		g.setFont(nameFont);
		g.drawString("Butcher Hook" , x + 105 , y + 25);
		g.setFont(normalFont);
		g.drawString(getHDamage() + " DMG (" + calcHDamage() +")" , x + 110, y + 45);
		//en cost
		g.drawString(getEnergyCost() + "" , x + 10, y + 20);
		g.drawImage(applet.getImage(Images.Energy20), x + 40 ,y + 3, applet);
		//die cost
		g.drawImage(applet.getImage(Images.Combat20), x ,y + 27, applet);
		g.drawImage(applet.getImage(Images.Combat20), x ,y + 47, applet);
		g.drawImage(applet.getImage(Images.Combat20), x + 20,y + 27 , applet);
		g.drawImage(applet.getImage(Images.Experience20), x + 20,y + 47 , applet);
	}

}
